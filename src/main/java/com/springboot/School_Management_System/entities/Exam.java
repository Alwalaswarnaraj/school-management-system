package com.springboot.School_Management_System.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
@Entity
public class Exam {
	
	@Id
	private String exam_id;
	private String name;
	private String class_id;
	private String subject_id;
	private int exam_duration;
	private Date date;
	private int total_marks;


	public void generateID(){
		if(this.exam_id == null){
			this.exam_id = UUID.randomUUID().toString().replace("-","").substring(0,10);
		}
	}

	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public int getExam_duration() {
		return exam_duration;
	}
	public void setExam_duration(int exam_duration) {
		this.exam_duration = exam_duration;
	}
	public Date getDate() {
		return date;
	}
	public void setData(Date date) {
		this.date = date;
	}
	public int getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	
	
		
}
