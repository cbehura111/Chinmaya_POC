package com.chinmaya.code.payment.service.core.impl;

import com.chinmaya.code.payment.config.IdGenerator;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.service.core.IPaymentService;
import com.chinmaya.code.payment.service.core.IPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private Map<String, IPaymentStrategy> paymentStrategies;

    private final IdGenerator idGenerator;



    /**
     * @param paymentData
     */
    @Override
    public BaseResponse processPayment(PaymentRequestData paymentData) {
            IPaymentStrategy iPaymentStrategy = paymentStrategies.get(paymentData.getPaymentChannel().getChannelBean());  // card number
        if(iPaymentStrategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentData.getPaymentDetails());
        }
        return iPaymentStrategy.pay(paymentData, String.valueOf(idGenerator.nextId()));

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
