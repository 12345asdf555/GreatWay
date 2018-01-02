package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.EquipmentManufacturer;
import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;

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
	
	/**
	 * 获取所有维修记录
	 * @return
	 */
	List<WeldingMaintenance> getWeldingMaintenanceAll(@WebParam(name="object")String object);

	/**
	 * 获取维修结束时间
	 * @param wid
	 * @return
	 */
	List<WeldingMaintenance> getEndtime(@WebParam(name="object")String object);
	
	/**
	 * 根据id查询所有信息
	 * @param wid
	 * @return
	 */
	WeldingMaintenance getWeldingMaintenanceById(@WebParam(name="object")String object);
	
	/**
	 * 获取设备编码
	 * @return
	 */
	List<WeldingMachine> getEquipmentno();
	
	/**
	 * 新增维修记录
	 * @param wm
	 */
	boolean addMaintian(@WebParam(name="object")String object);
	
	/**
	 * 修改结束时间为当前时间
	 * @param wid
	 */
	boolean updateEndtime(@WebParam(name="object")String object);
	
	/**
	 * 修改
	 * @param mr
	 */
	boolean updateMaintenanceRecord(@WebParam(name="object")String object);
	
	/**
	 * 删除维修记录
	 * @param mid
	 */
	boolean deleteMaintenanceRecord(@WebParam(name="object")String object);
	
	/**
	 * 删除焊机维修记录
	 * @param wid
	 */
	boolean deleteWeldingMaintenance(@WebParam(name="object")String object);
	
	/**
	 * 根据焊机id查找维修记录id
	 * @param wid
	 * @return
	 */
	List<WeldingMaintenance> getMaintainByWeldingMachinId(@WebParam(name="object")String object);
	
	/**
	 * 修改焊机维修状态
	 * @param wid
	 * @param status
	 */
	boolean editstatus(@WebParam(name="object")String object);
}
