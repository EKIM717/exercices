package com.windframework.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
//@ComponentScan(value = { "com.bps" }, excludeFilters = {
//		@Filter(type = FilterType.REGEX, pattern = "com\\.bps\\.multpf\\..*")
//})
@ImportResource(locations={"classpath:spring-config.xml","classpath:spring-mvc-shiro.xml"})//,"classpath:spring","classpath:spring","classpath:spring-config-shiro.xml",
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}
}
