package com.spring.service;

import java.math.BigInteger;

import com.spring.model.Report;

public interface ReportService {
	BigInteger getWpsid(BigInteger machid);
	Report getWps(BigInteger wpsid);
	Report getSyspara();
}
