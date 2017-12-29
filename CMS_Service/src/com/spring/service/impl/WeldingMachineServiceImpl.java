package com.spring.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.WeldingMachineMapper;
import com.spring.dto.WeldDto;
import com.spring.model.EquipmentManufacturer;
import com.spring.model.Page;
import com.spring.model.WeldingMachine;
import com.spring.service.WeldingMachineService;

@Service
@Transactional
public class WeldingMachineServiceImpl implements WeldingMachineService {
	
	@Autowired
	private WeldingMachineMapper wmm;
//	@Autowired
//	private EquipmentManufacturerMapper em;
//	@Autowired
//	private InsframeworkMapper im;
	
	@Override
	public List<WeldingMachine> getWeldingMachineAll(BigInteger parent,String str) {
		try{
			return wmm.getWeldingMachineAll(parent,str);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void addWeldingMachine(WeldingMachine wm) {
		try{
		wmm.addWeldingMachine(wm);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void editWeldingMachine(WeldingMachine wm) {
		try{
			wmm.editWeldingMachine(wm);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<WeldingMachine> getWeldingMachine(String str) {
		try{
			return wmm.getWeldingMachineAll(null,str);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getWeldingMachineByEno(String eno) {
		try{
			return wmm.getWeldingMachineByEno(eno);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<EquipmentManufacturer> getManuAll() {
//		return em.getmanuAll();
		return null;
	}

	@Override
	public int getEquipmentnoCount(String eno) {
		try{
			return wmm.getEquipmentnoCount(eno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getGatheridCount(BigInteger itemid,String gather) {
		try{
			return wmm.getGatheridCount(itemid,gather);
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getManuidByValue(String value,String type) {
//		return em.getManuidByValue(value,type);
		return null;
	}

	@Override
	public WeldingMachine getWeldingMachineById(BigInteger wid) {
		try{
			return wmm.getWeldingMachineById(wid);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void deleteWeldingChine(BigInteger wid) {
		try{
			wmm.deleteWeldingMachine(wid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public BigInteger getInsframeworkByName(String name) {
//		return im.getInsframeworkByName(name);
		return null;
	}

	@Override
	public BigInteger getMachineCountByManu(BigInteger mid,WeldDto dto,BigInteger id) {
		try{
			return wmm.getMachineCountByManu(mid,dto,id);
		}catch(Exception e){
			return null;
		}
	}

}
