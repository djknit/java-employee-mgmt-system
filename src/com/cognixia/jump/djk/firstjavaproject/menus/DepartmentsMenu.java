package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.inputs.DepartmentAdder;

abstract class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("List All Departments", () -> {
			// list names, budget, number of employees
			// also list salary costs?
			System.out.println(Company.getDepartments());
			run();
		}),
		new MenuOption("View/Edit Single Department", () -> {
			// show name, budget, employees, salary costs?
			
		}),
		new MenuOption("Add New Department", () -> {
			new DepartmentAdder().run();
		}),
		new MenuOption("Main Menu", Menus::main),
		new EndProgramMenuOption()
	};
	
	static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
