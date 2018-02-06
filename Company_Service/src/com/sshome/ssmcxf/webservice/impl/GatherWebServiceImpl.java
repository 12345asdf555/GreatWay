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
import com.spring.service.GatherService;
import com.sshome.ssmcxf.webservice.GatherWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class GatherWebServiceImpl implements GatherWebService{

	@Autowired
	private GatherService gs;
	
	@Override
	public Object getGatherAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<Gather> list = gs.getGatherAll(json.getString("STR"), new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BigInteger getGatherByNo(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherByNo(json.getString("GATHERNO"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getGatherNoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return gs.getGatherNoCount(json.getString("GATHERNO"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getGatherById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			Gather list = gs.getGatherById(new BigInteger(json.getString("ID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean addGather(String obj1,String obj2) {
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
			//获取层级id
			String hierarchy = json.getString("HIERARCHY");
			String itemurl = "";
			if(hierarchy.equals("4")){
				itemurl = json.getString("ITEMURL");
			}else{
				BigInteger insfid = new BigInteger(json.getString("INSFID"));
				itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
			}
			Gather g = new Gather();
			g.setId(id);
			g.setGatherNo(json.getString("GATHERNO"));
			g.setIpurl(json.getString("IPURL"));
			g.setItemid(new BigInteger(json.getString("INSFID")));
			String leavetime =json.getString("LEAVETIME");
			if(leavetime!=null && !"".equals(leavetime)){
				g.setLeavetime(leavetime);
			}
			g.setMacurl(json.getString("MACURL"));
			g.setProtocol(json.getString("PROTOCOL"));
			g.setStatus(json.getString("STATUS"));
			g.setCreator(json.getString("CREATOR"));
			boolean flag = gs.addGather(g);
			//向项目执行插入
			Client itemclient = dcf.createClient(itemurl);
			obj2 = obj2.substring(0,obj2.length()-1)+",\"ID\":\""+id+"\"}";
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && result.equals("true")){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editGather(String obj1,String obj2) {
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
			if(hierarchy.equals("4")){
				itemurl = json.getString("ITEMURL");
			}else{
				BigInteger insfid = new BigInteger(json.getString("INSFID"));
				itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
			}
			Gather g = new Gather();
			g.setId(new BigInteger(json.getString("ID")));
			g.setGatherNo(json.getString("GATHERNO"));
			g.setIpurl(json.getString("IPURL"));
			g.setItemid(new BigInteger(json.getString("INSFID")));
			String leavetime =json.getString("LEAVETIME");
			if(leavetime!=null && !"".equals(leavetime)){
				g.setLeavetime(leavetime);
			}
			g.setMacurl(json.getString("MACURL"));
			g.setProtocol(json.getString("PROTOCOL"));
			g.setStatus(json.getString("STATUS"));
			g.setModifier(json.getString("MODIFIER"));
			boolean flag = gs.editGather(g);
			//向项目执行操作
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && result.equals("true") && blocResult.equals("true")){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteGather(String obj1,String obj2) {
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
			if(hierarchy.equals("4")){
				itemurl = json.getString("ITEMURL");
			}else{
				BigInteger insfid = new BigInteger(json.getString("INSFID"));
				itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
			}
			boolean flag = gs.deleteGather(new BigInteger(json.getString("ID")));
			//向项目执行操作
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			System.out.println("--------公司："+flag+"----------项目部："+result+"-------------------集团："+blocResult+"--------------------");
			if(flag && result.equals("true") && blocResult.equals("true")){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
