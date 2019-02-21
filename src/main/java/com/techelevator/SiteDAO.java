package com.techelevator;

import java.util.List;

public interface SiteDAO {
	
	List<Site> site(int siteId, int campgroundId, int siteNumber, int maxOccupancy, int maxRvLength, boolean accessible, boolean utilities);
	
	
	
	

}
