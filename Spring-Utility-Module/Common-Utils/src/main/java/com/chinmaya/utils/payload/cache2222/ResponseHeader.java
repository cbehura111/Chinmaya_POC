package com.chinmaya.utils.payload.cache2222;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseHeader {

	private String ResponseCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ErrorCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ResponseMessage;

	public String getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getResponseMessage() {
		return ResponseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "ResponseHeader [ResponseCode=" + ResponseCode + ", ErrorCode=" + ErrorCode + ", ResponseMessage="
				+ ResponseMessage + "]";
	}

}