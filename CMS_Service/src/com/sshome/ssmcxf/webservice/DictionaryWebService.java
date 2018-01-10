package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Dictionarys;

@WebService
public interface DictionaryWebService {

	/**
	 * 获取字典信息
	 * @param page
	 * @param str
	 * @return
	 */
	List<Dictionarys> getAllDictionary(@WebParam(name="object")String object);
	
    boolean addDictionary(@WebParam(name="object")String object);
	
    boolean editDictionary(@WebParam(name="object")String object);
	
	Dictionarys getDictionaryByFid(@WebParam(name="object")String object);
	
	boolean deleteDictionary(@WebParam(name="object")String object);
	
	/**
	 * 获取字典值及值名称
	 * @param typeid 类型id
	 * @return
	 */
	List<Dictionarys> getDictionaryValue(@WebParam(name="object")String object);
	
	/**
	 * 根据类型值及字典值获取字典值及值名称
	 * @param typeid 类型值
	 * @param value 字典值
	 * @return
	 */
	List<Dictionarys> getDicValueByValue(@WebParam(name="object")String object);
	
	/**
	 * 根据值名称获取值
	 * @param valuename 值名称
	 * @return
	 */
	int getvaluebyname(@WebParam(name="object")String object);
	
}
