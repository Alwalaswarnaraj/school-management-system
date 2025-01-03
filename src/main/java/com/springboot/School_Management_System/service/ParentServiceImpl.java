package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;


import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.repo.ParentDao;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.Parent;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class ParentServiceImpl implements ParentService{
	
	@Autowired
	private ParentDao dao;
	
	public void addParent(Parent parent) {
		dao.save(parent);
	}

	@Override
	public Parent findParentById(String parentId) throws UserNotFoundException {
	    return dao.findById(parentId)
	        .orElseThrow(() -> new UserNotFoundException("Parent not found for ID: " + parentId));
	}

	
	@Override
	public List<Parent> findAllParent() throws UserNotFoundException {
		List<Parent> list = dao.findAll();
		if(list.isEmpty()){
			throw new UserNotFoundException("NO parent found please add the parents");
		}else
			return list;
	}

	@Override
	public Parent updateParent(Parent parent, String id) throws UserNotFoundException {
		Optional<Parent> updateParent = dao.findById(id);
		if(updateParent.isPresent()){
			Parent parentUpdated = updateParent.get();
			parentUpdated.setParent_id(parent.getParent_id());
			parentUpdated.setParent_name(parent.getParent_name());
			parentUpdated.setEmail(parentUpdated.getEmail());
			parentUpdated.setStudents(parent.getStudents());
			parentUpdated.setContact_info(parent.getContact_info());
			return dao.save(parentUpdated);
		}else
			throw new UserNotFoundException("Parent with id not found "+id);
	}

	@Override
	public Parent deleteParent(String parentId) throws UserNotFoundException {
	    Optional<Parent> parent = dao.findById(parentId);
		if(parent.isPresent()){
			dao.delete(parent.get());
			return parent.get();
		}else
			throw new UserNotFoundException("parent with id Not Found "+parentId);
	}


}
