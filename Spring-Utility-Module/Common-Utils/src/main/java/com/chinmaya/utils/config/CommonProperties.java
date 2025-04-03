package com.chinmaya.utils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class CommonProperties {

	private final Map<String, String> common = new HashMap<>();

	@Value("${exchangeRateIntfName}")
	private String exchangeRateIntfName;

	@Value("${statusCodeNodeName}")
	private String statusCodeNodeName;
	
	@Value("${securitykey}")
	private String securitykey;

	public Map<String, String> getCommon() {
		common.put("exchangeRateIntfName", exchangeRateIntfName);
		common.put("statusCodeNodeName", statusCodeNodeName);
		common.put("securitykey", securitykey);
		return common;
	}

}
