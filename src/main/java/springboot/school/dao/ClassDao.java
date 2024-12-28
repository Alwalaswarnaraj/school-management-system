package springboot.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.school.entity.StdClass;
@Repository
public interface ClassDao extends JpaRepository<StdClass,String>{

}
