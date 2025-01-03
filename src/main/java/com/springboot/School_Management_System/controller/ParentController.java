package com.springboot.School_Management_System.controller;

import java.util.List;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.service.ParentService;
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


import com.springboot.School_Management_System.entities.Parent;

@RestController
@RequestMapping("parent")
public class ParentController {
	
	@Autowired
	private ParentService service;
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addParents(@RequestBody Parent parent) {
		service.addParent(parent);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@GetMapping("/get/id/{id}")
	public ResponseEntity<Parent> findParentsById(@PathVariable("id") String parentId) throws UserNotFoundException {
	    Parent parent = service.findParentById(parentId);
	    if(parent != null){
			return new ResponseEntity<>(parent, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	
	@GetMapping("/getAllParents")
	public ResponseEntity<List<Parent>> findAllParents() throws UserNotFoundException {
		List<Parent> list=service.findAllParent();
		if(list.isEmpty()){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else
			return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
	
	@PutMapping("update/id/{id}")
	public ResponseEntity<Parent> updateParents(@RequestBody Parent parent, @PathVariable String id) throws UserNotFoundException {
		Parent paren = service.updateParent(parent, id);
		if(paren != null){
			return new ResponseEntity<>(paren, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity deleteParentById(@PathVariable("id") String parentId) {
//		service.deleteParent(parentId);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Parent> deleteParentById(@PathVariable("id") String parentId) throws UserNotFoundException {
	    Parent parent = service.deleteParent(parentId);
		if(parent != null){
			return new ResponseEntity<>(parent, HttpStatus.OK);
		}else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}















