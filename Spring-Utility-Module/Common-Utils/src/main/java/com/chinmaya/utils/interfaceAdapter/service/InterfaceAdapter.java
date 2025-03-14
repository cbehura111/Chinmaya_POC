package com.chinmaya.utils.interfaceAdapter.service;

import com.chinmaya.utils.interfaceAdapter.utils.AdapterUtil;
import com.chinmaya.utils.interfaceAdapter.utils.ParserUtils;
import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.cache.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;

import static com.chinmaya.utils.constants.CommonConstants.API_REQUEST;

@Component
public class InterfaceAdapter {

	@Autowired
	private HttpInterfaceParser httpInterfaceParser;

	@Autowired
	private SoapInterfaceParser soapInterfaceParser;

	@Autowired
	private AdapterUtil adapterUtil;

	@Autowired
	private ParserUtils parserUtils;

	private static final Logger logger = LogManager.getLogger(InterfaceAdapter.class);

	private static final String INTF_FILENOTFOUND_LG = "Please upload the interface file in the configured path.";

	private static final String REQ_RES_MISMATCH_LG = "Request/Response parameters are missing.";

	private static final String EFRMS_INTF = "CheckEFRMS";
	
	private static final String EFRMS_SCORE = "EFRMSScore";

	/**
	 * Method to call External Rest API by reading the content of external Interface
	 * file.
	 * 
	 * @param header         Request Header Parameters
	 * @param restApiRequest Front-End API request as {@code Object}
	 * @param interfaceName  Name of the External Interface File.
	 * @return Returns the API Response as {@code Mono<Object>}
	 */
	public Mono<Object> callExternalService(Header header, Object restApiRequest, String interfaceName) {

		logger.debug("Start : interface adapter flow=",
				restApiRequest + ", interfaceFileName=" + interfaceName + ", header=" + header);
		Mono<Object> apiResponseMono = Mono.just(new JSONObject());

		try {
			ObjectMapper mapperObj = new ObjectMapper();
			JSONObject requestWrapper = new JSONObject(mapperObj.writeValueAsString(restApiRequest));

			JSONObject request = new JSONObject();
			request.put(API_REQUEST, requestWrapper);
			String interfaceFileName = interfaceName + ".apzinterface";

			String interfaceFileContent = parserUtils.readInterfaceContentFromServer(interfaceFileName);
			JSONObject interfaceJsonContent = new JSONObject(interfaceFileContent);
			if ("HTTP".equalsIgnoreCase(interfaceJsonContent.get("servicetype").toString())) {
				logger.debug("Service type is http");
				apiResponseMono = httpInterfaceParser.callService(request, interfaceJsonContent, header, interfaceName);
			} else {
				logger.debug("Invalid Service Type");
				apiResponseMono = adapterUtil
						.setErrorMono("Invalid Service Type. Please configure the interface type as HTTP", "3");
			}
		} catch (FileNotFoundException e) {
			logger.error("Error occurred while calling the service file not found, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono(INTF_FILENOTFOUND_LG, "2");
		} catch (Exception e) {
			logger.error("Error occurred while calling the service, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono(REQ_RES_MISMATCH_LG, "5");
		}
		return apiResponseMono;
	}

	/**
	 * Method to call External SOAP API by reading the content of external Interface
	 * file.
	 * 
	 * @param header         Request Header Parameters
	 * @param restApiRequest Front-End API request as {@code Object}
	 * @param interfaceName  Name of the External Interface File.
	 * @return Returns the API Response as {@code Mono<Object>}
	 */
	public JSONObject callExternalSOAPService(Header header, Object restApiRequest, String interfaceName) {

		logger.debug("Start : interface adapter flow=",
				restApiRequest + ", interfaceFileName=" + interfaceName + ", header=" + header);
		JSONObject apiResponse = new JSONObject();
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			JSONObject requestWrapper = new JSONObject(mapperObj.writeValueAsString(restApiRequest));

			JSONObject request = new JSONObject();
			request.put(API_REQUEST, requestWrapper);
			String interfaceFileName = interfaceName + ".apzinterface";

			String interfaceFileContent = parserUtils.readInterfaceContentFromServer(interfaceFileName);
			JSONObject interfaceJsonContent = new JSONObject(interfaceFileContent);
			if ("SOAP".equalsIgnoreCase(interfaceJsonContent.get("servicetype").toString())) {
				logger.debug("Service type is soap");
				apiResponse = soapInterfaceParser.callService(request, interfaceJsonContent, header, interfaceName);
			} else {
				logger.debug("Invalid Service Type");
				apiResponse = adapterUtil.setError("Invalid Service Type. Please configure the interface type as SOAP",
						"3");
			}
		} catch (FileNotFoundException e) {
			logger.error("Error occurred while calling the service file not found, error = ", e);
			apiResponse = adapterUtil.setError(INTF_FILENOTFOUND_LG, "2");
		} catch (Exception e) {
			logger.error("Error occurred while calling the service, error = ", e);
			apiResponse = adapterUtil.setError(REQ_RES_MISMATCH_LG, "5");
		}
		logger.debug("End : adapter flow with response = ", apiResponse);
		return apiResponse;

	}

	/**
	 * Method to call External Rest API by reading the content of external Interface
	 * file to process workflow.
	 * 
	 * @param interfaceRequest Front-End API request as {@code Object}
	 * @param interfaceName    Name of the External Interface File.
	 * @param header           Request Header Parameters
	 * @return Returns the API Response as {@code Mono<Object>}
	 */
	public Mono<Object> executeWorkflowAdapter(JSONObject interfaceRequest, String interfaceName, Header header) {
		logger.debug("Start : interface adapter flow");
		JSONObject apiResponse = new JSONObject();
		Mono<Object> apiResponseMono = Mono.just(new JSONObject());
		AdapterUtil adapterUtil = new AdapterUtil();
		try {
			logger.debug("Start : interface adapter request = " + interfaceRequest);
			String interfaceFileName = interfaceName + ".apzinterface";
			logger.debug("interfaceFileName =" + interfaceFileName);
			String interfaceFileContent = parserUtils.readInterfaceContentFromServer(interfaceFileName);
			logger.debug("interfaceFileContent = " + interfaceFileContent);
			JSONObject interfaceJsonContent = new JSONObject(interfaceFileContent);
			String serviceType = interfaceJsonContent.get("servicetype").toString();
			if (serviceType.equalsIgnoreCase("HTTP")) {
				logger.debug("Service type is http");
				apiResponseMono = this.httpInterfaceParser.callService(interfaceRequest, interfaceJsonContent, header,
						interfaceName);
			} else if (serviceType.equalsIgnoreCase("SOAP")) {
				logger.debug("Service type is soap");
				apiResponse = this.soapInterfaceParser.callService(interfaceRequest, interfaceJsonContent, header,
						interfaceName);
			} else {
				logger.debug("Invalid Service Type");
				apiResponseMono = adapterUtil
						.setErrorMono("Invalid Service Type. Please configure the interface type as HTTP/SOAP", "3");
			}
		} catch (FileNotFoundException e) {
			logger.error("Error occurred while calling the service file not found, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono("Please upload the interface file in the configured path.", "2");
		} catch (JSONException e) {
			logger.error("Error occurred while calling the service, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono("Request/Response parameters are missing.", "5");
		} catch (Exception e) {
			logger.error("Error occurred while calling the service, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono("Request/Response parameters are missing.", "5");

		}
		logger.debug("End : adapter flow with response = " + apiResponse);
		return apiResponseMono;
	}

	/**
	 * Method to call External Rest API by reading the content of external Interface
	 * JSON definition file.
	 * 
	 * @param header             Request Header Parameters
	 * @param restApiRequest     Front-End API request as {@code Object}
	 * @param interfaceName      Name of the External JSON File.
	 * @param isExternalJSONCall Flag to denote that interface call will be via JSON
	 *                           definition
	 * @return Returns the API Response as {@code Mono<Object>}
	 */
	public Mono<Object> callExternalService(Header header, Object restApiRequest, String interfaceName,
			boolean isExternalJSONCall) {
		logger.debug("Start : interface adapter flow= "
			+restApiRequest + ", interfaceFileName=" + interfaceName + ", header=" + header);
		Mono<Object> apiResponseMono = Mono.just(new JSONObject());

		try {
			ObjectMapper mapperObj = new ObjectMapper();
			JSONObject requestWrapper = new JSONObject(mapperObj.writeValueAsString(restApiRequest));

			JSONObject request = new JSONObject();
			request.put(API_REQUEST, requestWrapper);

			String interfaceFileName = interfaceName + ".json";

			String interfaceFileContent = parserUtils.readInterfaceJSONFileContentFromServer(interfaceFileName);
			JSONObject interfaceJsonContent = new JSONObject(interfaceFileContent);
			if ("HTTP".equalsIgnoreCase(interfaceJsonContent.get("servicetype").toString())) {
				logger.debug("Service type is http");
				apiResponseMono = httpInterfaceParser.callRestAPIService(request.toString(), interfaceFileContent,
						header, interfaceName);
			} else {
				logger.debug("Invalid Service Type");
				apiResponseMono = adapterUtil
						.setErrorMono("Invalid Service Type. Please configure the interface type as HTTP/SOAP", "3");
			}
		} catch (FileNotFoundException e) {
			logger.error("Error occurred while calling the service file not found, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono(INTF_FILENOTFOUND_LG, "2");
		} catch (Exception e) {
			logger.error("Error occurred while calling the service, error = ", e);
			apiResponseMono = adapterUtil.setErrorMono(REQ_RES_MISMATCH_LG, "5");
		}
		return apiResponseMono;

	}
	
	public Mono<Boolean> checkEFRMS(Header header, Object restApiRequest, boolean isExternalJSONCall) {
		logger.debug("Start : check EFRMS");
		try {
			Mono<Object> checkEFRMSResponse = callExternalService(header, restApiRequest, EFRMS_INTF, true);
			return checkEFRMSResponse.map(val -> {
				JSONObject resObj = new JSONObject(val);
				logger.debug("Response from EFRMS service call :: {} ", resObj);

				if (resObj.has("ErrorCode") && resObj.get("ErrorCode").toString().equalsIgnoreCase("0")) {
					JSONArray feedbackFieldsArr = resObj.getJSONArray("FeedbackFields");
					for (int i = 0; i < feedbackFieldsArr.length(); i++) {
						JSONObject field = feedbackFieldsArr.getJSONObject(i);
						if (field.has("Key") && "SCORE".equalsIgnoreCase(field.getString("Key"))) {
							int score = field.getInt("Value");
							String efrmsScoreStr = CommonUtils.getExternalProperties(EFRMS_SCORE);
							int efrmsScore = Integer.parseInt(efrmsScoreStr);
							return score <= efrmsScore;
						}
					}
				} else {
					logger.warn("Error code is not present in Response or Error code is not equals to 0");
				}
				return false;
			});
		} catch (Exception e) {
			logger.error("Error occurred while calling the check EFRMS, error = {}", e);
			return Mono.just(false);
		}

	}

}
