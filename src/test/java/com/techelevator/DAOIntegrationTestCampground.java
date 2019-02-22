package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DAOIntegrationTestCampground extends DAOIntegrationTest{
	private JDBCCampgroundDAO campgroundDAO;
	
	
	
	@Before
	public void setup() {
		
		
		
		campgroundDAO = new JDBCCampgroundDAO(getDataSource());	

		
	}
	
	@Test
	public void return_all_employees() {
		List<Reservation> results = campgroundDAO.createReservation();
		assertEquals(13, results.size());
	}

}
