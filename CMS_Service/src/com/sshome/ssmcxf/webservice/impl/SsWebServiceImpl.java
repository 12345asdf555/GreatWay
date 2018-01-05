package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.service.WeldService;
import com.sshome.ssmcxf.webservice.SsWebService;
@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.SsWebService", serviceName = "SsWebService")
public class SsWebServiceImpl implements SsWebService {

	@Autowired
	private WeldService userService;

	@Override
	public Boolean AddWeld(String aweld) {
		try{
			return userService.AddWeld(aweld);
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean UpdateWeld(String uweld) {
		try{
		return userService.UpdateWeld(uweld);
	}catch(Exception e){
		return false;
	}	
	}

	@Override
	public Boolean AddJunction(String ajunction) {
		try{
			return userService.AddJunction(ajunction);
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean UpdateJunction(String ujunction) {
		try{
			return userService.UpdateJunction(ujunction);
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean DeleteJunction(String djunction) {
		try{
			return userService.DeleteJunction(djunction);
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public BigInteger FindIns_Id(String insname) {
		return userService.FindIns_Id(insname);
	}
	

}
