package com.smartcab.service;

import java.util.ArrayList;
import java.util.List;

import com.smartcab.bo.TripDetailBo;
import com.smartcab.command.TripCommand;
import com.smartcab.dao.TripDao;

public class TripServiceImpl implements TripService {
	private TripDao tripDao;

	@Override
	public String assignTrip(TripCommand command) {
		TripDetailBo bo = null;

		bo = new TripDetailBo(command.getSource(), command.getDest(),
				command.getCapacity(), command.getCabId(),
				command.getDriverName(), "Assigned", command.getName(),
				command.getContactMobile(), command.getEmergencyContact());
		return tripDao.saveTrip(bo);
	}

	@Override
	public List<TripCommand> getTripsByCabId(int cabId) {
		List<TripCommand> trips = null;
		List<TripDetailBo> tripBos = null;

		tripBos = tripDao.getTripsByCabId(cabId);
		trips = new ArrayList<TripCommand>();
		for (TripDetailBo bo : tripBos) {
			TripCommand cmd = new TripCommand();
			cmd.setCabId(bo.getCabId());
			cmd.setSource(bo.getSource());
			cmd.setDest(bo.getDest());
			trips.add(cmd);
		}
		return trips;
	}

	public void setTripDao(TripDao tripDao) {
		this.tripDao = tripDao;
	}

}
