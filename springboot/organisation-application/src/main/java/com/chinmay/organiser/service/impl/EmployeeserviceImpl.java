package com.chinmay.organiser.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chinmay.organiser.entity.Employee;
import com.chinmay.organiser.exception.ResourceNotFoundException;
import com.chinmay.organiser.repository.EmployeeRepository;
import com.chinmay.organiser.service.EmployeeService;

@Service
public class EmployeeserviceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeserviceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		return employeeRepository.findById(id).get();
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else
			throw new ResourceNotFoundException("Employee", "id", id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {

//		We need to check with DB for employee data availability
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setEmail(employee.getEmail());

//		save Existing employee to database
		employeeRepository.save(existingEmployee);
		return existingEmployee;

	}
}
