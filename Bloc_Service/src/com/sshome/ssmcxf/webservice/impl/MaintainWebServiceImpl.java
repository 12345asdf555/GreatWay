package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.MaintenanceRecord;
import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;
import com.spring.service.MaintainService;
import com.sshome.ssmcxf.webservice.MaintainWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class MaintainWebServiceImpl implements MaintainWebService {
	@Autowired
	private MaintainService ms;
	
	@Override
	public Object getWeldingMaintenanceAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getWeldingMaintenanceAll(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEndtime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getEndtime(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMaintenanceById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance list = ms.getWeldingMaintenanceById(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEquipmentno() {
		try{
			List<WeldingMachine> list = ms.getEquipmentno();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger addMaintian(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance wm = new WeldingMaintenance();
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setId(new BigInteger(json.getString("RID")));
			mr.setEndTime(json.getString("ENDTIME"));
			wm.setMaintenance(mr);
			wm.setCreator(json.getString("CREATOR"));
			WeldingMachine w = new WeldingMachine();
			BigInteger wid = new BigInteger(json.getString("WELDID"));
			w.setId(wid);
			wm.setWelding(w);
			if(ms.addMaintian(wm,mr,wid)){
				return wm.getId();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public BigInteger addMaintenanceRecord(String object){
		try{
			JSONObject json = JSONObject.fromObject(object);
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setViceman(json.getString("VICEMAN"));
			mr.setStartTime(json.getString("STARTTIME"));
			String endTime = json.getString("ENDTIME");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("ENDTIME"));
			}
			mr.setDesc(json.getString("DESC"));
			mr.setTypeId(json.getInt("TYPEID"));
			mr.setCreator(json.getString("CREATOR"));
			if(ms.addMaintenanceRecord(mr)){
				return mr.getId();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public boolean updateEndtime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.updateEndtime(new BigInteger(json.getString("MID")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateMaintenanceRecord(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setId(new BigInteger(json.getString("MID")));
			mr.setViceman(json.getString("VICEMAN"));
			mr.setStartTime(json.getString("STARTTIME"));
			String endTime = json.getString("ENDTIME");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("ENDTIME"));
			}
			mr.setDesc(json.getString("DESC"));
			mr.setTypeId(json.getInt("TYPEID"));
			mr.setModifier(json.getString("MODIFIER"));
			boolean flag = ms.updateMaintenanceRecord(mr);
			BigInteger wid = new BigInteger(json.getString("WID"));
			List<WeldingMaintenance> list =  ms.getEndtime(wid);
			if(endTime==null || "".equals(endTime)){
				//修改焊机状态为维修中
				ms.editstatus(wid, 33);
			}
			if(list!=null){
				//如果维修结束时间没有为空的则修改状态为启用
				ms.editstatus(wid, 31);
			}
			return flag;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteMaintenanceRecord(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance wm = ms.getWeldingMaintenanceById(new BigInteger(json.getString("MID")));
			boolean flag = ms.deleteMaintenanceRecord(wm.getMaintenance().getId());
			boolean flags = ms.deleteWeldingMaintenance(wm.getId());
			if(flag && flags){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteWeldingMaintenance(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.deleteWeldingMaintenance(new BigInteger(json.getString("WID")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object getMaintainByWeldingMachinId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getMaintainByWeldingMachinId(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean editstatus(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.editstatus(new BigInteger(json.getString("WID")), json.getInt("STATUSID"));
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public BigInteger getInsfidByMachineid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.getInsfidByMachineid(new BigInteger(json.getString("WID")));
		}catch(Exception e){
			return null;
		}
	}
}
