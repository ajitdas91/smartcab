package com.smartcab.dao;

import java.util.List;

import com.smartcab.bo.CabBo;
import com.smartcab.bo.CabCriteriaBo;

public interface CabDao {
	List<CabBo> getCabsByCriteria(CabCriteriaBo criteria);
	CabBo getCab(int cabId);
	List<Integer> getAllCabIds();
}
