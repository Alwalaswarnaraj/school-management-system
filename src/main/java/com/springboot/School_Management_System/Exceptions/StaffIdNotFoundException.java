package com.springboot.School_Management_System.Exceptions;

public class StaffIdNotFoundException extends Exception{

		StaffIdNotFoundException(){
			
		}

		public StaffIdNotFoundException(String string) {
			super(string);
		}
}
