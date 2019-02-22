package com.techelevator;

import java.util.List;

public interface ParkDAO {
		
		public List<Park> parks();
		

		public Park getParkName(String Name);

	}


