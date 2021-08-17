package com.windframework.shiro.demo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存管理器配置
 * @author Administrator
 *
 */
@Configuration
@EnableCaching
public class CacheManagerConfig {

//	@Bean
//	public EhCacheManager getCacheManager() {
//		EhCacheManager cacheManager = new EhCacheManager();
//	    cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
//	    return cacheManager;
//	}
	
}
