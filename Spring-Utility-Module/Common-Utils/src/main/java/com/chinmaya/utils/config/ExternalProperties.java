package com.chinmaya.utils.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("file:${externalPropFile.path}")
@ConfigurationProperties(prefix = "ab")
@Slf4j
public class ExternalProperties {

	private final Map<String, String> common = new HashMap<>();

	public Map<String, String> getCommon() {
		log.debug("Debugging this line");
		return common;
	}
	
	

	/*
	 * @Value("${ab.common.interFaceDir}") private String interFaceDir;
	 *
	 * @Value("${ab.common.soapProtocol}") private String soapProtocol;
	 */

	/*
	 * public Map<String, String> getCommon() { common.put("interFaceDir",
	 * interFaceDir); common.put("soapProtocol", soapProtocol); return common; }
	 */
}
