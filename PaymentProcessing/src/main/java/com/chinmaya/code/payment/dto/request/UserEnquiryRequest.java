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
public class UserEnquiryRequest {

	@JsonProperty("vendor")
	private String vendor;

	@JsonProperty("client")
	private String client;

	@JsonProperty("data")
	private String data;

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("chksum")
	private String chksum;

	@JsonProperty("reqTimestamp")
	private String reqTimestamp;
}
