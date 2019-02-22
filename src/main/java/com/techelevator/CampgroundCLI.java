package com.techelevator;

import java.util.ArrayList;
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
//MENU ARRAYS//		
	//This is the main menu array to display each park
	
	private static final String MAIN_MENU_OPTION_ARCADIA = "Arcadia"; 						  
	private static final String MAIN_MENU_OPTION_ARCHES = "Arches"; 						 
	private static final String MAIN_MENU_OPTION_CUYAHOGA = "Cuyahoga National Valley Park"; 
	private static final String MAIN_MENU_OPTION_QUIT = "Quit"; 							
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_ARCADIA, MAIN_MENU_OPTION_ARCHES,
																	 MAIN_MENU_OPTION_CUYAHOGA, MAIN_MENU_OPTION_QUIT };
	//This is the option to return to the main menu
	
	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu"; 

	private static final String CAMP_MENU_CAMPGROUNDS = "View Campgrounds"; 		
	private static final String CAMP_MENU_RESERVATIONS = "Search for Reservations"; 
	private static final String CAMP_MENU_RETURN_TO_MAIN = "Return to Main Menu"; 	
	private static final String[] CAMP_MENU_OPTIONS = new String[] { CAMP_MENU_CAMPGROUNDS, 
																	 CAMP_MENU_RESERVATIONS,
																	 CAMP_MENU_RETURN_TO_MAIN };

	private static final String RESERVATION_MENU_CAMPGROUND = "Which campground? (Enter 0 to cancel)";
	private static final String RESERVATION_MENU_ARRIVAL = "What is the arrival day? MM/DD/YEAR";
	private static final String RESERVATION_MENU_DEPARTURE = "What is the departure date? MM/DD/YEAR";
	private static final String[] RESERVATION_MENU_OPTIONS = new String[] { RESERVATION_MENU_CAMPGROUND,
																			RESERVATION_MENU_ARRIVAL, 
																			RESERVATION_MENU_DEPARTURE };

	private static final String RESULTS_MENU_RESERVE_SITE = "Which site should be reserved? (Enter 0 to cancel)";
	private static final String RESULTS_MENU_RESERVE_NAME = "What name should the reservation be made under?";

	//DAOs and Menu
	
	private Menu menu;
	private ParkDAO parkDAO; 				
	private ReservationDAO reservationDAO;   
	private SiteDAO siteDAO; 				
	private CampgroundDAO campgroundDAO; 	
											
public static void main(String[] args) {
		CampgroundCLI application = new CampgroundCLI(null);
		application.run();
	}

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

	

	public void run() {
		while (true) {
			printHeading("Welcome to the National Park System! Select a park for details.");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_ARCADIA)) {
				handleCampsiteInfo();
			} else if (choice.equals(MAIN_MENU_OPTION_ARCHES)) {
				handleCampsiteInfo();
			} else if (choice.equals(MAIN_MENU_OPTION_CUYAHOGA)) {
				handleCampsiteInfo();
			} else if (choice.equals(MAIN_MENU_OPTION_QUIT)) {
				System.exit(0);
			}

		}
	}
	
	private void handleCampsiteInfo() {
		printHeading("Campsites");
		List<Campground> campsites = campgroundDAO.getCampgroundsByParkID();
		listCampsites(campsites);
	}
	
	private void listCampsites(List<Campground>campsites) {
		System.out.println();
		if (campsites.size() > 0) {
			for(Campground cg : campsites) {
				System.out.println(cg.getName());
			} 
			} else {
				System.out.println("No results!");
		}
	}

	
		

	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
