package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.model.Gather;

@WebService
public interface GatherWebService {
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
