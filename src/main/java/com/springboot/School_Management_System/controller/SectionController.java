package com.springboot.School_Management_System.controller;

import java.util.List;

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

import com.springboot.School_Management_System.entities.Section;
import com.springboot.School_Management_System.Exceptions.SectionNotFoundException;
import com.springboot.School_Management_System.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	private SectionService service;
	
	@PostMapping("/add")
	public void addSection(@RequestBody Section section){
		service.addSection(section);
	}
	
	@GetMapping("/findSection/id/{id}")
	public ResponseEntity<Section> findSectionById(@PathVariable("id") String id) throws SectionNotFoundException{
		Section section = service.getSection(id);
		if(section != null){
			return new ResponseEntity<>(section, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/findAllSections")
	public ResponseEntity<List<Section>> findAll() throws SectionNotFoundException{
		List<Section> section = service.getAllSections();
		if(section != null){
			return new ResponseEntity<List<Section>>(section, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("update/id/{id}")
	public ResponseEntity<Section> updateSection(@RequestBody Section section,@PathVariable String id) throws SectionNotFoundException{
		Section sectionUpdated = service.updateSection(section, id);
		if(sectionUpdated != null){
			return new ResponseEntity<>(sectionUpdated, HttpStatus.ACCEPTED);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<Section> deleteSectionById(@PathVariable("id") String id) throws SectionNotFoundException{
		Section section = service.RemoveSection(id);
		if(section != null){
			return new ResponseEntity<>(section, HttpStatus.FOUND);
		}else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
