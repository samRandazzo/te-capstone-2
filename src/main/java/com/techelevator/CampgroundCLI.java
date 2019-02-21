package com.techelevator;

import java.util.List;

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
//MENU ARRAYS//																				  //*************	
	private static final String MAIN_MENU_OPTION_ARCADIA = "Arcadia"; 						 // Park 
	private static final String MAIN_MENU_OPTION_ARCHES = "Arches"; 						 // Info 
	private static final String MAIN_MENU_OPTION_CUYAHOGA = "Cuyahoga National Valley Park"; // Menu 
	private static final String MAIN_MENU_OPTION_QUIT = "Quit"; 							// *************
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_ARCADIA, MAIN_MENU_OPTION_ARCHES,
			MAIN_MENU_OPTION_CUYAHOGA, MAIN_MENU_OPTION_QUIT };

	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu"; // ***Return to main menu option***

	private static final String CAMP_MENU_CAMPGROUNDS = "View Campgrounds"; 		// ************************************
	private static final String CAMP_MENU_RESERVATIONS = "Search for Reservations"; // *View camp grounds and
																					// reservations*
	private static final String CAMP_MENU_RETURN_TO_MAIN = "Return to Main Menu"; 	// ************************************
	private static final String[] CAMP_MENU_OPTIONS = new String[] { CAMP_MENU_CAMPGROUNDS, CAMP_MENU_RESERVATIONS,
			CAMP_MENU_RETURN_TO_MAIN };

	private static final String RESERVATION_MENU_CAMPGROUND = "Which campground? (Enter 0 to cancel)";
	private static final String RESERVATION_MENU_ARRIVAL = "What is the arrival day? MM/DD/YEAR";
	private static final String RESERVATION_MENU_DEPARTURE = "What is the departure date? MM/DD/YEAR";
	private static final String[] RESERVATION_MENU_OPTIONS = new String[] { RESERVATION_MENU_CAMPGROUND,
			RESERVATION_MENU_ARRIVAL, RESERVATION_MENU_DEPARTURE };

	private static final String RESULTS_MENU_RESERVE_SITE = "Which site should be reserved? (Enter 0 to cancel)";
	private static final String RESULTS_MENU_RESERVE_NAME = "What name should the reservation be made under?";

	private Menu menu;
	private ParkDAO parkDAO; 				// *********
	private ReservationDAO reservationDAO;  // * 
	private SiteDAO siteDAO; 				// * DAOs 
	private CampgroundDAO campgroundDAO; 	// * 
											// *********

	public CampgroundCLI(DataSource datasource) {
		this.menu = new Menu(System.in, System.out);

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		campgroundDAO = new JDBCCampgroundDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
		parkDAO = new JDBCParkDAO(datasource);

	}

	public static void main(String[] args) {
		CampgroundCLI application = new CampgroundCLI();
		application.run();
	}

	public void run() {
		while (true) {
			printHeading("Welcome to the National Park System! Select a park for details.");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_ARCADIA)) {

			} else if (choice.equals(MAIN_MENU_OPTION_ARCHES)) {

			} else if (choice.equals(MAIN_MENU_OPTION_CUYAHOGA)) {

			} else if (choice.equals(MAIN_MENU_OPTION_QUIT)) {
				System.exit(0);
			}

		}
	}

	private void handlePickParkOption (Park park) {										//
		printHeading(park.getName() + "National Park");
		List<Park> parkInfo = parkDAO.
		
	}

	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
