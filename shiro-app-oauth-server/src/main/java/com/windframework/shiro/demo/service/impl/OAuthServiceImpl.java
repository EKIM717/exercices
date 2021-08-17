package com.windframework.shiro.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.windframework.shiro.demo.service.ClientService;
import com.windframework.shiro.demo.service.OAuthService;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-17
 * <p>
 * Version: 1.0
 */
@Service("oAuthServiceImpl")
public class OAuthServiceImpl implements OAuthService {

//	@Autowired
//	private OAuth2AuthenticationFilter filter;

	private Cache cache;

	@Autowired
	private ClientService clientService;

	@Autowired
	public OAuthServiceImpl(CacheManager cacheManager) {
		this.cache = cacheManager.getCache("code-cache");
	}

	@Override
	public void addAuthCode(String authCode, String username) {
		cache.put(authCode, username);
	}

	@Override
	public void addAccessToken(String accessToken, String username) {
		cache.put(accessToken, username);
	}

	@Override
	public String getUsernameByAuthCode(String authCode) {
		return (String) cache.get(authCode).get();
	}

	@Override
	public String getUsernameByAccessToken(String accessToken) {
		return (String) cache.get(accessToken).get();
	}

	@Override
	public boolean checkAuthCode(String authCode) {
		return cache.get(authCode) != null;
	}

	@Override
	public boolean checkAccessToken(String accessToken) {
		return cache.get(accessToken) != null;
	}

	@Override
	public boolean checkClientId(String clientId) {
		return clientService.findByClientId(clientId) != null;
	}

	@Override
	public boolean checkClientSecret(String clientSecret) {
		return clientService.findByClientSecret(clientSecret) != null;
	}

	@Override
	public long getExpireIn() {
		return 3600L;
	}

	@Override
	public Map<String, String> loadFilterChainDefinitions() {
		Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
		// 登出 /logout = logout
		filterChainDefinitionMap.put("/logout", "logout");
		// swagger
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/oauth2Failure.jsp", "anon");
		filterChainDefinitionMap.put("/oauth2-login", "oauth2Authc");
		// 静态资源
		// 对所有用户认证 /** = user
		filterChainDefinitionMap.put("/**", "user");
		return filterChainDefinitionMap;
	}

	@Override
	public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean, Long roleId, Boolean isRemoveSession) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShiroFilterFactoryBean getFilterBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(this.loadFilterChainDefinitions());
		Map<String, Filter> oAuthFilterMap = new HashMap<>();
//		oAuthFilterMap.put("oauth2Authc", filter);
		shiroFilterFactoryBean.setFilters(oAuthFilterMap);

		// 登录
		shiroFilterFactoryBean.setLoginUrl(
				"http://localhost:8080/chapter17-server/authorize?client_id=c1ebe466-1cdc-4bd3-ab69-77c3561b9dee&amp;response_type=code&amp;redirect_uri=http://localhost:9080/chapter17-client/oauth2-login");
		// 首页
		shiroFilterFactoryBean.setSuccessUrl("/");
		// 错误页面，认证不通过跳转
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		return shiroFilterFactoryBean;
	}
}
