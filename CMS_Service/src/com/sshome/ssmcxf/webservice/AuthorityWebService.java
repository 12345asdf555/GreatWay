package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Authority;

@WebService
public interface AuthorityWebService {
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
}
