package com.chinmaya.cache.custom.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class TbAbmiCommonCodeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CODE_TYPE", nullable = false)
	private String codeType;

	@Column(name = "CM_CODE", nullable = false)
	private String code;

	@Column(name = "LANGUAGE", nullable = false)
	private String language;

	@Column(name = "CHANNEL", nullable = false)
	private String channel;

	public TbAbmiCommonCodeId() {
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(channel, code, codeType, language);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbAbmiCommonCodeId other = (TbAbmiCommonCodeId) obj;
		return Objects.equals(channel, other.channel) && Objects.equals(code, other.code)
				&& Objects.equals(codeType, other.codeType) && Objects.equals(language, other.language);
	}

}
