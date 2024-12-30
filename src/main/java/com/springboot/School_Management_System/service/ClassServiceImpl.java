package com.springboot.School_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/service/ClassServiceImpl.java
import com.springboot.School_Management_System.entities.StdClass;
import com.springboot.School_Management_System.repo.ClassDao;
=======
import springboot.school.entities.StdClass;
import springboot.school.repo.ClassDao;
>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/service/ClassServiceImpl.java

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
