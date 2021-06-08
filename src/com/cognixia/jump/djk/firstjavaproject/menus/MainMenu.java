package com.cognixia.jump.djk.firstjavaproject.menus;

abstract public class MainMenu {
	
	static MenuOption[] options = {
		new MenuOption("Employees", () -> {
			
		}),
		new MenuOption("Departments", () -> {
			
		}),
		new MenuOption("Exit Program", () -> {})
	};
	
	public static void run() {
		new Menu(new MenuHeader("Main Menu"), options).run();
	}
	
}
