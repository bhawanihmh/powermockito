package com.javacodegeeks.powermock;

public class FinalClazzUser {
	
	private SimpleFinalClazz simpleFinalClazz;
	public FinalClazzUser(SimpleFinalClazz simpleFinalClazz) {
		this.simpleFinalClazz = simpleFinalClazz;
	}
	
	public String getMeSomething() {
		return "Get Me Something " + simpleFinalClazz.simpleFinalMethod();
	}
}
