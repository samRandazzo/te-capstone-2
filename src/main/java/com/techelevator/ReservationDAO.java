package com.techelevator;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {
	
	int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate);

	
	List<Reservation> reservations (Campground campground);
		
		
	}
	


