package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.inputs.TextInput;

abstract class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("List All Departments", () -> {
			// list names, budget, number of employees
			// also list salary costs?
			
		}),
		new MenuOption("View/Edit Single Department", () -> {
			// show name, budget, employees, salary costs?
			
		}),
		new MenuOption("Add New Department", () -> {
			String prompt = "";
			new TextInput(prompt, (String s) -> {}).run();
		}),
		new MenuOption("Main Menu", () -> {
			Menus.main();
		}),
		new EndProgramMenuOption()
	};
	
	static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
