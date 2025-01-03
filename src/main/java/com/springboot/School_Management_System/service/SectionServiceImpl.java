package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.Section;
import com.springboot.School_Management_System.Exceptions.SectionNotFoundException;
import com.springboot.School_Management_System.repo.SectionRepository;
@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	SectionRepository secRepo;
	
	@Override
	public void addSection(Section section) {
		secRepo.save(section);
	}

	@Override
	public Section getSection(String id) throws SectionNotFoundException {
		return secRepo.findById(id)
				.orElseThrow(()-> new SectionNotFoundException("section not found with id: "+id));
	}

	@Override
	public List<Section> getAllSections() throws SectionNotFoundException {
		List<Section> secList = secRepo.findAll();
		if(secList.isEmpty()) {
			throw new SectionNotFoundException("there is nothing in the section list");
		} else {
			return secRepo.findAll();
		}
	}

	@Override
	public void updateSection(Section section, String id) throws SectionNotFoundException {
		Optional<Section> updateSec = secRepo.findById(id);
		if(updateSec.isPresent()) {
			Section sectionUpdate = updateSec.get();
			sectionUpdate.setClass_id(section.getClass_id());
			sectionUpdate.setSection_name(section.getSection_name());
			sectionUpdate.setSection_id(section.getSection_id());
		}
	}

	@Override
	public void RemoveSection(String id) throws SectionNotFoundException {
		Optional<Section> sec = secRepo.findById(id);
		if(sec.isEmpty()) {
			secRepo.deleteById(id);
		} else {
			throw new SectionNotFoundException("no section found with id: "+id);
		}
	}

	
}
