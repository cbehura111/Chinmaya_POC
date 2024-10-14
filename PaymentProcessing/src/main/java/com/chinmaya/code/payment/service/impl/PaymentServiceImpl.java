package com.chinmaya.code.payment.service.impl;

import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.PaymentResponse;
import com.chinmaya.code.payment.enums.PaymentChannelEnum;
import com.chinmaya.code.payment.service.IPaymentService;
import com.chinmaya.code.payment.service.IPaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private Map<String, IPaymentStrategy> paymentStrategies;



    /**
     * @param paymentData
     */
    @Override
    public PaymentResponse processPayment(PaymentRequestData paymentData) {
            IPaymentStrategy iPaymentStrategy = paymentStrategies.get(paymentData.getPaymentChannel().getChannelBean());  // card number
        if(iPaymentStrategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentData.getPaymentDetails());
        }
        return iPaymentStrategy.pay(paymentData);

    }

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse initiatePayment(PaymentRequestData paymentData) {
    return null;
    }

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse deletePayment(PaymentRequestData paymentData) {
        return null;
    }
}
