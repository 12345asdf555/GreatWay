package com.greatway.manager.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.DictionaryMapper;
import com.greatway.dao.EquipmentManufacturerMapper;
import com.greatway.dao.InsframeworkMapper;
import com.greatway.dao.WeldingMachineMapper;
import com.greatway.manager.WeldingMachineManager;
import com.greatway.model.Dictionarys;
import com.greatway.model.EquipmentManufacturer;
import com.greatway.model.WeldingMachine;
import com.greatway.page.Page;

@Service
@Transactional
public class WeldingMachineManagerImpl implements WeldingMachineManager {
	
	@Autowired
	private WeldingMachineMapper wmm;
	@Autowired
	private EquipmentManufacturerMapper em;
	@Autowired
	private InsframeworkMapper im;
	
	@Override
	public List<WeldingMachine> getWeldingMachineAll(Page page,String str) {
		PageHelper.startPage(page.getPageIndex(),page.getPageSize());
		return wmm.getWeldingMachineAll(str);
	}

	@Override
	public void addWeldingMachine(WeldingMachine wm) {
		wmm.addWeldingMachine(wm);
	}

	@Override
	public void editWeldingMachine(WeldingMachine wm) {
		wmm.editWeldingMachine(wm);
	}

	@Override
	public List<WeldingMachine> getWeldingMachine(String str) {
		return wmm.getWeldingMachineAll(str);
	}

	@Override
	public BigInteger getWeldingMachineByEno(String eno) {
		return wmm.getWeldingMachineByEno(eno);
	}

	@Override
	public List<EquipmentManufacturer> getManuAll() {
		return em.getmanuAll();
	}

	@Override
	public int getEquipmentnoCount(String eno) {
		return wmm.getEquipmentnoCount(eno);
	}

	@Override
	public int getGatheridCount(BigInteger gatherid) {
		return wmm.getGatheridCount(gatherid);
	}

	@Override
	public BigInteger getManuidByValue(String value) {
		return em.getManuidByValue(value);
	}

	@Override
	public WeldingMachine getWeldingMachineById(BigInteger wid) {
		return wmm.getWeldingMachineById(wid);
	}

	@Override
	public void deleteWeldingChine(BigInteger wid) {
		wmm.deleteWeldingMachine(wid);
	}

	@Override
	public BigInteger getInsframeworkByName(String name) {
		return im.getInsframeworkByName(name);
	}

	@Override
	public BigInteger getMachineCountByManu(BigInteger mid) {
		return wmm.getMachineCountByManu(mid);
	}

}
