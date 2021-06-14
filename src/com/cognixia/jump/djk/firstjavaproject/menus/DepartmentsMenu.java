package com.cognixia.jump.djk.firstjavaproject.menus;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.DepartmentAdder;
import com.cognixia.jump.djk.firstjavaproject.inputs.IdInput;

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
			Collection<Department> departments = Company.getDepartments();
			Collection<RecordWithId> genericizedDepts = departments.stream().collect(Collectors.toList());
			RecordReporter.departments.printEntities(departments, "Select a Department");
			if (departments.isEmpty()) {
				new AnythingInput(DepartmentsMenu::run).run();
				return;
			}
			new IdInput(
				"Enter the id of a department to select it.",
				(RecordWithId selectedEntity) -> {
					Department selectedDepartment = (Department) selectedEntity;
					SingleDepartmentMenu.run(selectedDepartment);
				},
				Menus::departments
			).run(genericizedDepts);
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Departments Menu").run();
	}
}
