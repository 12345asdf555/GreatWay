package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Authority;
import com.spring.model.Resources;
import com.spring.model.Role;
import com.spring.model.User;
@WebService
public interface UserWebService {
	//Authority
	boolean saveAuthority(@WebParam(name="object") String object);
	boolean saveAuthorityResource(@WebParam(name="object") String object);
	boolean updateAuthority(@WebParam(name="object") String object);
	boolean deleteAuthority(@WebParam(name="object") String object);
	boolean deleteAuthoritiesResources(@WebParam(name="object") String object);
	boolean deleteRolesAuthorities(@WebParam(name="object") String object);
	String findByResourceId(@WebParam(name="object") String object);
	Authority findAuthorityById(@WebParam(name="object") String object);
	List<Authority> findAllAuthority(@WebParam(name="object") String object);
	List<Authority> findAllResource();
	List<Authority> findAuthorityResource(@WebParam(name="object") String object);
	String fineAuthorityNameById(@WebParam(name="object") String object);
	int getAuthoritynameCount(@WebParam(name="object") String object);
	List<Authority> getAllAuthoritys();
	int findAuthId(@WebParam(name="object") String object);
	//Resource
	boolean saveResource(@WebParam(name="object") String object);
	boolean updateResource(@WebParam(name="object") String object);
	boolean deleteResource(@WebParam(name="object") String object);
	Resources findResourceById(@WebParam(name="object") String object);
	List<Resources> findResourceAll(@WebParam(name="object") String object);
	int getResourcenameCount(@WebParam(name="object") String object);
	List<String> getAuthByRes(@WebParam(name="object") String object);
	//Role
	boolean saveRolesAuthority(@WebParam(name="object") String object);
	boolean saveRoles(@WebParam(name="object") String object);
	boolean saveUserRole(@WebParam(name="object") String object);
	boolean updateRole(@WebParam(name="object") String object);
	boolean deleteRole(@WebParam(name="object") String object);
	boolean deleteUsersRoles(@WebParam(name="object") String object);
	boolean deleteRolesAuthoritiesByRole(@WebParam(name="object") String object);
	Role findRoleById(@WebParam(name="object") String object);
	String findAuthorityDescById(@WebParam(name="object") String object);
	String findUserNameById(@WebParam(name="object") String object);
	List<Role> findRoleAll(@WebParam(name="object") String object);
	List<Role> findIdDescByAuthority();
	List<Role> findAuthorityDetail(@WebParam(name="object") String object);
	String getRoleNameById(@WebParam(name="object") String object);
	List<Role> findAllUser();
	List<Role> findUserRoleDetail(@WebParam(name="object") String object);
	int getRolenameCount(@WebParam(name="object") String object);
	//User
	boolean save(@WebParam(name="object") String object);
	boolean update(@WebParam(name="object") String object);
	boolean delete(@WebParam(name="object") String object);
	User findById(@WebParam(name="object") String object);
	String findByRoleId(@WebParam(name="object") String object);
	int findByName(@WebParam(name="object") String object);
	List<User> findAll(@WebParam(name="object") String object);
	List<User> findRole(@WebParam(name="object") String object);
	List<User> findAllRole();
	int getUsernameCount(@WebParam(name="object") String object);
	User LoadUser(@WebParam(name="object") String object);
	List<String> getAuthoritiesByUsername(@WebParam(name="object") String object);
	List<User> getIns(@WebParam(name="object") String object);
	User getUserInsframework(@WebParam(name="object") String object);
	List<User> getInsUser(@WebParam(name="object") String object);
}
