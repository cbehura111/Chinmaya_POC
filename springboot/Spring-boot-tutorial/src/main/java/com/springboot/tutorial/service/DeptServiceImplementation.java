package com.springboot.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.tutorial.entity.Department;
import com.springboot.tutorial.repository.DeptRepository;

@Service
public class DeptServiceImplementation implements DeptService {

	@Autowired
	private DeptRepository deptRepository;

	@Override
	public Department saveDepartment(Department department) {

		return deptRepository.save(department);
	}

	@Override
	public List<Department> fetchDeptList() {

		return deptRepository.findAll();
	}

}
