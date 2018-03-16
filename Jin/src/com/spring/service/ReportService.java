package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.dto.WeldDto;
import com.greatway.page.Page;
import com.spring.model.Report;

public interface ReportService {
	BigInteger getWpsid(BigInteger machid);
	Report getWps(String wpsid);
	Report getSyspara();
	List<Report> findAllWelder(Page page, BigInteger iid,String str);
	List<Report> findMachine(String weldid);
	long getWeldingTime(WeldDto dto,BigInteger machid,String weldid);
	long getOnTime(WeldDto dto,BigInteger machid);
	long getRealEle(WeldDto dto,BigInteger machid);
	long getRealVol(WeldDto dto,BigInteger machid);
	long getHjTime(BigInteger machid,String time);
	long getZxTime(BigInteger machid,String time);
	String getFirstTime(BigInteger machid,String time);
	List<Report> getAllPara(Page page, BigInteger parent,String str,String time);
	List<Report> historyData(WeldDto dto,String fid);
}
