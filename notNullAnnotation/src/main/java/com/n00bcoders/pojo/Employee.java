package com.n00bcoders.pojo;

import com.n00bcoders.notnullannotation.NotNull;

public class Employee {
	
	@NotNull
	private String firstName;
	private String lastName;
	private int age;

	public Employee(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}

}
