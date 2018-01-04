package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;


import com.spring.model.Td;

@WebService
public interface LiveDataWebService {
	//实时曲线
	List<Td> findAll(@WebParam(name="object")String object);
	List<Td> findAlldiv(@WebParam(name="object")String object);
	List<Td> getAllPosition();
	long findIns(@WebParam(name="object")String object);
	long findInsid(@WebParam(name="object")String object);
	String findweld(@WebParam(name="object")String object);
	String findInsname(@WebParam(name="object")String object);
	String findPosition(@WebParam(name="object")String object);
	List<Td> allWeldname();
	int findDic(@WebParam(name="object")String object);
}
