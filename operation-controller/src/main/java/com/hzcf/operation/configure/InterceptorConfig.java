package com.hzcf.operation.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hzcf.operation.interceptor.SessionInterceptor;

/**
 * Create by hanlin on 2017年12月7日
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private SessionInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor).addPathPatterns("/**");//配置登录拦截器拦截路径
        registry.addInterceptor(securityInterceptor).excludePathPatterns("**/platfrom/**","**/error");//配置不拦截的地址
    }
}
