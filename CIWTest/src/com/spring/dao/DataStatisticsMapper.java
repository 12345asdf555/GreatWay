package com.spring.dao;


import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.WeldDto;
import com.spring.model.DataStatistics;

import tk.mybatis.mapper.common.Mapper;

public interface DataStatisticsMapper  extends Mapper<DataStatistics>{
	List<DataStatistics> getItemMachineCount();

	int getStartingUpMachineNum(@Param("itemid") BigInteger itemid,@Param("dto") WeldDto dto);
	
	DataStatistics getWorkNum(@Param("itemid") BigInteger itemid,@Param("dto") WeldDto dto);
	
	BigInteger  getStaringUpTime(@Param("itemid") BigInteger itemid,@Param("dto") WeldDto dto);
	
	DataStatistics getParameter();
	
	BigInteger getStandytime(@Param("itemid") BigInteger itemid,@Param("dto") WeldDto dto);
	
	DataStatistics getWorkTimeAndEleVol(@Param("itemid") BigInteger itemid,@Param("dto") WeldDto dto);
	
	List<DataStatistics> getAllMachine(@Param("item") BigInteger item);
	
	List<DataStatistics> getAllWelder();
	
	List<DataStatistics> getAllJunction(@Param("junctionno") String junctionno);
	
	List<DataStatistics> getAllInsframe();
}
