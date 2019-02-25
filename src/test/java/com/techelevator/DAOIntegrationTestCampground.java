package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DAOIntegrationTestCampground {
	private JDBCCampgroundDAO campgroundDAO;
	
	
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
		
		
		
		campgroundDAO = new JDBCCampgroundDAO(getDataSource());	
}

	@Test
	public void testGetAvailableCampgrounds() {
		Campground testCamp = new Campground();
		testCamp = campgroundDAO.getCampgroundsByParkID().get(0);
		
		assertEquals("Blackwoods", campgroundDAO.getCampgroundsByParkID().get(0).getName());
		assertEquals("01", campgroundDAO.getCampgroundsByParkID().get(0).getOpenTo());
		assertEquals("12", campgroundDAO.getCampgroundsByParkID().get(0).getOpenFrom());
		assertEquals("35.00", campgroundDAO.getCampgroundsByParkID().get(0).getDailyFee());
	}






}
