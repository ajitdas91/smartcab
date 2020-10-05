package com.smartcab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.smartcab.command.FindCabCommand;
import com.smartcab.dto.CabDto;
import com.smartcab.service.CabService;

public class FindCabCommandController extends AbstractCommandController {
	private CabService cabService;

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = null;
		List<CabDto> cabs = null;
		FindCabCommand cabCommand = null;

		cabCommand = (FindCabCommand) command;
		cabs = cabService.search(cabCommand, "unassigned");

		mav = new ModelAndView();
		mav.addObject("cabs", cabs);
		mav.addObject("cabdetails", cabCommand);
		mav.setViewName("choosecab");

		return mav;
	}

	public void setCabService(CabService cabService) {
		this.cabService = cabService;
	}

}
