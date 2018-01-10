package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.EquipmentManufacturer;
import com.spring.model.Gather;
import com.spring.model.Insframework;
import com.spring.model.MaintenanceRecord;
import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;
import com.spring.service.MaintainService;
import com.spring.service.WeldingMachineService;
import com.sshome.ssmcxf.webservice.WeldingMachineWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.WeldingMachineWebService", serviceName = "WeldingMachineWebService")
public class WeldingMachineWebServiceImpl implements WeldingMachineWebService {
	@Autowired
	private WeldingMachineService wms;
	
	@Override
	public List<WeldingMachine> getWeldingMachineAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger parent = new BigInteger(json.getString("insId"));
			String str = json.getString("str");
			return wms.getWeldingMachineAll(parent, str);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<WeldingMachine> getWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getWeldingMachine(json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<EquipmentManufacturer> getManuAll() {
		try{
			return wms.getManuAll();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine wm = new WeldingMachine();
			wm.setEquipmentNo(json.getString("equipmentNo"));
			wm.setPosition(json.getString("position"));
			wm.setIsnetworking(json.getInt("isnetworking"));
			wm.setJoinTime(json.getString("joinTime"));
			wm.setTypeId(json.getInt("typeId"));
			wm.setStatusId(json.getInt("statusId"));
			Gather gather = new Gather();
			gather.setId(new BigInteger(json.getString("gatherId")));
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("manufacturerId")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("insframeworkId")));
			wm.setInsframeworkId(ins);
			return wms.addWeldingMachine(wm);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine wm = new WeldingMachine();
			wm.setId(new BigInteger(json.getString("id")));
			wm.setEquipmentNo(json.getString("equipmentNo"));
			wm.setPosition(json.getString("position"));
			wm.setIsnetworking(json.getInt("isnetworking"));
			wm.setJoinTime(json.getString("joinTime"));
			wm.setTypeId(json.getInt("typeId"));
			wm.setStatusId(json.getInt("statusId"));
			Gather gather = new Gather();
			gather.setId(new BigInteger(json.getString("gatherId")));
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("manufacturerId")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("insframeworkId")));
			wm.setInsframeworkId(ins);
			return wms.editWeldingMachine(wm);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteWeldingChine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.deleteWeldingChine(new BigInteger(json.getString("wid")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public BigInteger getWeldingMachineByEno(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getWeldingMachineByEno(json.getString("eno"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getEquipmentnoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getEquipmentnoCount(json.getString("eno"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public int getGatheridCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger itemid = new BigInteger(json.getString("insfId"));
			String gather = json.getString("gatherNo");
			return wms.getGatheridCount(itemid, gather);
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getManuidByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getManuidByValue(json.getString("manuName"), json.getString("manuType"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public WeldingMachine getWeldingMachineById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getWeldingMachineById(new BigInteger(json.getString("wid")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getInsframeworkByName(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getInsframeworkByName(json.getString("insName"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getMachineCountByManu(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger mid = new BigInteger(json.getString("manuId"));
			BigInteger insid = new BigInteger(json.getString("insId"));
			return wms.getMachineCountByManu(mid, insid);
		}catch(Exception e){
			return null;
		}
	}

}
