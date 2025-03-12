package com.chinmaya.cache.payload.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenRequestWrapper {
	
	@JsonProperty("apiRequest")
	private AuthTokenRequest apiRequest;
}
