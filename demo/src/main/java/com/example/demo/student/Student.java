package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.persistence.*

//import jdk.vm.ci.meta.Local;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator( 
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;   

    public Student () {
        };
    public Student (Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public Student (String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getID() {
        return id;
    }
    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setID(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return dob;
    }
    public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    //I don't think setAge works with this anymore
    //toString automatically uses the getAge, or maybe its because of the Transient?

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' + 
                ", dob=" + dob + 
                ", age=" + age + 
                '}';
    }
}
