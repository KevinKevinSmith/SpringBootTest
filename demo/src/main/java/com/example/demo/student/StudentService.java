package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Same as @Component, based on tutorial, but Service is better semantically. //Service Layer
public class StudentService {
	private final StudentRepository studentRepository; 

	@Autowired
	public StudentService(StudentRepository studentRepository) { 
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() {
		return studentRepository.findAll();
	}
    
}
