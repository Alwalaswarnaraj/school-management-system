package com.springboot.School_Management_System.controller;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Student;
import com.springboot.School_Management_System.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceInterface service;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @GetMapping("findStudent/id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) throws UserNotFoundException {
        Student student = service.getStudentById(id);
        if(student != null){
            return new ResponseEntity(student, HttpStatus.FOUND);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findAllStudent")
    public ResponseEntity<List<Student>> getAllStudent() throws UserNotFoundException {
        List<Student> listStudent = service.getAllStudents();
        if(listStudent != null){
            return new ResponseEntity<>(listStudent, HttpStatus.FOUND);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("update/id/{id}")
    public void deleteStudentById(@PathVariable String id) throws UserNotFoundException {
        service.deleteStudentById(id);
    }


    @PutMapping("update/id/{id}")
    public void updateStudentById(@RequestBody Student student, @PathVariable String id) throws UserNotFoundException {
        service.updateStudentById(student, id);
    }
}
