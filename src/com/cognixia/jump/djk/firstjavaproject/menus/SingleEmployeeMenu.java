package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.data.Employee;
import com.cognixia.jump.djk.firstjavaproject.display.InputGroupHeader;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.StringInHandler;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.DollarsInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.TextInput;

abstract class SingleEmployeeMenu {

	private static final Executor runThis = SingleEmployeeMenu::run;
	private static Employee selectedEmployee;
	
	static MenuOption[] options = {
		new MenuOption("Change First Name", () -> {
			InputGroupHeader.print(selectedEmployee + "\nChange First Name");
			StringInHandler handleInput = (String newName) -> {
				selectedEmployee.getName().setFirstName(newName);
				System.out.println("Employee name updated.");
				new AnythingInput(runThis).run();
			};
			new TextInput("Enter the new name.", handleInput, runThis).run();
		}),
		new MenuOption("Change Last Name", () -> {
			InputGroupHeader.print(selectedEmployee + "\nChange Last Name");
			StringInHandler handleInput = (String newName) -> {
				selectedEmployee.getName().setLastName(newName);
				System.out.println("Employee name updated.");
				new AnythingInput(runThis).run();
			};
			new TextInput("Enter the new name.", handleInput, runThis).run();
		}),
		new MenuOption("Change Salary", () -> {
			InputGroupHeader.print(selectedEmployee + "\nChange Salary");
			DollarAmountInHandler handleInput = (DollarAmount newSalary) -> {
				selectedEmployee.setSalary(newSalary);
				System.out.println("Employee salary updated.");
				new AnythingInput(runThis).run();
			};
			new DollarsInput("Enter the new name.", handleInput, runThis).run();
		}),
		new MenuOption("Permanently Delete Employee", () -> {
			selectedEmployee.getDepartment().removeEmployee(selectedEmployee);
			Company.removeEmployee(selectedEmployee);
			MainMenu.run();
		}),
		new MenuOption("Employees Menu", EmployeesMenu::run),
		new MenuOption("Departments Menu", DepartmentsMenu::run),
		new MenuOption("Main Menu", MainMenu::run)
	};
	
	static void run(Employee employee) {
		selectedEmployee = employee;
		run();
	}
	
	static void run() {
		String heading = "EMPLOYEE SELECTED:\n\n " + selectedEmployee;
		new Menu(options, heading, false).run();
	}
	
}
