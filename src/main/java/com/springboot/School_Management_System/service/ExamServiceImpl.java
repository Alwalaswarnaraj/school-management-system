package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.Exam;
import com.springboot.School_Management_System.Exceptions.ExamNotFoundException;
import com.springboot.School_Management_System.repo.ExamRepository;
@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamRepository examRepo;
	
	@Override
	public void addExam(Exam exam) {
		 examRepo.save(exam);
	}

	@Override
	public Exam getExamById(String id) throws ExamNotFoundException {
		return examRepo.findById(id)
				.orElseThrow(()-> new ExamNotFoundException("Exam not found"));
				
	}

	@Override
	public List<Exam> getAllExams() throws ExamNotFoundException {
		List<Exam> list = examRepo.findAll();
		if(list.isEmpty()) {
			throw new ExamNotFoundException("no Exam found please add th exam");
		} else {
			return list;
		}
	}

	@Override
	public Exam updateExam(Exam exam, String id) throws ExamNotFoundException {
		Optional<Exam> updateEx = examRepo.findById(id);
		if(updateEx.isPresent()) {
			Exam updateExam = updateEx.get();
			updateExam.setExam_id(id);
			updateExam.setName(exam.getName());
			updateExam.setClass_id(exam.getClass_id());
			updateExam.setData(exam.getDate());
			updateExam.setExam_duration(exam.getExam_duration());
			updateExam.setSubject_id(exam.getSubject_id());
			updateExam.setTotal_marks(exam.getTotal_marks());
			return updateExam;
		} else {
			throw new ExamNotFoundException("exam not found with id :"+id);
		}
	}

	@Override
	public Exam cancelExam(String id) throws ExamNotFoundException {
		Optional<Exam> exam = examRepo.findById(id);
		if(exam.isPresent()) {
			examRepo.deleteById(id);
			return exam.get();
		} else {
			throw new ExamNotFoundException("there is no exam with id: "+id);
		}
	}

}
