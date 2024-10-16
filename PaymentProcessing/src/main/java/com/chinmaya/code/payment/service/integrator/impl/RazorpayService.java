package com.chinmaya.code.payment.service.integrator.impl;

import com.chinmaya.code.payment.dto.response.ApiResponse;
import com.chinmaya.code.payment.service.integrator.IGatewayIntegrator;
import com.chinmaya.code.payment.utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service("razorpayService")
@Slf4j
public class RazorpayService implements IGatewayIntegrator {
    @Autowired
    private Utility utility;
    @Override
    public ApiResponse createPaymentOrder(BigDecimal amount, String receiptId, HttpMethod method, String endPoint) {
        JSONObject response = new JSONObject();
        // Make POST request to Razorpay API
        Map<String, Object> orderRequest = new HashMap<>();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", receiptId);
        orderRequest.put("payment_capture", 1); // 1 for automatic capture after payment
        return utility.callExternalApi(method, endPoint, orderRequest);
    }
}
