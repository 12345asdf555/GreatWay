package com.spring.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.UserMapper;
import com.greatway.dto.WeldDto;
import com.greatway.page.Page;
import com.spring.model.User;
import com.spring.service.UserService;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}
	
	public boolean deleteRole(int id) {
		
		return mapper.deleteRole(id);
	}
	
	public int getUsernameCount(String userName) {
		return mapper.getUsernameCount(userName);
	}

	public List<User> findAll(Page page,BigInteger parent,WeldDto dto,String str) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		List<User> findAllList = mapper.findAll(parent,dto,str);
		return findAllList;
	}
	
	public List<User> findAllRole() {
		List<User> findAllRoleList = mapper.findAllRole();
		return findAllRoleList;
	}
	
	public int findByName(String name){
		return mapper.findByName(name);
	}
	
	public List<User> getIns() {
		return mapper.getIns();
	}
	
	public List<String> getAuthoritiesByUsername(String userName) {
		 
		return mapper.getAuthoritiesByUsername(userName);
	}

	public User findById(Integer id) {

		User user = mapper.findById(id);
		
		return user;
	}
	
	public User LoadUser(String userName) {
		
		return mapper.LoadUser(userName);
	}
	
	public String findByRoleId(Integer id) {
		
		return mapper.findByRoleId(id);
	}

	public List<User> findRole(Integer id) {
		return mapper.findRole(id);
	}
	
	public void save(User user) {

		mapper.save(user);
	}
	
	public void saveRole(User user) {

		mapper.saveRole(user);
	}

	public boolean update(User user) {

		return mapper.update(user);
	}

	@Override
	public String updateUserRole(Integer findByRoleId) {
		// TODO Auto-generated method stub
		return mapper.updateUserRole(findByRoleId);
	}
	
	

}