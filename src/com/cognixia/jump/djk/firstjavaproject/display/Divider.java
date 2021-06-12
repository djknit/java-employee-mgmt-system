package com.cognixia.jump.djk.firstjavaproject.display;

abstract public class Divider {

	private static String divider = "";
	
	static {
		for (int i = 0; i < 42; i++) {
			divider += "-";
		}
	}
	
	public static String get() {
		return divider;
	}
	
	public static void print() {
		System.out.println(divider);
	}
	
}
