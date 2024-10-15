package com.chinmaya.code.payment.utils;

import com.chinmaya.code.payment.dto.response.ApiResponse;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.enums.SuccessCodes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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

    public ApiResponse callExternalApi(HttpMethod method, String uri, Map<String, Object> requestObject) {
        WebClient.RequestBodySpec requestSpec = webClient.method(method)
                .uri(uri);

        if (method == HttpMethod.POST || method == HttpMethod.PUT) {
            requestSpec.bodyValue(requestObject);
        }

        return requestSpec
                .retrieve()
                .toEntity(String.class) // Use toEntity to get the status code along with the body
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
            JSONObject jsonObj = new JSONObject(responseBody);
            log.debug("JSON object : {}", jsonObj);
            return ((JSONObject) jsonObj.optJSONArray("loanAccounts").get(0)).optString("accountName");
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
