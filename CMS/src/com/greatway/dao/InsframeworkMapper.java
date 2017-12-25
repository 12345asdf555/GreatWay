package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.dto.WeldDto;
import com.greatway.model.Insframework;

import tk.mybatis.mapper.common.Mapper;

public interface InsframeworkMapper extends Mapper<Insframework>{
	List<Insframework> getInsframeworkAll(@Param("parent")BigInteger parent,@Param("str")String str,@Param("dto")WeldDto dto);
	
	List<Insframework> getInsframework();
	
	BigInteger getInsframeworkByName(@Param("name")String name);
	
	Insframework getInsfAllById(@Param("id")BigInteger id);
	
	int getInsframeworkNameCount(@Param("name")String name);
	
	String getInsframeworkById(@Param("id")BigInteger id);
	
	BigInteger getParentById(@Param("id")BigInteger id);
	
	void addInsframework(Insframework ins);
	
	void editInsframework(Insframework ins);
	
	void deleteInsframework(@Param("id")BigInteger id);
	
	List<Insframework> getConmpany();
	
	List<Insframework> getCause(@Param("id")BigInteger id);
	
	Insframework getParent(@Param("id")BigInteger id);
	
	List<Insframework> getInsByType(@Param("type") int type,@Param("parent")BigInteger parent);
	
	int getUserInsfType(@Param("uid")BigInteger uid);
	
	BigInteger  getUserInsfId(@Param("uid")BigInteger uid);
	
	int getTypeById(@Param("id")BigInteger id);
	
	Insframework getBloc();
	
	List<Insframework> getInsIdByParent(@Param("parent")BigInteger parent);
	
	List<Insframework> getInsByUserid(@Param("uid")BigInteger uid);
	
	Insframework getInsById(@Param("id")BigInteger id);
	
	List<Insframework> getInsAll();
}
