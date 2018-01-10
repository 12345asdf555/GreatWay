package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.User;

@WebService
public interface UserWebService {
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
