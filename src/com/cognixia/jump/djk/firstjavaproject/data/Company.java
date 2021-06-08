package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.HashSet;
import java.util.Set;

public class Company {

	private static int nextId = 1;
	
	private int id;
	private String name;
	private DollarAmount budget;
	private Set<Employee> employees = new HashSet<>();
	
	public Company(String name) {
		this(name, 0);
	}
	
	public Company(String name, int budget) {
		this.name = name;
		this.budget = new DollarAmount(budget);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public DollarAmount getBudget() {
		return budget;
	}
	
	public void setBudget(int budget) {
		this.budget = new DollarAmount(budget);
	}
	
	public void setBudget(DollarAmount budget) {
		this.budget = budget;
	}
	
	public Set<Employee> addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
		return employees;
	}
	
}
