package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Insframework;
import com.spring.service.InsframeworkService;
import com.sshome.ssmcxf.webservice.InsfWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.InsfWebService", serviceName = "InsfWebService")
public class insfWebServiceImpl implements InsfWebService {
	@Autowired
	private InsframeworkService is;
	
	@Override
	public List<Insframework> getInsframeworkAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsframeworkAll(new BigInteger(json.getString("insfId")), json.getString("str"));
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
			i.setName(json.getString("name"));
			i.setLogogram(json.getString("logogram"));
			i.setCode(json.getString("code"));
			i.setParent(new BigInteger(json.getString("parent")));
			i.setType(json.getInt("typeId"));
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
			i.setId(new BigInteger(json.getString("insfId")));
			i.setName(json.getString("name"));
			i.setLogogram(json.getString("logogram"));
			i.setCode(json.getString("code"));
			i.setParent(new BigInteger(json.getString("parent")));
			i.setType(json.getInt("typeId"));
			return is.editInsframework(i);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteInsframework(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.deleteInsframework(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public int getInsframeworkNameCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsframeworkNameCount(json.getString("name"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public String getInsframeworkById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsframeworkById(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Insframework getInsfAllById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsfAllById(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Insframework getBloc() {
		try{
			return is.getBloc();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Insframework> getCompany() {
		try{
			return is.getConmpany();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Insframework> getCause(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getCause(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Insframework> getWeldingMachineInsf(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getWeldingMachineInsf(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Insframework getParent(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getParent(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Insframework> getInsByType(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsByType(json.getInt("typeId"), new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getUserInsfType(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getUserInsfType(new BigInteger(json.getString("userId")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getUserInsfId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getUserInsfId(new BigInteger(json.getString("userId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getTypeById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getTypeById(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getParentById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getParentById(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Insframework> getInsByUserid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return is.getInsByUserid(new BigInteger(json.getString("userId")));
		}catch(Exception e){
			return null;
		}
	}
}
