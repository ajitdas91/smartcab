package com.smartcab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.smartcab.command.TripCommand;
import com.smartcab.service.TripService;

public class ConfirmTripCommandController extends AbstractCommandController {
	private TripService tripService;

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String tripId = null;
		ModelAndView mav = null;
		TripCommand tCommand = null;

		tCommand = (TripCommand) command;
		tripId = tripService.assignTrip(tCommand);

		mav = new ModelAndView();
		mav.addObject("tripId", tripId);
		mav.addObject("driverName", tCommand.getDriverName());
		mav.addObject("mobile", tCommand.getMobile());

		mav.setViewName("finish");
		return mav;
	}

	public void setTripService(TripService tripService) {
		this.tripService = tripService;
	}

}
