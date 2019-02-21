package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;
import com.techelevator.Campground;
import com.techelevator.CampgroundDAO;
import com.techelevator.Park;
import com.techelevator.ParkDAO;
import com.techelevator.Reservation;
import com.techelevator.ReservationDAO;
import com.techelevator.Site;
import com.techelevator.SiteDAO;

public class CampgroundCLI {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}

	public CampgroundCLI(DataSource datasource) {
		// create your DAOs here
	}
	
	public void run() {
		
	}
}
