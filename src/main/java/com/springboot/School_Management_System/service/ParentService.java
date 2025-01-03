package com.springboot.School_Management_System.service;

import java.util.List;


import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Parent;

public interface ParentService {
	
	void addParent(Parent parent);
	
	Parent findParentById(String parentId) throws UserNotFoundException;
	
	List<Parent> findAllParent() throws UserNotFoundException;
	
	Parent updateParent(Parent parent, String id) throws UserNotFoundException;
	
	Parent deleteParent(String parentId) throws UserNotFoundException;

}
