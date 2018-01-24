package com.sshome.ssmcxf.webservice;

import java.util.List;

import com.spring.dto.ModelDto;

public interface LiveDataWebService {
	/**
	 * 查询事业部焊接工时
	 * @param dto扩展参数类
	 * @param parent 父id
	 * @return
	 */
	Object getCausehour(String object);
	
	/**
	 * 查询公司焊接工时
	 * @param dto扩展参数类
	 * @param parent父id
	 * @return
	 */
	Object getCompanyhour(String object);
	
	/**
	 * 项目部焊接工时
	 * @param dto扩展参数类
	 * @return
	 */
	Object getItemhour(String object);
	
	/**
	 * 焊口焊接工时
	 * @param dto扩展参数类
	 * @return
	 */
	Object getJunctionHous(String object);
	
	/**
	 * 事业部工艺超标统计
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	Object getCauseOverproof(String object);
	
	/**
	 * 项目部工艺超标统计
	 * @param dto 扩展参数类
	 * @param id 项目id
	 * @return
	 */
	Object getItemOverproof(String object);
	
	/**
	 * 获取当前所包含的项目
	 * @param parent 上级项目id
	 * @return
	 */
	Object getAllInsf(String object);
	
	/**
	 * 获取当前跨度所包含的时间
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getAllTime(String object);
	
	/**
	 * 公司工艺超标统计
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getCompanyOverproof(String object);
	
	/**
	 * 超标明细
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getDatailOverproof(String object);
	
	/**
	 * 获取某焊工在某个时间/焊机/焊口的总工时
	 * @param welderno焊工编号
	 * @param machineno焊机编号
	 * @param junctionno焊口编号
	 * @param time时间
	 * @return
	 */
	int getCountTime(String object);
	
	/**
	 * 获取焊机超标
	 * @param welderno焊工编号
	 * @param machineno焊机编号
	 * @param junctionno焊口编号
	 * @param time时间
	 * @return
	 */
	Object getjunctionoverproof(String object);
	
	/**
	 * 获取公司超时待机统计
	 * @param dto 扩展参数类
	 * @param num 超时点
	 * @return
	 */
	Object getcompanyOvertime(String object);
	
	/**
	 * 获取事业部超时待机统计
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent上级id
	 * @return
	 */
	Object getCaustOvertime(String object);
	
	/**
	 * 获取项目部超时待机统计
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent上级id
	 * @return
	 */
	Object getItemOvertime(String object);
	
	/**
	 * 获取所有焊口
	 * @param parent 所属项目id
	 * @return
	 */
	Object getJunction(String object);
	
	/**
	 * 待机明细
	 * @param dto扩展参数类
	 * @param num超时点
	 * @param parent 项目id
	 * @return
	 */
	Object getDetailovertime(String object);
	
	/**
	 * 公司负荷率
	 * @param dto扩展参数类
	 * @return
	 */
	Object getCompanyLoads(String object);
	
	/**
	 * 事业部负荷率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	Object getCaustLoads(String object);
	
	/**
	 * 项目部负荷率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	Object getItemLoads(String object);
	
	/**
	 * 获取所有焊机
	 * @param parent 项目id
	 * @param dto扩展参数类
	 * @return
	 */
	Object getMachine(String object);
	
	/**
	 * 获取负荷率明细
	 * @param dto扩展参数类
	 * @param machineno焊机编号
	 * @return
	 */
	Object getDetailLoads(String object);
	
	/**
	 * 获取公司空载率
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getCompanyNoLoads(String object);

	/**
	 * 获取事业部空载率
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	Object getCaustNOLoads(String object);
	
	/**
	 * 获取项目部空载率
	 * @param dto 扩展参数类
	 * @param parent 父id
	 * @return
	 */
	Object getItemNOLoads(String object);
	
	/**
	 * 公司闲置率
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getCompanyIdle(String object);
	
	/**
	 * 事业部闲置率
	 * @param dto扩展参数类
	 * @param parent上级id
	 * @return
	 */
	Object getCaustIdle(String object);
	
	/**
	 * 项目部闲置率
	 * @param dto扩展参数类
	 * @param itemid项目id
	 * @return
	 */
	Object getItemIdle(String object);
	
	/**
	 * 获取项目所有焊机数量
	 * @param id 项目id
	 * @return
	 */
	int getMachineCount(String object);
	
	/**
	 * 公司单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param parent 上级id
	 * @return
	 */
	Object getCompanyUse(String object);
	
	/**
	 * 事业部单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param insid 项目id
	 * @return
	 */
	Object getCaustUse(String object);
	

	/**
	 * 项目部单台设备运行数据统计
	 * @param dto 扩展参数类
	 * @param insid 项目id
	 * @return
	 */
	Object getItemUse(String object);
	
	/**
	 * 集团焊接工时
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getBlochour(String object);
	
	/**
	 * 集团超标统计
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getBlocOverproof(String object);
	
	/**
	 * 集团超时待机统计
	 * @param dto 扩展参数类
	 * @param num 超时点
	 * @return
	 */
	Object getBlocOvertime(String object);
	
	/**
	 * 集团负载率
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getBlocLoads(String object);
	
	/**
	 * 集团空载率
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getBlocNoLoads(String object);
	
	/**
	 * 集团闲置率
	 * @param dto 扩展参数类
	 * @return
	 */
	Object getBlocIdle(String object);
	
	/**
	 * 集团单台设备运行数据统计
	 * @param dto  扩展参数类
	 * @param parent 上级的父id
	 * @return
	 */
	Object getBlocUse(String object);
	
	/**
	 * 获取集团下的公司
	 * @return
	 */
	Object getBlocChildren();
	
	/**
	 * 事业部工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	Object caustEfficiency(String object);
	
	/**
	 * 公司工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	Object companyEfficiency(String object);
	
	/**
	 * 集团工效
	 * @param page 分页
	 * @param parent 父id
	 * @param dto 扩展参数类
	 * @return
	 */
	Object blocEfficiency(String object);
	
	/**
	 * 获取工效图表数据
	 */
	Object getEfficiencyChart(String object);
	
	/**
	 * 获取焊口分类
	 * @param parent 父id
	 * @param material 材质
	 * @param external_diameter 外径
	 * @param wall_thickness 璧厚
	 * @param nextExternal_diameter 下游外径
	 * @return
	 */
	Object getHousClassify(String object);
	
	Object getDetailNoLoads(String object);
	

	/**
	 * 查询实时数据集团焊机数量
	 * @param dto 扩张参数类
	 * @param parent 公司id
	 * @return
	 */
	Object getBlocMachineCount(String object);

	/**
	 * 查询实时数据公司焊机数量
	 * @param dto 扩张参数类
	 * @param parent 公司id
	 * @return
	 */
	Object getCompanyMachineCount(String object);

	/**
	 * 查询实时数据事业部/项目部焊机数量
	 * @param dto 扩张参数类
	 * @param parent 公司id
	 * @return
	 */
	Object getCaustMachineCount(String object);
}
