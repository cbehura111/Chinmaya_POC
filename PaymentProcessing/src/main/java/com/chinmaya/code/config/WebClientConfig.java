package com.chinmaya.code.config;

import io.netty.handler.ssl.SslContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.util.Base64;

@Configuration
public class WebClientConfig {

    @Value("${service.base.url}")
    private String baseUrl;

    @Value("${common.service.base.url}")
    private String commonServiceBaseUrl;

    @Bean
    public WebClient webClient(WebClient.Builder builder) throws SSLException {
        // Create a custom SSL context
        HttpClient httpClient = HttpClient.create()
                .secure(sslContextSpec ->
                        sslContextSpec.sslContext(SslContextBuilder.forClient())
                );

        return builder
                .baseUrl(commonServiceBaseUrl)
                .clientConnector(new ReactorClientHttpConnector())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, getBasicAuthHeader())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
    private String getBasicAuthHeader() {
        String keyId = "your_razorpay_key_id";
        String keySecret = "your_razorpay_secret_key";
        String credentials = keyId + ":" + keySecret;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
