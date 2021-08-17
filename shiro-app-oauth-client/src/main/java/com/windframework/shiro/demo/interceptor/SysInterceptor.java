package com.windframework.shiro.demo.interceptor;
//package com.windframework.shiro.demo.config.interceptor;
//
//import java.util.Objects;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.windframework.shiro.demo.entity.User;
//
//public class SysInterceptor implements HandlerInterceptor {
//
//	private static final Logger logger = LoggerFactory.getLogger(SysInterceptor.class);
//	private static final String TIMEOUT_STR = "操作超时，请重新登陆！";
//	private static final String NOTPERMISSION_STR = "没有此操作权限，请联系管理员！";
////	@Autowired
////    private RedisTemplate<String, String> redisTemplate;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// 业务逻辑
//		boolean tage = true;
//		Object sessionUser = request.getSession(true).getAttribute("user");
//		String user = "";
//		if (null == sessionUser) {
////			if (request.getHeader("x-requested-with") != null
////					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
////				logger.warn(request.getRequestURI() + " no login for ajax.");
////				response.sendError(401, SysInterceptor.TIMEOUT_STR);
////
////			}
////			else {
////				logger.warn(request.getRequestURI() + " no login for page.");
////				request.setAttribute("reset_login", SysInterceptor.TIMEOUT_STR);
//////				request.getRequestDispatcher("/").forward(request, response);
////				request.setAttribute("requestURI", request.getRequestURI());
////				request.getRequestDispatcher("/static/template/relogin").forward(request, response);
////			}
////			tage = false;
//		} else {
//			user = ((User) sessionUser).getName();
//		}
////		MDC.put("threadName", user);
//		if (!tage) {
//			response.sendError(402, SysInterceptor.NOTPERMISSION_STR);
//			tage = false;
//		}
////		logger.info(request.getRequestURI() + " passed.");
//		logger.info("{} - {}", request.getServletPath(), user);
//		return tage;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
////		// 业务逻辑
////		Object o = request.getSession(true)
////				.getAttribute("loginUser");
////		User user = null;
////		if (Objects.nonNull(o)) {
////			user = (User) o;
////			logger.info("用户名{}请求{}", user.getName(), request.getServletPath());
////		}
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//
//	}
//}
