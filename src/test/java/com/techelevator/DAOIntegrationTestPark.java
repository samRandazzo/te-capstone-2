package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DAOIntegrationTestPark {
	private JDBCParkDAO parkDAO;
	
private static SingleConnectionDataSource dataSource;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	@Before
	public void setup() {
		
		
		
		parkDAO = new JDBCParkDAO(getDataSource());	

		
	}
	
	@Test
	public void testGetAllAvailableParks() {
		
		assertEquals("Acadia", parkDAO.parks().get(0).getName());
		assertEquals("Maine", parkDAO.parks().get(0).getLocation());
		assertEquals(LocalDate.of(2008, 02, 22), parkDAO.parks().get(0).getEstablishDate());
		assertEquals(47389, parkDAO.parks().get(0).getArea());
		
	}
	@Test
	public void testGetParkInformation() {
		
		assertEquals("Acadia", parkDAO.getParkName("Acadia").getName());
		assertEquals("Maine", parkDAO.getParkName("Acadia").getLocation());
		assertEquals(LocalDate.of(1919, 02, 26), parkDAO.getParkName("Acadia").getEstablishDate());
		assertEquals(47389, parkDAO.getParkName("Acadia").getArea());
		
}
}