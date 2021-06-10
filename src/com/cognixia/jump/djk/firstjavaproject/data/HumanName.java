package com.cognixia.jump.djk.firstjavaproject.data;

public class HumanName {
	
	private String first;
	private String last;
	
	public HumanName(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public void setFirstName(String firstName) {
		first = firstName;
	}
	
	public void setLastName(String lastName) {
		last = lastName;
	}
	
	public String getFirstName() {
		return first;
	}
	
	public String getLastName() {
		return last;
	}
	
	@Override
	public String toString() {
		return (last + ", " + first);
	}
	
}
