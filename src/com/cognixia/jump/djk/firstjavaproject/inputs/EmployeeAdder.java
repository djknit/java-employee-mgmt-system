package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.Department;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.data.Employee;
import com.cognixia.jump.djk.firstjavaproject.data.HumanName;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.StringInHandler;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class EmployeeAdder {
	
	private Executor cancel = Menus::employees;
	
	private String firstName;
	private HumanName name;
	private DollarAmount salary;
	private Department department;
	
	public EmployeeAdder(Executor cancel) {
		this(null, cancel);
	}
	
	public EmployeeAdder(Department department, Executor cancel) {
		this.department = department;
		this.cancel = cancel;
	}
	
	public void run() {
		Executor addEmpAndProcede = () -> this.addEmployee(cancel);
		getNameInput(() -> getSalaryInput(addEmpAndProcede));
	}
	
	private void getNameInput(Executor next) {
		StringInHandler handleInput = (String firstNameIn) -> {
			firstName = firstNameIn;
			getLastNameIn(next);
		};
		new TextInput("Enter the employee's first name.", handleInput, cancel).run();
	}
	
	private void getLastNameIn(Executor next) {
		StringInHandler handleInput = (String lastNameIn) -> {
			name = new HumanName(firstName, lastNameIn);
			next.execute();
		};
		new TextInput("Enter the employee's last name.", handleInput, cancel).run();
	}
	
	private void getSalaryInput(Executor next) {
		DollarAmountInHandler handleInput = (DollarAmount salaryInput) -> {
			salary = salaryInput;
			next.execute();
		};
		new DollarsInput("Enter the employee's salary.", handleInput, cancel).run();
	}
	
	private void addEmployee(Executor next) {
		Employee newEmployee = new Employee(name, salary, department);
		Company.addEmployee(newEmployee);
		department.addEmployee(newEmployee);
		RecordReporter.employees.announceCreationOf(newEmployee);
		new AnythingInput(next).run();
	}
	
}
