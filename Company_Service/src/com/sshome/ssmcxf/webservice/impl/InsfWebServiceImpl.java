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
import com.spring.model.Gather;
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
	public boolean addInsframework(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			//向集团层执行插入
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client blocclient = dcf.createClient(request.getSession().getServletContext().getInitParameter("blocurl"));
			Object[] blocobj = blocclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
			BigInteger id = new BigInteger(blocobj[0].toString());
			JSONObject json = JSONObject.fromObject(obj2);
			Insframework i = new Insframework();
			i.setId(id);
			i.setName(json.getString("NAME"));
			i.setLogogram(json.getString("LOGOGRAM"));
			i.setCode(json.getString("CODE"));
			i.setParent(new BigInteger(json.getString("PARENT")));
			i.setType(json.getInt("TYPEID"));
			i.setCreator(json.getString("CREATOR"));
			boolean flag = is.addInsframework(i);
			if(flag){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean editInsframework(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			//向集团层执行操作
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client blocclient = dcf.createClient(request.getSession().getServletContext().getInitParameter("blocurl"));
			Object[] blocobj = blocclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
			String blocResult = blocobj[0].toString();
			JSONObject json = JSONObject.fromObject(obj2);
			//获取层级id
			String hierarchy = json.getString("HIERARCHY");
			String itemurl = "";
			boolean resultflag = false;
			if(hierarchy.equals("4")){
				itemurl = json.getString("ITEMURL");
			}else{
				int typeid = json.getInt("TYPEID");
				Insframework i = new Insframework();
				i.setId(new BigInteger(json.getString("INSFID")));
				i.setName(json.getString("NAME"));
				i.setLogogram(json.getString("LOGOGRAM"));
				i.setCode(json.getString("CODE"));
				i.setParent(new BigInteger(json.getString("PARENT")));
				i.setType(json.getInt("TYPEID"));
				i.setModifier(json.getString("MODIFIER"));
				boolean flag = is.editInsframework(i);
				boolean result = true;
				if(typeid==23){
					BigInteger insfid = new BigInteger(json.getString("INSFID"));
					itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
					//向项目执行操作
					Client itemclient = dcf.createClient(itemurl);
					Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
					String str = itemobj[0].toString();
					if(!str.equals("true")){
						result = false;
					}
				}
				if(flag && result && blocResult.equals("true")){
					resultflag = true;
				}
			}
			return resultflag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteInsframework(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			//向集团层执行操作
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client blocclient = dcf.createClient(request.getSession().getServletContext().getInitParameter("blocurl"));
			Object[] blocobj = blocclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
			String blocResult = blocobj[0].toString();
			JSONObject json = JSONObject.fromObject(obj2);
			//获取层级id
			String hierarchy = json.getString("HIERARCHY");
			String itemurl = "";
			boolean resultflag = false;
			if(hierarchy.equals("4")){
				itemurl = json.getString("ITEMURL");
			}else{
				int type = json.getInt("TYPE");
				boolean flag = is.deleteInsframework(new BigInteger(json.getString("INSFID")));
				boolean result = true;
				if(type==23){
					BigInteger insfid = new BigInteger(json.getString("INSFID"));
					itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
					//向项目执行操作
					Client itemclient = dcf.createClient(itemurl);
					Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
					String str = itemobj[0].toString();
					if(!str.equals("true")){
						result = false;
					}
				}
				if(flag && result && blocResult.equals("true")){
					resultflag = true;
				}
			}
			return resultflag;
		}catch(Exception e){
			e.printStackTrace();
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
