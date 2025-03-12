package com.chinmaya.cache.config;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.CommonConstants;
import com.chinmaya.cache.constants.LoggerConstants;
import com.chinmaya.cache.database.config.AppzillonCBConfiguration;
import com.chinmaya.cache.database.config.ApzBankingConfiguration;
import com.chinmaya.cache.utils.GenericUtils;

public class ApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, ApplicationInitializer.class.toString());

	private boolean initialized = false;

	private static ApplicationInitializer applicationInitializer;

	private static WebApplicationContext springContext;

	@Autowired
	private AnnotationConfigApplicationContext context;

	public void initializeProps(ServletContext servletContxt) {
		logger.debug("Starting Cache Services Intialization", "[CacheInitializer] =>");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContxt);
		logger.debug("{} Cache WebApplicationContext {}", "[CacheInitializer] => ", wac);
		if (!this.initialized) {
			this.init(wac);
			this.initializeProperties();
			this.initialized = true;
			
		}
	}

	public void initializeProperties() {
		try {
			if (null == getContext()) {
				logger.debug("Context is null, Hence setting the context.");
				setContext(new AnnotationConfigApplicationContext(CommonProperties.class, ExternalProperties.class,
						AppzillonCBConfiguration.class, ApzBankingConfiguration.class));
			}
			PropertyLoader propLoader = new PropertyLoader();
			propLoader.loadClassPathProperties(context);
			propLoader.loadExternalProperties(context);
			propLoader.refreshDBCache(context);
			this.callSchedulerToRefreshCache(context);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e.getMessage());
		}
	}
	
	/*
	 * public void initializePropertiesForAPIRefresh() { try { if (null ==
	 * getContext()) { logger.
	 * debug("Inside initializePropertiesForAPIRefresh:: Context is null, Hence setting the context."
	 * ); setContext(new
	 * AnnotationConfigApplicationContext(ExternalProperties.class,
	 * ApzBankingConfiguration.class)); } PropertyLoader propLoader = new
	 * PropertyLoader(); propLoader.loadExternalProperties(context);
	 * propLoader.refreshDBCache(context); } catch (Exception e) {
	 * logger.error(CommonConstants.EXCEPTION_OCCURED + e.getMessage());
	 * e.printStackTrace(); } }
	 */
	
	

	/**
	 * Method to refresh the cached data based on the schedule interval based on the
	 * configured duration(in minutes).
	 * 
	 * @author akshay.upadhya
	 * @param appContext 
	 * @param externalProperties
	 * @param externalProps
	 * @since 23.08.2022
	 * 
	 */
	private void callSchedulerToRefreshCache(AnnotationConfigApplicationContext appContext) {

		Map<String, String> externalProps = GenericUtils.getAllExternalFileProperties();
		String isScheduleBasedCacheRefresh = externalProps
				.get(CommonConstants.AB_COMMON_PROP + CommonConstants.IS_SCHEDULED_CACHE_REFRESH);
		if ("Y".equalsIgnoreCase(isScheduleBasedCacheRefresh)) {
			String cacheRefreshPeriod = externalProps
					.get(CommonConstants.AB_COMMON_PROP + CommonConstants.CACHE_REFRESH_PERIOD);
			logger.debug("Schedule based Cache Refresh Enabled, Refreshing content based on configured "
					+ cacheRefreshPeriod + " minutes");
			ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
			if (null != cacheRefreshPeriod && !"".equalsIgnoreCase(cacheRefreshPeriod)) {
				scheduler.scheduleAtFixedRate(new CacheReloader(appContext), 0, Integer.parseInt(cacheRefreshPeriod),
						TimeUnit.MINUTES);
			} else {
				scheduler.scheduleAtFixedRate(new CacheReloader(appContext), 0, 5, TimeUnit.MINUTES);
			}
		}
	}

	

	public static ApplicationInitializer getInstance() {
		if (applicationInitializer == null)
			applicationInitializer = new ApplicationInitializer();
		return applicationInitializer;
	}

	public void init(WebApplicationContext wac) {
		springContext = wac;
		getInstance();
	}

	public WebApplicationContext getSpringContext() {
		return springContext;
	}

	public AnnotationConfigApplicationContext getContext() {
		return context;
	}

	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}
}
