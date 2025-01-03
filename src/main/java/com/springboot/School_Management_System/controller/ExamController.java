package com.springboot.School_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.School_Management_System.entities.Exam;
import com.springboot.School_Management_System.Exceptions.ExamNotFoundException;
import com.springboot.School_Management_System.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService service;
	
	@PostMapping("/add")
	public void newExam(@RequestBody Exam exam) throws ExamNotFoundException{
		 service.addExam(exam);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Exam> getExamById(@PathVariable("id") String id) throws ExamNotFoundException{
		Exam exam = service.getExamById(id);
		return new ResponseEntity<Exam>(exam, HttpStatus.OK);
	}
	
	@GetMapping("/getAllExams")
	public ResponseEntity<List<Exam>> getAll() throws ExamNotFoundException{
		List<Exam> examList = service.getAllExams();
		if(examList != null) {
			return new ResponseEntity<>(examList, HttpStatus.FOUND);
		}else 
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateExam")
	public void updateExamById(@RequestBody Exam exam,@PathVariable String id) throws ExamNotFoundException{
		service.updateExam(exam, id);
	}
	
	@DeleteMapping("/cancelExam/{id}")
	public void deleteExamById(@PathVariable("id") String id) throws ExamNotFoundException{
		service.cancelExam(id);
	}

}
