package com.sshome.ssmcxf.webservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Resources;
import com.spring.service.ResourceService;
import com.sshome.ssmcxf.webservice.ResourceWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class ResourceWebServiceImpl implements ResourceWebService{
	@Autowired
	private ResourceService rs;

	@Override
	public int saveResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources r = new Resources();
			r.setResourceName(json.getString("RESOURCENAME"));
			r.setResourceAddress(json.getString("ADDRESS"));
			r.setResourceType(json.getString("TYPEID"));
			r.setResourceDesc(json.getString("DESC"));
			r.setStatus(json.getInt("STATUSID"));
			r.setCreator(json.getString("CREATOR"));
			if(rs.save(r)){
				return r.getId();
			}else{
				return 0;
			}
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public boolean updateResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources r = new Resources();
			r.setId(json.getInt("ID"));
			r.setResourceName(json.getString("RESOURCENAME"));
			r.setResourceAddress(json.getString("ADDRESS"));
			r.setResourceType(json.getString("TYPEID"));
			r.setResourceDesc(json.getString("DESC"));
			r.setStatus(json.getInt("STATUSID"));
			r.setModifier(json.getString("MODIFIER"));
			return rs.update(r);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.delete(json.getInt("ID"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object findResourceById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources list = rs.findById(json.getInt("ID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findResourceAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Resources> list = rs.findAll(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getResourcenameCount(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.getResourcenameCount(json.getString("NAME"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getAuthByRes(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<String> list = rs.getAuthByRes(json.getString("ADDRESS"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

}
