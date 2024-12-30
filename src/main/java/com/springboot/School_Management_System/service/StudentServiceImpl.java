package com.springboot.School_Management_System.service;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Student;
import com.springboot.School_Management_System.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServiceInterface{

    @Autowired
    private StudentRepo repo;
    @Override
    public void addStudent(Student student) {
        repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() throws UserNotFoundException {
        List<Student> studentList = repo.findAll();
        if(studentList.isEmpty()){
            throw new UserNotFoundException("No Student Found");
        }else
            return studentList;
    }

    @Override
    public Student getStudentById(String id) throws UserNotFoundException {
       return repo.findById(id)
               .orElseThrow(()->new UserNotFoundException("Student with "+id+" not Found"));
    }

    @Override
    public void updateStudentById(Student student, String id) throws UserNotFoundException {
        Optional<Student> updateStudent = repo.findByStudentId(id);
        if(updateStudent.isPresent()){
            Student updatedStudent = updateStudent.get();
            updatedStudent.setStudentId(id);
            updatedStudent.setStudentName(student.getStudentName());
            updatedStudent.setDob(student.getDob());
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setGender(student.getGender());
            updatedStudent.setAdmissionDate(student.getAdmissionDate());

            repo.save(updatedStudent);
//            updatedStudent.setClassId(student.get);
        }else
            throw new UserNotFoundException("Student Not Found");
    }

    @Override
    public void deleteStudentById(String id) throws UserNotFoundException {
        if(!repo.existsById(id)){
            throw new UserNotFoundException("Student Not Found");
        }else
            repo.deleteById(id);
    }
}
