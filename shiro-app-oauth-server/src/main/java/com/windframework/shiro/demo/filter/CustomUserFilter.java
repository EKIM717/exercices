package com.windframework.shiro.demo.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * 自定义用户filter
 * @author Administrator
 *
 */
public class CustomUserFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		if (this.isLoginRequest(request, response)) {
			return true;
		} else {
			Subject subject = this.getSubject(request, response);
			return subject.getPrincipal() != null;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		this.saveRequestAndRedirectToLogin(request, response);
		return false;
	}

}
