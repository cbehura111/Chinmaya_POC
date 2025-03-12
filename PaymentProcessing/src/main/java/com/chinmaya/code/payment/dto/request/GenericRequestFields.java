package com.chinmaya.code.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericRequestFields {

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("data")
	private String data;
	
}
