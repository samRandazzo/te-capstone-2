package com.techelevator;

import java.time.LocalDate;

public class Park {
	
	private int parkId, area, visitors;
	private String name, location, description;
	private LocalDate establishDate;
	
	
	
	public Park(int parkID, int area, int visitors, String name, String location, String description, LocalDate establishDate) {
		
		this.area =area;
		this.parkId = parkID;
		this.visitors = visitors;
		this.name = name;
		this.location = location;
		this.description = description;
		this.establishDate =establishDate;
		}
	
	
	public int getArea() {
		return area;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getEstablishDate() {
		return establishDate;
	}
	public String getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public int getParkId() {
		return parkId;
	}
	public int getVisitors() {
		return visitors;
	}
public void setArea(int area) {
	this.area = area;
}
public void setDescription(String description) {
	this.description = description;
}public void setEstablishDate(LocalDate establishDate) {
	this.establishDate = establishDate;
}public void setLocation(String location) {
	this.location = location;
}public void setName(String name) {
	this.name = name;
}public void setParkId(int parkId) {
	this.parkId = parkId;
}public void setVisitors(int visitors) {
	this.visitors = visitors;
}
}

