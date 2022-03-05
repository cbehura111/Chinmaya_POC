package com.chinmay.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Setter
@Getter
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long skillId;

	private String skillName;
}
