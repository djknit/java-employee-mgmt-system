package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract public class Company {

//	private DollarAmount budget;
	private static Set<Department> departments = new HashSet<>();
	private static Set<Employee> employees = new HashSet<>();
	
	public static DollarAmount getBudget() {
		return departments
				.stream()
				.map(Department::getBudget)
				.reduce(new DollarAmount(), DollarAmount::getSum);
//				.map(dept -> dept.getBudget())
//				.reduce((d1_budget, d2_budget) -> DollarAmount.getSum(d1_budget, d2_budget))
//				.get();
	}
	
	public static Set<Employee> getEmployees() {
		return employees;
	}
	
	public static Set<Department> getDepartments() {
		return departments;
	}
	
	public static Set<Employee> addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
		return employees;
	}
	
	public static Set<Department> addDepartment(Department newDept) {
		departments.add(newDept);
		return departments;
	}
	
}
