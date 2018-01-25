package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.service.WeldService;
import com.sshome.ssmcxf.webservice.SsWebService;

@Transactional
@Service
public class SsWebServiceImpl implements SsWebService {

	@Autowired
	private WeldService userService;
	
	@Override
	public Boolean AddWeld(String aweld) {
		Boolean flag = userService.AddWeld(aweld);
			return flag;	
	}

	@Override
	public Boolean UpdateWeld(String uweld) {
		Boolean flag = userService.UpdateWeld(uweld);
		return flag;
	}

	@Override
	public Boolean AddJunction(String ajunction) {
		Boolean flag = userService.AddJunction(ajunction);
		return flag;
	}

	@Override
	public Boolean UpdateJunction(String ujunction) {
		Boolean flag = userService.UpdateJunction(ujunction);
		return flag;
	}

	@Override
	public Boolean DeleteJunction(String djunction) {
		Boolean flag = userService.DeleteJunction(djunction);
		return flag;
	}

	@Override
	public BigInteger FindIns_Id(String insname) {
		return userService.FindIns_Id(insname);
	}

}
