package com.springboot.School_Management_System.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Parent implements Serializable{
	@Id
	String parent_id;
	String parent_name;
	String contact_info;
	String email;
	String students;
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudents() {
		return students;
	}
	public void setStudents(String students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Parent [parent_id=" + parent_id + ", parent_name=" + parent_name + ", contact_info=" + contact_info
				+ ", email=" + email + ", students=" + students + "]";
	}
}
