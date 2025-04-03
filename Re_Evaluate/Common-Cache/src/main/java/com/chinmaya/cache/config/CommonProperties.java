package com.chinmaya.cache.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class CommonProperties {

	private final Map<String, String> common = new HashMap<>();

	@Value("${ab.common.securitykey}")
	private String securityKey;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Map<String, String> getCommon() {
		common.put("encSecurityKey", securityKey);
		return common;
	}
}
