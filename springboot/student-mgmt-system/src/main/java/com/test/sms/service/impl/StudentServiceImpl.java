package com.test.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.sms.entity.Student;
import com.test.sms.repository.StudentRepository;
import com.test.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;

	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.findAll();
	}

}
