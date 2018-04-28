package com.spring.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ChartMapper;
import com.spring.dto.ModelDto;
import com.spring.service.ChartService;

@Service
@Transactional
public class ChartServiceImpl implements ChartService {
	
	@Autowired
	private ChartMapper cm;

	@Override
	public List<ModelDto> getEfficiency(String time) {
		return cm.getEfficiency(time);
	}

	@Override
	public BigInteger getDyneByJunctionno(String str) {
		return cm.getDyneByJunctionno(str);
	}

	@Override
	public List<ModelDto> getHour(String time, String str) {
		return cm.getHour(time, str);
	}

	@Override
	public List<ModelDto> getHourClassify(String str) {
		return cm.getHourClassify(str);
	}

}
