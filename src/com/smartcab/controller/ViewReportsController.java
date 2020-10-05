package com.smartcab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.smartcab.service.CabService;

public class ViewReportsController extends AbstractController {
	private CabService cabService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Integer> cabIds = null;
		ModelAndView mav = null;

		cabIds = cabService.getAllCabIds();
		mav = new ModelAndView();
		mav.addObject("cabIds", cabIds);
		mav.setViewName("reports");

		return mav;
	}

	public void setCabService(CabService cabService) {
		this.cabService = cabService;
	}

}
