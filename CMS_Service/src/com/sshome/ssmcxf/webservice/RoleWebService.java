package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Role;

@WebService
public interface RoleWebService {
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
}
