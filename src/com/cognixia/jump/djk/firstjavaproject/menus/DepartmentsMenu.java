package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.DepartmentAdder;

abstract class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("Add New Department", () -> {
			new DepartmentAdder().run();
		}),
		new MenuOption("List All Departments", () -> {
			// list names, budget, number of employees
			// also list salary costs?
			RecordReporter.departments.printEntities(Company.getDepartments());
			new AnythingInput(() -> run()).run();
		}),
		new MenuOption("View/Edit Single Department", () -> {
			// show name, budget, employees, salary costs?
			
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
