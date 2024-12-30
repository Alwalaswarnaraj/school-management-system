package com.springboot.School_Management_System.service;

import java.util.List;


import com.springboot.School_Management_System.entities.StdClass;


public interface ClassService {
	
	void addClass(StdClass stdclass);
	
	 StdClass findStdClassById(String classId);
	
	List<StdClass> findAllStdClass();
	
	void updateStdClass(StdClass stdclass);
	
	void deleteStdClass(String classId);

}
