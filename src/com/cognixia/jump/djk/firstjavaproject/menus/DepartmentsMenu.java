package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.*;

abstract public class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("List All Departments", () -> {
			// list names, budget, number of employees
			// also list salary costs?
			
		}),
		new MenuOption("Get and/or Edit Single Department", () -> {
			// show name, budget, employees, salary costs?
			
		}),
		new MenuOption("Add New Department", () -> {
			
		}),
		new MenuOption("Main Menu", () -> {
			Menus.main();
		}),
		new EndProgramMenuOption()
	};
	
	public static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
