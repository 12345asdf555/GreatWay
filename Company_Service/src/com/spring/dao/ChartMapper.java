package com.spring.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.ModelDto;

import tk.mybatis.mapper.common.Mapper;

public interface ChartMapper extends Mapper<ModelDto>{
	List<ModelDto> getEfficiency(@Param("time") String time);
	
	BigInteger getDyneByJunctionno(@Param("str") String str);
	
	List<ModelDto> getHour(@Param("time") String time,@Param("str") String str);
	
	List<ModelDto> getHourClassify(@Param("str") String str);
}
