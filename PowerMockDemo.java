package com.adcb.payment.salary;

public class PowerMockDemo {

	Employee employee;

	public Employee callPrivateMethod() {
		return privateMethod(new Employee("Singh"));
	}

	public Employee callGetEmployee() {
		return Employee.getEmployee(new Employee("Singh"));
	}

	private Employee privateMethod(Employee point) {
		return null;
	}
}
