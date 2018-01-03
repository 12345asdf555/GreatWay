package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Dictionarys;
import com.spring.model.Gather;
import com.spring.model.Insframework;
import com.spring.service.DictionaryService;
import com.spring.service.GatherService;
import com.spring.service.InsframeworkService;
import com.sshome.ssmcxf.webservice.InsfWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.InsfWebService", serviceName = "InsfWebService")
public class insfWebServiceImpl implements InsfWebService {
	@Autowired
	private InsframeworkService is;
	
	@Autowired
	private DictionaryService ds;
	
	@Autowired
	private GatherService gs;
	
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

	//字典
	
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

	//采集
	
	@Override
	public List<Gather> getGatherAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherAll(json.getString("str"), new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BigInteger getGatherByNo(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherByNo(json.getString("gatherNo"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getGatherNoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherNoCount(json.getString("gatherNo"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Gather getGatherById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherById(new BigInteger(json.getString("id")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Gather g = new Gather();
			g.setGatherNo(json.getString("gatherNo"));
			g.setIpurl(json.getString("ipurl"));
			g.setItemid(new BigInteger(json.getString("insfId")));
			g.setLeavetime(json.getString("leavetime"));
			g.setMacurl(json.getString("macurl"));
			g.setProtocol(json.getString("protocol"));
			g.setStatus(json.getString("status"));
			return gs.addGather(g);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Gather g = new Gather();
			g.setId(new BigInteger(json.getString("id")));
			g.setGatherNo(json.getString("gatherNo"));
			g.setIpurl(json.getString("ipurl"));
			g.setItemid(new BigInteger(json.getString("insfId")));
			g.setLeavetime(json.getString("leavetime"));
			g.setMacurl(json.getString("macurl"));
			g.setProtocol(json.getString("protocol"));
			g.setStatus(json.getString("status"));
			return gs.editGather(g);
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean deleteGather(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.deleteGather(new BigInteger(json.getString("id")));
		}catch(Exception e){
			return false;
		}
	}
}
