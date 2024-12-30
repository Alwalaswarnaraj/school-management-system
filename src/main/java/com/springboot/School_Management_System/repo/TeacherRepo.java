package com.springboot.School_Management_System.repo;

import com.springboot.School_Management_System.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, String> {
    Optional<Teacher> findByTeacherID(String teacherId);
}
