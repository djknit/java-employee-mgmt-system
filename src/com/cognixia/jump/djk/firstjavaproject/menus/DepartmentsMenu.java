package com.cognixia.jump.djk.firstjavaproject.menus;

abstract public class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("List All Departments", () -> {
			
		}),
		new MenuOption("Get and/or Edit Single Department", () -> {
			
		}),
		new MenuOption("Exit Program", () -> {})
	};
	
	public static void run() {
		new Menu(options, "DepartmentsMenu").run();
	}
}
