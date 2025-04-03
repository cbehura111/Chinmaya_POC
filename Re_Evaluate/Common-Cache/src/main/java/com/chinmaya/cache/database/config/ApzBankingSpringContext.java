package com.chinmaya.cache.database.config;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.LoggerConstants;

import groovy.lang.Singleton;

@Startup
@Singleton
public class ApzBankingSpringContext {

	private static AbstractApplicationContext abContext = null;
	
	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, AppzillonCBSpringContext.class.toString());

	private ApzBankingSpringContext() {
		// Exists only to defeat instantiation.
	}

	@PostConstruct
	public void init() {
		if (abContext == null) {
			abContext = new AnnotationConfigApplicationContext(ApzBankingConfiguration.class);
		}
	}

	public static AbstractApplicationContext getCustomSpringContext() {
		if (abContext == null) {
			abContext = new AnnotationConfigApplicationContext(ApzBankingConfiguration.class);
		}
		logger.debug("AbstractApplicationContext:"+abContext);
		return abContext;
	}

	public static Object getBean(String beanName) {
		// return
		// ApplicationInitializer.getInstance().getSpringContext().getBean(beanName);
		AbstractApplicationContext customCtx = ApzBankingSpringContext.getCustomSpringContext();
		return customCtx.getBean(beanName);
	}
}
