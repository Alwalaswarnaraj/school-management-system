package springboot.school.service;

import java.util.List;

import springboot.school.entities.Parent;

public interface ParentService {
	
	void addParent(Parent parent);
	
	Parent findParentById(String parentId);
	
	List<Parent> findAllParent();
	
	void updateParent(Parent parent);
	
	void deleteParent(String parentId);

}
