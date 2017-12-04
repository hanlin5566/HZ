package com.hzcf.operation.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;

/**
 * Create by hanlin on 2017年12月4日
 **/
@RestController
public class FinalExceptionHandler implements ErrorController {
	private static final String PATH = "/error";

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping(value = PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Result<String> error(HttpServletResponse resp, HttpServletRequest request) {
		// 错误处理逻辑
		Result<String> ret = buildBody(request,false);
		resp.setStatus(200);
		return ret;
	}


	private Result<String> buildBody(HttpServletRequest request,Boolean includeStackTrace) {
		Result<String> ret = new Result<String>();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		Map<String, Object> attr = errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
		Integer status = (Integer) attr.get("status");
		String path = (String) attr.get("path");
		String messageFound = (String) attr.get("message");
		String message = "";
		String trace = "";
		if (!StringUtils.isEmpty(path)) {
			message = String.format("Requested path %s with result %s", path, messageFound);
		}
		ResponseCode code = ResponseCode.RESULT_SYSTEM_ERROR;
		if(includeStackTrace){
			trace = (String) attr.get("trace");
			if (!StringUtils.isEmpty(trace)) {
				message += String.format(" and trace %s", trace);
			}
			switch (status) {
			case 400:
				code = ResponseCode.ERROR_PARAM;
				break;
			case 404:
				code = ResponseCode.RESOURCE_NOT_FOUND;
				break;
			case 500:
				code = ResponseCode.RESULT_SYSTEM_ERROR;
				break;
			default:
				code = ResponseCode.RESULT_SYSTEM_ERROR;
				break;
			}
		}
		CustomException customException = new CustomException(code, code.text());
		ret.setCode(code.code());
		ret.setCodeText(code.text());
		if(includeStackTrace){
			ret.setData(customException.getMessage());
		}
		ret.setMessage(message);
		return ret;
	}


	@Override
	public String getErrorPath() {
		return PATH;
	}
}