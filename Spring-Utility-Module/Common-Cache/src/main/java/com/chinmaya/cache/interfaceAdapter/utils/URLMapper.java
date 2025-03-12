package com.chinmaya.cache.interfaceAdapter.utils;

import com.chinmaya.cache.utils.BaseDynamicValue;
import com.chinmaya.cache.utils.CommonUtils;
import com.chinmaya.cache.utils.CustomDynamicValue;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class URLMapper {

	public String updateEndPointURL(Map<String, Object> requestMap, String url) {

		Pattern p = Pattern.compile(".*\\{([^$']*)\\}.*");
		Matcher m1 = p.matcher(url);
		if (m1.find()) {
			String currVal = "{" + m1.group(1) + "}";
			String readValueFrom = m1.group(1).split("~")[0].toUpperCase();
			String valueMapperKey = m1.group(1).split("~")[1];
			switch (readValueFrom) {
			case "REQUEST":
				url = url.replace(currVal, requestMap.get(valueMapperKey).toString());
				break;
			case "PROPERTYFILE":
				String value = CommonUtils.getExternalProperties(valueMapperKey);
				url = url.replace(currVal, value);
				break;
			case "CONST":
				url = url.replace(currVal, valueMapperKey);
				break;
			case "BASEJAVACODE":
				BaseDynamicValue baseDynamicValue = new BaseDynamicValue();
				String baseJavaVal = baseDynamicValue.generateValue(valueMapperKey);
				url = url.replace(currVal, baseJavaVal);
				break;
			case "CUSTOMJAVACODE":
				CustomDynamicValue customDynamicValue = new CustomDynamicValue();
				String custJavaVal = customDynamicValue.generateValueAppendURL(valueMapperKey,requestMap);
				url = url.replace(currVal, custJavaVal);
				break;
			default:
				break;
			}
			return updateEndPointURL(requestMap, url);
		} else {
			return url;
		}
	}
}
