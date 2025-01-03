package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.Exceptions.ExamNotFoundException;
import com.springboot.School_Management_System.entities.Exam;

public interface ExamService {
	
	void addExam(Exam exam);
	Exam getExamById(String id) throws ExamNotFoundException;
	List<Exam> getAllExams() throws ExamNotFoundException;
	void updateExam(Exam exam, String id) throws ExamNotFoundException;
	void cancelExam(String id) throws ExamNotFoundException;
	
}
