package com.spring.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.spring.dao.DataStatisticsMapper;
import com.spring.dto.WeldDto;
import com.spring.model.DataStatistics;
import com.spring.page.Page;
import com.spring.service.DataStatisticsService;

@Service
@Transactional
public class DataStatisticsServiceImpl implements DataStatisticsService {
	@Autowired
	private DataStatisticsMapper ds;
	
	@Override
	public List<DataStatistics> getItemMachineCount(Page page) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getItemMachineCount();
	}

	@Override
	public int getStartingUpMachineNum(BigInteger itemid, WeldDto dto) {
		return ds.getStartingUpMachineNum(itemid, dto);
	}

	@Override
	public DataStatistics getParameter() {
		return ds.getParameter();
	}

	@Override
	public DataStatistics getWorkMachineNum(BigInteger itemid, WeldDto dto) {
		return ds.getWorkMachineNum(itemid, dto);
	}

	@Override
	public DataStatistics getWorkJunctionNum(BigInteger itemid, WeldDto dto) {
		return ds.getWorkJunctionNum(itemid, dto);
	}

	@Override
	public BigInteger getStaringUpTime(BigInteger itemid, WeldDto dto) {
		return ds.getStaringUpTime(itemid, dto); 
	}

	@Override
	public BigInteger getStandytime(BigInteger itemid, WeldDto dto) {
		return ds.getStandytime(itemid, dto);
	}

	@Override
	public DataStatistics getWorkTimeAndEleVol(BigInteger itemid, WeldDto dto) {
		return ds.getWorkTimeAndEleVol(itemid, dto);
	}

	@Override
	public List<DataStatistics> getAllMachine(Page page,BigInteger itemid) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getAllMachine(itemid);
	}

	@Override
	public List<DataStatistics> getAllWelder(Page page) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getAllWelder();
	}

	@Override
	public List<DataStatistics> getAllJunction(Page page, String junctionno) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getAllJunction(junctionno);
	}

	@Override
	public List<DataStatistics> getAllInsframe() {
		return ds.getAllInsframe();
	}

	@Override
	public List<DataStatistics> getWeldItemInCount(Page page, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldItemInCount(dto);
	}

	@Override
	public List<DataStatistics> getWeldItemOutCount(Page page, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldItemOutCount(dto);
	}

	@Override
	public List<DataStatistics> getWeldMachineInCount(Page page, WeldDto dto ,BigInteger itemid) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldMachineInCount(dto,itemid);
	}

	@Override
	public List<DataStatistics> getWeldMachineOutCount(Page page, WeldDto dto ,BigInteger itemid) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldMachineOutCount(dto,itemid);
	}

	@Override
	public List<DataStatistics> getWeldPersonInCount(Page page, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldPersonInCount(dto);
	}

	@Override
	public List<DataStatistics> getWeldPersonOutCount(Page page, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldPersonOutCount(dto);
	}

	@Override
	public List<DataStatistics> getWeldPieceInCount(Page page, WeldDto dto,String junctionno) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldPieceInCount(dto,junctionno);
	}

	@Override
	public List<DataStatistics> getWeldPieceOutCount(Page page, WeldDto dto,String junctionno) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getWeldPieceOutCount(dto,junctionno);
	}

	@Override
	public List<DataStatistics> getFauit(Page page, WeldDto dto, int value) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getFauit(dto, value);
	}

	@Override
	public List<DataStatistics> getFauitDetail(Page page, WeldDto dto, BigInteger id, int value) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return ds.getFauitDetail(dto, id, value);
	}

}
