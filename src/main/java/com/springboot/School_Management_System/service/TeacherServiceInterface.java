package com.springboot.School_Management_System.service;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherServiceInterface {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(String id) throws UserNotFoundException;
    List<Teacher> getAllTeachers() throws UserNotFoundException;

    void updateTeacherById(Teacher teacher, String id) throws UserNotFoundException;
    void deleteTeacherById(String id) throws UserNotFoundException;

//    void deleteTeacherByName();
}
