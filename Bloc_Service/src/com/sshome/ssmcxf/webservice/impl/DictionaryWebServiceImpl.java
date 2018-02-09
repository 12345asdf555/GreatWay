package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.model.Dictionarys;
import com.spring.model.Insframework;
import com.spring.service.DictionaryService;
import com.spring.service.InsframeworkService;
import com.sshome.ssmcxf.webservice.DictionaryWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class DictionaryWebServiceImpl implements DictionaryWebService{

	@Autowired
	private DictionaryService ds;

	@Autowired
	private InsframeworkService is;
	
	@Override
	public Object getAllDictionary(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getAllDictionary(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addDictionary(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			JSONObject json = JSONObject.fromObject(obj2);
			Dictionarys d = new Dictionarys();
			d.setBack(json.getString("BACK"));
			d.setTypeid(json.getInt("TYPEID"));
			d.setValueName(json.getString("VALUENAME"));
			d.setCreator(json.getString("CREATOR"));
			boolean flag = ds.addDictionary(d);
			obj2 = obj2.substring(0,obj2.length()-1)+",\"ID\":\""+d.getId()+"\"}";
			//获取集团下所有公司
			List<Insframework> company = is.getConmpany();
			for(Insframework i:company){
				Client companyclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(i.getId().toString()));
				Object[] companyobj = companyclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
				companyobj[0].toString();
			}
			List<Insframework> item = is.getInsByType(23);
			//获取公司下所有项目部
			for(Insframework insf:item){
				Client itemclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(insf.getId().toString()));
				Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2}); 
				itemobj[0].toString();
			}
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editDictionary(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			JSONObject json = JSONObject.fromObject(obj2);
			Dictionarys d = new Dictionarys();
			d.setId(new BigInteger(json.getString("ID")));
			d.setBack(json.getString("BACK"));
			d.setTypeid(json.getInt("TYPEID"));
			d.setValueName(json.getString("VALUENAME"));
			d.setModifier(json.getString("MODIFIER"));
			boolean flag = ds.editDictionary(d);
			//获取集团下所有公司
			List<Insframework> company = is.getConmpany();
			for(Insframework i:company){
				Client companyclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(i.getId().toString()));
				Object[] companyobj = companyclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
				companyobj[0].toString();
			}
			List<Insframework> item = is.getInsByType(23);
			//获取公司下所有项目部
			for(Insframework insf:item){
				Client itemclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(insf.getId().toString()));
				Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2}); 
				itemobj[0].toString();
			}
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object getDictionaryByFid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Dictionarys list = ds.getDictionaryByFid(json.getInt("ID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean deleteDictionary(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			JSONObject json = JSONObject.fromObject(obj2);
			boolean flag = ds.deleteDictionary(json.getInt("ID"));
			//获取集团下所有公司
			List<Insframework> company = is.getConmpany();
			for(Insframework i:company){
				Client companyclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(i.getId().toString()));
				Object[] companyobj = companyclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
				companyobj[0].toString();
			}
			List<Insframework> item = is.getInsByType(23);
			//获取公司下所有项目部
			for(Insframework insf:item){
				Client itemclient = dcf.createClient(request.getSession().getServletContext().getInitParameter(insf.getId().toString()));
				Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2}); 
				itemobj[0].toString();
			}
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object getDictionaryValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getDictionaryValue(json.getInt("TYPEID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDicValueByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Dictionarys> list = ds.getDicValueByValue(json.getInt("TYPEID"), json.getInt("VALUE"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getvaluebyname(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ds.getvaluebyname(json.getInt("TYPEID"), json.getString("VALUENAME"));
		}catch(Exception e){
			return -1;
		}
	}

}
