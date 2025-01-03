package com.springboot.School_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.School_Management_System.entities.Section;
import com.springboot.School_Management_System.Exceptions.SectionNotFoundException;
import com.springboot.School_Management_System.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	private SectionService service;
	
	@PostMapping("/add")
	public ResponseEntity<Section> addSection(@RequestBody Section section){
		service.addSection(section);
		return new ResponseEntity<>(section, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Section> findSectionById(@PathVariable("id") String id) throws SectionNotFoundException{
		Section section = service.getSection(id);
		return ResponseEntity.ok(section);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Section>> findAll() throws SectionNotFoundException{
		List<Section> section = service.getAllSections();
		return new ResponseEntity<List<Section>>(section, HttpStatus.OK);
	}
	
	@PutMapping("update")
	public void updateSection(@RequestBody Section section,@PathVariable String id) throws SectionNotFoundException{
		service.updateSection(section, id);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Section>deleteSectionById(@PathVariable("id") String id) throws SectionNotFoundException{
		service.RemoveSection(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
