package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.dto.WeldDto;
import com.spring.model.EquipmentManufacturer;
import com.spring.model.Page;
import com.spring.model.WeldingMachine;

@WebService
public interface WeldingMachineWebService {

	/**
	 * 查询所有焊机信息
	 */
	List<WeldingMachine> getWeldingMachineAll(@WebParam(name="object")String object);
	
	/**
	 * 查询所有焊机信息
	 */
	List<WeldingMachine> getWeldingMachine(@WebParam(name="object")String object);
	
	/**
	 * 查询所有厂商信息
	 */
	List<EquipmentManufacturer> getManuAll();
	
	/**
	 * 新增设备
	 */
	boolean addWeldingMachine(@WebParam(name="object")String object);
	
	/**
	 * 修改设备
	 */
	boolean editWeldingMachine(@WebParam(name="object")String object);
	
	/**
	 * 删除设备
	 */
	boolean deleteWeldingChine(@WebParam(name="object")String object);
	
	/**
	 * 根据焊机编号查找id
	 */
	BigInteger getWeldingMachineByEno(@WebParam(name="object")String object);
	
	/**
	 * 判断焊机编号是否存在
	 */
	int getEquipmentnoCount(@WebParam(name="object")String object);
	
	/**
	 * 判断采集序号是否存在
	 */
	int getGatheridCount(@WebParam(name="object")String object);
	
	/**
	 * 根据厂商值和类型查找厂商id
	 */
	BigInteger getManuidByValue(@WebParam(name="object")String object);
	
	/**
	 * 根据id查找记录
	 */
	WeldingMachine getWeldingMachineById(@WebParam(name="object")String object);
	
	/**
	 * 根据项目名称获取项目id
	 */
	BigInteger getInsframeworkByName(String object);
	
	/**
	 * 获取某厂商下的焊机总数
	 */
	BigInteger getMachineCountByManu(@WebParam(name="object")String object);
}
