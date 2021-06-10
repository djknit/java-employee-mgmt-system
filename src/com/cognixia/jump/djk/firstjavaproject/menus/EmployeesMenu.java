package com.cognixia.jump.djk.firstjavaproject.menus;

abstract public class EmployeesMenu {

	static MenuOption[] options = {
		new MenuOption("Add New Employee", () -> {
			
		}),
		new MenuOption("List All Employees", () -> {
			
		}),
		new MenuOption("Get and/or Edit Single Employee", () -> {
			
		}),
		new MenuOption("Main Menu", () -> {
			Menus.main();
		}),
		new EndProgramMenuOption()
	};
	
	public static void run() {
		new Menu(options, "Employees Menu").run();
	}
}