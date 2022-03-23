package com.chinmay.relationship.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class CatagoryResponseDto {
	private Long id;
	private String name;
	private List<String> bookNames;
}
