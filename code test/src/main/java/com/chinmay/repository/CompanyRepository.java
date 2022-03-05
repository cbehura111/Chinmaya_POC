package com.chinmay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinmay.entity.Department;
import com.chinmay.entity.Employee;

@Repository
public interface CompanyRepository extends JpaRepository<Employee, Long>{

		public Employee findByEmployeeName(String emp);
		public Employee findByEmployeeNameIgnoreCase(String deptName);
}
