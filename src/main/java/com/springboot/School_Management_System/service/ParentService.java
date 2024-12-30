package com.springboot.School_Management_System.service;

import java.util.List;

import com.springboot.School_Management_System.entities.Parent;

public interface ParentService {
	
	void addParent(Parent parent);
	
	Parent findParentById(String parentId);
	
	List<Parent> findAllParent();
	
	void updateParent(Parent parent);
	
	void deleteParent(String parentId);

}
