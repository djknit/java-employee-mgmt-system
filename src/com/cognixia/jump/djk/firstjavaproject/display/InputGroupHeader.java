package com.cognixia.jump.djk.firstjavaproject.display;

abstract public class InputGroupHeader {
	
	public static void print(String label) {
		Divider.print();
		Divider.printLow();
		System.out.println(formatLabel(label));
	}
	
	public static String get(String label) {
		return Divider.get() + "\n" + Divider.getLow() + "\n" + formatLabel(label);
	}
	
	private static String formatLabel(String label) {
		return label + ":";
	}
	
}
