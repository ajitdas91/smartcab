package com.smartcab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.smartcab.bo.TripDetailBo;

public class TripDaoImpl implements TripDao {
	private final String SQL_INSERT_TRIP = "INSERT INTO TRIP(TRIP_ID, CAB_ID, SRC, DEST, NAME, MOBILE, EMERGENCTY_CONTACT_NO, STATUS) VALUES(?,?,?,?,?,?,?,?)";
	private final String SQL_GET_TRIPS_BY_CAB_ID = "SELECT T.CAB_ID, T.SRC, T.DEST FROM TRIP T WHERE T.CAB_ID = ?";
	private JdbcTemplate jdbcTemplate;

	public TripDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String saveTrip(TripDetailBo bo) {
		String tripId = null;

		tripId = UUID.randomUUID().toString();
		jdbcTemplate.update(
				SQL_INSERT_TRIP,
				new Object[] { tripId, bo.getCabId(), bo.getSource(),
						bo.getDest(), bo.getName(), bo.getContactMobile(),
						bo.getEmergencyContact(), bo.getStatus() });
		return tripId;
	}

	public List<TripDetailBo> getTripsByCabId(int cabId) {
		return jdbcTemplate.query(SQL_GET_TRIPS_BY_CAB_ID, new TripRowMapper(),
				new Object[] { cabId });
	}

	private final class TripRowMapper implements RowMapper<TripDetailBo> {

		@Override
		public TripDetailBo mapRow(ResultSet rs, int index) throws SQLException {
			return new TripDetailBo(rs.getString("SRC"), rs.getString("DEST"),
					0, rs.getInt("CAB_ID"), null, null, null, null, null);
		}

	}

}
