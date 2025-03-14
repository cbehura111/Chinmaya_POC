package com.chinmaya.utils.payload.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
	@JsonProperty("ReferenceNumber")
	private String referenceNumber;

	@JsonProperty("AuthenticationType")
	private Integer authenticationType;

	private int authState;

}
