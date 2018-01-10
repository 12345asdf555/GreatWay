package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;

@WebService
public interface MaintainWebService {

	
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
