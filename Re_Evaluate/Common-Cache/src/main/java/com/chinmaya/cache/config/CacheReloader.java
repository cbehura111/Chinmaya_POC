package com.chinmaya.cache.config;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.CommonConstants;
import com.chinmaya.cache.constants.LoggerConstants;

public class CacheReloader implements Runnable {

	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, CacheReloader.class.toString());
	
	private AnnotationConfigApplicationContext appContext;

	public CacheReloader(AnnotationConfigApplicationContext appContext) {
		this.appContext = appContext;
	}

	@Override
	public void run() {
		logger.debug("Invoking the Runable method, Current Execution DateTime:" + new Date());
		try {
			PropertyLoader propLoader = new PropertyLoader();
			propLoader.loadClassPathProperties(appContext);
			propLoader.loadExternalProperties(appContext);
			propLoader.refreshDBCache(appContext);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
	}
}
