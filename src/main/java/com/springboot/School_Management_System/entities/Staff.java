package com.springboot.School_Management_System.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Staff{
	@Id
//	@GeneratedValue
	private String staff_id;
	private String staff_name;
	private String staff_role;
	private String contact_info;


	public void generateId(){
		if(this.staff_id == null){
			this.staff_id = UUID.randomUUID().toString().replace("-","").substring(0,10);
		}
	}

	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_role() {
		return staff_role;
	}
	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_role=" + staff_role
				+ ", contact_info=" + contact_info + "]";
	}
	
	
	
	
}
