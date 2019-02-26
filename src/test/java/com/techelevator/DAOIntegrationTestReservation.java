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



public class DAOIntegrationTestReservation {

	
	private JDBCReservationDAO resDAO;

		
	private static SingleConnectionDataSource dataSource;
		
		@BeforeClass
		public static void setupDataSource() {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/nationalparks");
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
			resDAO = new JDBCReservationDAO(getDataSource());	
		}
		
	
	@Test
	public void book_reservation() {
	LocalDate fromDate = LocalDate.of(2019, 02, 19);
	LocalDate toDate = LocalDate.of(2019, 02, 23);
	}
	
	

	
	
	

}
