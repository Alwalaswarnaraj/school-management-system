package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.entities.Grade;

public interface GradeService {
	
	public Grade addStudentGrade(Grade grade);
	
	Grade getGradeById(String gradeId);
	
	List<Grade> getAllGrade();
	
	Grade updateGrade(Grade grade);
	
	void deleteGrade(String gradeId);
}
