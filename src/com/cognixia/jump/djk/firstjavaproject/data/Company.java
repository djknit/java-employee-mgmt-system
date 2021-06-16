package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.HashSet;

abstract public class Company {

	private static HashSet<Department> departments = new HashSet<>();
	private static HashSet<Employee> employees = new HashSet<>();
	
	public static DollarAmount getBudget() {
		return departments
				.stream()
				.map(Department::getBudget)
				.reduce(new DollarAmount(), DollarAmount::getSum);
	}
	
	public static HashSet<Employee> getEmployees() {
		return employees;
	}
	
	public static HashSet<Department> getDepartments() {
		return departments;
	}
	
	public static HashSet<Employee> addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
		return employees;
	}
	
	public static HashSet<Department> addDepartment(Department newDept) {
		departments.add(newDept);
		return departments;
	}
	
	public static HashSet<Employee> removeEmployee(Employee employee) {
		employees.remove(employee);
		return employees;
	}
	
}
