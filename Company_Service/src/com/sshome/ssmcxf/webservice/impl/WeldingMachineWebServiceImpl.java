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
import com.spring.model.EquipmentManufacturer;
import com.spring.model.Gather;
import com.spring.model.Insframework;
import com.spring.model.WeldingMachine;
import com.spring.model.WeldingMaintenance;
import com.spring.service.MaintainService;
import com.spring.service.WeldingMachineService;
import com.sshome.ssmcxf.webservice.WeldingMachineWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class WeldingMachineWebServiceImpl implements WeldingMachineWebService {
	@Autowired
	private WeldingMachineService wms;
	
	@Autowired
	private MaintainService ms;
	
	@Override
	public Object getWeldingMachineAll(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger parent = new BigInteger(json.getString("INSFID"));
			String str = json.getString("STR");
			List<WeldingMachine> list =  wms.getWeldingMachineAll(parent, str);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<WeldingMachine> list = wms.getWeldingMachine(json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getManuAll() {
		try{
			List<EquipmentManufacturer> list =  wms.getManuAll();
			return JSON.toJSONString(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addWeldingMachine(String obj1,String obj2) {
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
				BigInteger insfid = new BigInteger(json.getString("INSFRAMEWORKID"));
				itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
			}
			WeldingMachine wm = new WeldingMachine();
			wm.setId(id);
			wm.setEquipmentNo(json.getString("EQUIPMENTNO"));
			wm.setPosition(json.getString("POSITION"));
			wm.setIsnetworking(json.getInt("ISNETWORKING"));
			wm.setJoinTime(json.getString("JOINTIME"));
			wm.setTypeId(json.getInt("TYPEID"));
			wm.setStatusId(json.getInt("STATUSID"));
			wm.setCreator(json.getString("CREATOR"));
			Gather gather = new Gather();
			String gatherid = json.getString("GATHERID");
			if(gatherid!=null && !gatherid.equals("")){
				gather.setId(new BigInteger(gatherid));
			}
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("MANUFACTURERID")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("INSFRAMEWORKID")));
			wm.setInsframeworkId(ins);
			boolean flag = wms.addWeldingMachine(wm);
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
	public boolean editWeldingMachine(String obj1,String obj2) {
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
				BigInteger insfid = new BigInteger(json.getString("INSFRAMEWORKID"));
				itemurl = request.getSession().getServletContext().getInitParameter(insfid.toString());
			}
			WeldingMachine wm = new WeldingMachine();
			wm.setId(new BigInteger(json.getString("ID")));
			wm.setEquipmentNo(json.getString("EQUIPMENTNO"));
			wm.setPosition(json.getString("POSITION"));
			wm.setIsnetworking(json.getInt("ISNETWORKING"));
			wm.setJoinTime(json.getString("JOINTIME"));
			wm.setTypeId(json.getInt("TYPEID"));
			wm.setStatusId(json.getInt("STATUSID"));
			wm.setModifier(json.getString("MODIFIER"));
			Gather gather = new Gather();
			String gatherid = json.getString("GATHERID");
			if(gatherid!=null && !gatherid.equals("")){
				gather.setId(new BigInteger(gatherid));
			}
			wm.setGatherId(gather);
			EquipmentManufacturer e = new EquipmentManufacturer();
			e.setId(new BigInteger(json.getString("MANUFACTURERID")));
			wm.setManufacturerId(e);
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(json.getString("INSFRAMEWORKID")));
			wm.setInsframeworkId(ins);
			boolean flag = wms.editWeldingMachine(wm);
			//向项目执行操作
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && result.equals("true") && blocResult.equals("true")){
				//修改焊机状态为启用时，结束所有维修任务
				int sid = wm.getStatusId();
				if(sid == 31){
					List<WeldingMaintenance> list = ms.getEndtime(wm.getId());
					for(WeldingMaintenance w : list){
							ms.updateEndtime(w.getId());
					}
				}
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
	public boolean deleteWeldingChine(String obj1,String obj2) {
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
			boolean flag = wms.deleteWeldingChine(new BigInteger(json.getString("WID")));
			//向项目执行操作
			Client itemclient = dcf.createClient(itemurl);
			Object[] itemobj = itemclient.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
			String result = itemobj[0].toString();
			if(flag && result.equals("true") && blocResult.equals("true")){
				List<WeldingMaintenance> list = ms.getMaintainByWeldingMachinId(new BigInteger(json.getString("WID")));
				for(WeldingMaintenance wm : list){
					//删除维修记录
					ms.deleteWeldingMaintenance(wm.getId());
					ms.deleteMaintenanceRecord(wm.getMaintenance().getId());
				}
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
	public BigInteger getWeldingMachineByEno(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getWeldingMachineByEno(json.getString("ENO"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getEquipmentnoCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getEquipmentnoCount(json.getString("ENO"));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public int getGatheridCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger itemid = new BigInteger(json.getString("INSFID"));
			String gather = json.getString("GATHERNO");
			return wms.getGatheridCount(itemid, gather);
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public BigInteger getManuidByValue(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getManuidByValue(json.getString("MANUNAME"), json.getString("MANUTYPE"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getWeldingMachineById(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldingMachine list = wms.getWeldingMachineById(new BigInteger(json.getString("WID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getInsframeworkByName(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return wms.getInsframeworkByName(json.getString("INSFNAME"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public BigInteger getMachineCountByManu(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			BigInteger mid = new BigInteger(json.getString("MANUID"));
			BigInteger insid = new BigInteger(json.getString("INSFID"));
			return wms.getMachineCountByManu(mid, insid);
		}catch(Exception e){
			return null;
		}
	}

}
