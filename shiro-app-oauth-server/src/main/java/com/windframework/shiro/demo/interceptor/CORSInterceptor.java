package com.windframework.shiro.demo.interceptor;
//package com.windframework.shiro.demo.config.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Component(value="corsInterceptor")
//@Slf4j
//public class CORSInterceptor extends HandlerInterceptorAdapter {
//
//	@Override
//
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
//		//添加跨域CORS
//
//		// 服务器不在一起，下面这个跨域是马川 给我的，好用
//
//		String originHeader = request.getHeader("Origin");
//
//		response.setHeader("Access-Control-Allow-Origin", originHeader);
//
//		response.addHeader("Access-Control-Allow-Headers",
//				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,accessToken");
//
//		response.addHeader("Access-Control-Allow-Credentials", "true");
//
//		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//
//		return true;
//
//	}
//}
