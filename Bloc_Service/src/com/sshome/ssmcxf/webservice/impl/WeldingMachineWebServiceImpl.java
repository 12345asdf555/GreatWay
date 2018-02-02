package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.EquipmentManufacturer;
import com.spring.model.Gather;
import com.spring.model.Insframework;
import com.spring.model.WeldingMachine;
import com.spring.service.WeldingMachineService;
import com.sshome.ssmcxf.webservice.WeldingMachineWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class WeldingMachineWebServiceImpl implements WeldingMachineWebService {
	@Autowired
	private WeldingMachineService wms;
	
	@Override
	public Object getWeldingMachineAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger parent = new BigInteger(json.getString("INSFID"));
			String str = json.getString("STR");
			List<WeldingMachine> list =  wms.getWeldingMachineAll(parent, str);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMachine> list = wms.getWeldingMachine(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getManuAll() {
		try{
			List<EquipmentManufacturer> list =  wms.getManuAll();
			return JSON.toJSONString(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BigInteger addWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine wm = new WeldingMachine();
			wm.setEquipmentNo(json.getString("EQUIPMENTNO"));
			wm.setPosition(json.getString("POSITION"));
			wm.setIsnetworking(json.getInt("ISNETWORKING"));
			wm.setJoinTime(json.getString("JOINTIME"));
			wm.setTypeId(json.getInt("TYPEID"));
			wm.setStatusId(json.getInt("STATUSID"));
			wm.setCreator(json.getString("CREATOR"));
			Gather gather = new Gather();
			gather.setId(new BigInteger(json.getString("GATHERID")));
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("MANUFACTURERID")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("INSFRAMEWORKID")));
			wm.setInsframeworkId(ins);
			if(wms.addWeldingMachine(wm)){
				return wm.getId();
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine wm = new WeldingMachine();
			wm.setId(new BigInteger(json.getString("ID")));
			wm.setEquipmentNo(json.getString("EQUIPMENTNO"));
			wm.setPosition(json.getString("POSITION"));
			wm.setIsnetworking(json.getInt("ISNETWORKING"));
			wm.setJoinTime(json.getString("JOINTIME"));
			wm.setTypeId(json.getInt("TYPEID"));
			wm.setStatusId(json.getInt("STATUSID"));
			wm.setModifier(json.getString("MODIFIER"));
			Gather gather = new Gather();
			gather.setId(new BigInteger(json.getString("GATHERID")));
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("MANUFACTURERID")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("INSFRAMEWORKID")));
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
			return wms.deleteWeldingChine(new BigInteger(json.getString("WID")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public BigInteger getWeldingMachineByEno(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getWeldingMachineByEno(json.getString("ENO"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getEquipmentnoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getEquipmentnoCount(json.getString("ENO"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public int getGatheridCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger itemid = new BigInteger(json.getString("INSFID"));
			String gather = json.getString("GATHERNO");
			return wms.getGatheridCount(itemid, gather);
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getManuidByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getManuidByValue(json.getString("MANUNAME"), json.getString("MANUTYPE"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMachineById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine list = wms.getWeldingMachineById(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getInsframeworkByName(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getInsframeworkByName(json.getString("INSFNAME"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getMachineCountByManu(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger mid = new BigInteger(json.getString("MANUID"));
			BigInteger insid = new BigInteger(json.getString("INSFID"));
			return wms.getMachineCountByManu(mid, insid);
		}catch(Exception e){
			return null;
		}
	}

}
