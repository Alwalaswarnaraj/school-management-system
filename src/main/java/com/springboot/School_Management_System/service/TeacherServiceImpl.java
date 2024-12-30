package com.springboot.School_Management_System.service;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Teacher;
import com.springboot.School_Management_System.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface{

    @Autowired
    private TeacherRepo repo;
    @Override
    public void addTeacher(Teacher teacher) {
        Teacher tea = repo.save(teacher);
    }

    @Override
    public Teacher getTeacherById(String id) throws UserNotFoundException {
       return repo.findById(id)
               .orElseThrow(()-> new UserNotFoundException("Teacher Not Found"));
    }

    @Override
    public List<Teacher> getAllTeachers() throws UserNotFoundException {
        List<Teacher> teacherList = repo.findAll();
        if(teacherList.isEmpty()){
            throw new UserNotFoundException("No teachers added");
        }else
            return teacherList;
    }

    @Override
    public void updateTeacherById(Teacher teacher, String id) throws UserNotFoundException {
        Optional<Teacher> updateTeacher = repo.findByTeacherID(id);
        if(updateTeacher.isPresent()){
            Teacher teacherUpdated = updateTeacher.get();
            teacherUpdated.setTeacherID(id);
            teacherUpdated.setTeacherName(teacher.getTeacherName());
            teacherUpdated.setDob(teacher.getDob());
            teacherUpdated.setAddress(teacher.getAddress());
            teacherUpdated.setContact(teacher.getContact());
            repo.save(teacherUpdated);
        }else
            throw new UserNotFoundException("Teacher Not Found With "+id+" id");
    }

    @Override
    public void deleteTeacherById(String id) throws UserNotFoundException {
        Optional<Teacher> teacher = repo.findByTeacherID(id);
        if(teacher.isPresent()){
            repo.deleteById(id);
        }else
            throw new UserNotFoundException("Teacher nor Found With "+id+" id");
    }
}
