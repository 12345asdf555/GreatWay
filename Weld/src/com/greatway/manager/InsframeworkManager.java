package com.greatway.manager;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.Insframework;
import com.greatway.page.Page;

public interface InsframeworkManager {
	/**
	 * 获取组织机构:分页
	 * @param str
	 * @return
	 */
	List<Insframework> getInsframeworkAll(Page page, String str);
	
	/**
	 * 获取组织机构
	 * @param str
	 * @return
	 */
	List<Insframework> getInsframework(String str);
	
	/**
	 * 新增组织机构
	 * @param ins
	 */
	void addInsframework(Insframework ins);
	/**
	 * 修改组织机构
	 * @param ins
	 */
	void editInsframework(Insframework ins);
	
	/**
	 * 删除组织机构
	 * @param id
	 */
	void deleteInsframework(BigInteger id);
	
	/**
	 * 判断name是否存在
	 * @param name 项目名称
	 * @return
	 */
	int getInsframeworkNameCount(String name);
	
	/**
	 * 根据id查找name
	 * @param id 项目id
	 * @return
	 */
	String getInsframeworkById(BigInteger id);
	
	/**
	 * 根据id查找所有
	 * @param id 组织机构id
	 * @return
	 */
	Insframework getInsfAllById(BigInteger id);
	
	/**
	 * 查看公司级
	 * @return
	 */
	List<Insframework> getConmpany();
	
	/**
	 * 查看公司级子级
	 * @return
	 */
	List<Insframework> getCause(BigInteger id);
	
	/**
	 * 焊机获取项目
	 * @return
	 */
	List<Insframework> getWeldingMachineInsf();
	
	/**
	 * 获取父级
	 * @param id 子级编号
	 * @return
	 */
	Insframework getParent(BigInteger id);
	
	/**
	 * 显示所有上级名称
	 * @param temp上级id
	 * @return
	 */
	void showParent(HttpServletRequest request,String parentid);
	
	/**
	 * 获取某层级的单位名称
	 * @param type单位类型
	 * @return
	 */
	List<Insframework> getInsByType(int type,BigInteger parent);
	
	/**
	 * 获取用户所属层级
	 * @param uid 用户id
	 * @return
	 */
	int getUserInsfType(BigInteger uid);
	
	/**
	 * 获取用户所属部门id
	 * @param uid 用户id
	 * @return
	 */
	BigInteger getUserInsfId(BigInteger uid);
	
	
}
