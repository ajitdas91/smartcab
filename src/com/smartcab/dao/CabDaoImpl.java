package com.smartcab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.smartcab.bo.CabBo;
import com.smartcab.bo.CabCriteriaBo;

public class CabDaoImpl implements CabDao {
	private final String SQL_CABS_AVAILABLE = "SELECT C.CAB_ID, CONCAT(CONCAT(D.FIRST_NM,','),D.LAST_NM) AS DRIVER_NM, D.MOBILE, CL.AREA FROM CAB C, DRIVER D, CAB_LOC CL WHERE C.DRIVER_ID = D.DRIVER_ID AND C.CAB_ID = CL.CAB_ID AND (CL.AREA IS NULL OR CL.AREA = ?) AND C.CAPACITY = ? AND C.CAB_ID NOT IN (SELECT T.CAB_ID FROM TRIP T WHERE  STATUS IN ('In Progress', 'Assigned'))";
	private final String SQL_GET_CAB_BY_ID = "SELECT C.CAB_ID, CONCAT(CONCAT(D.FIRST_NM,','),D.LAST_NM) AS DRIVER_NM, (SELECT CL.AREA FROM CAB_LOC CL WHERE CL.CAB_ID = C.CAB_ID) AS Area, D.MOBILE FROM CAB C, DRIVER D WHERE C.DRIVER_ID = D.DRIVER_ID AND C.CAB_ID = ?";
	private final String SQL_GET_ALL_CABIDS = "SELECT CAB_ID  FROM CAB ORDER BY CAB_ID";
	
	private JdbcTemplate jdbcTemplate;

	public CabDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CabBo> getCabsByCriteria(CabCriteriaBo criteria) {
		if (criteria.getStatus().equals("unassigned")) {
			return jdbcTemplate
					.query(SQL_CABS_AVAILABLE,
							new CabRowMapper(),
							new Object[] { criteria.getSource(),
									criteria.getCapacity() });
		}
		return null;
	}
	
	public List<Integer> getAllCabIds() {
		return jdbcTemplate.queryForList(SQL_GET_ALL_CABIDS, Integer.class);
	}

	@Override
	public CabBo getCab(int cabId) {
		return jdbcTemplate.queryForObject(SQL_GET_CAB_BY_ID,
				new CabRowMapper(), new Object[] { cabId });
	}

	private final class CabRowMapper implements RowMapper<CabBo> {
		@Override
		public CabBo mapRow(ResultSet rs, int index) throws SQLException {
			return new CabBo(rs.getInt("CAB_ID"), rs.getString("DRIVER_NM"),
					rs.getString("MOBILE"), rs.getString("AREA"));
		}
	}

}
