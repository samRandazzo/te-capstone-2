package com.techelevator;

public class Site {

	//might break from Int, change to long if so 
	private int siteId, campgroundId, siteNumber, maxOccupancy, maxRvLength;
	private boolean accessible, utilities;
	
	
/* public Site(int siteId, int campgroundId, int siteNumber, int maxOccupancy, int maxRvLength, boolean accessible, boolean utilities) {
		this.accessible = accessible;
		this.campgroundId = campgroundId;
		this.maxOccupancy = maxOccupancy;
		this.maxRvLength = maxRvLength;
		this.siteId = siteId;
		this.siteNumber = siteNumber;
		this.utilities = utilities;
	}*/
	
	
	public int getCampgroundId() {
		return campgroundId;
	}public int getMaxOccupancy() {
		return maxOccupancy;
	}public int getMaxRvLength() {
		return maxRvLength;
	}public int getSiteId() {
		return siteId;
	}public int getSiteNumber() {
		return siteNumber;
	}public boolean isAccesible() {
		return accessible;
	}public boolean isUtilities() {
		return utilities;
	}public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
	}public void setSiteId(int siteId) {
		this.siteId = siteId;
	}public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
}
