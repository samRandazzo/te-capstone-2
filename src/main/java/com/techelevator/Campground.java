package com.techelevator;

public class Campground {

	private int campgroundId, parkId;
	private String name, dailyFee;
	int openFrom;
	int openTo;

	public int getCampgroundId() {
		return campgroundId;
	}

	public String getDailyFee() {
		return dailyFee;
	}

	public String getName() {
		return name;
	}

	public int getOpenFrom() {
		return openFrom;
	}

	public int getOpenTo() {
		return openTo;
	}

	public int getParkId() {
		return parkId;
	}

	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}

	public void setDailyFee(String dailyFee) {
		this.dailyFee = dailyFee;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOpenFrom(int openFrom) {
		this.openFrom = openFrom;
	}

	public void setOpenTo(int openTo) {
		this.openTo = openTo;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

}
