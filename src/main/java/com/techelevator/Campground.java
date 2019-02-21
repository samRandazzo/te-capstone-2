package com.techelevator;

public class Campground {
	
	
	public int campgroundId, parkId, openTo, openFrom;
	public String name;
	public Double dailyFee;
	
	
	public Campground(int campgroundId, int parkId, int openTo, int openFrom, String name, Double dailyFee) {
		this.campgroundId = campgroundId;
		this.dailyFee = dailyFee;
		this.parkId = parkId;
		this.openFrom = openFrom;
		this.openTo = openTo;
		this.name= name;
		
	}
	public int getCampgroundId() {
		return campgroundId;
	}public Double getDailyFee() {
		return dailyFee;
	}public String getName() {
		return name;
	}public int getOpenFrom() {
		return openFrom;
	}public int getOpenTo() {
		return openTo;
	}public int getParkId() {
		return parkId;
	}public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}public void setDailyFee(Double dailyFee) {
		this.dailyFee = dailyFee;
	}public void setName(String name) {
		this.name = name;
	}public void setOpenFrom(int openFrom) {
		this.openFrom = openFrom;
	}public void setOpenTo(int openTo) {
		this.openTo = openTo;
	}public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	

}
