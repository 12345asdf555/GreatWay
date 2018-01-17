package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.User;
import com.spring.service.UserService;
import com.sshome.ssmcxf.webservice.UserWebService;

import net.sf.json.JSONObject;
@Transactional
@Service
public class UserWebServiceImpl implements UserWebService {
	@Autowired
	private UserService us;

	@Override
	public boolean save(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User user = new User();
			user.setUserName(json.getString("uname"));
			user.setUserPassword(json.getString("password"));
			user.setUserLoginName(json.getString("loginName"));
			user.setUserEmail(json.getString("email"));
			user.setUserPhone(json.getString("phone"));
			user.setUserInsframework(json.getLong("insfId"));
			user.setUserPosition(json.getString("position"));
			user.setStatus(json.getInt("statusId"));
			return us.save(user);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean update(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User user = new User();
			user.setId(json.getInt("uId"));
			user.setUserName(json.getString("uname"));
			user.setUserPassword(json.getString("password"));
			user.setUserLoginName(json.getString("loginName"));
			user.setUserEmail(json.getString("email"));
			user.setUserPhone(json.getString("phone"));
			user.setUserInsframework(json.getLong("insfId"));
			user.setUserPosition(json.getString("position"));
			user.setStatus(json.getInt("statusId"));
			return us.update(user);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean delete(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.delete(json.getInt("uId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public  Object findById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.findById(json.getInt("uId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findByRoleId(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findByRoleId(json.getInt("roleId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int findByName(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findByName(json.getString("loginName"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object findAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.findAll(new BigInteger(json.getString("insfId")), json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.findRole(json.getInt("uId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAllRole() {
		try{
			List<User> list = us.findAllRole();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getUsernameCount(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.getUsernameCount(json.getString("loginname"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object LoadUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.LoadUser(json.getString("loginName"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getAuthoritiesByUsername(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<String> list = us.getAuthoritiesByUsername(json.getString("loginName"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getIns(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.getIns(new BigInteger(json.getString("insfId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getUserInsframework(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.getUserInsframework(new BigInteger(json.getString("uId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getInsUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.getInsUser(json.getInt("insfId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

}
