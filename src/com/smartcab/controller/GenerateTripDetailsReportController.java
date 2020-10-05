package com.smartcab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.smartcab.command.TripCommand;
import com.smartcab.service.TripService;

public class GenerateTripDetailsReportController extends AbstractController {
	private TripService tripService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TripCommand> trips = null;
		ModelAndView mav = null;
		String viewName = "cabtrips";
		String view = null;
		int cabId = 0;

		cabId = Integer.parseInt(request.getParameter("cabId"));
		view = request.getParameter("view");
		trips = tripService.getTripsByCabId(cabId);
		if (view != null && !view.equals("")) {
			if (view.equals("xl")) {
				viewName = "cabxltrips";
			} else if (view.equals("pdf")) {
				viewName = "cabpdftrips";
			}

		}

		mav = new ModelAndView();
		mav.addObject("id", cabId);
		mav.addObject("trips", trips);
		mav.setViewName(viewName);

		return mav;
	}

	public void setTripService(TripService tripService) {
		this.tripService = tripService;
	}

}
