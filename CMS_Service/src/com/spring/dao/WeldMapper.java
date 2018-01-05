package com.spring.dao;

import java.math.BigInteger;

import com.spring.model.Weld;

public interface WeldMapper {
	BigInteger FindIns_Id(Weld user);
	int AddWeld(Weld user);
	int UpdateWeld(Weld user);
	int AddJunction(Weld user);
	int UpdateJunction(Weld user);
	int DeleteJunction(Weld user);
}