package com.springboot.School_Management_System.controller;


import java.util.List;

//import org.hibernate.mapping.List;
import com.springboot.School_Management_System.Exceptions.StaffIdNotFoundException;
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

import com.springboot.School_Management_System.entities.Staff;
import com.springboot.School_Management_System.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/addStaff")
	public void addNewStaff(@RequestBody Staff staff){
		staffService.addNewStaff(staff);
	}
	
	 @DeleteMapping("/deleteStaff/id/{id}")
	    public ResponseEntity<Staff> deleteStaffById(@PathVariable("id") String staffId) throws StaffIdNotFoundException {
	        Staff staff = staffService.deleteStaffById(staffId);
			if(staff != null){
				return new ResponseEntity<>(staff, HttpStatus.FOUND);
			}else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	
	@PutMapping("/staffUpdate/id/{id}")
	public ResponseEntity<Staff> updateById(@RequestBody Staff staff,@PathVariable String id) throws StaffIdNotFoundException{
		Staff staffUpdated = staffService.updateStaffById(staff, id);
		if(staffUpdated != null){
			return new ResponseEntity<>(staffUpdated, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Staff>> getAllStaffDetails() throws StaffIdNotFoundException {
		List<Staff> staff=staffService.getAllStaffDetails();
		if(staff != null) {
			return new ResponseEntity<>(staff, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	 @GetMapping("/findStaffById/id/{id}")
	 public ResponseEntity<Staff> findId(@PathVariable("id") String staffId) throws StaffIdNotFoundException {
		 Staff staff = staffService.GetById(staffId);
		 if(staff != null) {
			 return new ResponseEntity<>(staff, HttpStatus.FOUND);
		 } else {
			 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 }
	 }
	 
}
