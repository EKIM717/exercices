package com.windframework.shiro.demo.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.windframework.shiro.demo.entity.Permission;
import com.windframework.shiro.demo.entity.Role;
import com.windframework.shiro.demo.entity.User;
import com.windframework.shiro.demo.service.LoginService;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private LoginService loginService;
	

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		// 获取用户信息
		String name = authenticationToken.getPrincipal().toString();
		User user = loginService.findByName(name);
		if (user == null) {
			// 这里返回后会报出对应异常
			return null;
		} else {
			// 这里验证authenticationToken和simpleAuthenticationInfo的信息
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,
					user.getPassword().toString(), getName());
			
			//在已登录用户的session上保存用户的信息
	        Subject currentSubject = SecurityUtils.getSubject();
	        Session session = currentSubject.getSession();
	        session.setAttribute("loginUser",user);
			return simpleAuthenticationInfo;
		}
	}

	/**
	 * 角色权限和对应权限添加
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//		// 获取登录用户名
//		String name = (String) principalCollection.getPrimaryPrincipal();
		
		User user = (User) principalCollection.getPrimaryPrincipal();
		// 查询用户名称
//		User dbUser = loginService.findByName(user.getName());
		// 添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Role role : user.getRoles()) {
			// 添加角色
			simpleAuthorizationInfo.addRole(role.getRoleName());
			for (Permission permission : role.getPermissions()) {
				// 添加权限
				simpleAuthorizationInfo.addStringPermission(permission.getPermission());
			}
		}
		return simpleAuthorizationInfo;
	}

}