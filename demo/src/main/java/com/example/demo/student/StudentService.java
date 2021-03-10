package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = StudentRepository.findStudentByEmail(student.getEmail()); //minimal validation

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);		
		System.out.println(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) { 
			throw new IllegalStateException("student with id " + studentId + "does not exist");
		}
		studentRepository.deleteById(studentId);
	}

	//My version
	@Transactional
	public void updateStudent(Student student, Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) { 
			throw new IllegalStateException("student with id " + studentId + "does not exist");
		}
		Student old = studentRepository.getOne(studentId);
		String newName = student.getName();
		String newEmail = student.getEmail();
		LocalDate newDOB = student.getDOB();
		if (old.getName() != newName){
			old.setName(newName);
		}
		if (old.getEmail() != newEmail){
			old.setEmail(newEmail);
		}
		if (old.getDOB() != newDOB){
			old.setDOB(newDOB);
		}
		studentRepository.save(old);
	}
	
	/* //Amigos solution
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
							.orElseThrow(() -> new IllegalStateException(
								"student with id " + studentId + " does not exist."
							));
		if (name != null && 
					name.length() > 0 &&
					!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && 
					email.length() > 0 &&
					!Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = StudentRepository.findStudentByEmail(email); //In order to make sure the email isn't taken. Missed this error possibility.
			//Annoyed that above doesn't work without editing the repository still (made method static). 
			//We didn't make a new query but I assumed it would mean avoiding the repository class entirely.
			if (studentOptional.isPresent()) { //if email is already there
				throw new IllegalStateException("email taken");	
			}	
			student.setEmail(email);		
		}

		//Ugh, so he assumes lax PUT requirements, so then needs more complicated checks.
		//At least only needs updates to be in parameters instead of adding a new object in the body, something I didn't think of. 
	}
	//Put request is broken with his method. Always has Null exception after checking if studentOptional.isPresent().
	*/
    
}
