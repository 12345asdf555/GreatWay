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
	public boolean addMaintian(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance wm = new WeldingMaintenance();
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
			wm.setMaintenance(mr);
			wm.setCreator(json.getString("CREATOR"));
			WeldingMachine w = new WeldingMachine();
			BigInteger wid = new BigInteger(json.getString("WELDID"));
			w.setId(wid);
			wm.setWelding(w);
			return ms.addMaintian(wm,mr,wid);
		}catch(Exception e){
			return false;
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
			return ms.updateMaintenanceRecord(mr);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteMaintenanceRecord(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.deleteMaintenanceRecord(new BigInteger(json.getString("MID")));
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

}
