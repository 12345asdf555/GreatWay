package com.greatway.dao;

import java.math.BigInteger;

import com.spring.model.User;

public interface UserMapper {
	BigInteger FindIns_Id(User user);
	void AddWeld(User user);
	void UpdateWeld(User user);
	void AddJunction(User user);
	void UpdateJunction(User user);
	void DeleteJunction(User user);
}