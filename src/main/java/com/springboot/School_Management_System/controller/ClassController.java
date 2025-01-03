package com.springboot.School_Management_System.controller;

import java.util.List;

import com.springboot.School_Management_System.Exceptions.ClassNotFoundException;
import com.springboot.School_Management_System.service.ClassService;
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

import com.springboot.School_Management_System.entities.StdClass;


@RestController
@RequestMapping("class")
public class ClassController {
	
	@Autowired
	private ClassService service;
	
	@PostMapping("/add")
	public ResponseEntity addStdClass(@RequestBody StdClass stdclass) {
		service.addClass(stdclass);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@GetMapping("/getClass/id/{id}")
	public ResponseEntity findStdClassById(@PathVariable("id") String classId) throws ClassNotFoundException {
		StdClass stdclass =service.findStdClassById(classId);
		if(stdclass != null){
			return new ResponseEntity(stdclass, HttpStatus.FOUND);
		}else
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
	} 
	
	@GetMapping("getAllClasses")
	public ResponseEntity findAllStdClasses() throws ClassNotFoundException {
		List list =service.findAllStdClass();
		if(list != null){
			return new ResponseEntity(list, HttpStatus.FOUND);
		}else
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("update/id/{id}")
	public ResponseEntity<StdClass> updateStdClass(@RequestBody StdClass stdclass, @PathVariable String id) throws ClassNotFoundException {
		StdClass cls = service.updateStdClass(stdclass, id);
		if(cls != null){
			return new ResponseEntity<>(cls, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity deleteParentById(@PathVariable("id") String classId) {
		try {
			service.deleteStdClass(classId);
			return new ResponseEntity<>("Parent deleted successfully",HttpStatus.OK);
		} catch (RuntimeException | ClassNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
