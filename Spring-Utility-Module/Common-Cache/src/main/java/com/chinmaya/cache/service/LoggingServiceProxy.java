package com.chinmaya.cache.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingServiceProxy {

	private static final Logger logger = LogManager.getLogger(LoggingServiceProxy.class);

//	@Autowired
//	private LoggingService loggingService;
//
//	public void logTransactionDetails(LogData logData, JSONObject interfaceJsonContent, Boolean isJSONAdapterCall) {
//		try {
//			loggingService.logTransactionDetails(logData, interfaceJsonContent, isJSONAdapterCall);
//		} catch (Exception e) {
//			logger.error("logTransactionDetails ERROR = " , e);
//		}
//	}
}
