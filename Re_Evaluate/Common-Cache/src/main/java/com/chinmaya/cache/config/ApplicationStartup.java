package com.chinmaya.cache.config;

import static com.iexceed.appzillon.utils.ServerConstants.APPID;
import static com.iexceed.appzillon.utils.ServerConstants.APPID_VALUE;
import static com.iexceed.appzillon.utils.ServerConstants.LOG_ROUTER;
import static com.iexceed.appzillon.utils.ServerConstants.MESSAGE_HEADER_USER_ID;
import static com.iexceed.appzillon.utils.ServerConstants.OSTYPE;
import static com.iexceed.appzillon.utils.ServerConstants.OSTYPE_VALUE;
import static com.iexceed.appzillon.utils.ServerConstants.TXNREF;
import static com.iexceed.appzillon.utils.ServerConstants.TXNREF_VALUE;
import static com.iexceed.appzillon.utils.ServerConstants.USERID;
import static com.iexceed.appzillon.utils.ServerConstants.USERID_VALUE;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.slf4j.MDC;

import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.chinmaya.cache.constants.LoggerConstants;

/**
 * Startup class that will be invoked when the Appzillon Server is deployed.
 * NOTE:- listener entry has to be added in the web.xml file to allow the
 * initialization of properties only during startup
 * 
 * @author akshay.upadhya
 *
 */
@WebListener
public class ApplicationStartup implements ServletContextListener {

	private static final Logger LOG = LoggerFactory.getLoggerFactory().getFrameWorksLogger(LoggerConstants.LOGGER_CACHE,
			ApplicationStartup.class.toString());

	private static final String CACHE_SERVICES_LG_ROUTE = "[CacheServices] => ";

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		MDC.put(LOG_ROUTER, "CacheAppStartUp/Shutdown");
		// MDC.put(MESSAGE_HEADER_USER_ID,"");
		// log pattern changes
		MDC.put(APPID, APPID_VALUE);
		MDC.put(OSTYPE, OSTYPE_VALUE);
		MDC.put(TXNREF, TXNREF_VALUE);
		MDC.put(USERID, USERID_VALUE);
		LOG.info("{} Ending CacheServices....", CACHE_SERVICES_LG_ROUTE);
		destory();
		LOG.info("{} CacheServices is stopped....", CACHE_SERVICES_LG_ROUTE);
		MDC.clear();
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		MDC.put(LOG_ROUTER, "CacheAppStartUp/StartUp");
		// MDC.put(MESSAGE_HEADER_USER_ID,"");
		// log pattern changes
		MDC.put(APPID, APPID_VALUE);
		MDC.put(OSTYPE, OSTYPE_VALUE);
		MDC.put(TXNREF, TXNREF_VALUE);
		MDC.put(USERID, USERID_VALUE);
		init(contextEvent);
		MDC.remove(MESSAGE_HEADER_USER_ID);
		MDC.remove(LOG_ROUTER);
		// log pattern changes
		MDC.remove(APPID);
		MDC.remove(OSTYPE);
		MDC.remove(TXNREF);
		MDC.remove(USERID);
	}

	public void init(ServletContextEvent contextEvent) {
		LOG.info("{} Starting Cache Service Processing", CACHE_SERVICES_LG_ROUTE);
		ApplicationInitializer.getInstance().initializeProps(contextEvent.getServletContext());
		LOG.info("{} Completed Cache Service Processing", CACHE_SERVICES_LG_ROUTE);
	}

	public void destory() {
		LOG.debug("Destroying context");
	}
}
