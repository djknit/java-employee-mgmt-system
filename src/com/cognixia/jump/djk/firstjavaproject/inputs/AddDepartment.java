package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.InputHandler;
import com.cognixia.jump.djk.firstjavaproject.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.Executor;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

abstract public class AddDepartment {
	
	private static String name;
	private static DollarAmount budget;
	private static final Executor cancel = Menus::departments;
	
	public static void run() {
		getNameInput(() -> {
			getBudgetInput(() -> {
				
			});
		});
	}
	
	private static void getNameInput(Executor next) {
		InputHandler handleInput = (String nameInput) -> {
			name = nameInput;
			next.execute();
		};
		new TextInput("Enter the name of the new department.", handleInput, cancel).run();
	}
	
	private static void getBudgetInput(Executor next) {
		DollarAmountInHandler handleInput = (DollarAmount budgetInput) -> {
			budget = budgetInput;
		};
		new DollarsInput("Enter the department budget.", handleInput, cancel);
	}
	
}
