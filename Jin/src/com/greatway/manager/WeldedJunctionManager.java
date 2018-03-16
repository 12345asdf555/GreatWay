package com.greatway.manager;

import java.math.BigInteger;
import java.util.List;

import com.greatway.model.WeldedJunction;
import com.greatway.page.Page;

public interface WeldedJunctionManager {
	
	/**
	 * 查询所有焊口
	 */
	List<WeldedJunction> getWeldedJunctionAll(Page page, String str);

	List<WeldedJunction> getWeldingJun(Page page, String str, BigInteger welderid);
}
