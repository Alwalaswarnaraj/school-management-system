package com.springboot.School_Management_System.service;

import java.util.List;

<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/service/ParentService.java
import com.springboot.School_Management_System.entities.Parent;
=======
import springboot.school.entities.Parent;
>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/service/ParentService.java

public interface ParentService {
	
	void addParent(Parent parent);
	
	Parent findParentById(String parentId);
	
	List<Parent> findAllParent();
	
	void updateParent(Parent parent);
	
	void deleteParent(String parentId);

}
