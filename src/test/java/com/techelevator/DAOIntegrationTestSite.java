package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DAOIntegrationTestSite extends DAOIntegrationTest{
	private JDBCSiteDAO siteDAO;
	
	
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
		siteDAO = new JDBCSiteDAO(getDataSource());	
	}
	
	
	
	
	
	@Test
	public void test_Available_Sites {
		Assert.assertFalse(siteDAO.getAvailableSitesByReservationDate(1, LocalDate.parse("2019-06-19"), LocalDate.parse("2019-06-20")).isEmpty());

	}
	
	
}


