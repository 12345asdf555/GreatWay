package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Dictionarys;
import com.spring.service.DictionaryService;
import com.sshome.ssmcxf.webservice.DictionaryWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.DictionaryWebService", serviceName = "DictionaryWebService")
public class DictionaryWebServiceImpl implements DictionaryWebService{

	@Autowired
	private DictionaryService ds;
	
	@Override
	public List<Dictionarys> getAllDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getAllDictionary(json.getString("str"));
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
	public Dictionarys getDictionaryByFid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getDictionaryByFid(json.getInt("id"));
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
	public List<Dictionarys> getDictionaryValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getDictionaryValue(json.getInt("typeId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Dictionarys> getDicValueByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getDicValueByValue(json.getInt("typeId"), json.getInt("value"));
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
