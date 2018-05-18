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
import com.spring.model.MaintenanceRecord;
import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;
import com.spring.service.MaintainService;
import com.sshome.ssmcxf.webservice.MaintainWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class MaintainWebServiceImpl implements MaintainWebService {
	@Autowired
	private MaintainService ms;
	
	@Override
	public Object getWeldingMaintenanceAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getWeldingMaintenanceAll(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEndtime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getEndtime(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMaintenanceById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMaintenance list = ms.getWeldingMaintenanceById(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEquipmentno() {
		try{
			List<WeldingMachine> list = ms.getEquipmentno();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public boolean addMaintian(String obj1,String obj2) {
		try{
			//webservice获取request
			MessageContext ctx = new WebServiceContextImpl().getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
			//向集团层执行插入
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client blocclient = dcf.createClient(request.getSession().getServletContext().getInitParameter("blocurl"));
			//执行明细表插入
			String str = "{\"CLASSNAME\":\"maintainWebServiceImpl\",\"METHOD\":\"addMaintenanceRecord\"}";
			Object[] blocobj2 = blocclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{str,obj2});  
			BigInteger rid = new BigInteger(blocobj2[0].toString());
			//执行关联表的插入
			obj2 = obj2.substring(0,obj2.length()-1)+",\"RID\":\""+rid+"\"}";
			Object[] blocobj1 = blocclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
			BigInteger mid = new BigInteger(blocobj1[0].toString());
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

			WeldingMaintenance wm = new WeldingMaintenance();
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setId(new BigInteger(json.getString("RID")));
			mr.setViceman(json.getString("VICEMAN"));
			mr.setStartTime(json.getString("STARTTIME"));
			String endTime = json.getString("ENDTIME");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("ENDTIME"));
			}
			mr.setDesc(json.getString("DESC"));
			mr.setTypeId(json.getInt("TYPEID"));
			mr.setCreator(json.getString("CREATOR"));
			wm.setMaintenance(mr);
			wm.setCreator(json.getString("CREATOR"));
			WeldingMachine w = new WeldingMachine();
			BigInteger wid = new BigInteger(json.getString("WELDID"));
			w.setId(wid);
			wm.setWelding(w);
			wm.setId(mid);

			obj2 = obj2.substring(0,obj2.length()-1)+",\"MID\":\""+mid+"\"}";
			boolean flag = ms.addMaintenanceRecord(mr);
			boolean flags = ms.addMaintian(wm,mr,wid);
			//向项目执行插入
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && flags && result.equals("true")){
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
	public boolean updateEndtime(String obj1,String obj2) {
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
			boolean flag = ms.updateEndtime(new BigInteger(json.getString("MID")));
			BigInteger weldingid = new BigInteger(json.getString("WELDINGID"));
			List<WeldingMaintenance> list =  ms.getEndtime(weldingid);
			if(list.isEmpty()){
				//如果维修结束时间没有为空的则修改状态为启用
				ms.editstatus(weldingid, 31);
			}
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
			return false;
		}
	}

	@Override
	public boolean updateMaintenanceRecord(String obj1,String obj2) {
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
			MaintenanceRecord mr = new MaintenanceRecord();
			mr.setId(new BigInteger(json.getString("MID")));
			mr.setViceman(json.getString("VICEMAN"));
			mr.setStartTime(json.getString("STARTTIME"));
			String endTime = json.getString("ENDTIME");
			if(endTime!=null && !"".equals(endTime)){
				mr.setEndTime(json.getString("ENDTIME"));
			}
			mr.setDesc(json.getString("DESC"));
			mr.setTypeId(json.getInt("TYPEID"));
			mr.setModifier(json.getString("MODIFIER"));
			boolean flag = ms.updateMaintenanceRecord(mr);
			BigInteger wid = new BigInteger(json.getString("WID"));
			List<WeldingMaintenance> list =  ms.getEndtime(wid);
			if(endTime==null || "".equals(endTime)){
				//修改焊机状态为维修中
				ms.editstatus(wid, 33);
			}
			if(list.isEmpty()){
				//如果维修结束时间没有为空的则修改状态为启用
				ms.editstatus(wid, 31);
			}
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
	public boolean deleteMaintenanceRecord(String obj1,String obj2) {
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
			WeldingMaintenance wm = ms.getWeldingMaintenanceById(new BigInteger(json.getString("MID")));
			boolean flag = ms.deleteMaintenanceRecord(wm.getMaintenance().getId());
			boolean flags = ms.deleteWeldingMaintenance(wm.getId());
			//向项目执行操作
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && flags && result.equals("true") && blocResult.equals("true")){
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
	public boolean deleteWeldingMaintenance(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.deleteWeldingMaintenance(new BigInteger(json.getString("WID")));
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object getMaintainByWeldingMachinId(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMaintenance> list = ms.getMaintainByWeldingMachinId(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean editstatus(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.editstatus(new BigInteger(json.getString("WID")), json.getInt("STATUSID"));
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public BigInteger getInsfidByMachineid(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return ms.getInsfidByMachineid(new BigInteger(json.getString("WID")));
		}catch(Exception e){
			return null;
		}
	}

}
