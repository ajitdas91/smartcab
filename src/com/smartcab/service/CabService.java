package com.smartcab.service;

import java.util.List;

import com.smartcab.command.FindCabCommand;
import com.smartcab.dto.CabDto;

public interface CabService {
	List<CabDto> search(FindCabCommand command, String status);
	CabDto getCab(int cabId);
	List<Integer> getAllCabIds();
}
