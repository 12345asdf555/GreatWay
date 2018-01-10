package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Resources;

@WebService
public interface ResourceWebService {
	boolean saveResource(@WebParam(name="object") String object);
	boolean updateResource(@WebParam(name="object") String object);
	boolean deleteResource(@WebParam(name="object") String object);
	Resources findResourceById(@WebParam(name="object") String object);
	List<Resources> findResourceAll(@WebParam(name="object") String object);
	int getResourcenameCount(@WebParam(name="object") String object);
	List<String> getAuthByRes(@WebParam(name="object") String object);
}
