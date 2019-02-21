package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



public class JDBCParkDAO implements ParkDAO{
	
private JdbcTemplate jdbcTemplate;
	
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	
	@Override
	public List<Park> parks() {

	ArrayList<Park> parks = new ArrayList<>();
	String sqlGetAllParks = "SELECT * FROM Park Order By Name ";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
	while(results.next()) {
		Park eachPark = mapRowToPark(results);
		parks.add(eachPark);
	}
	return parks;
	
	}
	
	@Override
	public Park getParkName(String Name) {
		Park parkName = new Park();
	
		String sqlParkName = "SELECT * FROM Park Where name = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkName, Name);
		if (results.next()) {
			parkName = mapRowToPark(results);
		}
			return parkName;
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

