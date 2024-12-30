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

import com.springboot.School_Management_System.entities.Grade;
import com.springboot.School_Management_System.service.GradeServiceImpl;

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	GradeServiceImpl service;
	
	@PostMapping("/addStudentGrade")
	public void addStudentGrade(@RequestBody Grade grade) {
		service.addStudentGrade(grade);
	}
	
	@GetMapping("/get/{id}")
	public void getGrade(@PathVariable String grade_id) {
		service.getGradeById(grade_id);
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
	
	@GetMapping("getall")
	public ResponseEntity<List<Grade>> getAllGrades() {
		List<Grade> list=service.getAllGrade();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
//	  @GetMapping("/getall")
//	    public ResponseEntity<List<Grade>> getAllGrades() {
//	        List<Grade> grades = service.getAllGrade();
//	        if (grades.isEmpty()) {
//	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	        }
//	        return new ResponseEntity<>(grades, HttpStatus.OK);
//	    }
	
	@PutMapping("update")
	public ResponseEntity updateGrades(@RequestBody Grade grade) {
		service.updateGrade(grade);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity deleteGradeById(@PathVariable String gradeId) {
		service.deleteGrade(gradeId);
		return new ResponseEntity(HttpStatus.OK);
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
