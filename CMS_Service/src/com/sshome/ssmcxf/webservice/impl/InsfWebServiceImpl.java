package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Insframework;
import com.spring.service.InsframeworkService;
import com.sshome.ssmcxf.webservice.InsfWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class InsfWebServiceImpl implements InsfWebService {
	@Autowired
	private InsframeworkService is;
	
	@Override
	public Object getInsframeworkAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Insframework> list = is.getInsframeworkAll(new BigInteger(json.getString("INSFID")), json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addInsframework(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Insframework i = new Insframework();
			i.setName(json.getString("NAME"));
			i.setLogogram(json.getString("LOGOGRAM"));
			i.setCode(json.getString("CODE"));
			i.setParent(new BigInteger(json.getString("PARENT")));
			i.setType(json.getInt("TYPEID"));
			i.setCreator(json.getString("CREATOR"));
			return is.addInsframework(i);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editInsframework(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Insframework i = new Insframework();
			i.setId(new BigInteger(json.getString("INSFID")));
			i.setName(json.getString("NAME"));
			i.setLogogram(json.getString("LOGOGRAM"));
			i.setCode(json.getString("CODE"));
			i.setParent(new BigInteger(json.getString("PARENT")));
			i.setType(json.getInt("TYPEID"));
			i.setModifier(json.getString("MODIFIER"));
			return is.editInsframework(i);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteInsframework(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.deleteInsframework(new BigInteger(json.getString("INSFID")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public int getInsframeworkNameCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsframeworkNameCount(json.getString("NAME"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public String getInsframeworkById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsframeworkById(new BigInteger(json.getString("INSFID")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getInsfAllById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Insframework list = is.getInsfAllById(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBloc() {
		try{
			Insframework list = is.getBloc();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompany() {
		try{
			 List<Insframework> list = is.getConmpany();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCause(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Insframework> list = is.getCause(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMachineInsf(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Insframework> list = is.getWeldingMachineInsf(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getParent(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Insframework list =  is.getParent(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getInsByType(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Insframework> list = is.getInsByType(json.getInt("TYPEID"), new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getUserInsfType(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getUserInsfType(new BigInteger(json.getString("USERID")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getUserInsfId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getUserInsfId(new BigInteger(json.getString("USERID")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getTypeById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getTypeById(new BigInteger(json.getString("INSFID")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getParentById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getParentById(new BigInteger(json.getString("INSFID")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getInsByUserid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Insframework> list = is.getInsByUserid(new BigInteger(json.getString("USERID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}
}
