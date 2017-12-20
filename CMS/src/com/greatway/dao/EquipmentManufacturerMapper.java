package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.EquipmentManufacturer;

import tk.mybatis.mapper.common.Mapper;

public interface EquipmentManufacturerMapper extends Mapper<EquipmentManufacturer> {
	List<EquipmentManufacturer> getmanuAll();

	BigInteger getManuidByValue(@Param("value")String value,@Param("type")String type);
}
