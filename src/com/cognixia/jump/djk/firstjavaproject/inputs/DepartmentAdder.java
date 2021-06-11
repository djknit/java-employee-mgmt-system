package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.StringInHandler;
import com.cognixia.jump.djk.firstjavaproject.Divider;
import com.cognixia.jump.djk.firstjavaproject.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.Executor;
import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class DepartmentAdder {
	
	private static final Executor cancel = Menus::departments;

	private String name;
	private DollarAmount budget;
	
	public void run() {
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
		System.out.println(Divider.get() + "\nNew department created:\n" + newDepartment);
		new AnythingInput(next).run();
	}
	
}
