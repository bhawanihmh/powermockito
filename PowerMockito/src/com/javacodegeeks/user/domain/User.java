package com.javacodegeeks.user.domain;

/**
 * Class representing User entity.
 * @author Meraj
 *
 */
public class User {
	
	private String firstName;
	private String surname;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
