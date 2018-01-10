package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Gather;
import com.spring.service.GatherService;
import com.sshome.ssmcxf.webservice.GatherWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.GatherWebService", serviceName = "GatherWebService")
public class GatherWebServiceImpl implements GatherWebService{

	@Autowired
	private GatherService gs;
	@Override
	public List<Gather> getGatherAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherAll(json.getString("str"), new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BigInteger getGatherByNo(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherByNo(json.getString("gatherNo"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getGatherNoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherNoCount(json.getString("gatherNo"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Gather getGatherById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherById(new BigInteger(json.getString("id")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Gather g = new Gather();
			g.setGatherNo(json.getString("gatherNo"));
			g.setIpurl(json.getString("ipurl"));
			g.setItemid(new BigInteger(json.getString("insfId")));
			String leavetime =json.getString("leavetime");
			if(leavetime!=null && !"".equals(leavetime)){
				g.setLeavetime(leavetime);
			}
			g.setMacurl(json.getString("macurl"));
			g.setProtocol(json.getString("protocol"));
			g.setStatus(json.getString("status"));
			return gs.addGather(g);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Gather g = new Gather();
			g.setId(new BigInteger(json.getString("id")));
			g.setGatherNo(json.getString("gatherNo"));
			g.setIpurl(json.getString("ipurl"));
			g.setItemid(new BigInteger(json.getString("insfId")));
			String leavetime =json.getString("leavetime");
			if(leavetime!=null && !"".equals(leavetime)){
				g.setLeavetime(leavetime);
			}
			g.setMacurl(json.getString("macurl"));
			g.setProtocol(json.getString("protocol"));
			g.setStatus(json.getString("status"));
			return gs.editGather(g);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.deleteGather(new BigInteger(json.getString("id")));
		}catch(Exception e){
			return false;
		}
	}
}
