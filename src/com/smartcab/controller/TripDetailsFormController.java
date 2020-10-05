package com.smartcab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.smartcab.command.TripCommand;
import com.smartcab.dto.CabDto;
import com.smartcab.service.CabService;

public class TripDetailsFormController extends SimpleFormController {
	private CabService cabService;

	@Override
	/**
	 * Post-back phase request
	 */
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = null;

		if (((TripCommand) command).getDest().equals("Goa")) {
			errors.rejectValue("dest", "dest.unavailable");
			return showForm(request, response, errors);
		}

		mav = new ModelAndView();
		mav.addObject("trip", command);
		mav.setViewName("reviewtrip");

		return mav;
	}

	/**
	 * Initial Phase request
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		TripCommand command = null;
		CabDto dto = null;

		dto = cabService.getCab(Integer.parseInt(request.getParameter("id")));
		command = new TripCommand();
		command.setSource(request.getParameter("src"));
		command.setDest(request.getParameter("destination"));
		command.setCapacity(Integer.parseInt(request.getParameter("cap")));
		command.setCabId(dto.getCabId());
		command.setDriverName(dto.getDriverName());
		command.setMobile(dto.getMobile());
		command.setArea(dto.getArea());

		return command;
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> referenceDataMap = null;
		List<String> supportedProofTypes = null;

		supportedProofTypes = new ArrayList<String>();
		supportedProofTypes.add("Adhar");
		supportedProofTypes.add("Voter Id");
		supportedProofTypes.add("Passport");
		supportedProofTypes.add("Pancard");
		supportedProofTypes.add("Driving License");

		referenceDataMap = new HashMap<String, Object>();
		referenceDataMap.put("supportedProofTypes", supportedProofTypes);

		return referenceDataMap;
	}

	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("dup_form_error");
	}

	public void setCabService(CabService cabService) {
		this.cabService = cabService;
	}

}
