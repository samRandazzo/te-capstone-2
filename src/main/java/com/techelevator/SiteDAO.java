package com.techelevator;

import java.util.List;

public interface SiteDAO {
	
	List<Site> getSitesByCampgroundId(int campgroundId);

}
