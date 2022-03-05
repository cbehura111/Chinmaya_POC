package com.chinmay.service;

import java.util.List;

import com.chinmay.entity.Department;
import com.chinmay.entity.Employee;

public interface EmpService {

	Employee saveEmployee(Employee employee);

	public List<Employee> fetchEmpList();

	public Employee fetchEmpById(Long employeeId);
	public void deleteEmpById(Long employeeId);

	public Employee updateEmployee(Long deptId, Employee employee);

	public Employee fetchEmployeeByName(String employeeName);


}
