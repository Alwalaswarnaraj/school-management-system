package com.springboot.School_Management_System.Exceptions;

public class ExamNotFoundException extends Exception{
	ExamNotFoundException(){
		
	}
	
	public ExamNotFoundException(String string) {
		super(string);
	}
}
