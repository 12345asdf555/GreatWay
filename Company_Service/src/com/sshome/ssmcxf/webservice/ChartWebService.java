package com.sshome.ssmcxf.webservice;

public interface ChartWebService {
	/**
	 * 工效
	 * @param object
	 * @return
	 */
	String getEfficiency(String object);
	
	/**
	 * 工时
	 * @param object
	 * @return
	 */
	String getHour(String object);
	
	/**
	 * 工时-获取所有焊口分类
	 * @param object
	 * @return
	 */
	String getHourClassify(String object);
	
	/**
	 * 工艺超标
	 * @param Object
	 * @return
	 */
	String getOverproof(String object);
	
	/**
	 * 超时待机
	 * @param object
	 * @return
	 */
	String getOvertime(String object);
	
	/**
	 * 负荷率
	 * @param object
	 * @return
	 */
	String getLoads(String object);
	
	/**
	 * 空载率
	 * @param object
	 * @return
	 */
	String getNoLoads(String object);
	
	/**
	 * 闲置率
	 * @param object
	 * @return
	 */
	String getIdle(String object);
	
	/**
	 * 单台设备运行数据统计
	 * @param object
	 * @return
	 */
	String getUse(String object);
}
