package com.chinmaya.cache.database.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.LoggerConstants;

public class AppzillonInitializer {

	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, AppzillonInitializer.class.toString());

	@Autowired
	ApplicationContext context;

	@PostConstruct
	public void init() {
		logger.debug("{} Starting Cache Processing", "[Cache Initializer] =>");
		if (context == null) {
			context = new AnnotationConfigApplicationContext(AppzillonCBConfiguration.class, ApzBankingConfiguration.class);
		}
	}

	public ApplicationContext getCamelContext() {

		if (context == null) {
			context = new AnnotationConfigApplicationContext(AppzillonCBConfiguration.class, ApzBankingConfiguration.class);
		}
		return context;
	}
}
