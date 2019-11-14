package com.adcb.payment.salary;

import java.util.HashMap;

public class TestStatic extends Employee{
	
	Company companyObj = new Company();
	
	public void setCompanyObj(Company companyObj) {
		this.companyObj = companyObj;
	}

	static {
		Employee.getEmployee(new Employee("Singh"));
	}
	
	public Employee callTestStaticGetEmployee() {		
		return Employee.getEmployee(new Employee("Singh"));
	}

	public TestStatic() {
		// TODO Auto-generated constructor stub
	}

	public HashMap retrieveChannelDetails(String channel){
		System.out.println("TestStatic.retrieveChannelDetails() 2222222222222222222222");
		HashMap channelDetails = new HashMap();
		channelDetails.put("AAA", "N");
		channelDetails.put("BBBB", "N");
		return channelDetails;
	}
	
	public String getCompanyName() {
		return companyObj.getCompanyName();
	}
}
