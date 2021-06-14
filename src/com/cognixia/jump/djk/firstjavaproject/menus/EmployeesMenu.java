package com.cognixia.jump.djk.firstjavaproject.menus;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.Employee;
import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.display.InputGroupHeader;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.EmployeeAdder;
import com.cognixia.jump.djk.firstjavaproject.inputs.IdInput;

abstract class EmployeesMenu {

	static MenuOption[] options = {
		new MenuOption("Add New Employee", () -> {
			InputGroupHeader.print("Add Employee");
			Collection<Department> departments = Company.getDepartments();
			Collection<RecordWithId> genericizedDepts = departments.stream().collect(Collectors.toList());
			RecordReporter.departments.printEntities(departments, "Select Department for New Employee");
			if (departments.isEmpty()) {
				System.out.println("\nYou can't add an employee when there are no departments.");
				new AnythingInput(DepartmentsMenu::run).run();
				return;
			}
			new IdInput(
				"Enter the id of a department to select it.",
				(RecordWithId selectedEntity) -> {
					Department selectedDepartment = (Department) selectedEntity;
					new EmployeeAdder(selectedDepartment).run();
				},
				Menus::departments
			).run(genericizedDepts);
		}),
		new MenuOption("List All Employees", () -> {
			Divider.print();
			System.out.println("EMPLOYEES:\n");
			Company.getEmployees().forEach(employee -> {
				System.out.println(employee);
			});
			new AnythingInput(() -> run()).run();
		}),
		new MenuOption("View/Edit Single Employee", () -> {
			Collection<Employee> employees = Company.getEmployees();
			Collection<RecordWithId> genericizedEmps = employees.stream().collect(Collectors.toList());
			RecordReporter.employees.printEntities(employees, "Select an Employee");
			if (employees.isEmpty()) {
				new AnythingInput(EmployeesMenu::run).run();
				return;
			}
			new IdInput(
				"Enter employee id to select.",
				(RecordWithId selectedEntity) -> {
					Employee selectedEmployee = (Employee) selectedEntity;
					SingleEmployeeMenu.run(selectedEmployee);
				},
				Menus::employees
			).run(genericizedEmps);
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Employees Menu").run();
	}
	
}
