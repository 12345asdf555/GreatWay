package com.spring.service;

import java.math.BigInteger;
import java.util.List;

import com.greatway.page.Page;
import com.spring.model.Person;

public interface PersonService {

	List<Person> findAll(Page page, BigInteger parent,String str);
	List<Person> findLeve(int type);
	List<Person> dic();
	List<Person> ins();
	void save(Person welder);
	Person findById(BigInteger fid);
	int getUsernameCount(String welderno);
	void update(Person welder);
	void delete(BigInteger fid);
}