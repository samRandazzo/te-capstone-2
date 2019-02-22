package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DAOIntegrationTestSite extends DAOIntegrationTest{
	private JDBCSiteDAO siteDAO;
	
	
	
	@Before
	public void setup() {
		
		
		
		siteDAO = new JDBCSiteDAO(getDataSource());	

		
	}
	
	@Test
	public void return_all_employees() {
		List<Reservation> results = siteDAO.createsite();
		assertEquals(13, results.size());
	}

}
