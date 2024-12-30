package com.springboot.School_Management_System.service;

import java.util.List;

<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/service/ClassService.java
import com.springboot.School_Management_System.entities.StdClass;
=======
import springboot.school.entities.StdClass;
>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/service/ClassService.java


public interface ClassService {
	
	void addClass(StdClass stdclass);
	
	 StdClass findStdClassById(String classsId);
	
	List<StdClass> findAllStdClass();
	
	void updateStdClass(StdClass stdclass);
	
	void deleteStdClass(String classId);

}
