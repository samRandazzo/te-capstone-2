package com.techelevator;

import java.time.LocalDate;

public class Park {
	
	private Long parkId;
	private String name;
	private String location;
	private LocalDate establishDate;
	private Long area;
	private Long visitors;
	private String description;
	
	
	public Long getParkId() {
		return parkId;
	}
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(LocalDate establishDate) {
		this.establishDate = establishDate;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	public long getVisitors() {
		return visitors;
	}
	public void setVisitors(long visitors) {
		this.visitors = visitors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return name + ", " + location;
	}
}

