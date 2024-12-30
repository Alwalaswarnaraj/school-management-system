package com.springboot.School_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.School_Management_System.entities.StdClass;
import com.springboot.School_Management_System.repo.ClassDao;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	ClassDao dao;
	
	@Override
	public void addClass(StdClass stdclass) {
		dao.save(stdclass);
	}

	@Override
	public StdClass findStdClassById(String classId) {
		return dao.findById(classId)
				.orElseThrow(()->new RuntimeException("Class not found for ID : " +classId));
		
	}

	@Override
	public List<StdClass> findAllStdClass() {		
		return dao.findAll();
	}

	@Override
	public void updateStdClass(StdClass stdclass) {
		dao.save(stdclass);
	}

	@Override
	public void deleteStdClass(String classId) {
		dao.deleteById(classId);
	} 
}
