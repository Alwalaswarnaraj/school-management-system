package com.springboot.School_Management_System.repo;

import com.springboot.School_Management_System.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    Optional<Student> findByStudentId(String studentId);
}
