package com.spring.service;

import java.util.List;

import com.greatway.page.Page;
import com.spring.model.Authority;


public interface AuthorityService {
	void save(Authority authority);
	void saveResource(Authority authority);
	boolean update(Authority authority);
	boolean delete(int id);
	boolean delete1(String authorityName);
	boolean delete2(int id);
	boolean deleteResource(String authorityName);
	String findByResourceId(Integer id);
	Authority findById(Integer id);
	List<Authority> findAll(Page page, String search);
	List<Authority> findAllResource();
	List<Authority> findResource(Integer id);
	String updateAuthorityResource(Integer findByRoleId);
	int getAuthoritynameCount(String authorityName);
	List<Authority> getAllAuthoritys();
}
