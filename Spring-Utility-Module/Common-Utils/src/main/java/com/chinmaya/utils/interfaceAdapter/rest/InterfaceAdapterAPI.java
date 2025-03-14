package com.chinmaya.utils.interfaceAdapter.rest;

import com.chinmaya.utils.interfaceAdapter.service.InterfaceAdapter;
import com.chinmaya.utils.interfaceAdapter.utils.AdapterUtil;
import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.utils.payload.core.Request;
import com.chinmaya.utils.payload.core.RequestWrapper;
import com.chinmaya.utils.payload.core.ResponseWrapper;
import com.chinmaya.cache.utils.CommonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(description = "/interfaceAdapter", name= "Common Interface Adapter")
@RequestMapping("/interfaceAdapter")
public class InterfaceAdapterAPI {

	private static final Logger logger = LogManager.getLogger(InterfaceAdapterAPI.class);

	@Autowired
	private InterfaceAdapter interfaceAdapter;

	@Autowired
	private AdapterUtil adapterUtil;

	@ApiResponses({
			@ApiResponse(responseCode = "200", description= "AppzillonBanking API reachable"),
			@ApiResponse(responseCode = "408", description= "Service Timed Out"),
			@ApiResponse(responseCode = "500", description= "Internal Server Error"),
			@ApiResponse(responseCode = "404", description= "AppzillonBanking not reachable") })
	@Operation(summary = "Execute Any External Service", description= "Common API to execute any External Service")
	@PostMapping(value = "/commonapi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<ResponseWrapper>> executeApi(@RequestBody RequestWrapper commonRequestWrapper,
															@RequestHeader String appId, @RequestHeader String interfaceId, @RequestHeader String userId,
															@RequestHeader String masterTxnRefNo, @RequestHeader String deviceId) {

		logger.warn("Start : Common Api execution with request :: " + commonRequestWrapper);
		Header header = CommonUtils.obtainHeader(appId, interfaceId, userId, masterTxnRefNo, deviceId);
		logger.debug(" Common Api execution Header value :: " + header);
		Request externalServiceRequest = commonRequestWrapper.getApiRequest();
		Mono<Object> externalServiceRespJson = interfaceAdapter.callExternalService(header, externalServiceRequest,
				externalServiceRequest.getInterfaceName(), true);
		return adapterUtil.generateResponseWrapper(externalServiceRespJson, externalServiceRequest.getInterfaceName(),
				header, true);
	}
}
