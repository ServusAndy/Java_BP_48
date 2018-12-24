package com.telran.data;

public abstract class Place {
	private int id;
	private String name;
	private String city;
	private String address;
	
	protected Place(int id, String name, String city,String address) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
	}
	
	public String name() {
		return name;
	}
	
	public int id() {
		return id;
	}
	
	public String city() {
		return city;
	}
	
	public String address() {
		return address;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Place)) {
			return false;
		}
		Place other = (Place) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	
	
}
