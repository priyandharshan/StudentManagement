package com.example.services;



public class AddressDto {
	
	private long id;
	private String streetName;
	private String city;
	public AddressDto(long id, String streetName, String city) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.city = city;
	}
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
}
