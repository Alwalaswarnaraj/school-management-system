package com.springboot.School_Management_System.service;

import java.util.List;


import com.springboot.School_Management_System.repo.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.Parent;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService{
	
	@Autowired
	private ParentDao dao;
	
	public void addParent(Parent parent) {
		dao.save(parent);
	}

	@Override
	public Parent findParentById(String parentId) {
	    return dao.findById(parentId)
	        .orElseThrow(() -> new RuntimeException("Parent not found for ID: " + parentId));
	}

	
	@Override
	public List<Parent> findAllParent() {
		
		return dao.findAll();
	}

	@Override
	public void updateParent(Parent parent) {
		dao.save(parent);
	}

	@Override
	public void deleteParent(String parentId) {
	    dao.deleteById(parentId);
	}


}
