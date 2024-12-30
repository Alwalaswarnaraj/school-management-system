package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.School_Management_System.entities.Grade;
import com.springboot.School_Management_System.repo.GradeDao;
@Service
public class GradeServiceImpl implements GradeService{
	@Autowired
	GradeDao dao;
	
	public Grade addStudentGrade(Grade grade) {
		dao.save(grade);
		return grade;
	}

	

    @Override
    public Grade getGradeById(String gradeId) {
        return dao.findById(gradeId)
                       .orElseThrow(() -> new RuntimeException("Grade not found for ID: " + gradeId));
    }

	public List<Grade> getAllGrade() {
		
		return dao.findAll();
	}

	public Grade updateGrade(Grade grade) {
		
		return dao.save(grade);
	}

	public void deleteGrade(String gradeId) {
		
		dao.deleteById(gradeId);
	}
	
	
//	@Override
//	public void deleteGrade(String gradeId) {
//	   
//	    Optional<Grade> grade = dao.findById(gradeId);
//	    if (grade.isPresent()) {
//	        dao.delete(grade.get());
//	    } else {
//	        throw new RuntimeException("Grade not found for ID: " + gradeId);
//	    }
//	}

}
