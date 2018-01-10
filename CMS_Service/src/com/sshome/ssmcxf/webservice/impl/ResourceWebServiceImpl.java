package com.sshome.ssmcxf.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Resources;
import com.spring.service.ResourceService;
import com.sshome.ssmcxf.webservice.ResourceWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.ResourceWebService", serviceName = "ResourceWebService")
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
	public Resources findResourceById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.findById(json.getInt("id"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Resources> findResourceAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.findAll(json.getString("str"));
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
	public List<String> getAuthByRes(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return rs.getAuthByRes(json.getString("address"));
		}catch(Exception e){
			return null;
		}
	}

}
