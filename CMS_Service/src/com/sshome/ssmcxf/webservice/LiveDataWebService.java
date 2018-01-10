package com.sshome.ssmcxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.dto.ModelDto;
import com.spring.model.LiveData;

@WebService
public interface LiveDataWebService {
	/**
	 * 查询事业部焊接工时
	 * @param dto扩展参数类
	 * @param parent 父id
	 * @return
	 */
	List<ModelDto> getCausehour(@WebParam(name="object")String object);
	
	/**
	 * 查询公司焊接工时
	 * @param dto扩展参数类
	 * @param parent父id
	 * @return
	 */
	List<ModelDto> getCompanyhour(@WebParam(name="object")String object);
	
	/**
	 * 项目部焊接工时
	 * @param dto扩展参数类
	 * @return
	 */
	List<ModelDto> getItemhour(@WebParam(name="object")String object);
	
	/**
	 * 焊口焊接工时
	 * @param dto扩展参数类
	 * @return
	 */
	List<ModelDto> getJunctionHous(@WebParam(name="object")String object);
	
	/**
	 * 事业部工艺超标统计
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	List<ModelDto> getCauseOverproof(@WebParam(name="object")String object);
	
	/**
	 * 项目部工艺超标统计
	 * @param dto 扩展参数类
	 * @param id 项目id
	 * @return
	 */
	List<ModelDto> getItemOverproof(@WebParam(name="object")String object);
	
	/**
	 * 获取当前所包含的项目
	 * @param parent 上级项目id
	 * @return
	 */
	List<LiveData> getAllInsf(@WebParam(name="object")String object);
	
	/**
	 * 获取当前跨度所包含的时间
	 * @param dto 扩展参数类
	 * @return
	 */
	List<LiveData> getAllTime(@WebParam(name="object")String object);
	
	/**
	 * 公司工艺超标统计
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getCompanyOverproof(@WebParam(name="object")String object);
	
	/**
	 * 超标明细
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getDatailOverproof(@WebParam(name="object")String object);
	
	/**
	 * 获取某焊工在某个时间/焊机/焊口的总工时
	 * @param welderno焊工编号
	 * @param machineno焊机编号
	 * @param junctionno焊口编号
	 * @param time时间
	 * @return
	 */
	int getCountTime(@WebParam(name="object")String object);
	
	/**
	 * 获取焊机超标
	 * @param welderno焊工编号
	 * @param machineno焊机编号
	 * @param junctionno焊口编号
	 * @param time时间
	 * @return
	 */
	List<ModelDto> getjunctionoverproof(@WebParam(name="object")String object);
	
	/**
	 * 获取公司超时待机统计
	 * @param dto 扩展参数类
	 * @param num 超时点
	 * @return
	 */
	List<ModelDto> getcompanyOvertime(@WebParam(name="object")String object);
	
	/**
	 * 获取事业部超时待机统计
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent上级id
	 * @return
	 */
	List<ModelDto> getCaustOvertime(@WebParam(name="object")String object);
	
	/**
	 * 获取项目部超时待机统计
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent上级id
	 * @return
	 */
	List<ModelDto> getItemOvertime(@WebParam(name="object")String object);
	
	/**
	 * 获取所有焊口
	 * @param parent 所属项目id
	 * @return
	 */
	List<LiveData> getJunction(@WebParam(name="object")String object);
	
	/**
	 * 待机明细
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent 项目id
	 * @return
	 */
	List<ModelDto> getDetailovertime(@WebParam(name="object")String object);
	
	/**
	 * 公司负荷率
	 * @param dto扩展参数类
	 * @return
	 */
	List<ModelDto> getCompanyLoads(@WebParam(name="object")String object);
	
	/**
	 * 事业部负荷率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	List<ModelDto> getCaustLoads(@WebParam(name="object")String object);
	
	/**
	 * 项目部负荷率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	List<ModelDto> getItemLoads(@WebParam(name="object")String object);
	
	/**
	 * 获取所有焊机
	 * @param parent 项目id
	 * @param dto扩展参数类
	 * @return
	 */
	List<LiveData> getMachine(@WebParam(name="object")String object);
	
	/**
	 * 获取负荷率明细
	 * @param dto扩展参数类
	 * @param machineno焊机编号
	 * @return
	 */
	List<ModelDto> getDetailLoads(@WebParam(name="object")String object);
	
	/**
	 * 获取公司空载率
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getCompanyNoLoads(@WebParam(name="object")String object);

	/**
	 * 获取事业部空载率
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	List<ModelDto> getCaustNOLoads(@WebParam(name="object")String object);
	
	/**
	 * 获取项目部空载率
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	List<ModelDto> getItemNOLoads(@WebParam(name="object")String object);
	
	/**
	 * 公司闲置率
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getCompanyIdle(@WebParam(name="object")String object);
	
	/**
	 * 事业部闲置率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	List<ModelDto> getCaustIdle(@WebParam(name="object")String object);
	
	/**
	 * 项目部闲置率
	 * @param dto扩展参数类
	 * @param itemid项目id
	 * @return
	 */
	List<ModelDto> getItemIdle(@WebParam(name="object")String object);
	
	/**
	 * 获取项目所有焊机数量
	 * @param id 项目id
	 * @return
	 */
	int getMachineCount(@WebParam(name="object")String object);
	
	/**
	 * 公司单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param parent 上级id
	 * @return
	 */
	List<ModelDto> getCompanyUse(@WebParam(name="object")String object);
	
	/**
	 * 事业部单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param insid 项目id
	 * @return
	 */
	List<ModelDto> getCaustUse(@WebParam(name="object")String object);
	

	/**
	 * 项目部单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param insid 项目id
	 * @return
	 */
	List<ModelDto> getItemUse(@WebParam(name="object")String object);
	
	/**
	 * 集团焊接工时
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getBlochour(@WebParam(name="object")String object);
	
	/**
	 * 集团超标统计
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getBlocOverproof(@WebParam(name="object")String object);
	
	/**
	 * 集团超时待机统计
	 * @param dto 扩展参数类
	 * @param num 超时点
	 * @return
	 */
	List<ModelDto> getBlocOvertime(@WebParam(name="object")String object);
	
	/**
	 * 集团负载率
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getBlocLoads(@WebParam(name="object")String object);
	
	/**
	 * 集团空载率
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getBlocNoLoads(@WebParam(name="object")String object);
	
	/**
	 * 集团闲置率
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> getBlocIdle(@WebParam(name="object")String object);
	
	/**
	 * 集团单台设备运行数据统计
	 * @param dto  扩展参数类
	 * @param parent 上级的父id
	 * @return
	 */
	List<ModelDto> getBlocUse(@WebParam(name="object")String object);
	
	/**
	 * 获取集团下的公司
	 * @return
	 */
	List<LiveData> getBlocChildren();
	
	/**
	 * 事业部工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> caustEfficiency(@WebParam(name="object")String object);
	
	/**
	 * 公司工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> companyEfficiency(@WebParam(name="object")String object);
	
	/**
	 * 集团工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	List<ModelDto> blocEfficiency(@WebParam(name="object")String object);
	
	/**
	 * 获取工效图表数据
	 */
	List<ModelDto> getEfficiencyChart(@WebParam(name="object")String object);
	
	/**
	 * 获取焊口分类
	 * @param parent 父id
	 * @param material 材质
	 * @param external_diameter 外径
	 * @param wall_thickness 璧厚
	 * @param nextExternal_diameter 下游外径
	 * @return
	 */
	List<ModelDto> getHousClassify(@WebParam(name="object")String object);
	
	List<ModelDto> getDetailNoLoads(@WebParam(name="object")String object);
}
