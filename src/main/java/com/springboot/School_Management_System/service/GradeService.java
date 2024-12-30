package com.springboot.School_Management_System.service;

import java.util.List;

<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/service/GradeService.java
import com.springboot.School_Management_System.entities.Grade;
=======
import springboot.school.entities.Grade;
>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/service/GradeService.java

public interface GradeService {
	
	public Grade addStudentGrade(Grade grade);
	
	Grade getGradeById(String gradeId);
	
	List<Grade> getAllGrade();
	
	Grade updateGrade(Grade grade);
	
	void deleteGrade(String gradeId);
}
