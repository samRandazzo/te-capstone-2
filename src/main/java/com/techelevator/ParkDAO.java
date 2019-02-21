package com.techelevator;

import java.util.List;

public interface ParkDAO {
		
		List<Park> parks();
		
		Park getParkName(String Name);
	}


