package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Dictionarys;
import com.spring.service.DictionaryService;
import com.sshome.ssmcxf.webservice.DictionaryWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class DictionaryWebServiceImpl implements DictionaryWebService{

	@Autowired
	private DictionaryService ds;
	
	@Override
	public Object getAllDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getAllDictionary(json.getString("str"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Dictionarys d = new Dictionarys();
			d.setBack(json.getString("back"));
			d.setTypeid(json.getInt("typeId"));
			d.setValueName(json.getString("valueName"));
			return ds.addDictionary(d);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Dictionarys d = new Dictionarys();
			d.setId(new BigInteger(json.getString("id")));
			d.setBack(json.getString("back"));
			d.setTypeid(json.getInt("typeId"));
			d.setValueName(json.getString("valueName"));
			return ds.editDictionary(d);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object getDictionaryByFid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Dictionarys list = ds.getDictionaryByFid(json.getInt("id"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean deleteDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.deleteDictionary(json.getInt("id"));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object getDictionaryValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getDictionaryValue(json.getInt("typeId"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDicValueByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getDicValueByValue(json.getInt("typeId"), json.getInt("value"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getvaluebyname(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getvaluebyname(json.getInt("typeId"), json.getString("valueName"));
		}catch(Exception e){
			return -1;
		}
	}

}
