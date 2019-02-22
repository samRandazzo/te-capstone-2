package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.Campground;
import com.techelevator.CampgroundDAO;

public class JDBCCampgroundDAO implements CampgroundDAO{
	

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getCampgroundsByParkID() {
		List<Campground> campgroundList = new ArrayList <Campground>();
		String sqlFindAllCampgrounds = "SELECT park_id " + 
									   "FROM campground;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllCampgrounds);
		while(results.next()) {
			Campground c = mapRowToCampground(results);
			campgroundList.add(c);
		}
									
		return campgroundList;
	}



private Campground mapRowToCampground(SqlRowSet results) {
	Campground theCampground;
	theCampground = new Campground();
	theCampground.setCampgroundId(results.getInt("campground_id"));
	theCampground.setName(results.getString("name"));
	theCampground.setParkId(results.getInt("park_id"));
	theCampground.setOpenFrom(results.getString("open_from_mm"));
	theCampground.setOpenTo(results.getString("open_to_mm"));
	theCampground.setDailyFee(results.getString("daily_fee"));

	
	return theCampground;
	}

}
