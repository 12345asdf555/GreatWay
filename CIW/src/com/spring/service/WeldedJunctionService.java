package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import com.spring.model.WeldedJunction;
import com.spring.page.Page;

public interface WeldedJunctionService {
	
	/**
	 * 查询所有焊口
	 */
	List<WeldedJunction> getWeldedJunctionAll(Page page, String str);
	
	/**
	 * 根据id查询
	 * @param id 焊缝id
	 * @return
	 */
	WeldedJunction getWeldedJunctionById(BigInteger id);
	
	/**
	 * 判断焊缝编号是否存在
	 * @param wjno 悍缝编号
	 * @return 受影响的行数
	 */
	int getWeldedjunctionByNo(String wjno);
	
	/**
	 * 新增焊缝
	 * @param wj
	 */
	boolean addJunction(WeldedJunction wj);

	/**
	 * 修改焊缝
	 * @param wj
	 */
	boolean updateJunction(WeldedJunction wj);

	/**
	 * 删除焊缝
	 * @param wj
	 */
	boolean deleteJunction(BigInteger id);
	/**
	 * 查询焊工对应的焊缝
	 * @param page
	 * @param str
	 * @param welderid
	 * @return
	 */
	List<WeldedJunction> getWeldingJun(Page page, String str, BigInteger welderid);
}
