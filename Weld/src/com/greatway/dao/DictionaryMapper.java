package com.greatway.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.model.Dictionarys;

import tk.mybatis.mapper.common.Mapper;

public interface DictionaryMapper extends Mapper<Dictionarys> {
	List<Dictionarys> getDictionaryAll(@Param("dto") Dictionarys dto);
	
	void addDictionary(Dictionarys d);
	
	void editDictionary(Dictionarys d);
	
	BigInteger getDictionaryByValue(@Param("value")int value);
	
}
