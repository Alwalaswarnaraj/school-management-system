package com.springboot.School_Management_System.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
public class Section {
	@Id
	private String section_id;
	private String section_name;
	private String class_id;

	@PrePersist
	public void generateId(){
		if(this.section_id == null){
			this.section_id = UUID.randomUUID().toString().replace("-","").substring(0,10);
		}
	}
	
	
	public String getSection_id() {
		return section_id;
	}
	public void setSection_id(String section_id) {
		this.section_id = section_id;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	@Override
	public String toString() {
		return "Section [section_id=" + section_id + ", section_name=" + section_name + ", class_id=" + class_id + "]";
	}
	
	
}
