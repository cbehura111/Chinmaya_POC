package com.chinmaya.utils.payload.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestWrapper {
	
	@JsonProperty("apiRequest")
	private Request apiRequest;
	
	public RequestWrapper() {
		super();
	}

	public RequestWrapper(Request apiRequest) {
		super();
		this.apiRequest = apiRequest;
	}

	public Request getApiRequest() {
		return apiRequest;
	}

	public void setApiRequest(Request apiRequest) {
		this.apiRequest = apiRequest;
	}

	@Override
	public String toString() {
		return "RequestWrapper [apiRequest=" + apiRequest + "]";
	}
}
