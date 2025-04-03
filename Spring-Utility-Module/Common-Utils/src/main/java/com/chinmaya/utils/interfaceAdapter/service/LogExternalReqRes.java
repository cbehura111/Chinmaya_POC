package com.chinmaya.utils.interfaceAdapter.service;
import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.utils.payload.core.LogData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class LogExternalReqRes {

	@Autowired
	private LoggingServiceProxy proxy;

	public void logTransactionToDb(Header header, String request, String response, LocalDateTime startDateTime,
								   LocalDateTime endDateTime, String status, String requestType, JSONObject interfaceJsonContent, Boolean isJSONAdapterCall) {
		LogData logData = new LogData();
		logData.setAppId(header.getAppId());
		logData.setDeviceId(header.getDeviceId());
		logData.setInterfaceId(header.getInterfaceId());
		logData.setMasterTxnRefNo(header.getMasterTxnRefNo());
		logData.setStTm(startDateTime);
		logData.setEndTm(endDateTime);
		logData.setStatus(status);
		logData.setEndpointType(requestType);
		logData.setRequest(request);
		logData.setResponse(response);
		logData.setTxnRefNo(getTxnRefNum(header.getUserId()));
		logData.setUserId(header.getUserId());
		//proxy.logTransactionDetails(logData, interfaceJsonContent, isJSONAdapterCall);
	}

	private static String getTxnRefNum(String pUserId) {
		SecureRandom random = new SecureRandom();
		int randomno = random.nextInt(1000000);
		if (isNullOrEmpty(pUserId))
			return System.currentTimeMillis() + "" + randomno;
		else
			return (pUserId + System.currentTimeMillis() + "" + randomno);
	}

	private static boolean isNullOrEmpty(String pValue) {
		return pValue == null || pValue.isEmpty();
	}
}
