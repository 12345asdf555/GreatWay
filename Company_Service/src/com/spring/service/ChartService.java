package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import com.spring.dto.ModelDto;

public interface ChartService {
	List<ModelDto> getEfficiency(String time);
	
	BigInteger getDyneByJunctionno(String str);
	
	List<ModelDto> getHour(String time,String  str);
	
	List<ModelDto> getHourClassify(String str);
}
