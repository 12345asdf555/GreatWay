package com.sshome.ssmcxf.webservice;

public interface DictionaryWebService {

	/**
	 * 获取字典信息
	 * @param page
	 * @param str
	 * @return
	 */
	Object getAllDictionary(String object);
	
    boolean addDictionary(String obj1,String obj2);
	
    boolean editDictionary(String obj1,String obj2);
	
    Object getDictionaryByFid(String object);
	
	boolean deleteDictionary(String obj1,String obj2);
	
	/**
	 * 获取字典值及值名称
	 * @param typeid 类型id
	 * @return
	 */
	Object getDictionaryValue(String object);
	
	/**
	 * 根据类型值及字典值获取字典值及值名称
	 * @param typeid 类型值
	 * @param value 字典值
	 * @return
	 */
	Object getDicValueByValue(String object);
	
	/**
	 * 根据值名称获取值
	 * @param valuename 值名称
	 * @return
	 */
	int getvaluebyname(String object);
	
	/**
	 * 根据值获取值名称
	 * @param object 值id
	 * @return
	 */
	Object getDicValueByType(String object);
	
}
