package com.chinmay.relationship.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class BookrequestDto {
	private String name;
	private List<Long> authorIds;
	private Long catagoryId;
}
