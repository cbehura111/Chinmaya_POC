package com.chinmaya.cache.custom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ABMI_COMMON_CODES")
@IdClass(TbAbmiCommonCodeId.class)
public class TbAbmiCommonCode {

	@Id
	private String codeType;

	@Id
	private String code;

	@Id
	private String language;

	@Id
	private String channel;

	@Column(name = "CODE_DESC")
	private String codeDesc;

	@Column(name = "ACCESS_TYPE")
	private String accessType;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	@Override
	public String toString() {
		return "TbAbmiCommonCodeDomain [codeType=" + codeType + ", code=" + code + ", codeDesc=" + codeDesc
				+ ", language=" + language + ", accessType=" + accessType + "]";
	}
}
