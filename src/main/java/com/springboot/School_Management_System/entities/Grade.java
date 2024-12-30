package com.springboot.School_Management_System.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Grade {
	@Id
	String grade_id;
	String student_id;
	String exam_id;
	int marks;
	String remarks;
	String grade_level;
	public String getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getGrade_level() {
		return grade_level;
	}
	public void setGrade_level(String grade_level) {
		this.grade_level = grade_level;
	}
	@Override
	public String toString() {
		return "Grade [grade_id=" + grade_id + ", student_id=" + student_id + ", exam_id=" + exam_id + ", marks="
				+ marks + ", remarks=" + remarks + ", grade_level=" + grade_level + "]";
	}
	
	
}
