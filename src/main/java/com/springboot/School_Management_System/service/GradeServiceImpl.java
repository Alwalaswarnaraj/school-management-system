package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import com.springboot.School_Management_System.Exceptions.GlobalExceptionHandler;
import com.springboot.School_Management_System.Exceptions.GradeNotFoundException;
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
    public Grade getGradeById(String gradeId) throws GradeNotFoundException {
        return dao.findById(gradeId)
                       .orElseThrow(() -> new GradeNotFoundException("Grade not found for ID: " + gradeId));
    }

	public List<Grade> getAllGrade() throws GradeNotFoundException {
		List<Grade> list = dao.findAll();
		if(list.isEmpty()){
			throw new GradeNotFoundException("No Grades found please add the grades");
		}else
			return list;
	}

	public Grade updateGrade(Grade grade, String id) throws GradeNotFoundException {
		Optional<Grade> gradeUpdate = dao.findById(id);
		if(gradeUpdate.isPresent()){
			Grade grad = gradeUpdate.get();
			grad.setGrade_id(id);
			grad.setExam_id(grade.getExam_id());
			grad.setGrade_level(grade.getGrade_level());
			grad.setMarks(grade.getMarks());
			grad.setStudent_id(grade.getStudent_id());
			grad.setRemarks(grade.getRemarks());
			return dao.save(grad);
		}else
			throw new GradeNotFoundException("grade not found on Id "+id);
	}

	public Grade deleteGrade(String gradeId) throws GradeNotFoundException {
		Optional<Grade> grade = dao.findById(gradeId);
		if(grade.isPresent()){
			dao.delete(grade.get());
			return grade.get();
		}else
			throw new GradeNotFoundException("grade not found on Id "+gradeId);
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
