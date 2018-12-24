package com.telran.data;

public class Museum extends Place{

	private String[] workDays;
	public Museum(int id, 
			String name, 
			String city, 
			String address, 
			String[] workDays) {
		super(id, name, city, address);
		this.workDays = workDays;
	}
	
	public String[] workDays() {
		return workDays;
	}
	
}
