package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import com.greatway.dto.WeldDto;
import com.greatway.page.Page;
import com.spring.model.User;

public interface UserService {
	void save(User user);
	void saveRole(User user);
	boolean update(User user);
	boolean delete(int id);
	boolean deleteRole(int id);
	User findById(Integer id);
	String findByRoleId(Integer id);
	int findByName(String name);
	List<User> findAll(Page page, BigInteger parent,String str);
	List<User> findRole(Integer id);
	List<User> findAllRole();
	String updateUserRole(Integer findByRoleId);
	int getUsernameCount(String userName);
	User LoadUser(String userName);
	List<String> getAuthoritiesByUsername(String userName);
	List<User> getIns();
}