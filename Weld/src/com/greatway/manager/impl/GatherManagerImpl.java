package com.greatway.manager.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.GatherMapper;
import com.greatway.dao.WeldingMachineMapper;
import com.greatway.manager.GatherManager;
import com.greatway.model.Gather;
import com.greatway.page.Page;

@Service
@Transactional
public class GatherManagerImpl implements GatherManager {
	@Autowired
	private GatherMapper gm;
	
	@Autowired
	private WeldingMachineMapper wmm;
	
	@Override
	public List<Gather> getGatherPageAll(Page page, String str) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return gm.getGatherAll(str);
	}

	@Override
	public BigInteger getGatherByNo(String gatherno) {
		return gm.getGatherByNo(gatherno);
	}

	@Override
	public int getGatherNoCount(String gatherno) {
		return gm.getGatherNoCount(gatherno);
	}

	@Override
	public Gather getGatherById(BigInteger id) {
		return gm.getGatherById(id);
	}

	@Override
	public void addGather(Gather ins) {
		gm.addGather(ins);
	}

	@Override
	public void editGather(Gather ins) {
		gm.editGather(ins);
	}

	@Override
	public void deleteGather(BigInteger id) {
		//修改焊机采集序号为空
		BigInteger wid = wmm.getIdByGatherid(id);
		wmm.editGatherid(wid);
		gm.deleteGather(id);
	}

	@Override
	public List<Gather> getGatherAll(String str) {
		return gm.getGatherAll(str);
	}

}
