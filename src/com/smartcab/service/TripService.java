package com.smartcab.service;

import java.util.List;

import com.smartcab.command.TripCommand;

public interface TripService {
	String assignTrip(TripCommand command);
	List<TripCommand> getTripsByCabId(int cabId);
}
