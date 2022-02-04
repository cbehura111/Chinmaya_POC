package com.springboot.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.service.DeptService;

@RestController
public class DeptController {
	
//	DeptService service = new DeptServiceImplementation();
	
	@Autowired
	private DeptService deptService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
	
		return deptService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDeptList(){
			return deptService.fetchDeptList();
	}
}
