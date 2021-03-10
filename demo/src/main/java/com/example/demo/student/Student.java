package com.example.demo.student;

import java.time.LocalDate;

//import jdk.vm.ci.meta.Local;

public class Student {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;   

    public Student () {
        };
    public Student (Long id, String name, String email, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
    public Student (String name, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
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
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

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
