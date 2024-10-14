package com.chinmaya.code.payment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Payment API Collection", version = "1.0", description = "APIs for processing payment"))
//@EnableScheduling
public class PaymentProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProcessingApplication.class, args);
	}

}
