package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatway.page.Page;
import com.spring.model.Role;
import com.spring.model.User;

public interface UserService {
	void save(User user);
	void saveRole(User user);
	boolean update(User user);
	boolean delete(int id);
	boolean deleteRole(String userName);
	User findById(Integer id);
	String findByRoleId(Integer id);
	List<User> findAll(Page page, String str);
	List<User> findRole(Integer id);
	List<User> findAllRole();
	String updateUserRole(Integer findByRoleId);
	int getUsernameCount(String userName);
	User LoadUser(String userName);
	List<String> getAuthoritiesByUsername(String userName);
	List<User> getIns();
}
