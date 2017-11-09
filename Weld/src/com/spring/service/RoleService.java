package com.spring.service;


	import java.util.List;

import com.greatway.page.Page;
import com.spring.model.Role;

	public interface RoleService {
		void saveAuthority(Role role);
		void save(Role role);
		void saveUser(Role role);
		boolean update(Role role);
		boolean delete(int id);
		boolean delete1(int id);
		boolean delete2(String roleName);
		boolean deleteAuthority(String roleName);
		boolean deleteUser(int id);
		Role findById(int id);
		String findByAuthorityId(Integer id);
		String findByUserId(Integer id);
		List<Role> findAll(Page page, String search);
		List<Role> findAllAuthority();
		List<Role> findAuthority(Integer id);
		String updateRoleAuthority(Integer findByAuthorityId);
		String updateRoleUser(Integer findByAuthorityId);
		List<Role> findAllUser();
		List<Role> findUser(Integer id);
		int getRolenameCount(String roleName);
	}
