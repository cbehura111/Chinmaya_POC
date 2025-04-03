package com.chinmaya.cache.service;

import java.util.HashMap;
import java.util.Map;

public class CacheService {

	public static Map<String, String> commonProperties = new HashMap<String, String>();
	public static Map<String, String> externalProperties = new HashMap<String, String>();

	public void initializeCommonProperties(Map<String, String> commonValues) {
		commonProperties = commonValues;
	}

	public void initializeExternalProperties(Map<String, String> commonValues) {
		externalProperties = commonValues;
	}

	public Map<String, String> getCommonProperties() {
		return commonProperties;
	}

	public Map<String, String> getExternalProperties() {
		return externalProperties;
	}

}