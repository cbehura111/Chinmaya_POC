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
public class AppzillonCBSpringContext {

	private static AbstractApplicationContext apzContext = null;
	
	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, AppzillonCBSpringContext.class.toString());

	private AppzillonCBSpringContext() {
		// Exists only to defeat instantiation.
	}

	@PostConstruct
	public void init() {
		if (apzContext == null) {
			apzContext = new AnnotationConfigApplicationContext(AppzillonCBConfiguration.class);
		}
	}

	public static AbstractApplicationContext getCustomSpringContext() {
		if (apzContext == null) {
			apzContext = new AnnotationConfigApplicationContext(AppzillonCBConfiguration.class);
		}
		logger.debug("AbstractApplicationContext:"+apzContext);
		return apzContext;
	}

	public static Object getBean(String beanName) {
		// return
		// ApplicationInitializer.getInstance().getSpringContext().getBean(beanName);
		AbstractApplicationContext customCtx = AppzillonCBSpringContext.getCustomSpringContext();
		return customCtx.getBean(beanName);
	}

}
