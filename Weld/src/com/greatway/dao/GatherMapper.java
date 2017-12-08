package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.Gather;

import tk.mybatis.mapper.common.Mapper;

public interface GatherMapper extends Mapper<Gather>{
	List<Gather> getGatherAll(@Param("str")String str);
	
	BigInteger getGatherByNo(@Param("gatherno")String gatherno);
	
	int getGatherNoCount(@Param("gatherno")String gatherno);
	
	Gather getGatherById(@Param("id")BigInteger id);
	
	void addGather(Gather ins);
	
	void editGather(Gather ins);
	
	void deleteGather(@Param("id")BigInteger id);
}
