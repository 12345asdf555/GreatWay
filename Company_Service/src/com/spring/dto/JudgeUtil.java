package com.spring.dto;

public class JudgeUtil {
	/**
	 * 判断值是否为null，是则返回""，用于处理json的值为null时自动隐藏
	 * @param obj
	 * @return
	 */
	public Object setValue(Object obj){
		if(obj == null){
			obj = "";
		}
		return obj;
	}
}
