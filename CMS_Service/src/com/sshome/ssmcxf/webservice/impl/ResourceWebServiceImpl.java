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
	public boolean saveResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources r = new Resources();
			r.setResourceName(json.getString("resourceName"));
			r.setResourceAddress(json.getString("address"));
			r.setResourceType(json.getString("typeId"));
			r.setResourceDesc(json.getString("desc"));
			r.setStatus(json.getInt("statusId"));
			return rs.save(r);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources r = new Resources();
			r.setId(json.getInt("id"));
			r.setResourceName(json.getString("name"));
			r.setResourceAddress(json.getString("address"));
			r.setResourceType(json.getString("typeId"));
			r.setResourceDesc(json.getString("desc"));
			r.setStatus(json.getInt("statusId"));
			return rs.update(r);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.delete(json.getInt("id"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object findResourceById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Resources list = rs.findById(json.getInt("id"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findResourceAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Resources> list = rs.findAll(json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getResourcenameCount(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.getResourcenameCount(json.getString("name"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getAuthByRes(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<String> list = rs.getAuthByRes(json.getString("address"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

}
