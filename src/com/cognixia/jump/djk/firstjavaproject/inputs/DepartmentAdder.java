package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.display.DepartmentReporter;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.display.InputGroupHeader;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.StringInHandler;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class DepartmentAdder {
	
	private static final Executor cancel = Menus::departments;

	private String name;
	private DollarAmount budget;
	
	public void run() {
		InputGroupHeader.print("Add Department");
		Executor addDeptAndProcede = () -> this.addDepartment(cancel);
		getNameInput(() -> getBudgetInput(addDeptAndProcede));
	}
	
	private void getNameInput(Executor next) {
		StringInHandler handleInput = (String nameInput) -> {
			name = nameInput;
			next.execute();
		};
		new TextInput("Enter the name of the new department.", handleInput, cancel).run();
	}
	
	private void getBudgetInput(Executor next) {
		DollarAmountInHandler handleInput = (DollarAmount budgetInput) -> {
			budget = budgetInput;
			next.execute();
		};
		new DollarsInput("Enter the department budget.", handleInput, cancel).run();
	}
	
	private void addDepartment(Executor next) {
		Department newDepartment = new Department(name, budget);
		Company.addDepartment(newDepartment);
		new DepartmentReporter().announceCreationOf(newDepartment);
		new AnythingInput(next).run();
	}
	
}
