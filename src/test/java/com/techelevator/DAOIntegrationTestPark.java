package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DAOIntegrationTestPark extends DAOIntegrationTest {
	private JDBCParkDAO parkDAO;
	
	
	
	@Before
	public void setup() {
		
		
		
		parkDAO = new JDBCParkDAO(getDataSource());	

		
	}
	
	@Test
	public void return_all_employees() {
		List<Reservation> results = parkDAO.getParkName(Name);
		assertEquals(13, results.size());
	}

}
