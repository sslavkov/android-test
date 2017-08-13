package com.gostatz.gostatztrainer.activities;

/**
 * Created by sslavkov on 8/13/17.
 */

public class BusinessClient {
	
	private Long id;
	private String firstName;
	private String lastName;
	
	public BusinessClient(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public BusinessClient() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
