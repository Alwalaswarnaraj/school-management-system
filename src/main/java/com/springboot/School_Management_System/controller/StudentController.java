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

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable String id) throws UserNotFoundException {
        Student student = service.deleteStudentById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PutMapping("update/id/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable String id) throws UserNotFoundException {
        Student result = service.updateStudentById(student, id);
        if(result != null){
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
