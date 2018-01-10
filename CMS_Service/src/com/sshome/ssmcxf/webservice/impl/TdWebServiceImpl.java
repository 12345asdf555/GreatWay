package com.sshome.ssmcxf.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Td;
import com.spring.service.TdService;
import com.sshome.ssmcxf.webservice.TdWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.TdWebService", serviceName = "TdWebService")
public class TdWebServiceImpl implements TdWebService{
	@Autowired
	private TdService ts;

	@Override
	public List<Td> findAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findAll(json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Td> findAlldiv(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findAlldiv(json.getLong("insfId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Td> getAllPosition() {
		try{
			return ts.getAllPosition();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public long findIns(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findIns(json.getLong("uId"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public long findInsid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findInsid(json.getString("insfName"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public String findweld(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findweld(json.getString("weldNo"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findInsname(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findInsname(json.getLong("insfId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findPosition(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findPosition(json.getString("machineNo"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Td> allWeldname() {
		try{
			return ts.allWeldname();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int findDic(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ts.findDic(json.getLong("uId"));
		}catch(Exception e){
			return -1;
		}
	}
}
