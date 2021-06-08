package com.cognixia.jump.djk.firstjavaproject.menus;

abstract public class MainMenu {
	
	static MenuOption[] options = {
		new MenuOption("Employees", () -> {
			Menus.employees();
		}),
		new MenuOption("Departments", () -> {
			Menus.departments();
		}),
		new MenuOption("Exit Program", () -> {})
	};
	
	public static void run() {
		new Menu(options, "Main Menu").run();
	}
	
}
