package com.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.error.DepartmentNotFoundException;
import com.springboot.tutorial.service.DeptService;

@RestController
public class DeptController {

//	DeptService service = new DeptServiceImplementation();

	@Autowired
	private DeptService deptService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DeptController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		LOGGER.info("Inside SaveDepartment of Dept Controller !!!");
		return deptService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDeptList() {
		LOGGER.info("Inside Fetch Dept List of Dept Controller !!!");
		return deptService.fetchDeptList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDeptById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
		return deptService.fetchDeptById(deptId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDeptById(@PathVariable("id") Long deptId) {
		deptService.deleteDeptById(deptId);
		return "Department Deleted Successfully !!";
	}

	@PutMapping("/departments/{id}")
	public Department updateDept(@PathVariable("id") Long deptId, @RequestBody Department department) {
		return deptService.updateDept(deptId , department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName) {
		return deptService.fetchDepartmentByName(deptName);
	}

}
