package com.windframework.shiro.demo.service;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.Map;

public interface ShiroService {
	
	Map<String, String> loadFilterChainDefinitions();
	
	ShiroFilterFactoryBean getFilterBean(SecurityManager securityManager);

	void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean, Long roleId, Boolean isRemoveSession);
}
