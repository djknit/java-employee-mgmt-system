package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.display.Divider;

public class InputHeader {
	
	private String label;
	
	InputHeader(String label) {
		this.label = label;
	}
	
	void print() {
		printWithLabel(label);
	}
	
	static void printWithLabel(String label) {
		Divider.print();
		System.out.println(label + ":");
		Divider.print();
	}
	
}
