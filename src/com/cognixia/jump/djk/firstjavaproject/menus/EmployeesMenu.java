package com.cognixia.jump.djk.firstjavaproject.menus;

import java.util.Collection;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.Employee;
import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.EmployeeAdder;
import com.cognixia.jump.djk.firstjavaproject.inputs.RecordSelector;

abstract class EmployeesMenu {

	static MenuOption[] options = {
		new MenuOption("Add New Employee", () -> {
			new RecordSelector(
				"department",
				EmployeesMenu::run,
				(RecordWithId selectedEntity) -> {
					Department selectedDepartment = (Department) selectedEntity;
						new EmployeeAdder(selectedDepartment, EmployeesMenu::run).run();
				},
				"Add Employee:\n" + Divider.get() + "\nSelect a Department",
				"Enter the id of a department to select it.",
				DepartmentsMenu::run,
				"You can't add an employee when there are no departments."
			).selectFrom(Company.getDepartments());
		}),
		new MenuOption("List All Employees", () -> {
			RecordReporter.employees.printEntities(Company.getEmployees());
			new AnythingInput(() -> run()).run();
		}),
		new MenuOption("View/Edit Single Employee", () -> {
			Collection<Employee> employees = Company.getEmployees();
			new RecordSelector(
				"employee",
				EmployeesMenu::run,
				(RecordWithId selectedEntity) -> {
					Employee selectedEmployee = (Employee) selectedEntity;
					SingleEmployeeMenu.run(selectedEmployee);
				},
				"Select an Employee",
				"Enter the id of an employee to select them."
			).selectFrom(employees);;
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Employees Menu").run();
	}
	
}
