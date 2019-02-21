package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {
	private JdbcTemplate jdbctemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public int createReservation( int siteId, String name, LocalDate fromDate, LocalDate toDate) {
		String sqlReserved = "Insert INTO Reservation (site_id, name, from_date, to_date) + Values (?,?,?,?) RETURNING reservation_id";
	
		SqlRowSet id = jdbctemplate.queryForRowSet(sqlReserved, siteId, name, toDate, fromDate);
		
		id.next();
		return id.getInt(1);
		
		
	}
	
	
	
	
	
		public List<Reservation> reservations(int siteId, String fromDate) {

		ArrayList<Reservation> actualReservations = new ArrayList<>();
		String sqlGetAllReservations = "SELECT * FROM Reservation Where site_id = ? and to_date = ?";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllReservations);
		while(results.next()) {
			Reservation eachReservation = mapRowToReservation(results);
			actualReservations.add(eachReservation);
		}
		return actualReservations;
	}
	
	
	
	
	
	private Reservation mapRowToReservation(SqlRowSet results) {
		Reservation theReservation = new Reservation();
		theReservation.setReservationId(results.getInt("reservation_id"));
		theReservation.setSiteId(results.getInt("site_id"));
		theReservation.setName(results.getString("name"));
		theReservation.setToDate(results.getDate("to_date").toLocalDate());
		theReservation.setFromDate(results.getDate("from_date").toLocalDate());
		theReservation.setCreateDate(results.getDate("create_date").toLocalDate());
		
		
		return theReservation;
}





}
