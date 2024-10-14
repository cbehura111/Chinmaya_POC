package com.chinmaya.code.payment.resource;

import com.chinmaya.code.payment.dto.response.BaseResponse;
import com.chinmaya.code.payment.dto.PaymentRequestData;
import com.chinmaya.code.payment.dto.response.PaymentResponse;
import com.chinmaya.code.payment.service.IPaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/${app.version}")
@Tag(name = "Payments Processing Controller")
@AllArgsConstructor
public class PaymentController {
private final IPaymentService iPaymentService;
    @ApiOperation(value = "Process Payments", notes = "API to process various payments through channels")
    @PostMapping(value = "/process"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public PaymentResponse processPayment(@Valid  @RequestBody PaymentRequestData paymentData){
        return iPaymentService.processPayment(paymentData);
    }
}
