package springboot.school.dao;

import springboot.school.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentDao extends JpaRepository<Parent,String>{

}
