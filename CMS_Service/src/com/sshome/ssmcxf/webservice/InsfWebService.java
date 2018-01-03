package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Dictionarys;
import com.spring.model.Gather;
import com.spring.model.Insframework;
@WebService
public interface InsfWebService {
	/**
	 * 获取组织机构
	 * @param str
	 * @return
	 */
	List<Insframework> getInsframeworkAll(@WebParam(name="object")String object);
	
	/**
	 * 新增组织机构
	 * @param ins
	 */
	boolean addInsframework(@WebParam(name="object")String object);
	/**
	 * 修改组织机构
	 * @param ins
	 */
	boolean editInsframework(@WebParam(name="object")String object);
	
	/**
	 * 删除组织机构
	 * @param id
	 */
	boolean deleteInsframework(@WebParam(name="object")String object);
	
	/**
	 * 判断name是否存在
	 * @param name 项目名称
	 * @return
	 */
	int getInsframeworkNameCount(@WebParam(name="object")String object);
	
	/**
	 * 根据id查找name
	 * @param id 项目id
	 * @return
	 */
	String getInsframeworkById(@WebParam(name="object")String object);
	
	/**
	 * 根据id查找所有
	 * @param id 组织机构id
	 * @return
	 */
	Insframework getInsfAllById(@WebParam(name="object")String object);
	
	/**
	 * 查看集团
	 * @return
	 */
	Insframework getBloc();
	/**
	 * 查看公司级
	 * @return
	 */
	List<Insframework> getCompany();
	
	/**
	 * 查看公司级子级
	 * @return
	 */
	List<Insframework> getCause(@WebParam(name="object")String object);
	
	/**
	 * 焊机获取项目
	 * @return
	 */
	List<Insframework> getWeldingMachineInsf(@WebParam(name="object")String object);
	
	/**
	 * 获取父级
	 * @param id 子级编号
	 * @return
	 */
	Insframework getParent(@WebParam(name="object")String object);
		
	/**
	 * 获取某层级的单位名称
	 * @param type单位类型
	 * @return
	 */
	List<Insframework> getInsByType(@WebParam(name="object")String object);
	
	/**
	 * 获取用户所属层级
	 * @param uid 用户id
	 * @return
	 */
	int getUserInsfType(@WebParam(name="object")String object);
	
	/**
	 * 获取用户所属部门id
	 * @param uid 用户id
	 * @return
	 */
	BigInteger getUserInsfId(@WebParam(name="object")String object);
	
	/**
	 * 根据id获取类型
	 * @param id
	 * @return
	 */
	int getTypeById(@WebParam(name="object")String object);
	
	/**
	 * 根据id获取父类
	 * @param id 自己的id
	 * @return
	 */
	BigInteger getParentById(@WebParam(name="object")String object);
	
	/**
	 * 根据用户id查找组织机构id及类型
	 * @param uid
	 * @return
	 */
	List<Insframework> getInsByUserid(@WebParam(name="object")String object);
	
	//字典
	
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
	

	//采集
	
	/**
	 * 查询采集列表
	 * @param str 查询信息
	 * @return
	 */
	List<Gather> getGatherAll(@WebParam(name="object")String object);
	
	/**
	 * 根据编号查询id
	 * @param gatherno采集编号
	 * @return
	 */
	BigInteger getGatherByNo(@WebParam(name="object")String object);
	
	/**
	 * 判断采集编号是否存在
	 * @param gatherno采集编号
	 * @return
	 */
	int getGatherNoCount(@WebParam(name="object")String object);
	
	/**
	 * 根据id查询采集信息
	 * @param id 采集id
	 * @return
	 */
	Gather getGatherById(@WebParam(name="object")String object);
	
	/**
	 * 添加采集信息
	 * @param ins采集对象
	 */
	boolean addGather(@WebParam(name="object")String object);
	
	/**
	 * 修改采集信息
	 * @param ins采集对象
	 */
	boolean editGather(@WebParam(name="object")String object);
	
	/**
	 * 删除采集信息
	 * @param id采集id
	 */
	boolean deleteGather(@WebParam(name="object")String object);
	
}
