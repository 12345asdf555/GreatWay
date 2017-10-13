package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.Insframework;

import tk.mybatis.mapper.common.Mapper;

public interface InsframeworkMapper extends Mapper<Insframework>{
	List<Insframework> getInsframeworkAll(@Param("str")String str);
	
	List<Insframework> getInsframework();
	
	BigInteger getInsframeworkByName(@Param("name")String name);
	
	Insframework getInsfAllById(@Param("id")BigInteger id);
	
	int getInsframeworkNameCount(@Param("name")String name);
	
	String getInsframeworkById(@Param("id")BigInteger id);
	
	void addInsframework(Insframework ins);
	
	void editInsframework(Insframework ins);
	
	void deleteInsframework(@Param("id")BigInteger id);
	
	List<Insframework> getConmpany();
	
	List<Insframework> getCause(@Param("id")BigInteger id);
	
	Insframework getParent(@Param("id")BigInteger id);
	
	List<Insframework> getInsByType(@Param("type") int type);
	
	int getUserInsfType(@Param("uid")BigInteger uid);
	
	BigInteger  getUserInsfId(@Param("uid")BigInteger uid);
}
