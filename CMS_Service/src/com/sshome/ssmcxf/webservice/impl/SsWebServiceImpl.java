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
		userService.AddWeld(aweld);
		return true;
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean UpdateWeld(String uweld) {
		try{
		userService.UpdateWeld(uweld);
		return true;
	}catch(Exception e){
		return false;
	}	
	}

	@Override
	public Boolean AddJunction(String ajunction) {
		// TODO Auto-generated method stub
		try{
		System.out.println(ajunction);
		userService.AddJunction(ajunction);
		return true;
	}catch(Exception e){
		return false;
	}	
	}

	@Override
	public Boolean UpdateJunction(String ujunction) {
		// TODO Auto-generated method stub
		try{
		userService.UpdateJunction(ujunction);
		return true;
	}catch(Exception e){
		return false;
	}	
	}

	@Override
	public Boolean DeleteJunction(String djunction) {
		// TODO Auto-generated method stub
		try{
		userService.DeleteJunction(djunction);
		return true;
	}catch(Exception e){
		return false;
	}	
	}

	@Override
	public BigInteger FindIns_Id(String insname) {
		// TODO Auto-generated method stub
		return userService.FindIns_Id(insname);
	}
	

}
