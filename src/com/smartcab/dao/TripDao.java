package com.smartcab.dao;

import java.util.List;

import com.smartcab.bo.TripDetailBo;

public interface TripDao {
	String saveTrip(TripDetailBo bo);
	List<TripDetailBo> getTripsByCabId(int cabId);
}
