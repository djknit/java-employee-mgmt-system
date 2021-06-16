package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.DepartmentAdder;
import com.cognixia.jump.djk.firstjavaproject.inputs.RecordSelector;

abstract class DepartmentsMenu {
	static MenuOption[] options = {
		new MenuOption("Add New Department", () -> {
			new DepartmentAdder().run();
		}),
		new MenuOption("List All Departments", () -> {
			RecordReporter.departments.printEntities(Company.getDepartments());
			new AnythingInput(DepartmentsMenu::run).run();
		}),
		new MenuOption("View/Edit Single Department", () -> {
			new RecordSelector(
				"department",
				DepartmentsMenu::run,
				(RecordWithId selectedEntity) -> {
					Department selectedDepartment = (Department) selectedEntity;
					SingleDepartmentMenu.run(selectedDepartment);
				},
				"Select a Department",
				"Enter the id of a department to select it."
			).selectFrom(Company.getDepartments());
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
