package com.spring.service;

import java.math.BigInteger;

import com.spring.model.User;

public interface UserService {

	BigInteger FindIns_Id(String insname);
	Boolean AddWeld(String aweld);
	Boolean UpdateWeld(String uweld);
	Boolean AddJunction(String ajunction);
	Boolean UpdateJunction(String ujunction);
	Boolean DeleteJunction(String djunction);
	

}