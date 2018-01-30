package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.greatway.dto.WeldDto;
import com.greatway.page.Page;
import com.spring.model.Report;

public interface ReportService {
	BigInteger getWpsid(BigInteger machid);
	Report getWps(BigInteger wpsid);
	Report getSyspara();
	List<Report> findAllWelder(Page page, BigInteger iid,String str);
	List<Report> findMachine(String weldid);
	long getWeldingTime(WeldDto dto,BigInteger machid,String weldid);
	long getOnTime(WeldDto dto,BigInteger machid);
	long getRealEle(WeldDto dto,BigInteger machid);
	long getRealVol(WeldDto dto,BigInteger machid);
}
