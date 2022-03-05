package com.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.repository.DeptRepository;

@SpringBootTest
class DeptServiceTest {
	
	@Autowired
	private DeptService deptService;
	
	@MockBean
	private DeptRepository deptRepository;
	
	
	@BeforeEach
	void setUp() {
		Department dept = Department.builder()
				.deptName("IT")
				.deptAddress("BBSR")
				.deptCode("IT-06")
				.deptId(1L)
				.build();
		
		Mockito.when(deptRepository.findByDeptNameIgnoreCase("IT")).thenReturn(dept);
	}

		@Test
		@DisplayName("Get Data by Valid Dept. Name")
	public void whenDepartmentNamevalid_thenDepartmentShouldFound () {
		
			String deptName = "IT";
			Department found = deptService.fetchDepartmentByName(deptName);
			
			assertEquals(deptName, found.getDeptName());
			}
}
