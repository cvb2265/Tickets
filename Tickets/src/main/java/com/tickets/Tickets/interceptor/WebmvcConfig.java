package com.tickets.Tickets.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author tqy
 * @date 2018年5月6日
 * 
 */
@Configuration
public class WebmvcConfig extends WebMvcConfigurerAdapter {
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
	}
}
