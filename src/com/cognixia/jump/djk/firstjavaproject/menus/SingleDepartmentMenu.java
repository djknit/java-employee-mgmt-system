package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.display.InputGroupHeader;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.StringInHandler;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.DollarsInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.TextInput;

abstract class SingleDepartmentMenu {
	
	private static final Executor runThis = SingleDepartmentMenu::run;
	private static Department selectedDepartment;
	
	static MenuOption[] options = {
		new MenuOption("List Department Employees", () -> {
			RecordReporter.employees.printEntities(selectedDepartment.getEmployees());
			new AnythingInput(SingleDepartmentMenu::run).run();
		}),
		new MenuOption("Add New Employee", () -> {
			
		}),
		new MenuOption("Change Department Name", () -> {
			InputGroupHeader.print(selectedDepartment + "\nChange Department Name");
			StringInHandler handleInput = (String newName) -> {
				selectedDepartment.setName(newName);
				System.out.println("Department name updated.");
				new AnythingInput(runThis).run();
			};
			new TextInput("Enter the new name.", handleInput, runThis).run();
		}),
		new MenuOption("Change Budget", () -> {
			InputGroupHeader.print(selectedDepartment + "\nChange Budget");
			DollarAmountInHandler handleInput = (DollarAmount newBudget) -> {
				selectedDepartment.setBudget(newBudget);
				System.out.println("Department budget updated.");
				new AnythingInput(runThis).run();
			};
			new DollarsInput("Enter the new name.", handleInput, runThis).run();
		}),
		new MenuOption("Departments Menu", DepartmentsMenu::run),
		new MenuOption("Main Menu", MainMenu::run)
	};
	
	static void run(Department department) {
		selectedDepartment = department;
		run();
	}
	
	static void run() {
		String heading = "DEPARTMENT SELECTED:\n\n " + selectedDepartment;
		new Menu(options, heading, false).run();
	}
}
