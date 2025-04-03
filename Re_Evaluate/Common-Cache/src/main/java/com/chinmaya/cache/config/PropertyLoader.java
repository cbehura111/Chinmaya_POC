package com.chinmaya.cache.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.LoggerConstants;
import com.chinmaya.cache.service.CacheAppzillonCBService;
import com.chinmaya.cache.service.CacheApzBankingService;
import com.chinmaya.cache.service.CacheService;

public class PropertyLoader {

	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, PropertyLoader.class.toString());

	protected void loadClassPathProperties(AnnotationConfigApplicationContext context) {
		CacheService cacheService = new CacheService();
		CommonProperties commonProperties = (CommonProperties) context.getBean("commonProperties");
		cacheService.initializeCommonProperties(commonProperties.getCommon());
		logger.debug("CommonProperties Fetch from Cache {}" + cacheService.getCommonProperties());

	}

	protected void loadExternalProperties(AnnotationConfigApplicationContext context) {
		CacheService cacheService = new CacheService();
		ExternalProperties externalProperties = (ExternalProperties) context.getBean("externalProperties");
		cacheService.initializeExternalProperties(externalProperties.getExternal());
		logger.debug("ExternalProperties Fetch from Cache {}" + cacheService.getExternalProperties());
	}

	protected void refreshDBCache(AnnotationConfigApplicationContext context) {
		
		CacheAppzillonCBService cacheAppzillonCBService = (CacheAppzillonCBService) context
				.getBean("cacheAppzillonCBService");
		cacheAppzillonCBService.initializeWorkflowMasterProperties();
		cacheAppzillonCBService.initializeWorkflowDetailProperties();

		logger.debug(
				"cacheAppzillonCBService Workflow Master:::" + CacheAppzillonCBService.getWorkflowMasterProperties());
		logger.debug(
				"cacheAppzillonCBService Workflow Detail:::" + CacheAppzillonCBService.getWorkflowDetailProperties());
		
		CacheApzBankingService cacheApzBankingService = (CacheApzBankingService) context
				.getBean("cacheApzBankingService");
		logger.debug("cacheApzBankingService::" + cacheApzBankingService);
		cacheApzBankingService.initializeCommonCodes();
		logger.debug("cacheApzBankingService Common Codes:::" + cacheApzBankingService.getCommonCodesProperties());
	}
}
