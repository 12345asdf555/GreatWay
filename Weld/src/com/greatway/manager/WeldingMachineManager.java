package com.greatway.manager;

import java.math.BigInteger;
import java.util.List;

import com.greatway.dto.WeldDto;
import com.greatway.model.EquipmentManufacturer;
import com.greatway.model.WeldingMachine;
import com.greatway.page.Page;

public interface WeldingMachineManager {
	
	/**
	 * 查询所有焊机信息:分页
	 */
	List<WeldingMachine> getWeldingMachineAll(Page page,BigInteger parent,String str);
	
	/**
	 * 查询所有焊机信息
	 */
	List<WeldingMachine> getWeldingMachine(String str);
	
	/**
	 * 查询所有厂商信息
	 * @return
	 */
	List<EquipmentManufacturer> getManuAll();
	
	/**
	 * 新增设备
	 */
	void addWeldingMachine(WeldingMachine wm);
	
	/**
	 * 修改设备
	 */
	void editWeldingMachine(WeldingMachine wm);
	
	/**
	 * 删除设备
	 * @param wid
	 */
	void deleteWeldingChine(BigInteger wid);
	
	/**
	 * 根据焊机编号查找id
	 * @return
	 */
	BigInteger getWeldingMachineByEno(String eno);
	
	/**
	 * 判断焊机编号是否存在
	 * @param eno
	 * @return
	 */
	int getEquipmentnoCount(String eno);
	
	/**
	 * 判断采集序号是否存在
	 * @param gatherid
	 * @return
	 */
	int getGatheridCount(BigInteger gatherid);
	
	/**
	 * 根据厂商值查找厂商id
	 * @param value
	 * @return
	 */
	BigInteger getManuidByValue(String value);
	
	/**
	 * 根据id查找记录
	 * @param wid
	 * @return
	 */
	WeldingMachine getWeldingMachineById(BigInteger wid);
	
	/**
	 * 根据项目名称获取项目id
	 * @param name
	 * @return
	 */
	BigInteger getInsframeworkByName(String name);
	
	/**
	 * 获取某厂商下的焊机总数
	 * @param mid 厂商id
	 * @return
	 */
	BigInteger getMachineCountByManu(BigInteger mid,WeldDto dto,BigInteger id);
}
