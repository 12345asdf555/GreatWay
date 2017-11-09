package com.greatway.manager.impl;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.LiveDataMapper;
import com.greatway.dto.ModelDto;
import com.greatway.dto.WeldDto;
import com.greatway.manager.LiveDataManager;
import com.greatway.model.LiveData;
import com.greatway.page.Page;
import com.spring.model.MyUser;

@Service
@Transactional
public class LiveDataManagerImpl implements LiveDataManager {
	@Autowired
	private LiveDataMapper live;
	
	@Override
	public List<LiveData> getCausehour(Page page,WeldDto dto, BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getCausehour(dto,parent);
	}

	@Override
	public List<LiveData> getCompanyhour(Page page,WeldDto dto, BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getCompanyhour(dto, parent);
	}

	@Override
	public List<LiveData> getItemhour(Page page,WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getItemhour(dto);
	}

	@Override
	public List<LiveData> getJunctionHous(Page page,WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
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
	public List<LiveData> getAllTime(Page page,WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getAllTime(dto);
	}

	@Override
	public List<ModelDto> getCompanyOverproof(WeldDto dto,BigInteger parent) {
		return live.getCompanyOverproof(dto,parent);
	}

	@Override
	public List<ModelDto> getDatailOverproof(Page page,WeldDto dto,BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getDatailOverproof(dto,parent);
	}

	@Override
	public int getCountTime(String welderno, String machineno, String junctionno, String time) {
		return live.getCountTime(welderno, machineno, junctionno, time);
	}

	@Override
	public List<ModelDto> getjunctionoverproof(String welderno, String machineno, String junctionno,
			String time) {
		return live.getjunctionoverproof(welderno, machineno, junctionno, time);
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
	public List<ModelDto> getItemOvertime(WeldDto dto, String num, BigInteger parent) {
		return live.getItemOvertime(dto, num, parent);
	}

	@Override
	public List<LiveData> getJunction(BigInteger parent) {
		return live.getJunction(parent);
	}

	@Override
	public List<ModelDto> getDetailovertime(Page page,WeldDto dto, String num, String junctionno) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
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
	public List<ModelDto> getDetailLoads(Page page,WeldDto dto, String machineno) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
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
	public List<ModelDto> getCompanyIdle(Page page,WeldDto dto,BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getCompanyIdle(dto,parent);
	}

	@Override
	public List<ModelDto> getCaustIdle(Page page,WeldDto dto, BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
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
	public List<ModelDto> getCompanyUse(Page page, WeldDto dto, BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getCompanyUse(dto, parent);
	}

	@Override
	public List<ModelDto> getCaustUse(Page page, WeldDto dto, BigInteger insid) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getCaustUse(dto, insid);
	}
	
	@Override
	public BigInteger getUserId(HttpServletRequest request){
		try{
			//获取用户id
			Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(obj==null){
				request.setAttribute("afreshLogin", "您的Session已过期，请重新登录！");
				return null;
			}
			MyUser myuser = (MyUser)obj;
			BigInteger uid = new BigInteger(myuser.getId()+"");
			return uid;
		}catch(Exception e){
			request.setAttribute("afreshLogin", "您的Session已过期，请重新登录！");
			return null;
		}
	}
	

	@Override
	public List<LiveData> getAllTimes(WeldDto dto) {
		return live.getAllTime(dto);
	}

	@Override
	public List<LiveData> getBlochour(Page page, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(),page.getPageSize());
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
	public List<ModelDto> getBlocIdle(Page page,WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(),page.getPageSize());
		return live.getBlocIdle(dto);
	}

	@Override
	public List<ModelDto> getBlocUse(Page page,WeldDto dto, BigInteger parent) {
		PageHelper.startPage(page.getPageIndex(),page.getPageSize());
		return live.getBlocUse(dto, parent);
	}

	@Override
	public List<LiveData> getBlocChildren() {
		return live.getBlocChildren();
	}

	@Override
	public List<ModelDto> getItemEfficiency(Page page, BigInteger parent, WeldDto dto) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return live.getItemEfficiency(dto, parent);
	}
}
