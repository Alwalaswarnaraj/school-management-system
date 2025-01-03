package com.springboot.School_Management_System.service;

import java.util.List;
import java.util.Optional;

import com.springboot.School_Management_System.Exceptions.ClassNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public StdClass findStdClassById(String classId) throws ClassNotFoundException {
		return dao.findById(classId)
				.orElseThrow(()->new ClassNotFoundException("Class not found for ID : " +classId));
		
	}

	@Override
	public List<StdClass> findAllStdClass() throws ClassNotFoundException {
		List<StdClass> stdClasses = dao.findAll();
		if(!stdClasses.isEmpty()){
			return stdClasses;
		}else
			throw new ClassNotFoundException("Class Not Found Please the Classes");
	}

	@Override
	public StdClass updateStdClass(StdClass stdclass, String id) throws ClassNotFoundException {
		Optional<StdClass> cla = dao.findById(id);
		if(cla.isPresent()){
			StdClass c = cla.get();
			c.setClass_id(id);
			c.setClass_name(stdclass.getClass_name());
			c.setStudent_count(stdclass.getStudent_count());
			c.setTeacher_id(stdclass.getTeacher_id());
			c.setSection_id(stdclass.getSection_id());
			c.setSubject_list(stdclass.getSubject_list());
			dao.save(c);
			return c;
		}else
			throw new ClassNotFoundException("class not Found with id "+id);
	}

	@Override
	public void deleteStdClass(String classId) throws ClassNotFoundException {
		Optional<StdClass> cla = dao.findById(classId);
		if(cla.isPresent()){
			dao.deleteById(classId);
		}else
			throw new ClassNotFoundException("class not found with id "+classId);
	} 
}
