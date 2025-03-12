package com.chinmaya.cache.payload.cache;

public class Response {

	private ResponseHeader ResponseHeader;

	private ResponseBody ResponseBody;

	public Response() {
		super();
	}

	public ResponseHeader getResponseHeader() {
		return ResponseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		ResponseHeader = responseHeader;
	}

	public ResponseBody getResponseBody() {
		return ResponseBody;
	}

	public void setResponseBody(ResponseBody responseBody) {
		ResponseBody = responseBody;
	}

	@Override
	public String toString() {
		return "Response [ResponseHeader=" + ResponseHeader + ", ResponseBody=" + ResponseBody + "]";
	}

}
