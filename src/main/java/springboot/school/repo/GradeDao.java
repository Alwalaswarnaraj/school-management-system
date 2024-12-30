<<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/repo/GradeDao.java
package com.springboot.School_Management_System.repo;
========
package springboot.school.repo;
>>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/repo/GradeDao.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/repo/GradeDao.java
import com.springboot.School_Management_System.entities.Grade;
========
import springboot.school.entities.Grade;
>>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/repo/GradeDao.java
@Repository
public interface GradeDao extends JpaRepository<Grade, String>{

}
