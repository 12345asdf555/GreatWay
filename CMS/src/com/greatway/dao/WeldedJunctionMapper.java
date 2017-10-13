package com.greatway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.WeldedJunction;

import tk.mybatis.mapper.common.Mapper;

public interface WeldedJunctionMapper extends Mapper<WeldedJunction>{
	List<WeldedJunction> getWeldedJunctionAll(@Param("str")String str);
}
