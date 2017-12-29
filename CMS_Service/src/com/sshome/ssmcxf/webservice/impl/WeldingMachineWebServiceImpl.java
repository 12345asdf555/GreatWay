package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.WeldDto;
import com.spring.model.EquipmentManufacturer;
import com.spring.model.Page;
import com.spring.model.WeldingMachine;
import com.spring.service.WeldingMachineService;
import com.sshome.ssmcxf.webservice.WeldingMachineWebService;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.WeldingMachineWebService", serviceName = "WeldingMachineWebService")
public class WeldingMachineWebServiceImpl implements WeldingMachineWebService {
	@Autowired
	private WeldingMachineService wms;
	
	@Override
	public List<WeldingMachine> getWeldingMachineAll(BigInteger parent, String str) {
		try{
			return wms.getWeldingMachineAll(parent, str);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<WeldingMachine> getWeldingMachine(String str) {
		try{
			return wms.getWeldingMachine(str);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<EquipmentManufacturer> getManuAll() {
		try{
			return wms.getManuAll();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addWeldingMachine(WeldingMachine wm) {
		try{
			wms.addWeldingMachine(wm);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editWeldingMachine(WeldingMachine wm) {
		try{
			wms.editWeldingMachine(wm);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteWeldingChine(BigInteger wid) {
		try{
			wms.deleteWeldingChine(wid);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public BigInteger getWeldingMachineByEno(String eno) {
		try{
			return wms.getWeldingMachineByEno(eno);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getEquipmentnoCount(String eno) {
		try{
			return wms.getEquipmentnoCount(eno);
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int getGatheridCount(BigInteger itemid, String gather) {
		try{
			return wms.getGatheridCount(itemid, gather);
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public BigInteger getManuidByValue(String value, String type) {
		try{
			return wms.getManuidByValue(value, type);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public WeldingMachine getWeldingMachineById(BigInteger wid) {
		try{
			return wms.getWeldingMachineById(wid);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getInsframeworkByName(String name) {
		try{
			return wms.getInsframeworkByName(name);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getMachineCountByManu(BigInteger mid, WeldDto dto, BigInteger id) {
		try{
			return wms.getMachineCountByManu(mid, dto, id);
		}catch(Exception e){
			return null;
		}
	}

}
