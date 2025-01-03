package com.springboot.School_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.School_Management_System.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {

}
