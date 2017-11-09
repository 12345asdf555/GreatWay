package com.greatway.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.WeldedJunctionMapper;
import com.greatway.manager.WeldedJunctionManager;
import com.greatway.model.WeldedJunction;
import com.greatway.page.Page;

@Service
@Transactional
public class WeldedJunctionManagerImpl implements WeldedJunctionManager{
	@Autowired
	private WeldedJunctionMapper wjm;

	@Override
	public List<WeldedJunction> getWeldedJunctionAll(Page page, String str) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		return wjm.getWeldedJunctionAll(str);
	}

}
