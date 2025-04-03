package com.chinmaya.cache.custom.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chinmaya.cache.custom.model.TbAbmiCommonCode;
import com.chinmaya.cache.custom.model.TbAbmiCommonCodeId;

@Repository
public interface TbAbmiCommonCodeRepository extends CrudRepository<TbAbmiCommonCode, TbAbmiCommonCodeId> {
	
	@Cacheable(value = "codeCache", key = "#cmCode")
	TbAbmiCommonCode findByCode(String cmCode);
	
	Optional<TbAbmiCommonCode> findByCodeAndCodeType(String cmCode, String codeType);
}
