package com.spring.service.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatway.dao.ReportMapper;
import com.spring.model.Report;
import com.spring.service.ReportService;

@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class ReportServiceImpl implements ReportService{

	@Resource
	private ReportMapper mapper;
	
	@Override
	public BigInteger getWpsid(BigInteger machid) {
		// TODO Auto-generated method stub
		return mapper.getWpsid(machid);
	}

	@Override
	public Report getWps(BigInteger wpsid) {
		// TODO Auto-generated method stub
		return mapper.getWps(wpsid);
	}

	@Override
	public Report getSyspara() {
		// TODO Auto-generated method stub
		return mapper.getSyspara();
	}

}
