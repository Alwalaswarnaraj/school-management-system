package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.entities.Staff;
import com.springboot.School_Management_System.Exceptions.StaffIdNotFoundException;

public interface StaffService {
	
	void addNewStaff(Staff staff);
	Staff deleteStaffById(String staff_id) throws StaffIdNotFoundException;
	Staff updateStaffById(Staff staff, String staff_id) throws StaffIdNotFoundException;
	List<Staff> getAllStaffDetails() throws StaffIdNotFoundException;
	Staff GetById(String staff_id) throws StaffIdNotFoundException;
}
