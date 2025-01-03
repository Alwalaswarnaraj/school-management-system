package com.springboot.School_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.School_Management_System.entities.Exam;
@Repository
public interface ExamRepository extends JpaRepository<Exam, String>{

}
