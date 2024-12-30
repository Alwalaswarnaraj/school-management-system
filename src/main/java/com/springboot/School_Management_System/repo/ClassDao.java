<<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/repo/ClassDao.java
package com.springboot.School_Management_System.repo;
========
package springboot.school.repo;
>>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/repo/ClassDao.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/repo/ClassDao.java
import com.springboot.School_Management_System.entities.StdClass;
========
import springboot.school.entities.StdClass;
>>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/repo/ClassDao.java
@Repository
public interface ClassDao extends JpaRepository<StdClass,String>{

}
