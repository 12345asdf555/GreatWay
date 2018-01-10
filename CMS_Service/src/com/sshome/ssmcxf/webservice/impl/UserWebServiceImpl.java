package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.User;
import com.spring.service.UserService;
import com.sshome.ssmcxf.webservice.UserWebService;

import net.sf.json.JSONObject;
@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.UserWebService", serviceName = "UserWebService")
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
	public User findById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findById(json.getInt("uId"));
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
	public List<User> findAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findAll(new BigInteger(json.getString("insfId")), json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> findRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.findRole(json.getInt("uId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> findAllRole() {
		try{
			return us.findAllRole();
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
	public User LoadUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.LoadUser(json.getString("loginName"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<String> getAuthoritiesByUsername(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.getAuthoritiesByUsername(json.getString("loginName"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> getIns(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.getIns(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public User getUserInsframework(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.getUserInsframework(new BigInteger(json.getString("uId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> getInsUser(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return us.getInsUser(json.getInt("insfId"));
		}catch(Exception e){
			return null;
		}
	}

}
