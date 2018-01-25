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
			user.setUserName(json.getString("UNAME"));
			user.setUserPassword(json.getString("PASSWORD"));
			user.setUserLoginName(json.getString("LOGINNAME"));
			user.setUserEmail(json.getString("EMAIL"));
			user.setUserPhone(json.getString("PHONE"));
			user.setUserInsframework(json.getLong("INSFID"));
			user.setUserPosition(json.getString("POSITION"));
			user.setStatus(json.getInt("STATUSID"));
			user.setCreator(json.getString("CREATOR"));
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
			user.setId(json.getInt("UID"));
			user.setUserName(json.getString("UNAME"));
			user.setUserPassword(json.getString("PASSWORD"));
			user.setUserLoginName(json.getString("LOGINNAME"));
			user.setUserEmail(json.getString("EMAIL"));
			user.setUserPhone(json.getString("PHONE"));
			user.setUserInsframework(json.getLong("INSFID"));
			user.setUserPosition(json.getString("POSITION"));
			user.setStatus(json.getInt("STATUSID"));
			user.setModifier("MODIFIER");
			return us.update(user);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean delete(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.delete(json.getInt("UID"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public  Object findById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.findById(json.getInt("UID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findByRoleId(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findByRoleId(json.getInt("ROLEID"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int findByName(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findByName(json.getString("LOGINNAME"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object findAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.findAll(new BigInteger(json.getString("INSFID")), json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.findRole(json.getInt("UID"));
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
			return us.getUsernameCount(json.getString("LOGINNAME"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object LoadUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.LoadUser(json.getString("LOGINNAME"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getAuthoritiesByUsername(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<String> list = us.getAuthoritiesByUsername(json.getString("LOGINNAME"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getIns(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.getIns(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getUserInsframework(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			User list = us.getUserInsframework(new BigInteger(json.getString("UID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getInsUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<User> list = us.getInsUser(json.getInt("INSFID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

}
