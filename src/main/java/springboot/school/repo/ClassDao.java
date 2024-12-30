package springboot.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.school.entities.StdClass;
@Repository
public interface ClassDao extends JpaRepository<StdClass,String>{

}
