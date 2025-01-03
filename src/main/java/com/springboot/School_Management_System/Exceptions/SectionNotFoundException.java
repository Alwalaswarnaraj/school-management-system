package com.springboot.School_Management_System.Exceptions;
public class SectionNotFoundException extends Exception{
	SectionNotFoundException(){
		
	}
	
	public SectionNotFoundException(String string) {
		super(string);
	}
}
