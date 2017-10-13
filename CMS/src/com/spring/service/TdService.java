package com.spring.service;

import java.util.List;

import com.greatway.page.Page;
import com.spring.model.Td;

public interface TdService {

	List<Td> findAll(Page page, String str);
	List<Td> findAllpro();
	List<Td> findAllcom();
}
