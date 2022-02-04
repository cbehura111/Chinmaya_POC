package com.springboot.tutorial.service;

import java.util.List;
import java.util.Objects;

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

	@Override
	public Department fetchDeptById(Long deptId) {

		return deptRepository.findById(deptId).get();
	}

	@Override
	public void deleteDeptById(Long deptId) {
		deptRepository.deleteById(deptId);

	}

	@Override
	public Department updateDept(Long deptId, Department department) {
		Department depDB = deptRepository.findById(deptId).get();
		if (Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())) {
			depDB.setDeptName(department.getDeptName());
		}

		if (Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())) {
			depDB.setDeptCode(department.getDeptCode());
		}
		
		if (Objects.nonNull(department.getDeptAddress()) && !"".equalsIgnoreCase(department.getDeptAddress())) {
			depDB.setDeptAddress(department.getDeptAddress());
		}
		
		return deptRepository.save(depDB);
	}

}
