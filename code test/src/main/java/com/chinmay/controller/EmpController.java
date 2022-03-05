package com.chinmay.controller;

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

import com.chinmay.entity.Employee;
import com.chinmay.service.EmpService;


@RestController
public class EmpController {

//	DeptService service = new DeptServiceImplementation();

	@Autowired
	private EmpService empService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmpController.class);

	@PostMapping("/departments")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		
		LOGGER.info("Inside SaveEmployee of Employee Controller !!!");
		return empService.saveEmployee(employee);
	}

	@GetMapping("/departments")
	public List<Employee> fetchEmpList() {
		LOGGER.info("Inside Fetch Employee List of Employee Controller !!!");
		return empService.fetchEmpList();
	}

	@GetMapping("/departments/{id}")
	public Employee fetchEmpById(@PathVariable("id") Long deptId){
		return empService.fetchEmpById(deptId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteEmpById(@PathVariable("id") Long employeeId) {
		empService.deleteEmpById(employeeId);
		return "Employee Deleted Successfully !!";
	}

	@PutMapping("/departments/{id}")
	public Employee updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee) {
		return empService.updateEmployee(employeeId , employee);
	}
	
	@GetMapping("/departments/name/{name}")
	public Employee fetchEmployeeByName(@PathVariable("name") String employeeName) {
		return empService.fetchEmployeeByName(employeeName);
	}

}
