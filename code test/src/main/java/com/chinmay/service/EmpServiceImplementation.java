package com.chinmay.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmay.entity.Department;
import com.chinmay.entity.Employee;
import com.chinmay.repository.CompanyRepository;

@Service
public class EmpServiceImplementation implements EmpService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		return companyRepository.save(employee);
	}

	@Override
	public List<Employee> fetchEmpList() {

		return companyRepository.findAll();
	}

	@Override
	public Employee fetchEmpById(Long employeeId) {

		Optional<Employee> employee = companyRepository.findById(employeeId);
				return employee.get();
	}

	@Override
	public void deleteEmpById(Long employeeId) {
		companyRepository.deleteById(employeeId);

	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) {
		Employee empDB = companyRepository.findById(employeeId).get();
		if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
			empDB.setEmployeeName(employee.getEmployeeName());
		}

		if (Objects.nonNull(employee.getDesignation()) && !"".equalsIgnoreCase(employee.getDesignation())) {
			empDB.setDesignation(employee.getDesignation());
		}

		if (Objects.nonNull(employee.getDepartment())) {
			empDB.setDepartment(employee.getDepartment());
		}

		return companyRepository.save(empDB);
	}

	@Override
	public Employee fetchEmployeeByName(String empName) {

		return companyRepository.findByEmployeeNameIgnoreCase(empName);
	}

}
