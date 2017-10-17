package com.greatway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.model.Td;

public interface TdMapper {
	List<Td> findAll(@Param("str")String str);
	List<Td> findAllpro();
	List<Td> findAllcom();
	List<Td> findAlldiv(long ins);
	long findAllIns(long uid);
}
