package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.entities.Staff;
import com.springboot.School_Management_System.Exceptions.StaffIdNotFoundException;

public interface StaffService {
	
	void addNewStaff(Staff staff);
	void deleteStaffById(String staff_id) throws StaffIdNotFoundException;
	void updateStaffById(Staff staff, String staff_id) throws StaffIdNotFoundException;
	List<Staff> getAllStaffDetails();
	Staff GetById(String staff_id) throws StaffIdNotFoundException;
}
