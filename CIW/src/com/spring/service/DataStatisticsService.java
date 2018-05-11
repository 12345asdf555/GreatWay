package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * 获取工作的焊机数
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	DataStatistics getWorkMachineNum(BigInteger itemid,WeldDto dto);

	/**
	 * 获取工作的焊口数
	 * @param itemid  项目部id
	 * @param dto 扩展参数类
	 * @return
	 */
	DataStatistics getWorkJunctionNum(BigInteger itemid,WeldDto dto);
	
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
	
	/**
	 * 获取所有的焊机id，编号以及组织机构id，名称
	 * @param page 分页
	 * @param itemid 组织机构id
	 * @return
	 */
	List<DataStatistics> getAllMachine(Page page,BigInteger itemid);
	
	/**
	 * 获取所有的焊工编号，姓名
	 * @param page
	 * @return
	 */
	List<DataStatistics> getAllWelder(Page page);
	
	/**
	 * 获取所有悍缝编号及组织机构id，name
	 * @param page 分页
	 * @param junctionno 焊缝编号
	 * @return
	 */
	List<DataStatistics> getAllJunction(Page page,String junctionno);
	
	/**
	 * 获取所有项目部组织机构
	 * @return
	 */
	List<DataStatistics> getAllInsframe();

	/**
	 * 获取组织机构正常焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldItemInCount(Page page, WeldDto dto);
	
	/**
	 * 获取组织机构超规范焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldItemOutCount(Page page, WeldDto dto);
	
	/**
	 * 获取焊机正常焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldMachineInCount(Page page, WeldDto dto ,BigInteger itemid);
	
	/**
	 * 获取焊机超规范焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldMachineOutCount(Page page, WeldDto dto ,BigInteger itemid);
	
	/**
	 * 获取焊工正常焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldPersonInCount(Page page, WeldDto dto);
	
	/**
	 * 获取焊工超规范焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldPersonOutCount(Page page, WeldDto dto);
	
	/**
	 * 获取工件正常焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldPieceInCount(Page page, WeldDto dto,String junctionno);
	
	/**
	 * 获取工件超规范焊接时间
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @return
	 */
	List<DataStatistics> getWeldPieceOutCount(Page page, WeldDto dto,String junctionno);
	
	/**
	 * 获取焊机故障
	 * @param page 分页
	 * @param dto 扩展参数类
	 * @param value 故障类型id
	 * @return
	 */
	List<DataStatistics> getFauit(Page page,WeldDto dto,int value);
	
	/**
	 * 获取焊机故障明细
	 * @param page 分页
	 * @param dto 扩展dto类
	 * @param id 焊机id
	 * @param value 故障类型id
	 * @return
	 */
	List<DataStatistics> getFauitDetail(Page page,WeldDto dto,BigInteger id,int value);
}
