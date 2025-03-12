package com.chinmaya.cache.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmaya.cache.custom.model.TbAbmiCommonCode;
import com.chinmaya.cache.custom.repository.TbAbmiCommonCodeRepository;

@Service
public class CacheApzBankingService {

	@Autowired
	private TbAbmiCommonCodeRepository tbAbmiCommonCodeRepository;

	public static Map<String, TbAbmiCommonCode> commonCodesProprties = new HashMap<String, TbAbmiCommonCode>();

	public void initializeCommonCodes() {
		tbAbmiCommonCodeRepository.findAll().forEach(data -> {
			if ("AUTHENTICATION".equalsIgnoreCase(data.getCode())
					|| "TRANSFERLIMITAUTH".equalsIgnoreCase(data.getCode())) {
				commonCodesProprties.put(
						data.getCodeType().concat(".").concat(data.getCode()).concat(".").concat(data.getChannel()),
						data);
			} else {
				commonCodesProprties.put(data.getCodeType().concat(".").concat(data.getCode()), data);
			}
		});
	}

	public Map<String, TbAbmiCommonCode> getCommonCodesProperties() {
		return commonCodesProprties;
	}
}