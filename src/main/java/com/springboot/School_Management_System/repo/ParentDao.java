package com.springboot.School_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.School_Management_System.entities.Parent;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDao extends JpaRepository<Parent,String>{

}
