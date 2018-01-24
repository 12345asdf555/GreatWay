package com.greatway.dao;

import java.math.BigInteger;

import com.spring.model.Report;

public interface ReportMapper {
	BigInteger getWpsid(BigInteger machid);
	Report getWps(BigInteger wpsid);
	Report getSyspara();
}
