package com.spring.dao;

import java.math.BigInteger;

import com.spring.model.Weld;

public interface WeldMapper {
	BigInteger FindIns_Id(Weld user);
	void AddWeld(Weld user);
	void UpdateWeld(Weld user);
	void AddJunction(Weld user);
	void UpdateJunction(Weld user);
	void DeleteJunction(Weld user);
}