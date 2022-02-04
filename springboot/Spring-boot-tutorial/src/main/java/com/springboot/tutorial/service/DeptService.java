package com.springboot.tutorial.service;

import java.util.List;

import com.springboot.tutorial.entity.Department;

public interface DeptService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDeptList();

	public Department fetchDeptById(Long deptId);

	public void deleteDeptById(Long deptId);

	public Department updateDept(Long deptId, Department department);

}
