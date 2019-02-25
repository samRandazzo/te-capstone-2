package com.techelevator;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {
	
	List<Site> getAvailableSitesByReservationDate(long campgroundId, LocalDate startDate, LocalDate endDate);

}
