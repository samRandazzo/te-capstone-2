package com.techelevator;

import java.util.List;

public interface CampgroundDAO {

	List<Campground> getCampgroundsByParkID(int parkID);
	
	
}
