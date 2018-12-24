package com.telran.data;

public class History extends Place{
	private boolean isReligion;
	public History(int id, 
			String name, 
			String city, 
			String address, boolean isReligion) {
		super(id, name, city, address);
		this.isReligion = isReligion;
	}
	
	public boolean isReligion() {
		return isReligion;
	}

}
