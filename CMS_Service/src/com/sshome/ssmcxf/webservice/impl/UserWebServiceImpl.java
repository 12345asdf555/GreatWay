package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Authority;
import com.spring.model.Resources;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.service.AuthorityService;
import com.spring.service.ResourceService;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import com.sshome.ssmcxf.webservice.UserWebService;

import net.sf.json.JSONObject;
@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.UserWebService", serviceName = "UserWebService")
public class UserWebServiceImpl implements UserWebService {
	@Autowired
	private AuthorityService as;

	@Autowired
	private ResourceService rs;
	
	@Autowired
	private RoleService ros;
	
	@Autowired
	private UserService us;
	
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
	public Authority findAuthorityById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.findById(json.getInt("authId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Authority> findAllAuthority(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return as.findAll(json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Authority> findAllResource() {
		try{
			return as.findAllResource();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Authority> findAuthorityResource(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return as.findResource(json.getInt("authId"));
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
	public List<Authority> getAllAuthoritys() {
		try{
			return as.getAllAuthoritys();
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
	//资源
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

	//Role
	
	@Override
	public boolean saveRolesAuthority(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			Role r = new Role();
			r.setRoleName(json.getString("roleName"));
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
			return ros.delete2(json.getString("roleName"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Role findRoleById(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findById(json.getInt("roleId"));
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
	public List<Role> findRoleAll(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findAll(json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Role> findIdDescByAuthority() {
		try{
			return ros.findAllAuthority();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Role> findAuthorityDetail(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findAuthority(json.getInt("roleId"));
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
	public List<Role> findAllUser() {
		try{
			return ros.findAllUser();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Role> findUserRoleDetail(String object) {
		try{
			JSONObject json  = JSONObject.fromObject(object);
			return ros.findUser(json.getInt("roleId"));
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

	//User
	
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
