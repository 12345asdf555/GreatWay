package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.WeldedJunction;

import tk.mybatis.mapper.common.Mapper;

public interface WeldedJunctionMapper extends Mapper<WeldedJunction>{
	List<WeldedJunction> getWeldedJunctionAll(@Param("str")String str);
	List<WeldedJunction> getWeldingJun(@Param("str")String str,@Param("welderid")BigInteger welderid);
	WeldedJunction getWeldedJunctionById(@Param("id")BigInteger id);
}
