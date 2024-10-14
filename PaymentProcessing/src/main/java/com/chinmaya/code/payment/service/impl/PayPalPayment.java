package com.chinmaya.code.payment.service.impl;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.response.PaymentResponse;
import com.chinmaya.code.payment.mapper.IResponseMapper;
import com.chinmaya.code.payment.service.IPaymentStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//("payPalPayment")
public class PayPalPayment implements IPaymentStrategy {
    @Autowired
    IResponseMapper responseMapper;


    /**
     * @param paymentData
     */
    @Override
    public PaymentResponse pay(PaymentRequestData paymentData) {
        return responseMapper.toPaymentResponse(paymentData);
        // BaseResponse.builder().build();
    }

    public static void main(String[] args) {
        System.out.println(PayPalPayment.class.getSimpleName());
    }
}
