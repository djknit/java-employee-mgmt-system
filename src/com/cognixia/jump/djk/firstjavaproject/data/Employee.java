package com.cognixia.jump.djk.firstjavaproject.data;

public class Employee extends RecordWithId {
	// source: Cognixia Java JUMP program in-class demonstration (/3/21)

	private static int nextId = 1;
	private int id;
	private HumanName name;
	private DollarAmount salary;
	private Department department;
	
	public Employee(String firstName, String lastName, int salary, Department department) {
		this(new HumanName(firstName, lastName), new DollarAmount(salary), department);
	}

	public Employee(HumanName name, DollarAmount salary, Department department) {
		setName(name);
		this.salary = salary;		
		this.department = department;
		this.id = nextId++;
	}

	public HumanName getName() {
		return name;
	}
	
	public void setName(String firstName, String lastName) {
		setName(new HumanName(firstName, lastName));
	}

	public void setName(HumanName name) {
		this.name = name;
	}

	public DollarAmount getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		setSalary(new DollarAmount(salary));
	}
	
	public void setSalary(DollarAmount salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public boolean hasId(int id) {
		return id == this.id;
	}

	@Override
	public String toString() {
		return "Employee [ id=" + id + " | name=" + name + " | salary=" + salary + " | department=" + department.getName() + " ]";
	}

}