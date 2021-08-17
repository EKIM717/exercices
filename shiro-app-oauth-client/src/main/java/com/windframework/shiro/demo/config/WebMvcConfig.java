//package com.windframework.shiro.demo.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.windframework.shiro.demo.config.interceptor.CORSInterceptor;
//import com.windframework.shiro.demo.util.SpringUtil;
//
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
// 
//	/**
//	  * 将自定义拦截器作为Bean写入配置
//	  * @return
//	  */
////	 @Bean
//	 public CORSInterceptor customeInterceptor() {
//	  return SpringUtil.getBean(CORSInterceptor.class);
//	 }
//	 /**
//	  * 对拦截器注册
//	  */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		String[] patterns = new String[] {"/swagger-resources/**"};
//		registry.addInterceptor(customeInterceptor())
//		                         .addPathPatterns("/**")
//		                         .excludePathPatterns(patterns);
//		super.addInterceptors(registry);
//	}
//	
//	/**
//     * 配置跨域访问的过滤器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean registerFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.addUrlPatterns("/*");
//        bean.setFilter(new com.windframework.shiro.demo.filter.CorsFilter());
//        return bean;
//    }
//    
//}
