package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.inputs.AnythingInput;
import com.cognixia.jump.djk.firstjavaproject.inputs.EmployeeAdder;

abstract class EmployeesMenu {

	static MenuOption[] options = {
		new MenuOption("Add New Employee", () -> {
			new EmployeeAdder().run();
		}),
		new MenuOption("List All Employees", () -> {
			Divider.print();
			System.out.println("EMPLOYEES:\n");
			Company.getEmployees().forEach(employee -> {
				System.out.println(employee);
			});
//				System.out.println(Company.getEmployees());
			new AnythingInput(() -> run()).run();
		}),
		new MenuOption("View/Edit Single Employee", () -> {
			
		}),
		new MenuOption("Main Menu", Menus::main)
	};
	
	static void run() {
		new Menu(options, "Employees Menu").run();
	}
	
}
