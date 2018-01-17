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
			List<WeldingMaintenance> list = ms.getWeldingMaintenanceAll(json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEndtime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getEndtime(new BigInteger(json.getString("wid")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMaintenanceById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance list = ms.getWeldingMaintenanceById(new BigInteger(json.getString("wid")));
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
			mr.setViceman(json.getString("viceman"));
			mr.setStartTime(json.getString("startTime"));
			String endTime = json.getString("endTime");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("endTime"));
			}
			mr.setDesc(json.getString("desc"));
			mr.setTypeId(json.getInt("typeId"));
			wm.setMaintenance(mr);
			WeldingMachine w = new WeldingMachine();
			BigInteger wid = new BigInteger(json.getString("weldId"));
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
			return ms.updateEndtime(new BigInteger(json.getString("mid")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateMaintenanceRecord(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setId(new BigInteger(json.getString("mid")));
			mr.setViceman(json.getString("viceman"));
			mr.setStartTime(json.getString("startTime"));
			String endTime = json.getString("endTime");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("endTime"));
			}
			mr.setDesc(json.getString("desc"));
			mr.setTypeId(json.getInt("typeId"));
			return ms.updateMaintenanceRecord(mr);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteMaintenanceRecord(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.deleteMaintenanceRecord(new BigInteger(json.getString("mid")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteWeldingMaintenance(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.deleteWeldingMaintenance(new BigInteger(json.getString("wid")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object getMaintainByWeldingMachinId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getMaintainByWeldingMachinId(new BigInteger(json.getString("wid")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean editstatus(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.editstatus(new BigInteger(json.getString("wid")), json.getInt("statusId"));
		}catch(Exception e){
			return false;
		}
	}

}
