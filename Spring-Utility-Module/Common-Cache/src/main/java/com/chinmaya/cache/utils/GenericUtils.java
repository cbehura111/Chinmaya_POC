package com.chinmaya.cache.utils;

import com.chinmaya.cache.appzillon.model.WorkflowDetail;
import com.chinmaya.cache.appzillon.model.WorkflowMaster;
import com.chinmaya.cache.constants.CommonConstants;
import com.chinmaya.cache.constants.LoggerConstants;
import com.chinmaya.cache.custom.model.TbAbmiCommonCode;
import com.chinmaya.cache.service.CacheAppzillonCBService;
import com.chinmaya.cache.service.CacheApzBankingService;
import com.chinmaya.cache.service.CacheService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.iexceed.appzillon.json.JSONArray;
import com.iexceed.appzillon.json.JSONObject;
import com.iexceed.appzillon.logging.Logger;
import com.iexceed.appzillon.logging.LoggerFactory;
import com.iexceed.appzillon.message.Error;
import com.iexceed.appzillon.message.Message;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class GenericUtils {

	private GenericUtils() {
	}

	private static final Logger logger = LoggerFactory.getLoggerFactory()
			.getFrameWorksLogger(LoggerConstants.LOGGER_CACHE, GenericUtils.class.toString());

	// private static final String CACHE_APPZILLONCB_SERVICE =
	// "cacheAppzillonCBService";
	
	public static final String EXCEP_MASKING = "Error occurred while fetching masking details ="; 

	/**************** Generic Util Functions Starts ************/

	public static String getCommonProperties(String keyName) {
		logger.warn("Start : getCommonClassPathProperties:" + keyName);
		String classPathProps = null;
		try {
			CacheService cacheService = new CacheService();
			classPathProps = cacheService.getCommonProperties().get(keyName);
		} catch (Exception e) {
			logger.error("getCommonClassPathProperties error = " + e);
		}
		logger.warn("End : getCommonClassPathProperties file content response = " + classPathProps);
		return classPathProps;
	}

	public static Map<String, String> getAllCommonProperties() {
		logger.warn("Start : getAllCommonProperties:");
		Map<String, String> classPathProps = null;
		try {
			CacheService cacheService = new CacheService();
			classPathProps = cacheService.getCommonProperties();
		} catch (Exception e) {
			logger.error("getAllCommonProperties error = " + e);
		}
		logger.warn("End : getAllCommonProperties file content response = " + classPathProps);
		return classPathProps;
	}

	public static String getExternalFileProperties(String keyName) {
		logger.warn("Start : getExternalFileProperties:" + keyName);
		String classPathProps = null;
		try {
			CacheService cacheService = new CacheService();
			classPathProps = cacheService.getExternalProperties().get(keyName);
		} catch (Exception e) {
			logger.error("getExternalFileProperties error = " + e);
		}
		logger.warn("End : getExternalFileProperties file content response = " + classPathProps);
		return classPathProps;
	}

	public static Map<String, String> getAllExternalFileProperties() {
		logger.warn("Start : getAllExternalFileProperties:");
		Map<String, String> classPathProps = null;
		try {
			CacheService cacheService = new CacheService();
			classPathProps = cacheService.getExternalProperties();
		} catch (Exception e) {
			logger.error("getAllExternalFileProperties error = " + e);
		}
		logger.warn("End : getAllExternalFileProperties file content response = " + classPathProps);
		return classPathProps;
	}

	public static WorkflowMaster getWorkflowMasterProps(String workflowMasterKeyName) {
		logger.warn("Start : getWorkflowMasterProps:" + workflowMasterKeyName);
		WorkflowMaster workflowMaster = null;
		try {
			workflowMaster = CacheAppzillonCBService.getWorkflowMasterProperties().get(workflowMasterKeyName);
		} catch (Exception e) {
			logger.error("getWorkflowMasterProps error = " + e);
		}
		logger.warn("End : getWorkflowMasterProps response = " + workflowMaster);
		return workflowMaster;
	}

	public static Map<String, WorkflowMaster> getAllWorkflowMasterProps() {
		logger.warn("Start : getAllWorkflowMasterProps:");
		Map<String, WorkflowMaster> workflowMaster = null;
		try {
			workflowMaster = CacheAppzillonCBService.getWorkflowMasterProperties();
		} catch (Exception e) {
			logger.error("getAllWorkflowMasterProps error = " + e);
		}
		logger.warn("End : getAllWorkflowMasterProps response = " + workflowMaster);
		return workflowMaster;
	}

	public static List<WorkflowDetail> getWorkflowDetailsProps(String workflowMasterKeyName) {
		logger.warn("Start : getWorkflowDetailsProps:" + workflowMasterKeyName);
		List<WorkflowDetail> workflowDetail = new ArrayList<>();
		try {
			workflowDetail = CacheAppzillonCBService.getWorkflowDetailProperties().get(workflowMasterKeyName);
		} catch (Exception e) {
			logger.error("getWorkflowDetailsProps error = " + e);
		}
		logger.warn("End : getWorkflowDetailsProps response = " + workflowDetail);
		return workflowDetail;
	}

	public static Map<String, List<WorkflowDetail>> getAllWorkflowDetailsProps() {
		logger.warn("Start : getAllWorkflowDetailsProps:");
		Map<String, List<WorkflowDetail>> workflowDetail = null;
		try {
			workflowDetail = CacheAppzillonCBService.getWorkflowDetailProperties();
		} catch (Exception e) {
			logger.error("getAllWorkflowDetailsProps error = " + e);
		}
		logger.warn("End : getAllWorkflowDetailsProps response = " + workflowDetail);
		return workflowDetail;
	}

	public static TbAbmiCommonCode getCommonCodesProps(String keyName) {
		logger.warn("Start : getCommonCodesProps:" + keyName);
		TbAbmiCommonCode tbAbmiCommonCode = null;
		try {
			CacheApzBankingService cacheApzBankingService = new CacheApzBankingService();
			tbAbmiCommonCode = cacheApzBankingService.getCommonCodesProperties().get(keyName);
		} catch (Exception e) {
			logger.error("getCommonCodesProps error = " + e);
		}
		logger.warn("End : getCommonCodesProps file content response = " + tbAbmiCommonCode);
		return tbAbmiCommonCode;
	}

	public static JSONObject getCodeDescriptionFromCommonCode(String codeType, String code) {
		JSONObject description = null;
		try {
			TbAbmiCommonCode tbAbmiCommonCodeDomain = getCommonCodesProps(codeType.concat(".").concat(code));
			logger.warn("Common Code Data:" + tbAbmiCommonCodeDomain);
			if (null != tbAbmiCommonCodeDomain) {
				String codeDesc = tbAbmiCommonCodeDomain.getCodeDesc();
				description = new JSONObject(codeDesc);
				logger.warn("Code Description:" + description);
			} else {
				logger.warn("No record found in Common Code table.");
			}
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return description;
	}

	public static JSONObject getCodeDescFromCommonCodeForAuthentication(String codeType, String code, String channel) {
		JSONObject description = null;
		try {
			TbAbmiCommonCode tbAbmiCommonCodeDomain = getCommonCodesProps(
					codeType.concat(".").concat(code).concat(".").concat(channel));
			logger.warn("Common Code Data:" + tbAbmiCommonCodeDomain);
			if (null != tbAbmiCommonCodeDomain) {
				String codeDesc = tbAbmiCommonCodeDomain.getCodeDesc();
				description = new JSONObject(codeDesc);
				logger.warn("Code Description:" + description);
			} else {
				logger.warn("No record found in Common Code table.");
			}
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return description;
	}

	public static String getPrimaryCurrency() {
		String primaryCcy = "";
		TbAbmiCommonCode tbCommonCode = getCommonCodesProps(
				CommonConstants.CODETYPE.concat(".").concat(CommonConstants.PRIMARY_CCY));
		if (null != tbCommonCode && null != tbCommonCode.getCodeDesc()) {
			primaryCcy = tbCommonCode.getCodeDesc();
		}
		return primaryCcy;
	}

	public static TbAbmiCommonCode getCommonCodeMaskingObj() {
		logger.warn("Start: getCommonCodeMaskingObj");
		TbAbmiCommonCode tbCommonCode = null;
		try {

			tbCommonCode = getCommonCodesProps(
					CommonConstants.CODETYPE.concat(".").concat(CommonConstants.ACCOUNT_MASK_CODE));
			logger.warn(CommonConstants.ACCOUNT_MASKING_DETAILS + tbCommonCode);
		} catch (Exception e) {
			logger.error(EXCEP_MASKING + e);
		}
		logger.warn("End: getCommonCodeMaskingObj with response = " + tbCommonCode);
		return tbCommonCode;
	}

	public static String getAccountMaskingCodeDetails(TbAbmiCommonCode tbCommonCode, String keyName,
			String maskObjName) {
		logger.warn("Start: getMaskingDetails");
		String keyValue = null;
		try {
			logger.warn(CommonConstants.ACCOUNT_MASKING_DETAILS + tbCommonCode);
			if (null != tbCommonCode) {
				JSONObject maskingDetails = new JSONObject(tbCommonCode.getCodeDesc());
				keyValue = maskingDetails.getJSONObject(CommonConstants.ACCOUNT_MASK).getJSONObject(maskObjName)
						.get(keyName).toString();
			}
		} catch (Exception e) {
			logger.error(EXCEP_MASKING + e);
		}
		logger.warn("End: getMaskingFlag with response = " + keyValue);
		return keyValue;
	}

	/**
	 * Generic function to set message header for the service call invoked via VAPT
	 * validation wrapper.
	 * 
	 * @param pMessage
	 * @return
	 */
	public static JSONObject setMessageHeaderDtls(Message pMessage) {
		JSONObject requestHeader = new JSONObject();
		requestHeader.put(CommonConstants.APP_ID, pMessage.getHeader().getAppId());
		requestHeader.put(CommonConstants.USER_ID, pMessage.getHeader().getUserId());
		requestHeader.put("interfaceId", pMessage.getHeader().getInterfaceId());
		requestHeader.put("deviceId", pMessage.getHeader().getDeviceId());
		requestHeader.put("masterTxnRefNo", pMessage.getHeader().getMasterTxnRef());
		requestHeader.put("deviceType", pMessage.getHeader().getOs());
		requestHeader.put("customerId", pMessage.getHeader().getUserId());
		return requestHeader;
	}

	/**
	 * Function to get the TxnAppId string from properties file
	 * 
	 * @author akshay.upadhya
	 * @since 01.04.21
	 * @return
	 */
	public static String getTxnAppId() {
		String appId = null;
		try {
			appId = GenericUtils.getExternalFileProperties(CommonConstants.AB_COMMON_PROP + CommonConstants.TXN_APP_ID);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return appId;
	}

	/**
	 * Function to get the MpinAppId string from properties file
	 * 
	 * @author rajesh.murugesan
	 * @since 07.12.22
	 * @return
	 */
	public static String getMpinAppId() {
		String appId = null;
		try {
			appId = GenericUtils
					.getExternalFileProperties(CommonConstants.AB_COMMON_PROP + CommonConstants.MPIN_APP_ID);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return appId;
	}
	
	public static String getAppId() {
		String appId = null;
		try {
			appId = GenericUtils
					.getExternalFileProperties(CommonConstants.AB_COMMON_PROP + CommonConstants.APP_ID);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return appId;
	}

	/**
	 * 
	 * Method to fetch authenticator appId
	 * 
	 * @author akshay.upadhya
	 * @since 27.11.2023
	 * @return
	 */
	public static String getAuthenticatorAppId() {
		String appId = null;
		try {
			appId = GenericUtils
					.getExternalFileProperties(CommonConstants.AB_COMMON_PROP + CommonConstants.AUTHENTICATOR_APPID);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return appId;
	}

	public static String obtainIntfName(String intfKey) {
		String intfName = null;
		try {
			intfName = GenericUtils.getExternalFileProperties(CommonConstants.AB_COMMON_PROP + intfKey);
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return intfName;
	}

	public static void setError(Message pMessage, String errorMsg, String errorCode) {
		logger.warn("Start : setError, errorMsg:" + errorMsg + ", errorCode:" + errorCode);
		pMessage.getErrors().clear();

		Error error = Error.getInstance();
		error.setErrorCode(errorCode);
		error.setErrorDesc(errorMsg);

		JSONObject errorJson = new JSONObject();
		errorJson.put("errorCode", errorCode);
		errorJson.put("errorMsg", errorMsg);

		pMessage.getResponseObject().setResponseJson(errorJson);
		pMessage.getErrors().add(error);
		pMessage.getHeader().setStatus(false);
		logger.warn("End : setError");
	}

	/**
	 * Function to validate whether search key is present in the JSON keys or not.
	 * 
	 * @author akshay.upadhya
	 * @since 12.02.2021
	 * @param obj
	 * @return
	 */
	public static String verifyJsonKey(JSONObject obj, String keyName, String filterType) {
		String jsonKey = null;
		try {
			if (keyName != null) {
				List<String> listKeyNames = Arrays.asList(keyName.split(","));
				logger.warn("listKeyNames" + listKeyNames);
				logger.debug("Key Name from the property file::" + keyName);
				for (String keyStr : obj.keySet()) {
					String searchKey = keyStr;
					if (keyStr.contains("~")) {
						searchKey = keyStr.split("~")[0];
					}
					logger.warn("searchKey :: " + searchKey);
					if ((CommonConstants.ACCOUNT_MASKING.equalsIgnoreCase(filterType)
							|| CommonConstants.SHOW_HIDE_ACCOUNT.equalsIgnoreCase(filterType)
							|| CommonConstants.ACCTYPE_MAPPER.equalsIgnoreCase(filterType)
							|| CommonConstants.CARD_MASK.equalsIgnoreCase(filterType))
							&& listKeyNames.contains(searchKey)) {
						jsonKey = keyStr;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		logger.warn("Validated key:" + jsonKey);
		return jsonKey;
	}

	public static boolean isJSONValid(String jsonInString) {
		logger.warn("Start : isJSONValid");
		boolean validJson = false;
		try {
			if ((jsonInString == null) || (jsonInString.isEmpty())) {
				validJson = false;
			} else {
				final ObjectMapper mapper = new ObjectMapper();
				mapper.readTree(jsonInString);
				validJson = true;
			}
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
			validJson = false;
		}
		logger.warn("End : isJSONValid with response = " + validJson);
		return validJson;
	}

	/**
	 * Generic method to update the nested json value based on the key and new value
	 * 
	 * @author akshay.upadhya
	 * @since 03.02.2021
	 * @param obj
	 * @param keyMain
	 * @param newValue
	 * @return
	 * @throws Exception
	 */
	public static JSONObject updateNestedKeyValue(JSONObject obj, String keyMain, String newValue) {
		try {
			Iterator<String> iterator = obj.keys();
			String key = null;
			while (iterator.hasNext()) {
				key = iterator.next();
				// If key is just a string, Replace the value
				if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)
						&& (key.equalsIgnoreCase(keyMain))) {
					// put new value
					obj.put(key, newValue);
					return obj;
				}
				// In case of JSONObject, Call the recursive function once.
				if (obj.optJSONObject(key) != null) {
					updateNestedKeyValue(obj.getJSONObject(key), keyMain, newValue);
				}
				// In case of JSONArray, Call the recursive function in a loop.
				if (obj.optJSONArray(key) != null) {
					JSONArray jArray = obj.getJSONArray(key);
					for (int i = 0; i < jArray.length(); i++) {
						updateNestedKeyValue(jArray.getJSONObject(i), keyMain, newValue);
					}
				}
			}
		} catch (Exception e) {
			logger.error(CommonConstants.EXCEPTION_OCCURED + e);
		}
		return obj;
	}

	/**
	 * Generic method to fetch the parent node based on the key element in a JSON
	 * Object
	 * 
	 * @author akshay.upadhya
	 * @since 17.05.2021
	 * @param obj
	 * @param keyMain
	 * @param newValue
	 * @return
	 * @throws Exception
	 */
	public static void getParentName(JsonNode node, String targetChildName, List<String> fieldNames) {
		if (node.getNodeType() == JsonNodeType.ARRAY) {
			node.elements().forEachRemaining(x -> getParentName(x, targetChildName, fieldNames));
			return;
		}
		if (node.getNodeType() != JsonNodeType.OBJECT) {
			return;
		}
		node.fields().forEachRemaining(x -> {
			Iterator<String> iter = x.getValue().fieldNames();
			while (iter.hasNext()) {
				String fieldName = iter.next();
				if (fieldName.equals(targetChildName)) {
					fieldNames.add(x.getKey());
				}
			}
			getParentName(x.getValue(), targetChildName, fieldNames);
		});
	}

	/**
	 * 
	 * Method to merge payload data with requestObj to handle the single reequestObj
	 * format
	 * 
	 * @author akshay.upadhya
	 * @since 04.09.2020
	 * @param pMessage
	 * @return
	 */
	public static JSONObject mergeRequestPayload(Message pMessage) {

		JSONObject pMessageReqObj = pMessage.getRequestObject().getRequestJson();
		try {
			logger.warn("pMessage Request JSON:" + pMessageReqObj);
			JSONObject apiRequest = pMessageReqObj.getJSONObject(CommonConstants.API_REQUEST);
			JSONObject request = apiRequest.getJSONObject(CommonConstants.REQUEST_OBJ);
			if (request.has(CommonConstants.PAYLOAD_TXT_LW)) {
				logger.warn("Payload object found:" + request.getJSONObject(CommonConstants.PAYLOAD_TXT_LW));
				JSONObject payload = request.getJSONObject(CommonConstants.PAYLOAD_TXT_LW);
				JSONObject merged = new JSONObject(payload, JSONObject.getNames(payload));
				for (String key : JSONObject.getNames(request)) {
					merged.put(key, request.get(key));
				}
				// merged.remove(CommonConstants.PAYLOAD_TXT_LW);
				logger.warn("Final Merged Request Object:" + merged);
				pMessageReqObj.getJSONObject(CommonConstants.API_REQUEST).put(CommonConstants.REQUEST_OBJ, merged);
			}
		} catch (Exception e) {
			logger.error("Merged Payload Exception:" + e);
		}
		return pMessageReqObj;
	}

	public static boolean isNumeric(String text) {
		Pattern digitPattern = Pattern.compile("\\d+");
		return digitPattern.matcher(text).matches();
	}

	public static boolean isAplhaNumeric(String text) {
		Pattern digitPattern = Pattern.compile("[a-zA-Z0-9]+");
		return digitPattern.matcher(text).matches();
	}

	public static boolean isAlphabet(String text) {
		Pattern digitPattern = Pattern.compile("[a-zA-Z]+");
		return digitPattern.matcher(text).matches();
	}

	public static String addCommasToNumericString(String digits) {
		logger.debug("Start : addCommasToNumericString with request = " + digits);
		String result = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= digits.length(); ++i) {
			char ch = digits.charAt(digits.length() - i);
			if (i % 3 == 1 && i > 1) {
				sb = sb.append(",").append(result);
			}
			result = sb.append(ch).append(result).toString();
		}
		logger.debug("End : addCommasToNumericString with response = " + result);
		return result;
	}

	public static String formatAmount(double amount) {
		logger.debug("Start : formatAmount with request = " + amount);
		String formattedAmount;

		try {
			logger.debug("formatting the decimals to 2 digits");
			DecimalFormat df = new DecimalFormat("0.00");
			formattedAmount = df.format(amount);

			String decimalAmt = formattedAmount.substring(formattedAmount.length() - 3);
			logger.debug("decimalAmt = " + decimalAmt);

			logger.debug("formatting the entire amount");
			if ((formattedAmount.charAt(0) == '+') || (formattedAmount.charAt(0) == '-')) {
				logger.debug("Adding commas ignoring the +/- sign");
				formattedAmount = formattedAmount.charAt(0)
						+ addCommasToNumericString(formattedAmount.substring(1, formattedAmount.length() - 3))
						+ decimalAmt;
			} else {
				formattedAmount = addCommasToNumericString(formattedAmount.substring(0, formattedAmount.length() - 3))
						+ decimalAmt;
			}
		} catch (Exception e) {
			logger.debug("Error while formatting the amount, error msg = " + e);
			formattedAmount = String.valueOf(amount);
		}

		logger.debug("End : formatAmount with response = " + formattedAmount);
		return formattedAmount;
	}

	public static String formatLakh(double d, String currency) {
		TbAbmiCommonCode tbCommonCode = getCommonCodesProps(
				CommonConstants.CODETYPE.concat(".").concat("AMOUNTFORMAT"));
		String formatVal = "0";
		if (null != tbCommonCode) {
			JSONObject amountFormatJSON = new JSONObject(tbCommonCode.getCodeDesc());
			JSONArray decimalFormatArr = amountFormatJSON.getJSONObject("AmountFormat").getJSONObject("decimal")
					.getJSONArray("currencyDecimal");
			for (int j = 0; j < decimalFormatArr.length(); j++) {
				if (currency.equalsIgnoreCase(decimalFormatArr.getJSONObject(j).getString("key"))) {
					formatVal = decimalFormatArr.getJSONObject(j).getString("value");
					break;
				}
			}
		}
		String s = String.format(Locale.UK, "%1." + formatVal + "f", Math.abs(d));
		s = s.replaceAll("(.+)(...\\...)", "$1,$2");
		while (s.matches("\\d{3,},.+")) {
			s = s.replaceAll("(\\d+)(\\d{2},.+)", "$1,$2");
		}
		return d < 0 ? ("-" + s) : s;
	}

	// Card Masking

	public static String getCardMaskingCodeDetails(TbAbmiCommonCode tbCommonCode, String keyName) {
		logger.warn("Start: getMaskingDetails");
		String keyValue = null;
		try {
			logger.warn(CommonConstants.CARD_MASKING_DETAILS + tbCommonCode);
			if (null != tbCommonCode) {
				JSONObject maskingDetails = new JSONObject(tbCommonCode.getCodeDesc());
				keyValue = maskingDetails.getJSONObject(CommonConstants.CARD_MASK).get(keyName).toString();
			}
		} catch (Exception e) {
			logger.error(EXCEP_MASKING + e);
		}
		logger.warn("End: getMaskingFlag with response = " + keyValue);
		return keyValue;
	}
	
	public static boolean isNullOrEmpty(String value) {
		return (null == value || "".equalsIgnoreCase(value.trim()) || "null".equalsIgnoreCase(value.trim()));
	}
	/************ Generic Util Functions Ends *************/
}
