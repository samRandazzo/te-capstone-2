package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbctemplate;


	public JDBCSiteDAO(DataSource dataSource)
	{
		this.jdbctemplate = new JdbcTemplate(dataSource);
		
	}
		public List<Site> getSitesByCampgroundId(int campgroundId) {
		ArrayList<Site> allSites = new ArrayList<>();
		String sqlGetAllSites = "SELECT * FROM Site Where campground_id = ?";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllSites, campgroundId);
		while(results.next()) {
			Site eachSite = mapRowToSite(results);
			allSites.add(eachSite);
		}return allSites;
	}
		public List<Site> availableSites(int siteId, String fromDate, String toDate) {
			ArrayList<Site> aSite = new ArrayList<>();
			String sqlGetAvailableSites = "Select Site.* from site where site_id NOT IN (SELECT * from Reservation where reservation_id = ? and site_id = ?) order by site.site_id Limit 5";
			SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAvailableSites,siteId, fromDate, toDate);
			while(results.next()) {
				Site availableSite = mapRowToSite(results);
				aSite.add(availableSite);
			}
			return aSite;
		}

	

	
	private Site mapRowToSite(SqlRowSet results) {
		Site theSite;
		theSite = new Site();
		theSite.setCampgroundId(results.getInt("campground_id"));
		theSite.setSiteNumber(results.getInt("site_number"));
		theSite.setMaxOccupancy(results.getInt("max_occupancy"));
		theSite.setMaxRvLength(results.getInt("max_rv_length"));
		theSite.setAccessible(results.getBoolean("accesible"));
		theSite.setUtilities(results.getBoolean("utilities"));
		
		
		return theSite;
}

	
}
