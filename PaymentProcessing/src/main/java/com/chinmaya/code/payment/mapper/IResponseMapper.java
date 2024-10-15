package com.chinmaya.code.payment.mapper;

import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.PaymentResponse;
import com.chinmaya.code.payment.enums.PaymentChannelEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IResponseMapper {

    @Mapping(target = "transactionCurrency", source = "txnCurrency")  // Correct case for source property
    @Mapping(target = "transactionAmount", source = "amount")         // These already match correctly
    @Mapping(target = "paymentChannel", source = "paymentChannel", qualifiedByName = "mapPaymentChannel")    // These already match correctly
    @Mapping(target = "paymentDetails", source = "paymentDetails")    // These already match correctly
    @Mapping(target = "transactionId", source = "paymentId")
    PaymentResponse toPaymentResponse(PaymentRequestData requestData);
    @Named("mapPaymentChannel")
    default String mapPaymentChannel(PaymentChannelEnum paymentChannelEnum) {
        return paymentChannelEnum != null ? paymentChannelEnum.name() : null;
    }
}
