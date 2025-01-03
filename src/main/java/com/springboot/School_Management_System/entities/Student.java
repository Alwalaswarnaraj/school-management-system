package com.springboot.School_Management_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    private String studentId;

    @PrePersist
    public void generateId(){
        if(this.studentId == null){
            this.studentId = UUID.randomUUID().toString().replace("-","").substring(0,10);
        }
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @OneToMany(mappedBy = "student_id", cascade = CascadeType.ALL)
    private List<Grade> grades;

    private String studentName;
    private LocalDate dob;

    public enum Gender{
        Female,Male,Others;
    }

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private LocalDate admissionDate;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    //    private String parentId;
//    private String classId;
//    private String sectionId;
//    private List<>

}
