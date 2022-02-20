package com.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.tutorial.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long>{

		public Department findByDeptName(String deptName);
		public Department findByDeptNameIgnoreCase(String deptName);
}
