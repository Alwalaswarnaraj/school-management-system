package com.springboot.School_Management_System.service;

import java.util.List;


import com.springboot.School_Management_System.Exceptions.ClassNotFoundException;
import com.springboot.School_Management_System.entities.StdClass;


public interface ClassService {
	
	void addClass(StdClass stdclass);
	
	 StdClass findStdClassById(String classId) throws ClassNotFoundException;
	
	List<StdClass> findAllStdClass() throws ClassNotFoundException;
	
	StdClass updateStdClass(StdClass stdclass, String id) throws ClassNotFoundException;
	
	void deleteStdClass(String classId) throws ClassNotFoundException;

}
