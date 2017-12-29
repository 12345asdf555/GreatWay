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
	List<WeldingMachine> getWeldingMachineAll(@WebParam(name="parent")BigInteger parent,@WebParam(name="str")String str);
	
	/**
	 * 查询所有焊机信息
	 */
	List<WeldingMachine> getWeldingMachine(@WebParam(name="str")String str);
	
	/**
	 * 查询所有厂商信息
	 * @return
	 */
	List<EquipmentManufacturer> getManuAll();
	
	/**
	 * 新增设备
	 */
	boolean addWeldingMachine(@WebParam(name="wm")WeldingMachine wm);
	
	/**
	 * 修改设备
	 */
	boolean editWeldingMachine(@WebParam(name="wm")WeldingMachine wm);
	
	/**
	 * 删除设备
	 * @param wid
	 */
	boolean deleteWeldingChine(@WebParam(name="wid")BigInteger wid);
	
	/**
	 * 根据焊机编号查找id
	 * @return
	 */
	BigInteger getWeldingMachineByEno(@WebParam(name="eno")String eno);
	
	/**
	 * 判断焊机编号是否存在
	 * @param eno
	 * @return
	 */
	int getEquipmentnoCount(@WebParam(name="eno")String eno);
	
	/**
	 * 判断采集序号是否存在
	 * @param gatherid
	 * @return
	 */
	int getGatheridCount(@WebParam(name="itemid")BigInteger itemid,@WebParam(name="gather")String gather);
	
	/**
	 * 根据厂商值和类型查找厂商id
	 * @param value 厂商名字
	 * @param type 厂商类型
	 * @return
	 */
	BigInteger getManuidByValue(@WebParam(name="value")String value,@WebParam(name="type")String type);
	
	/**
	 * 根据id查找记录
	 * @param wid
	 * @return
	 */
	WeldingMachine getWeldingMachineById(@WebParam(name="wid")BigInteger wid);
	
	/**
	 * 根据项目名称获取项目id
	 * @param name
	 * @return
	 */
	BigInteger getInsframeworkByName(@WebParam(name="name")String name);
	
	/**
	 * 获取某厂商下的焊机总数
	 * @param mid 厂商id
	 * @return
	 */
	BigInteger getMachineCountByManu(@WebParam(name="mid")BigInteger mid,@WebParam(name="dto")WeldDto dto,@WebParam(name="id")BigInteger id);
}
