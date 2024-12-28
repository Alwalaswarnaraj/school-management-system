package springboot.school.controller;

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

import springboot.school.entity.StdClass;
import springboot.school.service.ClassServiceImpl;

@RestController
@RequestMapping("stdclass")
public class ClassController {
	
	@Autowired
	ClassServiceImpl service;
	
	@PostMapping("add")
	public ResponseEntity addStdClass(@RequestBody StdClass stdclass) {
		service.addClass(stdclass);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity findStdClassById(@PathVariable("id") String classId) {
		StdClass stdclass =service.findStdClassById(classId);
		return new ResponseEntity<>(stdclass,HttpStatus.OK);
	} 
	
	@GetMapping("getall")
	public ResponseEntity findAllStdClasses() {
		List list =service.findAllStdClass();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity updateStdClass(@RequestBody StdClass stdclass) {
		service.updateStdClass(stdclass);
		return new ResponseEntity(stdclass,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delteParentById(@PathVariable("id") String classId) {
		try {
			service.deleteStdClass(classId);
			return new ResponseEntity<>("Parent deleted successfully",HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
