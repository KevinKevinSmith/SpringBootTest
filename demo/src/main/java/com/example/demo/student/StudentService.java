package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Same as @Component, based on tutorial, but Service is better semantically. //Service Layer
public class StudentService {
    public List<Student> getStudents() {
		return List.of(
			new Student(
					1L, 
					"Mariam",
					"mariam.jamal@gmail.com", 
					LocalDate.of(2000, Month.JANUARY, 5),
					21
			)
		);
	}
    
}
