package com.chinmaya.code.payment.service.integrator;

import com.chinmaya.code.payment.dto.response.ApiResponse;
import org.springframework.http.HttpMethod;

import java.math.BigDecimal;

public interface IGatewayIntegrator {
    public ApiResponse createPaymentOrder(BigDecimal amount, String receiptId, HttpMethod method, String uri);
}
