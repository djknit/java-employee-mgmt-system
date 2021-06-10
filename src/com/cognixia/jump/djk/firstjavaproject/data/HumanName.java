package com.cognixia.jump.djk.firstjavaproject.data;

public class HumanName {
	
	private String first;
	private String last;
	
	HumanName(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	}
	
	public void setFirstName(String firstName) {
		first = firstName;
	}
	
	public void setLastName(String lastName) {
		last = lastName;
	}
	
	@Override
	public String toString() {
		return (last + ", " + first);
	}
	
}
