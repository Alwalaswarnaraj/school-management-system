package com.springboot.School_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.springboot.School_Management_System.entities.StdClass;

import java.util.Optional;

@Repository
public interface ClassDao extends JpaRepository<StdClass,String>{
}
