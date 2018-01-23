package com.sshome.ssmcxf.webservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Role;
import com.spring.service.RoleService;
import com.sshome.ssmcxf.webservice.RoleWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class RoleWebServiceImpl implements RoleWebService{
	@Autowired
	private RoleService ros;

	@Override
	public boolean saveRolesAuthority(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role r = new Role();
			r.setId(json.getInt("roleId"));
			r.setAuthorityId(json.getInt("authId"));
			return ros.saveAuthority(r);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean saveRoles(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role role = new Role();
			role.setRoleName(json.getString("roleName"));
			role.setRoleDesc(json.getString("desc"));
			role.setRoleStatus(json.getInt("statusId"));
			return ros.save(role);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean saveUserRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role role = new Role();
			role.setId(json.getInt("roleId"));
			role.setUserId(json.getInt("userId"));
			return ros.saveUser(role);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role role = new Role();
			role.setId(json.getInt("roleId"));
			role.setRoleName(json.getString("roleName"));
			role.setRoleDesc(json.getString("desc"));
			role.setRoleStatus(json.getInt("statusId"));
			return ros.update(role);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.delete(json.getInt("roleId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteUsersRoles(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.delete1(json.getInt("roleId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteRolesAuthoritiesByRole(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.delete2(json.getString("roleId"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object findRoleById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role list = ros.findById(json.getInt("roleId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findAuthorityDescById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findByAuthorityId(json.getInt("authId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String findUserNameById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findByUserId(json.getInt("userId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findRoleAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Role> list = ros.findAll(json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findIdDescByAuthority() {
		try{
			List<Role> list = ros.findAllAuthority();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAuthorityDetail(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Role> list = ros.findAuthority(json.getInt("roleId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public String getRoleNameById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.updateRoleAuthority(json.getInt("roleId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findAllUser() {
		try{
			List<Role> list = ros.findAllUser();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object findUserRoleDetail(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			List<Role> list = ros.findUser(json.getInt("roleId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getRolenameCount(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.getRolenameCount(json.getString("roleName"));
		}catch(Exception e){
			return -1;
		}
	}


}