package com.windframework.shiro.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.windframework.shiro.demo.util.JedisUtil;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Bean
    @ConditionalOnMissingBean(Jedis.class)
    public JedisPool jedisPool(RedisProperties redisProperties) {
    	if (null != JedisUtil.jedisPool) {
    		return JedisUtil.jedisPool;
    	}
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置配置
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
        jedisPoolConfig.setTestOnReturn(true);
        
        int timeout = 2*1000;
        return new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), 
        		timeout, redisProperties.getPassword());
    }
}
