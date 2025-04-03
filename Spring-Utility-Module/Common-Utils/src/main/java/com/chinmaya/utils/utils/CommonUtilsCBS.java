package com.chinmaya.utils.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

@Component
public class CommonUtilsCBS {

	private static final Logger logger = LogManager.getLogger(CommonUtilsCBS.class);

	public int randomNumGenerate(int max) {
		return new SecureRandom().nextInt(max);
	}

	public int randomNumGenerate(int min, int max) {
		int ranValue = new SecureRandom().nextInt();
		return min + (ranValue * ((max - min) + 1));
	}

	public String generateReqId(String customerId, int customerIdTrim) {
		if (customerId.length() >= customerIdTrim) {
			customerId = customerId.substring(customerId.length() - customerIdTrim);
		}
		return Long.toString(Instant.now().toEpochMilli()).substring(0, 12) + customerId;
	}

	public String generateReqId() {
		return Long.toString(Instant.now().toEpochMilli()).substring(0, 10);
	}
	
	public String generateRequstId() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss"); // Format: YYYYMMDDHHMMSS
		String timestamp = now.format(formatter);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(random.nextInt(9) + 1);
		for (int i = 1; i < 8; i++) {
			sb.append(random.nextInt(10));
		}
		String randomNumber = sb.toString();
		String finalOutput = timestamp + randomNumber;
		return finalOutput;
	}
	
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss"); // Format: YYYYMMDDHHMMSS
        String timestamp = now.format(formatter);
        System.out.println(timestamp);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(9) + 1);
        for (int i = 1; i < 8; i++) {
            sb.append(random.nextInt(10)); 
        }
        String randomNumber = sb.toString();
        System.out.println(randomNumber);
        String randomNumber2 = timestamp + randomNumber;
        System.out.println(randomNumber2);
	}

	public String generateReferenceNumber(int lengthOfCode) {
		String values = "0123456789";
		char[] refCode = new char[lengthOfCode];
		for (int i = 0; i < lengthOfCode; i++) {
			refCode[i] = values.charAt(new SecureRandom().nextInt(values.length()));
		}
		logger.debug("Random String generated for Auth Ref Code is -> " + Arrays.toString(refCode));
		return String.valueOf(refCode);
	}

	public Object generateRequest(String request, Class<?> wrapperClass) {
		ObjectMapper mapper = new ObjectMapper();
		Object requestObject = null;
		try {
			requestObject = mapper.readValue(request, wrapperClass);
		} catch (Exception e) {
			requestObject = null;
			logger.error("Error generating request " + e.getMessage());
		}
		return requestObject;
	}

	public String generateRequestString(Object requestObject) {
		ObjectMapper mapper = new ObjectMapper();
		String requestString = null;
		try {
			requestString = mapper.writeValueAsString(requestObject);
		} catch (Exception e) {
			requestString = null;
			logger.error("Cannot process persisted request payload " + e.getMessage());
		}
		return requestString;
	}

	public int generateRandomId(int minValue, int maxValue) {
		return new SecureRandom().nextInt(maxValue - minValue) + minValue;
	}

	public String getTxnRefNum(String pUserId) {
		logger.debug("Start : getTxnRefNum with pUserId = " + pUserId);
		String refNumber = null;

		if (pUserId == null || pUserId.isEmpty())
			refNumber = String.valueOf(new SecureRandom().nextInt(Integer.parseInt("999999999")));
		else
			refNumber = pUserId.substring(pUserId.length() - 4)
					+ String.valueOf(new SecureRandom().nextInt(Integer.parseInt("99999")));

		logger.debug("End : getTxnRefNum with resp = " + refNumber);
		return refNumber;
	}

	public static int getTxnRefNumInt(String pUserId) {
		logger.debug("Start : getTxnRefNum with pUserId = " + pUserId);
		String refNumber = null;
		if (pUserId == null || pUserId.isEmpty())
			refNumber = String.valueOf(new SecureRandom().nextInt(Integer.parseInt("999999999")));
		else
			refNumber = pUserId.substring(pUserId.length() - 4)
					+ String.valueOf(new SecureRandom().nextInt(Integer.parseInt("99999")));
		logger.debug("End : getTxnRefNum with resp = " + refNumber);
		return Integer.parseInt(refNumber);
	}

	public static boolean isNumeric(String strNum) {
		try {
			if ((strNum == null) || (strNum.isEmpty())) {
				return false;
			}
			new BigDecimal(strNum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
