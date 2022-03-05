package com.chinmay.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long companyId;
	private String companyName;
	
	@ManyToMany(targetEntity=Department.class)
	private List<Department> department;
	
	@ManyToMany(targetEntity=Employee.class)
	private List<Employee> employee;
}
