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
	public List<Campground> getCampgroundsByParkId(long id) {
		List<Campground> campgroundList = new ArrayList <Campground>();
		String sqlFindAllCampgrounds = "SELECT * " + 
									   "FROM campground "+
									   "WHERE park_id = ?";
		Campground theCampground;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllCampgrounds, id);
		while(results.next()) {
			theCampground = mapRowToCampground(results);
			campgroundList.add(theCampground);
		}
									
		return campgroundList;
	}



private Campground mapRowToCampground(SqlRowSet results) {
	Campground theCampground;
	theCampground = new Campground();
	theCampground.setCampgroundId(results.getInt("campground_id"));
	theCampground.setName(results.getString("name"));
	theCampground.setParkId(results.getInt("park_id"));
	theCampground.setOpenFrom(results.getInt("open_from_mm"));
	theCampground.setOpenTo(results.getInt("open_to_mm"));
	theCampground.setDailyFee(results.getString("daily_fee"));

	
	return theCampground;
	}

}
