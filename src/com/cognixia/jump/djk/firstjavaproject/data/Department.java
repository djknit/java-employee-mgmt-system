package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.HashSet;
import java.util.Set;

public class Department extends RecordWithId {

	private static int nextId = 1;
	
	private int id;
	private String name;
	private DollarAmount budget;
	private Set<Employee> employees = new HashSet<>();
	
	public Department(String name) {
		this(name, new DollarAmount());
	}
	
	public Department(String name, DollarAmount budget) {
		this.name = name;
		this.budget = budget;
		this.id = nextId++;
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
	
	public void setBudget(DollarAmount budget) {
		this.budget = budget;
	}
	
	public Set<Employee> addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
		return employees;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	@Override
	public boolean hasId(int id) {
		return id == this.id;
	}

	@Override
	public String toString() {
		return "[ id=" + id + " | name=\"" + name + "\" | budget=" + budget + " | employees=" +  employees.size() + " ]";
	}
	
}
