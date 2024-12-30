package springboot.school.service;

import java.util.List;

import springboot.school.entities.Grade;

public interface GradeService {
	
	public Grade addStudentGrade(Grade grade);
	
	Grade getGradeById(String gradeId);
	
	List<Grade> getAllGrade();
	
	Grade updateGrade(Grade grade);
	
	void deleteGrade(String gradeId);
}
