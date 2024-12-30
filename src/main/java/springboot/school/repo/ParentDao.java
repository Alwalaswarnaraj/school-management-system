package springboot.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.school.entities.Parent;

public interface ParentDao extends JpaRepository<Parent,String>{

}
