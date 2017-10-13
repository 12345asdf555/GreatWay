package com.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.greatway.dao.RoleMapper;
import com.greatway.page.Page;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.service.RoleService;




@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}
	
	public boolean delete1(String roleName) {
		
		return mapper.delete1(roleName);
	}
	
	public boolean delete2(String roleName) {
		
		return mapper.delete2(roleName);
	}
	
	public boolean deleteAuthority(String roleName) {
		
		return mapper.deleteAuthority(roleName);
	}
	
	public int getRolenameCount(String roleName) {
		return mapper.getRolenameCount(roleName);
	}
	
	public boolean deleteUser(String roleName) {
		
		return mapper.deleteAuthority(roleName);
	}

	public List<Role> findAll(Page page,String str) {
		PageHelper.startPage(page.getPageIndex(), page.getPageSize());
		List<Role> findAllList = mapper.findAll(str);
		return findAllList;
	}

	public Role findById(int id) {

		Role role = mapper.findById(id);
		
		return role;
	}
	
	public String findByAuthorityId(Integer id) {
		
		return mapper.findByAuthorityId(id);
	}
	
	public String findByUserId(Integer id) {
		
		return mapper.findByUserId(id);
	}
	
	public String updateRoleAuthority(Integer findByAuthorityId) {
		
		return mapper.updateRoleAuthority(findByAuthorityId);
	}
	
	public String updateRoleUser(Integer findByUserId) {
		
		return mapper.updateRoleUser(findByUserId);
	}

	public void save(Role role) {

		mapper.save(role);
	}
	
	public void saveAuthority(Role Role) {

		mapper.saveAuthority(Role);
	}
	
	public void saveUser(Role Role) {

		mapper.saveUser(Role);
	}

	public boolean update(Role role) {

		return mapper.update(role);
	}
	
	public List<Role> findAllAuthority() {
		List<Role> findAllAuthorityList = mapper.findAllAuthority();
		return findAllAuthorityList;
	}
	
	public List<Role> findAuthority(Integer id) {
		return mapper.findAuthority(id);
	}
	
	public List<Role> findAllUser() {
		List<Role> findAllUserList = mapper.findAllUser();
		return findAllUserList;
	}
	
	public List<Role> findUser(Integer id) {
		return mapper.findUser(id);
	}
	

}
