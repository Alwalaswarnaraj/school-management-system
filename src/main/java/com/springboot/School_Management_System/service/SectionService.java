package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.entities.Section;
import com.springboot.School_Management_System.Exceptions.SectionNotFoundException;

public interface SectionService {
	void addSection(Section section);
	Section getSection(String id) throws SectionNotFoundException;
	List<Section> getAllSections() throws SectionNotFoundException;
	Section updateSection(Section section, String id) throws SectionNotFoundException;
	Section RemoveSection(String id) throws SectionNotFoundException;
}