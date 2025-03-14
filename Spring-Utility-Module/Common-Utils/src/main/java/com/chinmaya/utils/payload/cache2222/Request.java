package com.chinmaya.utils.payload.cache2222;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

	@JsonProperty("interfaceName")
	private String interfaceName;
	
	@JsonProperty("appId")
	private String appId;
	
	@JsonProperty("userId")
	private String userId;
	
	/*
	 * @JsonProperty("requestObj") private RequestFields requestObj;
	 */
	
	@JsonProperty("requestObj")
	private Object requestObj;
	
	public Request() {
	}

	public Request(RequestFields requestObj, String interfaceName, String appId, String userId) {
		super();
		this.requestObj = requestObj;
		this.interfaceName = interfaceName;
		this.appId = appId;
		this.userId = userId;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public Object getRequestObj() {
		return requestObj;
	}

	public void setRequestObj(Object requestObj) {
		this.requestObj = requestObj;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Request [requestObj=" + requestObj + ", interfaceName=" + interfaceName + ", appId=" + appId + ", userId=" + userId + "]";
	}
}
