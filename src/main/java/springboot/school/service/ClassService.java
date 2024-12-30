package springboot.school.service;

import java.util.List;

import springboot.school.entities.StdClass;


public interface ClassService {
	
	void addClass(StdClass stdclass);
	
	 StdClass findStdClassById(String classsId);
	
	List<StdClass> findAllStdClass();
	
	void updateStdClass(StdClass stdclass);
	
	void deleteStdClass(String classId);

}
