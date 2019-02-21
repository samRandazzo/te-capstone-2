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

}



}
