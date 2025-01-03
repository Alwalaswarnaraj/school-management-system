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
	public ResponseEntity<Staff> addNewStaff(@RequestBody Staff staff){
		System.out.println("add new staff member");
		staffService.addNewStaff(staff);
		return new ResponseEntity<Staff>(staff,HttpStatus.OK);
	}
	
	 @DeleteMapping("/RemoveStaff/{id}")
	    public void deleteStaffById(@PathVariable("id") String staffId) throws StaffIdNotFoundException {
	        staffService.deleteStaffById(staffId);
	         ResponseEntity.ok().build();
	    }
	
	@PutMapping("/staffUpdate")
	public void updateById(@RequestBody Staff staff,@PathVariable String staff_id) throws StaffIdNotFoundException{
		staffService.updateStaffById(staff, staff_id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Staff>> getAllStaffDetails(){
		List<Staff> staff=staffService.getAllStaffDetails();
		if(staff != null) {
			return new ResponseEntity<>(staff, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	 @GetMapping("/find/{id}")
	 public ResponseEntity<Staff> findId(@PathVariable("id") String staffId) throws StaffIdNotFoundException {
		 Staff staff = staffService.GetById(staffId);
		 if(staff != null) {
			 return new ResponseEntity<>(staff, HttpStatus.FOUND);
		 } else {
			 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 }
	 }
	 
}
