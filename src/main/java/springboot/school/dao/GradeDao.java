package springboot.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.school.entity.Grade;
@Repository
public interface GradeDao extends JpaRepository<Grade, String>{

}
