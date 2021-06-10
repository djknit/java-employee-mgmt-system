package com.cognixia.jump.djk.firstjavaproject.data;

public class Employee {
	// source: Cognixia Java JUMP program in-class demonstration (6/3/21)

	private static int nextId = 1;

	private int id;
	private String name;
	private DollarAmount salary;
	private String department;

	public Employee(String name, int salary, String department) {
//		super();
		this.name = name;
		this.salary = new DollarAmount(salary);			
		this.department = department;
		this.id = nextId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DollarAmount getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = new DollarAmount(salary);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

}