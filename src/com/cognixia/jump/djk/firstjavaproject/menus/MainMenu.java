package com.cognixia.jump.djk.firstjavaproject.menus;

abstract class MainMenu {
	
	static MenuOption[] options = {
		new MenuOption("Employees", () -> {
			Menus.employees();
		}),
		new MenuOption("Departments", () -> {
			Menus.departments();
		})
	};
	
	public static void run() {
		new Menu(options, "Main Menu").run();
	}
	
}
