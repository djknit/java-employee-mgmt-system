package com.cognixia.jump.djk.firstjavaproject.display;

abstract public class Greeting {
	public static void run() {
		Divider.printLow();
		Divider.print();
		System.out.println(
			"WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM!"
		);
	};
	
	public static void runGoodbye() {
		Divider.printLow();
		Divider.print();
		System.out.println("* * * GOODBYE * * *");
	};
}
