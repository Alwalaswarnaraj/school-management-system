package com.springboot.School_Management_System.service;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Student;

import java.util.List;

public interface StudentServiceInterface {
    void addStudent(Student student);
    List<Student> getAllStudents() throws UserNotFoundException;
    Student getStudentById(String id) throws UserNotFoundException;
    void updateStudentById(Student student, String id) throws UserNotFoundException;
    void deleteStudentById(String id) throws UserNotFoundException;
//    public void deleteStudentByName(String name);
}
