package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDOA implements CampgroundDAO{
	

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDOA(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getCampgroundsByParkID(int parkID) {
		// TODO Auto-generated method stub
		return null;
	}
private Park mapRowToPark(SqlRowSet results) {
	Park thePark = new Park();
	thePark.setArea(results.getInt("area"));
	thePark.setDescription(results.getString("description"));
	thePark.setEstablishDate(results.getDate("establish_date").toLocalDate());
	thePark.setLocation(results.getString("location"));
	thePark.setName(results.getString("name"));
	thePark.setParkId(results.getInt("park_id"));
	thePark.setVisitors(results.getInt("vistors"));
	
	return thePark;
}



}
