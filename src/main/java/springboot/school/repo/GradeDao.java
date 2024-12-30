package springboot.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.school.entities.Grade;
@Repository
public interface GradeDao extends JpaRepository<Grade, String>{

}
