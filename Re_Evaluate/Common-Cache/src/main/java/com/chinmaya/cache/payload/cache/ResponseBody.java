package com.chinmaya.cache.payload.cache;

public class ResponseBody {

	public String responseObj;
	
	public ResponseBody() {
		super();
	}
	
	public ResponseBody(String responseObj) {
		super();
		this.responseObj = responseObj;
	}

	public String getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(String responseObj) {
		this.responseObj = responseObj;
	}

	@Override
	public String toString() {
		return "Response [responseObj=" + responseObj + "]";
	}
}
