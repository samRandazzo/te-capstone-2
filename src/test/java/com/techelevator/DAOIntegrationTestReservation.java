package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



public class DAOIntegrationTestReservation extends DAOIntegrationTest {

	
	private JDBCReservationDAO resDAO;
	
	
	
	@Before
	public void setup() {
		
		
		
		resDAO = new JDBCReservationDAO(getDataSource());	

		
	}
	
	@Test
	public void book_reservation() {
	LocalDate fromDate = LocalDate.of(2018, 8, 13);
	LocalDate toDate = LocalDate.of(2018, 8, 15);
	
	int reservation = resDAO.createReservation(1, "TEST", fromDate, toDate);
	assertEquals("TEST", reservation);
	}
	
	

}
