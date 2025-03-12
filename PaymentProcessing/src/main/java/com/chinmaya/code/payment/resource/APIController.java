package com.chinmaya.code.payment.resource;

import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.exception.PaymentProcessException;
import com.chinmaya.code.payment.utils.ApiProtocolUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static com.chinmaya.code.payment.constant.Constants.ENTERMETHOD;
import static com.chinmaya.code.payment.constant.Constants.EXITMETHOD;
import static com.chinmaya.code.payment.enums.PaymentProcessingErrorCode.ERR_GENERIC_SERVICE_FAILURE;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/${app.version}")
@Tag(name = "Payment API for invoking external APIs")
public class APIController {
    @Value("${mock.service.base.url}")
    private String mockUrl;

    @Value("${x.subscription.key}")
    private String subscriptionKey;

    @Value("${external.auth.enable}")
    private String isThirdPartyAuthEnabled;

    private final ApiProtocolUtil apiProtocolUtil;


    @ApiOperation(value = "Process HTTP/ HTTPS API call", notes = "API to do HTTP/HTTPS call")
    @GetMapping(value = "/process"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<BaseResponse> processApiRequest() {
        String method = "APIController :: processApiRequest()";
        log.info(ENTERMETHOD, method);
        BaseResponse response = handleApiCall("GET");

        log.info(EXITMETHOD, method);
        return ResponseEntity.status(response.getHttpStatusCode()).body(response);
    }

    @ApiOperation(value = "Fun", notes = "Eat 5 Star")
    @GetMapping(value = "/murali"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<String> callMurali() {
        String murali = "I'm Murali & I'm in";
        return new ResponseEntity<>(murali+"love with Rupesh. We're planning to go London in titanic", HttpStatus.OK);
    }

    private BaseResponse handleApiCall(String methodType) {
        var connection = apiProtocolUtil.getConnection(mockUrl, methodType);
        var responseCode = HttpURLConnection.HTTP_CREATED;
        JSONObject jsonResponse = new JSONObject();

        try (var reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            var responseContent = readResponse(reader);
            responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                jsonResponse = new JSONObject(responseContent);
                jsonResponse.put("status", responseCode);
                log.debug("Successful response: {}", jsonResponse);
            } else {
                log.error("Failed API call with response code: {}", responseCode);
            }
        } catch (IOException e) {
            log.error("IOException occurred while processing the API call : {}", e);
        } catch (Exception e) {
            log.error("Unexpected exception occurred : {}", e);
            throw new PaymentProcessException(ERR_GENERIC_SERVICE_FAILURE.getErrorMessage(),ERR_GENERIC_SERVICE_FAILURE.name());
        } finally {
            connection.disconnect();
        }
        return buildBaseResponse(jsonResponse, responseCode);
    }

    private String readResponse(BufferedReader reader) throws IOException {
        var response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line.trim());
        }
        return response.toString();
    }

    private BaseResponse buildBaseResponse(JSONObject jsonResponse, int statusCode) {
        var baseResponse = new BaseResponse();
        baseResponse.setData(jsonResponse);
        baseResponse.setHttpStatusCode(statusCode);
        return baseResponse;
    }
}
