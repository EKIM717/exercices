//package com.windframework.shiro.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.windframework.shiro.demo.config.interceptor.CORSInterceptor;
//
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurerAdapter {
//
//	@Autowired // 解决跨域
//	private CORSInterceptor corsInterceptor;
//
//	@Override
//
//	public void addInterceptors(InterceptorRegistry registry) {
//
//		registry.addInterceptor(corsInterceptor);
//
//		super.addInterceptors(registry);
//
//	}
//
//}
