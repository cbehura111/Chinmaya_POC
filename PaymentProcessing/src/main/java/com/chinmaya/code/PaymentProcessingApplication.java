package com.chinmaya.code;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Payment API Collection", version = "1.0", description = "APIs for processing payment"))
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.chinmaya.*"})
public class PaymentProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProcessingApplication.class, args);
	}

}
