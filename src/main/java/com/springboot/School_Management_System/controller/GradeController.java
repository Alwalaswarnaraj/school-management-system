package com.springboot.School_Management_System.controller;

import java.util.List;

import com.springboot.School_Management_System.Exceptions.GradeNotFoundException;
import com.springboot.School_Management_System.service.GradeService;
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


import com.springboot.School_Management_System.entities.Grade;
import com.springboot.School_Management_System.service.GradeServiceImpl;


@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService service;
	
	@PostMapping("/addStudentGrade")
	public void addStudentGrade(@RequestBody Grade grade) {
		service.addStudentGrade(grade);
	}
	
	@GetMapping("/get/id/{id}")
	public ResponseEntity<Grade> getGrade(@PathVariable String grade_id) throws GradeNotFoundException {
		Grade grade = service.getGradeById(grade_id);
		if(grade != null){
			return new ResponseEntity<>(grade, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/get/{id}")
//    public ResponseEntity<Grade> getGradeById(@PathVariable("id") String gradeId) {
//        try {
//            Grade grade = service.getGradeById(gradeId);
//            return new ResponseEntity<>(grade, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
	
	@GetMapping("/getAllGrades")
	public ResponseEntity<List<Grade>> getAllGrades() throws GradeNotFoundException {
		List<Grade> list=service.getAllGrade();
		if(list != null){
			return new ResponseEntity<>(list, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
//	  @GetMapping("/getall")
//	    public ResponseEntity<List<Grade>> getAllGrades() {
//	        List<Grade> grades = service.getAllGrade();
//	        if (grades.isEmpty()) {
//	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	        }
//	        return new ResponseEntity<>(grades, HttpStatus.OK);
//	    }
	
	@PutMapping("/update/id/{id}")
	public ResponseEntity<Grade> updateGrades(@RequestBody Grade grade, @PathVariable String id) throws GradeNotFoundException {
		Grade result = service.updateGrade(grade, id);
		if(result != null){
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<Grade> deleteGradeById(@PathVariable String gradeId) throws GradeNotFoundException {
		Grade grade = service.deleteGrade(gradeId);
		if(grade != null){
			return new ResponseEntity<>(grade, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteGrade(@PathVariable("id") String gradeId) {
//	    try {
//	        service.deleteGrade(gradeId);
//	        return new ResponseEntity<>("Grade deleted successfully!", HttpStatus.OK);
//	    } catch (RuntimeException e) {
//	        return new ResponseEntity<>("Grade not found for ID: " + gradeId, HttpStatus.NOT_FOUND);
//	    }
//	}

}
