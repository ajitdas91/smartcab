package com.smartcab.service;

import java.util.ArrayList;
import java.util.List;

import com.smartcab.bo.CabBo;
import com.smartcab.bo.CabCriteriaBo;
import com.smartcab.command.FindCabCommand;
import com.smartcab.dao.CabDao;
import com.smartcab.dto.CabDto;

public class CabServiceImpl implements CabService {
	private CabDao cabDao;

	@Override
	public List<CabDto> search(FindCabCommand command, String status) {
		List<CabBo> cabBos = null;
		List<CabDto> cabDtos = null;
		CabCriteriaBo criteria = null;

		criteria = new CabCriteriaBo(command.getSource(),
				command.getCapacity(), status);
		cabBos = cabDao.getCabsByCriteria(criteria);

		if (cabBos != null && cabBos.size() > 0) {
			cabDtos = new ArrayList<CabDto>();
			for (CabBo bo : cabBos) {
				cabDtos.add(new CabDto(bo.getCabId(), bo.getDriverName(), bo
						.getMobile(), bo.getArea()));
			}
		}
		return cabDtos;
	}

	@Override
	public CabDto getCab(int cabId) {
		CabDto dto = null;
		CabBo bo = null;

		bo = cabDao.getCab(cabId);
		if (bo != null) {
			dto = new CabDto(bo.getCabId(), bo.getDriverName(), bo.getMobile(),
					bo.getArea());
		}
		return dto;
	}

	public List<Integer> getAllCabIds() {
		return cabDao.getAllCabIds();
	}
	
	public void setCabDao(CabDao cabDao) {
		this.cabDao = cabDao;
	}

}
