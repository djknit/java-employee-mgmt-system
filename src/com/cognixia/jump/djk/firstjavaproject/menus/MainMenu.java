package com.cognixia.jump.djk.firstjavaproject.menus;

abstract public class MainMenu {
	
	static MenuOption[] options = {
		new MenuOption("Employees", () -> {
			System.out.println("accepted input");
			EmployeesMenu.run();
		}),
		new MenuOption("Departments", () -> {
			
		}),
		new MenuOption("Exit Program", () -> {})
	};
	
	public static void run() {
		new Menu(options, "Main Menu").run();
	}
	
}
