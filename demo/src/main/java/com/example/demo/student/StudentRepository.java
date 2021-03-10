package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //Data Layer, responsible for Data Access
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    //Below transforms into "SELECT * FROM student WHERE email = ?"
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    static Optional<Student> findStudentByEmail(String email) {
        // Auto-made static for update Service logic
        return null;
    }
}
