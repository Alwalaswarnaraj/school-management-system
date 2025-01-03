
package com.springboot.School_Management_System.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Parent implements Serializable{
	@Id
	private String parent_id;
	private String parent_name;
	private String contact_info;
	private String email;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Student> students;


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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Parent [parent_id=" + parent_id + ", parent_name=" + parent_name + ", contact_info=" + contact_info
				+ ", email=" + email + ", students=" + students + "]";
	}
}
