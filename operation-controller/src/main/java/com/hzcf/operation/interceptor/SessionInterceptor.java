package com.hzcf.operation.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzcf.operation.base.redis.RedisProvider;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.ResultResponse;
import com.hzcf.operation.gen.entity.SystemUser;
import com.hzcf.operation.service.SystemUserService;

/**
 * Create by hanlin on 2017年12月7日
 **/
@Component
public class SessionInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private SystemUserService systemUserService;
	
	
	//白名单，不拦截的名单，比如登录等。
	private static final String[] whiteList = {"/platfrom/userlogin"};
	
	/**
	 * session key
	 */
	public static final String SESSION_USER = "session_user";
	/**
	 * cookie key
	 */
	public static final String AUTH_TOKEN_KEY = "_IDENTIY_KEY_";
	/**
	 * token redis ttl，通过配置注入，默认30分钟
	 */
	@Value("${server.session.timeout}")
	public int AUTH_TOKEN_AGE = 30;
	
	 /**
	 * 生成客户端cookie
	 */
	public void createAuthToken(SystemUser user) throws Exception{
		//60秒为分
		AUTH_TOKEN_AGE = 60 * AUTH_TOKEN_AGE;
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute(SessionInterceptor.SESSION_USER, user);
		//token ttl 单位毫秒
		AuthToken authToken = new AuthToken(Long.valueOf(user.getId()), AUTH_TOKEN_AGE * 1000L );
		//redis ttl默认是秒
		RedisProvider.set(authToken.token(), JSONObject.toJSONString(user), AUTH_TOKEN_AGE*1L);
		Cookie cookie = new Cookie(SessionInterceptor.AUTH_TOKEN_KEY, authToken.token());
		//cookie保存时间秒
		cookie.setMaxAge(AUTH_TOKEN_AGE);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = this.handleRequest(request, response);
		return result;
	}
	
	private boolean checkInclude(String[] arr, String value) {
		for (String s : arr) {
			if (value.indexOf(s) > -1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {

		// 如果是白名单，放行
		String path = request.getRequestURI();
		if (checkInclude(whiteList, path)) {
			return true;
		}
		//如果已登录，放行
		Object user = request.getSession().getAttribute(SessionInterceptor.SESSION_USER);
		if (user != null) {
			return true;
		}
		//基于redis单点登录，request中传入token
		if(!StringUtils.isEmpty(request.getParameter("token")) && !StringUtils.isEmpty(RedisProvider.get(request.getParameter("token")))){
			String userJson = RedisProvider.get(request.getParameter("token"));
			SystemUser userInfo = JSONObject.parseObject(userJson,SystemUser.class);
			request.getSession().setAttribute(SessionInterceptor.SESSION_USER, userInfo);
			Cookie cookie = new Cookie(SessionInterceptor.AUTH_TOKEN_KEY, request.getParameter("token"));
			cookie.setMaxAge(AUTH_TOKEN_AGE);
			cookie.setPath("/");
			response.addCookie(cookie);
			return true;
		}
		
		//先判断cookies
		Cookie authCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			writeReponse(response, ResponseCode.RESULT_LOGIN_EXPIRED);
			return false;
		}
		for (Cookie c : cookies) {
			if (SessionInterceptor.AUTH_TOKEN_KEY.equals(c.getName())) {
				authCookie = c;
				break;
			}
		}
		
		if (authCookie == null) {
			writeReponse(response, ResponseCode.RESULT_LOGIN_EXPIRED);
			return false;
		}
		
		//判断redis中的key是否过期
		if(StringUtils.isEmpty(RedisProvider.get(authCookie.getValue()))){
			writeReponse(response, ResponseCode.RESULT_LOGIN_EXPIRED);
			return false;
		}
		
		//判断token是否过期
		AuthToken token = AuthToken.parse(authCookie.getValue());
		if (token == null || !token.isActive()) {
			logger.debug("token expired:{}", token);
			writeReponse(response, ResponseCode.RESULT_LOGIN_EXPIRED);
			return false;
		}
		
		SystemUser userInfo = systemUserService.selectByPrimarykey(Long.valueOf(token.userId).intValue());
		//cookies 与 数据库中无数据
		if (userInfo == null) {
			ResultResponse result = new ResultResponse();
			result.setResponseCode(ResponseCode.RESULT_LOGIN_EXPIRED);
			writeReponse(response, result);
			return false;
		}
		
		// 保存session
		request.getSession().setAttribute(SessionInterceptor.SESSION_USER, userInfo);
		return true;
	}
	
	private void writeReponse(HttpServletResponse response, ResponseCode code) throws IOException {
		ResultResponse result = new ResultResponse();
		result.setResponseCode(code);
		writeReponse(response, result);
	}
	
	private void writeReponse(HttpServletResponse response, ResultResponse result) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter wt = response.getWriter();
		try {
			new ObjectMapper().writeValue(wt, result);
		} finally {
			if (wt != null) wt.close();
		}
		
		logger.info("session interceptor result: {}", result);
		
		// 删除cookie
		Cookie cookie = new Cookie(SessionInterceptor.AUTH_TOKEN_KEY, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
