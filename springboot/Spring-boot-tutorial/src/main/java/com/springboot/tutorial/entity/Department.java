package com.springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @Data  //@Data is replacement for ToString, equalsandHashcode , Getters , setters annotations
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptId;
	
//	@NotBlank(message = "Please Enter Department name !!!")
	private String deptName;
	private String deptAddress;
	private String deptCode;
}
