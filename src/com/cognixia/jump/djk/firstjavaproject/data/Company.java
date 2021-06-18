package com.cognixia.jump.djk.firstjavaproject.data;

import java.io.Serializable;
import java.util.HashSet;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Company instance;

	private HashSet<Department> departments = new HashSet<>();
	private HashSet<Employee> employees = new HashSet<>();
	
	static {
		Object objectDataFromFile = IO.getObjectDataFromFile();
		instance = objectDataFromFile == null ?
				new Company() :
				(Company) objectDataFromFile;
		int maxDeptId = 0;
		int maxEmpId = 0;
		for (Department dept : instance.departments) {
			int deptId = dept.getId();
			if (deptId > maxDeptId) maxDeptId = deptId;
		}
		for (Employee emp : instance.employees) {
			int empId = emp.getId();
			if (empId > maxEmpId) maxEmpId = empId;
		}
		Department.reportGreatestId(maxDeptId);
		Employee.reportGreatestId(maxEmpId);
	}
	
	private Company() {
		super();
	}
	
	public static Company getInstance() {
		return Company.instance;
	}
	
	public static DollarAmount getBudget() {
		return instance.departments
				.stream()
				.map(Department::getBudget)
				.reduce(new DollarAmount(), DollarAmount::getSum);
	}
	
	public static HashSet<Employee> getEmployees() {
		return instance.employees;
	}
	
	public static HashSet<Department> getDepartments() {
		return instance.departments;
	}
	
	public static HashSet<Employee> addEmployee(Employee newEmployee) {
		instance.employees.add(newEmployee);
		return instance.employees;
	}
	
	public static HashSet<Department> addDepartment(Department newDept) {
		instance.departments.add(newDept);
		return instance.departments;
	}
	
	public static HashSet<Employee> removeEmployee(Employee employee) {
		instance.employees.remove(employee);
		return instance.employees;
	}
	
}
