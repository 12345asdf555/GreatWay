package com.greatway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.model.Authority;

public interface AuthorityMapper {
	void save(Authority authority);
	void saveResource(Authority authority);
	boolean update(Authority authority);
	boolean delete(int id);
	boolean delete1(String authorityName);
	boolean delete2(int id);
	boolean deleteResource(String authorityName);
	String findByResourceId(Integer id);
	Authority findById(Integer id);
	List<Authority> findAll(@Param("str")String str);
	List<Authority> findAllResource();
	List<Authority> findResource(Integer id);
	String updateAuthorityResource(Integer findByRoleId);
	int getAuthoritynameCount(@Param("authorityName")String authorityName);
	List<Authority> getAllAuthoritys();
}