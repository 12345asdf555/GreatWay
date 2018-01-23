package com.sshome.ssmcxf.webservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Authority;
import com.spring.service.AuthorityService;
import com.sshome.ssmcxf.webservice.AuthorityWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class AuthorityWebServiceImpl implements AuthorityWebService {
	@Autowired
	private AuthorityService as;

	
	@Override
	public boolean saveAuthority(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Authority auth = new Authority();
			auth.setAuthorityName(json.getString("authorityName"));
			auth.setAuthorityDesc(json.getString("authorityDesc"));
			auth.setStatus(json.getInt("statusId"));
			return as.save(auth);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean saveAuthorityResource(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Authority auth = new Authority();
			auth.setId(json.getInt("authId"));
			auth.setResourceId(json.getInt("resourceId"));
			return as.saveResource(auth);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateAuthority(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Authority auth = new Authority();
			auth.setId(json.getInt("authId"));
			auth.setAuthorityName(json.getString("authorityName"));
			auth.setAuthorityDesc(json.getString("authorityDesc"));
			auth.setStatus(json.getInt("statusId"));
			return as.update(auth);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteAuthority(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.delete(json.getInt("authId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteAuthoritiesResources(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.delete1(json.getInt("authId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteRolesAuthorities(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.delete2(json.getInt("authId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public String findByResourceId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.findByResourceId(json.getInt("resourceId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAuthorityById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Authority list = as.findById(json.getInt("authId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAllAuthority(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Authority> list = as.findAll(json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAllResource() {
		try{
			List<Authority> list =  as.findAllResource();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAuthorityResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Authority> list = as.findResource(json.getInt("authId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String fineAuthorityNameById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return as.updateAuthorityResource(json.getInt("authId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getAuthoritynameCount(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return as.getAuthoritynameCount(json.getString("authName"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getAllAuthoritys() {
		try{
			List<Authority> list = as.getAllAuthoritys();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int findAuthId(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return as.findAuthId(json.getString("authName"));
		}catch(Exception e){
			return -1;
		}
	}
}