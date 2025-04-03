package com.chinmaya.cache.payload.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;
	
	@JsonProperty("ResponseBody")
	private ResponseBody responseBody;
	
}
