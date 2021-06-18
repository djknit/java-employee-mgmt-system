package com.cognixia.jump.djk.firstjavaproject.data;

import java.io.Serializable;

public class HumanName implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7728354997313933615L;
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
