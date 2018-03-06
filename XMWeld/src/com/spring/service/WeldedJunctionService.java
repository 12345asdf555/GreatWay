package com.spring.service;

import java.util.List;

import com.spring.model.WeldedJunction;
import com.spring.page.Page;

public interface WeldedJunctionService {
	
	/**
	 * 查询所有焊口
	 */
	List<WeldedJunction> getWeldedJunctionAll(Page page, String str);
}
