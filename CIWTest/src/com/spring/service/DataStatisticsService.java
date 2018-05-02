package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import com.spring.dto.WeldDto;
import com.spring.model.DataStatistics;
import com.spring.page.Page;

public interface DataStatisticsService {
	/**
	 * 获取项目部焊机总数
	 * @param page 分页
	 * @param parent 组织机构父id
	 * @return
	 */
	List<DataStatistics> getItemMachineCount(Page page);
	
	/**
	 * 获取开机焊机总数
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	int getStartingUpMachineNum(BigInteger itemid,WeldDto dto);
	
	/**
	 * 获取参数
	 * @return
	 */
	DataStatistics getParameter();
	
	/**
	 * 获取工作的焊机数，焊口数以及焊接时长
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	DataStatistics getWorkNum(BigInteger itemid,WeldDto dto);
	
	/**
	 * 获取开机总时长
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	BigInteger getStaringUpTime(BigInteger itemid,WeldDto dto);
	
	/**
	 * 获取待机总时长
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	BigInteger getStandytime(BigInteger itemid,WeldDto dto);
	
	/**
	 * 获取焊接时长，平均电流电压
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	DataStatistics getWorkTimeAndEleVol(BigInteger itemid,WeldDto dto);
}
