package com.chinmaya.utils.interfaceAdapter.service;

import com.chinmaya.utils.payload.core.Header;
import com.chinmaya.cache.service.LogExternalReqRes;
import com.chinmaya.utils.exception.CustomException;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

@Component
public class RestService {

	private static final Logger logger = LogManager.getLogger(RestService.class);

	@Autowired
	private WebClient webClient;

	@Autowired
	private LogExternalReqRes logExternalReqRes;

	Object patchResponse = "";

	public static final String HTTP_ACCEPT_TYPE = "acceptType";
	public static final String AUTH_TOKEN = "authToken";
	public static final String APPLICATION = "application";

	public Mono<Object> executeRestApi(String restRequest, JSONArray headerParams, String methodType,
			String mediaTypeString, String endPointUrl, JSONObject interfaceJsonContent, Header header,
			Boolean isJSONAdapterCall) {
		logger.debug("Start : executeRestApi with request= " + restRequest.toString());

		Mono<Object> webClientAPIResponse = Mono.empty();

		StringBuilder builder = new StringBuilder(endPointUrl);
		URI uri = URI.create(builder.toString());
		logger.debug("API URL::" + uri);
		LocalDateTime startDateTime = LocalDateTime.now();
		// Code change added to set API timeout based on the interface file.
		int apiTimeout = 60;
		if (interfaceJsonContent.has("timeout") && !"".equalsIgnoreCase(interfaceJsonContent.getString("timeout"))) {
			apiTimeout = Integer.valueOf(interfaceJsonContent.getString("timeout"));
		}

		if ("POST".equalsIgnoreCase(methodType)) {
			if (MediaType.MULTIPART_FORM_DATA_VALUE.equalsIgnoreCase(mediaTypeString)) {
				MultiValueMap<String, String> multipartRequest = new LinkedMultiValueMap<>();
				JSONObject formReqObject = new JSONObject(restRequest);
				Iterator<String> keys = formReqObject.keys();
				while (keys.hasNext()) {
					String key = keys.next();
					String value = formReqObject.get(key).toString();
					multipartRequest.add(key, value);
				}
				
			
				
				logger.debug("Going to set timeout "+ apiTimeout);
				webClientAPIResponse = webClient.post().uri(uri)
						.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString))
						.body(BodyInserters.fromMultipartData(multipartRequest)).retrieve()
						.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
						.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse)
						.bodyToMono(Object.class).timeout(Duration.ofSeconds(apiTimeout))
						.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
								"JSON", interfaceJsonContent, isJSONAdapterCall))
						.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
								"JSON", interfaceJsonContent, isJSONAdapterCall))
						.flatMap(val -> {
							String response = (String) val;
							Object respObj = response;
							return Mono.just(respObj);
						});
			} else {
				logger.debug("Going to set timeout "+ apiTimeout);

				// 🔹 Modified WebClient configuration to disable SSL verification (for debugging only)
				WebClient webClient = WebClient.builder()
						.clientConnector(new ReactorClientHttpConnector(
								HttpClient.create()
										.secure(sslContextSpec -> sslContextSpec.sslContext(getInsecureSslContext()))
						))
						.build();

				webClientAPIResponse = webClient.post().uri(uri)
						.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString))
						.body(BodyInserters.fromValue(restRequest)).retrieve()
						.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
						.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse)
						.bodyToMono(String.class).timeout(Duration.ofSeconds(apiTimeout))
						.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
								"JSON", interfaceJsonContent, isJSONAdapterCall))
						.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
								"JSON", interfaceJsonContent, isJSONAdapterCall))
						.flatMap(val -> {
							String response = val;
							Object respObj = response;
							return Mono.just(respObj);
						});
			}
		} else if ("GET".equalsIgnoreCase(methodType)) {
			webClientAPIResponse = webClient.get().uri(uri)
					.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString)).retrieve()
					.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
					.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse).bodyToMono(Object.class)
					.timeout(Duration.ofSeconds(apiTimeout))
					.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
							"JSON", interfaceJsonContent, isJSONAdapterCall))
					.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
							"JSON", interfaceJsonContent, isJSONAdapterCall));
		} else if ("PUT".equalsIgnoreCase(methodType)) {
			webClientAPIResponse = webClient.put().uri(uri)
					.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString))
					.body(BodyInserters.fromValue(restRequest)).retrieve()
					.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
					.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse).bodyToMono(Object.class)
					.timeout(Duration.ofSeconds(apiTimeout))
					.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
							"JSON", interfaceJsonContent, isJSONAdapterCall))
					.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
							"JSON", interfaceJsonContent, isJSONAdapterCall));
		} else if ("PATCH".equalsIgnoreCase(methodType)) {
			webClientAPIResponse = webClient.patch().uri(uri)
					.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString))
					.body(BodyInserters.fromValue(restRequest)).retrieve()
					.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
					.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse).bodyToMono(Object.class)
					.timeout(Duration.ofSeconds(apiTimeout))
					.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
							"JSON", interfaceJsonContent, isJSONAdapterCall))
					.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
							"JSON", interfaceJsonContent, isJSONAdapterCall));
			return webClientAPIResponse;
		} else if ("DELETE".equalsIgnoreCase(methodType)) {
			webClientAPIResponse = webClient.delete().uri(uri)
					.headers(httpHeaders(headerParams, endPointUrl, mediaTypeString)).retrieve()
					.onStatus(HttpStatusCode::is5xxServerError, RestService::httpStatusErrResponse)
					.onStatus(HttpStatusCode::is4xxClientError, RestService::httpStatusErrResponse).bodyToMono(Object.class)
					.timeout(Duration.ofSeconds(apiTimeout))
					.doOnSuccess(value -> logTxnDtlsToDB(header, restRequest, value.toString(), startDateTime, "S",
							"JSON", interfaceJsonContent, isJSONAdapterCall))
					.doOnError(error -> logTxnDtlsToDB(header, restRequest, error.getMessage(), startDateTime, "F",
							"JSON", interfaceJsonContent, isJSONAdapterCall));
		}
		return webClientAPIResponse;

	}
	private static SslContext getInsecureSslContext() {
		try {
			return SslContextBuilder.forClient()
					.trustManager(InsecureTrustManagerFactory.INSTANCE) // Trust all certificates
					.build();
		} catch (SSLException e) {
			throw new RuntimeException("Error creating insecure SSL context", e);
		}
	}

	private static Mono<Error> httpStatusErrResponse(ClientResponse response) {

		logger.debug("Inside method for handling the httpStatusErrResponse" + response);
		return response.bodyToMono(String.class).flatMap(body -> {
			logger.debug("Inside 4xx or 5xx Error Response Body is {}" + body);
			JSONObject apiErrRespJSON = new JSONObject();
			int statusCode = response.statusCode().value();
			apiErrRespJSON.put("errorCode", String.valueOf(statusCode));
			apiErrRespJSON.put("errorMessage", new JSONObject(body));
			return Mono.error(new CustomException(apiErrRespJSON.toString()));
		});
	}

	private void logTxnDtlsToDB(Header header, String request, String response, LocalDateTime startDateTime,
			String status, String requestType, JSONObject interfaceJsonContent, Boolean isJSONAdapterCall) {
		logExternalReqRes.logTransactionToDb(header, request, response, startDateTime, LocalDateTime.now(), status,
				requestType, interfaceJsonContent, isJSONAdapterCall);
	}

	private Consumer<HttpHeaders> httpHeaders(JSONArray headersArr, String endPointUrl, String mediaTypeString) {
		return headers -> {

			// Set default Headers based on the media Type
			if (mediaTypeString.equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
				headers.setContentType(new MediaType(APPLICATION, "json", StandardCharsets.UTF_8));
				headers.setAccept(Arrays.asList(MediaType.ALL));
			} else if (mediaTypeString.equalsIgnoreCase(MediaType.APPLICATION_XML_VALUE)) {
				headers.setContentType(new MediaType(APPLICATION, "xml", StandardCharsets.UTF_8));
				headers.setAccept(Arrays.asList(new MediaType(APPLICATION, "xml", StandardCharsets.UTF_8)));
			} else if (mediaTypeString.equalsIgnoreCase(MediaType.TEXT_HTML_VALUE)) {
				headers.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
				headers.setAccept(Arrays.asList(new MediaType("text", "html", StandardCharsets.UTF_8)));
			} else if (mediaTypeString.equalsIgnoreCase(MediaType.MULTIPART_FORM_DATA_VALUE)) {
				headers.setContentType(new MediaType("multipart", "form-data", StandardCharsets.UTF_8));
				headers.setAccept(Arrays.asList(new MediaType("multipart", "form-data", StandardCharsets.UTF_8)));
			} else {
				headers.setAccept(Arrays.asList(MediaType.ALL));
			}
			// Set Additional Headers configured as part of the Interface/JSON file.
			logger.debug("Headers Array::", headersArr);
			for (int i = 0; i < headersArr.length(); i++) {
				JSONObject tempObj = headersArr.getJSONObject(i);
				String name = tempObj.get("name").toString();
				String value = tempObj.get("value").toString();
				headers.set(name, value);
			}
			logger.debug("Final Header Parameters value::" + headers.toString());
		};
	}
}
