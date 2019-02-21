package com.techelevator;

import java.time.LocalDate;

public class Reservation {
	
	
	public int reservationId, siteId;
	public String name;
	public LocalDate fromDate, toDate, createDate;

	
	/*public Reservation(int reservationId, int siteId, String name, LocalDate fromDate, LocalDate toDate, LocalDate createDate) {
		this.createDate = createDate;
		this.fromDate = fromDate;
		this.name = name;
		this.reservationId = reservationId;
		this.toDate = toDate;
		this.siteId = siteId;
	}*/
	
	public LocalDate getCreateDate() {
		return createDate;
	}public LocalDate getFromDate() {
		return fromDate;
	}public String getName() {
		return name;
	}public int getReservationId() {
		return reservationId;
	}public int getSiteId() {
		return siteId;
	}public LocalDate getToDate() {
		return toDate;
	}public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}public void setName(String name) {
		this.name = name;
	}public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}public void setSiteId(int siteId) {
		this.siteId = siteId;
	}public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
}
