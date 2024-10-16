package com.chinmaya.code.payment.utils;

import com.chinmaya.code.payment.dto.response.ApiResponse;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.enums.SuccessCodes;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Map;

import static com.chinmaya.code.payment.constant.Constants.*;

@Slf4j
@Component
public class Utility {
    @Autowired
    private WebClient webClient;
    @Autowired
    ObjectMapper objectMapper;
    private final SecureRandom random = new SecureRandom() ;

    public ApiResponse callExternalApi(HttpMethod method, String endPoint, Map<String, Object> requestObject) {
        WebClient.RequestBodySpec requestSpec = webClient.method(method)
                .uri(endPoint);

        if (method == HttpMethod.POST || method == HttpMethod.PUT) {
            requestSpec.bodyValue(requestObject);
        }

        return requestSpec
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), clientResponse -> {
                    // Handle 4xx errors
                    return Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()));
                })
                .onStatus(status -> status.is5xxServerError(), clientResponse -> {
                    // Handle 5xx errors
                    return Mono.error(new RuntimeException("Server Error: " + clientResponse.statusCode()));
                })
                .toEntity(String.class)
                .map(responseEntity -> new ApiResponse(responseEntity.getStatusCodeValue(), responseEntity.getBody()))
                .onErrorResume(e -> {
                    throw new RuntimeException("Error during request: " + e.getMessage(), e);
                })
                .block();
    }

    public BaseResponse formSuccessResponse(int statusCode, SuccessCodes successCodes, JsonNode responseObj) {
        String method = "StandingInstructionServiceImpl :: formSuccessResponse()";
        log.info(ENTERMETHOD, method);
        BaseResponse response = BaseResponse.builder()
                .httpStatusCode(statusCode)
                .status(STATUS_SUCCESS)
                .timestamp(LocalDateTime.now())
                .message(successCodes.getSuccessMessage())
                .messageCode(successCodes.name())
                .data(responseObj)
                .build();
        log.info(EXITMETHOD, method);
        return response;
    }

    public String extractTransactionId(String responseBody) {
        try {
            JSONArray jsonArray = new JSONArray(responseBody);
            JSONObject jsonObj = jsonArray.getJSONObject(random.nextInt(jsonArray.length()));
            log.debug("JSON object : {}", jsonObj);
            return (jsonObj.optString("id"));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Razorpay order response", e);
        }
    }

    public JSONObject formJSONObject(Object obj) {
        Gson gson = new Gson();
        String toJson = gson.toJson(obj);
        return new JSONObject(toJson);
    }

    public JSONArray formJSONArray(Object obj) {
        Gson gson = new Gson();
        String toJson = gson.toJson(obj);
        return new JSONArray(toJson);
    }

    public JsonNode getJsonNode(Object object) {
        try {
            return objectMapper.valueToTree(object);
        } catch (IllegalArgumentException e) {
            throw new JSONException("Error converting object to JsonNode: " + e.getMessage(), e);
        }
    }
}
