package com.cognixia.jump.djk.firstjavaproject.display;

public class InputGroupHeader {
	
	private String headerString = "";
	
	private InputGroupHeader(String label) {
		headerString = Divider.get() + "\n" + Divider.getLow() + "\n" + formatLabel(label);
	}
	
	public static void print(String label) {
		Divider.print();
		Divider.printLow();
		System.out.println(formatLabel(label));
	}
	
	public static String get(String label) {
		return new InputGroupHeader(label).headerString;
	}
	
	private static String formatLabel(String label) {
		return label + ":";
	}
	
}
