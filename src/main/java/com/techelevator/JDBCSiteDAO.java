package com.techelevator;

import java.time.LocalDate;
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
	@Override
	public List<Site> getAvailableSitesByReservationDate(long campgroundId, LocalDate startDate, LocalDate endDate) {
		List<Site> availableSites = new ArrayList<Site>();
		String sqlFindTopFiveAvailableSites = "SELECT distinct * FROM site " + 
				"join campground on site.campground_id = campground.campground_id " + 
				"where site.campground_id = ? " + 
				"and site_id not in " + 
				"(select site.site_id from site " + 
				"JOIN reservation ON reservation.site_id = site.site_id " + 
				"WHERE ? > reservation.from_date and ? < reservation.to_date) " + 
				"order by daily_fee " + 
				"LIMIT 5";
		Site theSite;
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlFindTopFiveAvailableSites, campgroundId, startDate, endDate);
		while(results.next()) {
			theSite = mapRowToSite(results);
			availableSites.add(theSite);
		}
		return  availableSites;
	}

	

	
	private Site mapRowToSite(SqlRowSet results) {
		Site theSite;
		theSite = new Site();
		theSite.setCampgroundId(results.getInt("campground_id"));
		theSite.setSiteNumber(results.getInt("site_number"));
		theSite.setMaxOccupancy(results.getInt("max_occupancy"));
		theSite.setMaxRvLength(results.getInt("max_rv_length"));
		theSite.setAccessible(results.getBoolean("accessible"));
		theSite.setHasUtilities(results.getBoolean("utilities"));
		
		
		return theSite;
}

	
}
