package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.Exceptions.GradeNotFoundException;
import com.springboot.School_Management_System.entities.Grade;
public interface GradeService {
	
	public Grade addStudentGrade(Grade grade);
	
	Grade getGradeById(String gradeId) throws GradeNotFoundException;
	
	List<Grade> getAllGrade() throws GradeNotFoundException;
	
	Grade updateGrade(Grade grade, String id) throws GradeNotFoundException;
	
	Grade deleteGrade(String gradeId) throws GradeNotFoundException;
}
