package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.Staff;
import com.springboot.School_Management_System.Exceptions.StaffIdNotFoundException;
import com.springboot.School_Management_System.repo.StaffRepository;
@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffRepository staffRepo;
	
	@Override
	public void addNewStaff(Staff staff) {
		Staff st = staffRepo.save(staff);
		
	}

	 @Override
	public void deleteStaffById(String staffId) throws StaffIdNotFoundException {
		 Optional<Staff> staff = staffRepo.findById(staffId);
		 if(staff.isPresent()) {
			 staffRepo.deleteById(staffId);
		 }
	}

	@Override
	public void updateStaffById(Staff staff, String staff_id) throws StaffIdNotFoundException {
		Optional<Staff> staffOptional = staffRepo.findById(staff_id);
		if(staffOptional.isPresent()) {
			Staff toBeUpdated = staffOptional.get();
			toBeUpdated.setStaff_id(staff.getStaff_id());
			toBeUpdated.setStaff_name(staff.getStaff_name());
			toBeUpdated.setStaff_role(staff.getStaff_role());
			toBeUpdated.setContact_info(staff.getContact_info());
			staffRepo.save(toBeUpdated);
		} else {
			throw new StaffIdNotFoundException("Staff member not found with id :"+staff_id);
		}
	}

	@Override
	public List<Staff> getAllStaffDetails(){
		
		return staffRepo.findAll();
	}

	 @Override
	    public Staff GetById(String staffId) throws StaffIdNotFoundException {
	        return staffRepo.findById(staffId)
	                        .orElseThrow(() -> new StaffIdNotFoundException("Staff ID " + staffId + " not found."));
	    }

	
}