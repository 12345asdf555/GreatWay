package com.spring.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.LiveDataMapper;
import com.spring.dao.WeldedJunctionMapper;
import com.spring.dto.ModelDto;
import com.spring.dto.WeldDto;
import com.spring.model.LiveData;
import com.spring.model.WeldedJunction;
import com.spring.service.LiveDataService;

@Service
@Transactional
public class LiveDataServiceImpl implements LiveDataService {
	@Autowired
	HttpServletRequest request ;
	
	@Autowired
	private LiveDataMapper live;
	@Autowired
	private WeldedJunctionMapper wm;
	
	@Override
	public List<ModelDto> getCausehour(WeldDto dto, BigInteger parent) {
		return live.getCausehour(dto,parent);
	}

	@Override
	public List<ModelDto> getCompanyhour(WeldDto dto, BigInteger parent) {
		return live.getCompanyhour(dto, parent);
	}

	@Override
	public List<ModelDto> getItemhour(WeldDto dto) {
		return live.getItemhour(dto);
	}

	@Override
	public List<ModelDto> getJunctionHous(WeldDto dto) {
		return live.getJunctionHous(dto);
	}

	@Override
	public List<ModelDto> getCauseOverproof(WeldDto dto, BigInteger parent) {
		return live.getCauseOverproof(dto, parent);
	}

	@Override
	public List<LiveData> getAllInsf(BigInteger parent,int type) {
		return live.getAllInsf(parent,type);
	}

	@Override
	public List<LiveData> getAllTime(WeldDto dto) {
		return live.getAllTime(dto);
	}

	@Override
	public List<ModelDto> getCompanyOverproof(WeldDto dto,BigInteger parent) {
		return live.getCompanyOverproof(dto,parent);
	}

	@Override
	public List<ModelDto> getDatailOverproof(WeldDto dto,BigInteger parent) {
		return live.getDatailOverproof(dto,parent);
	}

	@Override
	public int getCountTime(String welderno, String machineno, String junctionno, String time,BigInteger id) {
		return live.getCountTime(welderno, machineno, junctionno, time, id);
	}

	@Override
	public List<ModelDto> getjunctionoverproof(String welderno, String machineno, String junctionno,
			String time, BigInteger itemid) {
		return live.getjunctionoverproof(welderno, machineno, junctionno, time, itemid);
	}

	@Override
	public List<ModelDto> getcompanyOvertime(WeldDto dto, String num,BigInteger parent) {
		return live.getcompanyOvertime(dto, num,parent);
	}

	@Override
	public List<ModelDto> getCaustOvertime(WeldDto dto, String num, BigInteger parent) {
		return live.getCaustOvertime(dto, num, parent);
	}

	@Override
	public List<ModelDto> getItemOvertime(WeldDto dto, String num) {
		return live.getItemOvertime(dto, num);
	}

	@Override
	public List<LiveData> getJunction(BigInteger parent) {
		return live.getJunction(parent);
	}

	@Override
	public List<ModelDto> getDetailovertime(WeldDto dto, String num, String junctionno) {
		return live.getDetailovertime(dto, num,junctionno);
	}

	@Override
	public List<ModelDto> getCompanyLoads(WeldDto dto,BigInteger parent) {
		return live.getCompanyLoads(dto,parent);
	}

	@Override
	public List<ModelDto> getCaustLoads(WeldDto dto, BigInteger parent) {
		return live.getCaustLoads(dto, parent);
	}

	@Override
	public List<ModelDto> getItemLoads(WeldDto dto, BigInteger parent) {
		return live.getItemLoads(dto, parent);
	}

	@Override
	public List<LiveData> getMachine(BigInteger parent) {
		return live.getMachine(parent);
	}

	@Override
	public List<ModelDto> getDetailLoads(WeldDto dto, String machineno) {
		return live.getDetailLoads(dto, machineno);
	}

	@Override
	public List<ModelDto> getCompanyNoLoads(WeldDto dto,BigInteger parent) {
		return live.getCompanyNoLoads(dto,parent);
	}

	@Override
	public List<ModelDto> getCaustNOLoads(WeldDto dto, BigInteger parent) {
		return live.getCaustNoLoads(dto, parent);
	}

	@Override
	public List<ModelDto> getItemNOLoads(WeldDto dto, BigInteger parent,String equipmentno) {
		return live.getItemNOLoads(dto, parent,equipmentno);
	}

	@Override
	public List<ModelDto> getCompanyIdle(WeldDto dto,BigInteger parent) {
		return live.getCompanyIdle(dto,parent);
	}

	@Override
	public List<ModelDto> getCaustIdle(WeldDto dto, BigInteger parent) {
		return live.getCaustIdle(dto, parent);
	}

	@Override
	public List<ModelDto> getItemIdle(WeldDto dto, BigInteger itemid) {
		return live.getItemidle(dto, itemid);
	}

	@Override
	public int getMachineCount(BigInteger id) {
		return live.getMachineCount(id);
	}

	@Override
	public List<ModelDto> getCompanyUse( WeldDto dto, BigInteger parent) {
		return live.getCompanyUse(dto, parent);
	}

	@Override
	public List<ModelDto> getCaustUse( WeldDto dto, BigInteger insid) {
		return live.getCaustUse(dto, insid);
	}

	@Override
	public List<LiveData> getAllTimes(WeldDto dto) {
		return live.getAllTime(dto);
	}

	@Override
	public List<ModelDto> getBlochour( WeldDto dto) {
		return live.getBlochour(dto);
	}

	@Override
	public List<ModelDto> getBlocOverproof(WeldDto dto) {
		return live.getBlocOverproof(dto);
	}

	@Override
	public List<ModelDto> getBlocOvertime(WeldDto dto, String num) {
		return live.getBlocOvertime(dto, num);
	}

	@Override
	public List<ModelDto> getBlocLoads(WeldDto dto) {
		return live.getBlocLoads(dto);
	}

	@Override
	public List<ModelDto> getBlocNoLoads(WeldDto dto) {
		return live.getBlocNoLoads(dto);
	}

	@Override
	public List<ModelDto> getBlocIdle(WeldDto dto) {
		return live.getBlocIdle(dto);
	}

	@Override
	public List<ModelDto> getBlocUse(WeldDto dto, BigInteger parent) {
		return live.getBlocUse(dto, parent);
	}

	@Override
	public List<LiveData> getBlocChildren() {
		return live.getBlocChildren();
	}

	@Override
	public List<ModelDto> caustEfficiency(BigInteger parent, WeldDto dto) {
		return live.caustEfficiency(dto, parent);
	}

	@Override
	public List<ModelDto> companyEfficiency(BigInteger parent, WeldDto dto) {
		return live.companyEfficiency(dto,parent);
	}

	@Override
	public List<ModelDto> blocEfficiency(WeldDto dto,BigInteger parent) {
		return live.blocEfficiency(dto,parent);
	}

	@Override
	public List<ModelDto> getEfficiencyChartNum(WeldDto dto, BigInteger parent) {
		return live.getEfficiencyChartNum(dto, parent);
	}

	@Override
	public List<ModelDto> getEfficiencyChart(WeldDto dto, BigInteger parent, int minnum, int avgnum) {
		return live.getEfficiencyChart(dto, parent, minnum, avgnum);
	}

	@Override
	public WeldedJunction getWeldedJunctionById(BigInteger id) {
		return wm.getWeldedJunctionById(id);
	}

	@Override
	public List<ModelDto> getHousClassify( BigInteger parent, String searchStr) {
		return live.getHousClassify(parent,searchStr);
	}

	@Override
	public List<ModelDto> getDetailNoLoads(WeldDto dto) {
		return live.getDetailNoLoads(dto);
	}

	@Override
	public List<ModelDto> getItemOverproof(WeldDto dto, BigInteger id) {
		return live.getItemOverproof(dto, id);
	}

	@Override
	public List<ModelDto> getItemUse( WeldDto dto, BigInteger insid) {
		return live.getItemUse(dto, insid);
	}
}
