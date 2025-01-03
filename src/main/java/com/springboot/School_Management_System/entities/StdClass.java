
package com.springboot.School_Management_System.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
public class StdClass {
	@Id
	private String class_id;
	private String class_name;
	private String section_id;
	private String teacher_id;
	private String subject_list;

	@PrePersist
	public void generateId(){
		if(this.class_id == null){
			this.class_id = UUID.randomUUID().toString().replace("-","").substring(0,10);
		}
	}

	int student_count;
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getSection_id() {
		return section_id;
	}
	public void setSection_id(String section_id) {
		this.section_id = section_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getSubject_list() {
		return subject_list;
	}
	public void setSubject_list(String subject_list) {
		this.subject_list = subject_list;
	}
	public int getStudent_count() {
		return student_count;
	}
	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
	@Override
	public String toString() {
		return "Class [class_id=" + class_id + ", class_name=" + class_name + ", section_id=" + section_id
				+ ", teacher_id=" + teacher_id + ", subject_list=" + subject_list + ", student_count=" + student_count
				+ "]";
	}
	
	
}
