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
	public DataStatistics getWorkNum(BigInteger itemid, WeldDto dto) {
		return ds.getWorkNum(itemid, dto);
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

}
