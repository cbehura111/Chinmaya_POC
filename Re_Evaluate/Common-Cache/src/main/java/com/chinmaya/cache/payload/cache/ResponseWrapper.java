package com.chinmaya.cache.payload.cache;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseWrapper {
	
	@JsonProperty("apiResponse")
	private Response apiResponse;
	
	public ResponseWrapper() {
		super();
	}
	
	public ResponseWrapper(Response apiResponse) {
		super();
		this.apiResponse = apiResponse;
	}

	public Response getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(Response apiResponse) {
		this.apiResponse = apiResponse;
	}

	@Override
	public String toString() {
		return "ResponseWrapper [apiResponse=" + apiResponse + "]";
	}
}
