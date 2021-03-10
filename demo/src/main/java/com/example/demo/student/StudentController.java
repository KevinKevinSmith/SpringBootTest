package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //API Layer
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
	public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { //Take the Student from the Request Body
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) { 
        studentService.deleteStudent(studentId);
    }

    //My version
    @PutMapping(path = "{studentId}")
    public void updateStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
        studentService.updateStudent(student, studentId);
    }
    

    /* //Amigoscode version
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                studentService.updateStudent(studentId, name, email);
            }
    //Ugh, so he assumes lax PUT requirements, so then needs more complicated checks.
    //At least only needs updates to be in parameters instead of adding a new object in the body, something I didn't think of. 
    //Put request is broken with his method. Always has Null exception after checking if studentOptional.isPresent() in StudentService.
    */    
}
