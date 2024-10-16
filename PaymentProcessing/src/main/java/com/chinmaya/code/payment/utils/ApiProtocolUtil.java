package com.chinmaya.code.payment.utils;

import com.chinmaya.code.payment.config.WebClientConfig;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.exception.PaymentProcessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.chinmaya.code.payment.enums.PaymentProcessingErrorCode.ERR_GENERIC_SERVICE_FAILURE;

@Slf4j
@Component
public class ApiProtocolUtil {

    @Value("${x.subscription.key}")
    private String subscriptionKey;

    @Value("${external.auth.enable}")
    private String isThirdPartyAuthEnabled;

    private final WebClient webClient;

    public ApiProtocolUtil(WebClient webClient) {
        this.webClient = webClient;
    }



    public HttpURLConnection getConnection(String apiUrl, String methodType) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = null;
            // Check the protocol of the URL
            if (url.getProtocol().equalsIgnoreCase("https")) {
                // If the protocol is HTTPS, cast to HttpsURLConnection
                connection = (HttpsURLConnection) url.openConnection();
                log.info("HTTPS connection established.");
            } else if (url.getProtocol().equalsIgnoreCase("http")) {
                // If the protocol is HTTP, cast to HttpURLConnection
                connection = (HttpURLConnection) url.openConnection();
                log.info("HTTP connection established.");
            } else {
                throw new IOException("Unsupported protocol: " + url.getProtocol());
            }
            connection.setRequestMethod(methodType);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Mozilla");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            log.debug("xSubscriptionKey into httpsConnectionFactory : " + subscriptionKey);
//            String xSubscriptionVal = subscriptionKey;
//            log.debug("isThirdPartyAuthEnabled :" + isThirdPartyAuthEnabled);
//            if (isThirdPartyAuthEnabled.equalsIgnoreCase("Y")) {
//                xSubscriptionVal = getSecretValue(subscriptionKey);
//            }
            return connection;
        } catch (IOException e) {
            log.error("Error occurred while creating connection: ", e);
            throw new PaymentProcessException(ERR_GENERIC_SERVICE_FAILURE.getErrorMessage(),ERR_GENERIC_SERVICE_FAILURE.name());
        }
    }

    private static String getSecretValue(String subscriptionKey) {
        return "hi"+subscriptionKey;
    }

//    public BaseResponse getData(String uri) {
//        return webClient.get()
//                .uri(uri)
//                .retrieve()
//                .onStatus(status -> status.is4xxClientError(), clientResponse -> {
//                    // Handle 4xx errors
//                    return Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()));
//                })
//                .onStatus(status -> status.is5xxServerError(), clientResponse -> {
//                    // Handle 5xx errors
//                    return Mono.error(new RuntimeException("Server Error: " + clientResponse.statusCode()));
//                })
//                .bodyToMono(BaseResponse.class)
//                .block();
//    }
//
//    public BaseResponse postData(String uri, Object request) {
//        return webClient.post()
//                .uri(uri)
//                .bodyValue(request)
//                .retrieve()
//                .onStatus(status -> status.is4xxClientError(), clientResponse -> {
//                    return Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()));
//                })
//                .onStatus(status -> status.is5xxServerError(), clientResponse -> {
//                    return Mono.error(new RuntimeException("Server Error: " + clientResponse.statusCode()));
//                })
//                .bodyToMono(BaseResponse.class)
//                .block();
//    }

}
