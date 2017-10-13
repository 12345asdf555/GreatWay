package com.greatway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.page.Page;
import com.spring.model.User;

public interface UserMapper {
	void save(User user);
	void saveRole(User user);
	boolean update(User user);
	boolean delete(int id);
	boolean deleteRole(String userName);
	User findById(Integer id);
	String findByRoleId(Integer id);
	List<User> findAll(@Param("str")String str);
	int getUsernameCount(@Param("userName")String userName);
	List<User> findRole(Integer id);
	List<User> findAllRole();
	String updateUserRole(Integer findByRoleId);
	User LoadUser(String userName);
	List<String> getAuthoritiesByUsername(String userName);
	List<User> getIns();
	
}