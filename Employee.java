package com.adcb.payment.salary;

public class Employee {
	String name = "Singh";
	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public static Employee getEmployee(Employee point) {
		return new Employee("Singh");
	}
}
