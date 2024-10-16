package com.chinmaya.code.payment.service.core.impl;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.service.CommonService;
import com.chinmaya.code.payment.service.core.IPaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//("UPIPayment")
@Slf4j
public class UpiPayment implements IPaymentStrategy {

    @Autowired
    CommonService commonService;

    /**
     * @param paymentData
     */
    @Override
    public BaseResponse pay(PaymentRequestData paymentData, String receiptId) {
        return commonService.executePayment(paymentData, receiptId);
    }
}
