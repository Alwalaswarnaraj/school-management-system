package com.springboot.School_Management_System.repo;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.School_Management_System.entities.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
//	Optional<Staff> staffFindById(int staff_id);

}
