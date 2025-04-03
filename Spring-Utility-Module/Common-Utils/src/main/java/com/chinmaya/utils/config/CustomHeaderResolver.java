package com.chinmaya.utils.config;

import com.chinmaya.utils.payload.core.Header;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

@Configuration
public class CustomHeaderResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		if (methodParameter.getParameterType()==Header.class){
			Header header = new Header();
			header.setAppId(webRequest.getHeader("appId"));
			//header.setCustomerId(webRequest.getHeader("customerId"));
			header.setDeviceId(webRequest.getHeader("deviceId"));
			header.setInterfaceId(webRequest.getHeader("interfaceId"));
			header.setMasterTxnRefNo(webRequest.getHeader("masterTxnRefNo"));
			header.setUserId(webRequest.getHeader("userId"));
			return header;
		}
		return UNRESOLVED;
		
	}

}
