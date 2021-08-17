package com.windframework.shiro.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import redis.clients.jedis.JedisPool;

@Configuration
public class ShiroConfig {
	
	private static final String CACHE_KEY = "shiro:cache:";
	private static final String SESSION_KEY = "shiro:session:";
    private static final String NAME = "custom.name";
    private static final String VALUE = "/";
	
	/**
	 * 页面上使用shiro标签
	 * @return
	 */
	@Bean(name = "shiroDialect")
	public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}
	
	/**
	 * 密码的安全加密算法
	 * @return
	 */
	@Bean("credentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// md5散列算法
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		// 散列次数,相当于md5(md5(string))
		hashedCredentialsMatcher.setHashIterations(2);
		return hashedCredentialsMatcher;
	}

//    /**
//     * 将自己的验证方式加入容器
//     * @param redisCacheManager
//     * @return
//     */
//    @Bean
//    public Realm myShiroRealm(RedisCacheManager redisCacheManager) {
//        MyShiroRealm realm = new MyShiroRealm();
//        // 暂时不使用加密
////        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        realm.setCacheManager(redisCacheManager);
//        realm.setAuthenticationCachingEnabled(false);
//        realm.setAuthorizationCachingEnabled(false);
//        return realm;
//    }
    
//    @Bean("oauth2Realm")
//    public Realm oauth2ShiroRealm(RedisCacheManager redisCacheManager) {
//        OAuth2Realm realm = new OAuth2Realm();
//       realm.setCachingEnabled(true);
//       realm.setAuthenticationCachingEnabled(true);
//       realm.setAuthenticationCacheName("authenticationCache");
//       realm.setAuthorizationCachingEnabled(true);
//       realm.setAuthorizationCacheName("authenticationCache");
//
//       realm.setClientId("c1ebe466-1cdc-4bd3-ab69-77c3561b9dee");
//       realm.setClientSecret("d8346ea2-6017-43ed-ad68-19c0f971738b");
//       realm.setAccessTokenUrl("http://localhost:8080/chapter17-server/accessToken");
//	   realm.setUserInfoUrl("http://localhost:8080/chapter17-server/userInfo");
//	   realm.setRedirectUrl("http://localhost:9080/chapter17-client/oauth2-login");
//        // 暂时不使用加密
////        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        realm.setCacheManager(redisCacheManager);
//        return realm;
//    }

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(Realm realm, SessionManager sessionManager, RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }
    
//    @Bean
//    public CustomRolesAuthorizationFilter rolesAuthorizationFilter() {
//        return new CustomRolesAuthorizationFilter();
//    }

    // Filter工厂，设置对应的过滤条件和跳转条件
//    @Bean(name="shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager, @Qualifier("oAuthServiceImpl")ShiroService shiroService) {
//        return shiroService.getFilterBean(securityManager);
//    }

    /**
     * 加入注解的使用，不加入这个注解shiro的标签不生效
     * 　开启shiro aop注解支持.
     * 　使用代理方式;所以需要开启代码支持;
     * 
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    
    @Bean("defaultAdvisorAutoProxyCreator")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        //指定强制使用cglib为action创建代理对象
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * Shiro生命周期处理器
     * @return
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * shiroFilter作为代理filter
     * @return
     */
    @Bean("delegatingFilterProxy")
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }
    
    /**
     * 使用redis pool配置bean
     * @param jedisPool
     * @return
     */
    @Bean
    public RedisManager redisManager(JedisPool jedisPool) {
        RedisManager redisManager = new RedisManager();
        redisManager.setJedisPool(jedisPool);
        return redisManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        return redisCacheManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    @Bean
    public DefaultWebSessionManager sessionManager(RedisSessionDAO sessionDAO, SimpleCookie simpleCookie) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }

    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(NAME);
        simpleCookie.setValue(VALUE);
        return simpleCookie;
    }

}
