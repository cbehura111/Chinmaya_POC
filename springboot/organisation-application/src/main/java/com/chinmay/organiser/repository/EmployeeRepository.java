package com.chinmay.organiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinmay.organiser.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
