package com.greatway.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.DictionaryManager;
import com.greatway.manager.GatherManager;
import com.greatway.manager.InsframeworkManager;
import com.greatway.manager.MaintainManager;
import com.greatway.manager.WeldingMachineManager;
import com.greatway.model.Dictionarys;
import com.greatway.model.EquipmentManufacturer;
import com.greatway.model.Gather;
import com.greatway.model.Insframework;
import com.greatway.model.WeldingMachine;
import com.greatway.model.WeldingMaintenance;
import com.greatway.page.Page;
import com.greatway.util.IsnullUtil;
import com.spring.model.MyUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/weldingMachine", produces = { "text/json;charset=UTF-8" })
public class WeldingMachineController {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	
	@Autowired
	private WeldingMachineManager wmm;
	
	@Autowired
	private MaintainManager maintain;
	
	@Autowired
	private InsframeworkManager im;
	
	@Autowired
	private GatherManager gm;
	
	@Autowired
	private DictionaryManager dm;
	
	
	IsnullUtil iutil = new IsnullUtil();
	
	/**
	 * 焊机设备管理
	 * @return
	 */
	@RequestMapping("/goWeldingMachine")
	public String goWeldingMahine(){
		return "weldingMachine/weldingmachine";
	}
	
	/**
	 * 维修记录
	 * @param request
	 * @param wid
	 * @return
	 */
	@RequestMapping("/goMaintain")
	public String goMaintain(HttpServletRequest request, @RequestParam String wid){
		WeldingMachine weld = wmm.getWeldingMachineById(new BigInteger(wid));
		if(weld.getIsnetworking()==0){
			request.setAttribute("isnetworking", "是");
		}else{
			request.setAttribute("isnetworking", "否");
		}
		request.setAttribute("w", weld);
		return "maintain/weldingmaintenance";
	}
	
	/**
	 * 新增焊机设备
	 * @return
	 */
	@RequestMapping("/goAddWeldingMachine")
	public String goAddWeldingMachine(){
		return "weldingMachine/addweldingmachine";
	}
	
	/**
	 * 修改焊机设备
	 * @param request
	 * @param wid
	 * @return
	 */
	@RequestMapping("/goEditWeldingMachine")
	public String goEditWeldingMachine(HttpServletRequest request, @RequestParam String wid){
		WeldingMachine weld = wmm.getWeldingMachineById(new BigInteger(wid));
		request.setAttribute("w", weld);
		return "weldingMachine/editweldingmachine";
	}
	
	/**
	 * 删除焊机信息
	 * @param request
	 * @param wid
	 * @return
	 */
	@RequestMapping("/goremoveWeldingMachine")
	public String goremoveWeldingMahine(HttpServletRequest request, @RequestParam String wid){
		WeldingMachine weld = wmm.getWeldingMachineById(new BigInteger(wid));
		if(weld.getIsnetworking()==0){
			request.setAttribute("isnetworking", "是");
		}else{
			request.setAttribute("isnetworking", "否");
		}
		request.setAttribute("w", weld);
		return "weldingMachine/removeweldingmachine";
	}
	
	/**
	 * 显示焊机列表
	 * @return
	 */
	@RequestMapping("/getWedlingMachineList")
	@ResponseBody
	public String getWeldingMachine(HttpServletRequest request){
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String searchStr = request.getParameter("searchStr");
		String parentId = request.getParameter("parent");
		BigInteger parent = null;
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		request.getSession().setAttribute("searchStr", searchStr);
		page = new Page(pageIndex,pageSize,total);
		List<WeldingMachine> list = wmm.getWeldingMachineAll(page,parent,searchStr);
		long total = 0;
		
		if(list != null){
			PageInfo<WeldingMachine> pageinfo = new PageInfo<WeldingMachine>(list);
			total = pageinfo.getTotal();
		}
		
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(WeldingMachine wm:list){
				json.put("id", wm.getId());
				json.put("equipmentNo", wm.getEquipmentNo());
				json.put("position", wm.getPosition());
				json.put("gatherId", wm.getGatherId());
				if(wm.getIsnetworking()==0){
					json.put("isnetworking", "是");
				}else{
					json.put("isnetworking", "否");
				}
				json.put("isnetworkingId", wm.getIsnetworking());
				json.put("jointime", wm.getJoinTime());
				json.put("typeName",wm.getTypename());
				json.put("typeId", wm.getTypeId());
				json.put("statusName", wm.getStatusname());
				json.put("statusId", wm.getStatusId());
				json.put("insframeworkName", wm.getInsframeworkId().getName());
				json.put("insframeworkId", wm.getInsframeworkId().getId());
				json.put("manufacturerName", wm.getManufacturerId().getName()+" - "+wm.getManufacturerId().getType());
				json.put("manufacturerId", wm.getManufacturerId().getId());
				if(wm.getGatherId()!=null ||("").equals(wm.getGatherId())){
					json.put("gatherId", wm.getGatherId().getGatherNo());
				}else{
					json.put("gatherId", null);
				}
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	/**
	 * 获取设备类型
	 * @return
	 */
	@RequestMapping("/getTypeAll")
	@ResponseBody
	public String getTypeAll(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			List<Dictionarys> dictionary = dm.getDictionaryValue(4);
			for(Dictionarys d:dictionary){
				json.put("id", d.getValue());
				json.put("name", d.getValueName());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	
	/**
	 * 获取项目类型
	 * @return
	 */
	@RequestMapping("/getInsframeworkAll")
	@ResponseBody
	public String getInsframeworkAll(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			//获取用户id
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			List<Insframework> instype = im.getInsByUserid(new BigInteger(myuser.getId()+""));
			List<Insframework> list = null;
			for(Insframework i:instype){
				if(i.getType()==20){
					list = im.getWeldingMachineInsf(null);
				}else{
					list = im.getWeldingMachineInsf(i.getId());
				}
			}
			for(Insframework i:list){
				json.put("id", i.getId());
				json.put("name", i.getName());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	
	/**
	 * 获取采集编号
	 * @return
	 */
	@RequestMapping("/getGatherAll")
	@ResponseBody
	public String getGatherAll(HttpServletRequest request){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		String itemid = request.getParameter("itemid");
		BigInteger item = null;
		if(iutil.isNull(itemid)){
			item = new BigInteger(itemid);
		}
		try{
			List<Gather> list = gm.getGatherAll(null,item);
			for(Gather g:list){
				json.put("id", g.getId());
				json.put("name", g.getGatherNo());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	
	/**
	 * 获取焊机状态
	 * @return
	 */
	@RequestMapping("/getStatusAll")
	@ResponseBody
	public String getStatusAll(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			List<Dictionarys> dictionary = dm.getDictionaryValue(3);
			for(Dictionarys d:dictionary){
				json.put("id", d.getValue());
				json.put("name", d.getValueName());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	
	/**
	 * 获取厂商
	 * @return
	 */
	@RequestMapping("/getManuAll")
	@ResponseBody
	public String getManuAll(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			List<EquipmentManufacturer> list = wmm.getManuAll();
			for(EquipmentManufacturer es:list){
				json.put("id", es.getId());
				json.put("name", es.getName());
				json.put("type", es.getType());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	
	/**
	 * 新增
	 * @return
	 */
	@RequestMapping("/addWeldingMachine")
	@ResponseBody
	public String addWeldingMachine(HttpServletRequest request){
//		WeldingMachine wm = new WeldingMachine();
		JSONObject obj = new JSONObject();
		try{
			//当前层级
			String hierarchy = request.getSession().getServletContext().getInitParameter("hierarchy");
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			//获取项目层url
			String itemurl = request.getSession().getServletContext().getInitParameter("itemurl");
			//获取公司发布地址
			String companyurl = im.webserviceDto(request, new BigInteger(request.getParameter("iId")));
			//客户端执行操作
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client client = dcf.createClient(companyurl);
			String obj1 = "{\"CLASSNAME\":\"weldingMachineWebServiceImpl\",\"METHOD\":\"addWeldingMachine\"}";
			String obj2 = "{\"EQUIPMENTNO\":\""+request.getParameter("equipmentNo")+"\",\"POSITION\":\""+request.getParameter("position")+"\",\"ISNETWORKING\":\"0\","
					+ "\"JOINTIME\":\""+request.getParameter("joinTime")+"\",\"TYPEID\":\""+request.getParameter("tId")+"\",\"STATUSID\":\""+request.getParameter("sId")+"\","
					+ "\"GATHERID\":\""+request.getParameter("gatherId")+"\",\"MANUFACTURERID\":\""+request.getParameter("manuno")+"\","
					+ "\"INSFRAMEWORKID\":\""+request.getParameter("iId")+"\",\"CREATOR\":\""+myuser.getUsername()+"\",\"ITEMURL\":\""+itemurl+"\",\"HIERARCHY\":\""+hierarchy+"\"}";
			Object[] objects = client.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});  
			if(objects[0].toString().equals("true")){
				obj.put("success", true);
			}else{
				obj.put("success", false);
			}
			//获取当前用户
//			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			MyUser myuser = (MyUser)object;
//			wm.setEquipmentNo(request.getParameter("equipmentNo"));
//			if(iutil.isNull(request.getParameter("joinTime"))){
//				wm.setJoinTime(request.getParameter("joinTime"));
//			}
//			if(iutil.isNull(request.getParameter("position"))){
//				wm.setPosition(request.getParameter("position"));
//			}
//			if(iutil.isNull(request.getParameter("gatherId"))){
//				Gather g = new Gather();
//				g.setId(new BigInteger(request.getParameter("gatherId")));
//				wm.setGatherId(g);
//			}
//			wm.setIsnetworking(Integer.parseInt(request.getParameter("isnetworking")));
//			wm.setTypeId(Integer.parseInt(request.getParameter("tId")));
//			Insframework ins = new Insframework();
//			ins.setId(new BigInteger(request.getParameter("iId")));
//			wm.setInsframeworkId(ins);
//			wm.setStatusId(Integer.parseInt(request.getParameter("sId")));
//			EquipmentManufacturer em = new EquipmentManufacturer();
//			em.setId(new BigInteger(request.getParameter("manuno")));
//			wm.setManufacturerId(em);
//			wm.setCreator(myuser.getUsername());
//			wmm.addWeldingMachine(wm);
//			obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("/editWeldingMachine")
	@ResponseBody
	public String editWeldingMachine(HttpServletRequest request){
		WeldingMachine wm = new WeldingMachine();
		JSONObject obj = new JSONObject();
		try{
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			wm.setId(new BigInteger(request.getParameter("wid")));
			wm.setEquipmentNo(request.getParameter("equipmentNo"));
			if(iutil.isNull(request.getParameter("joinTime"))){
				wm.setJoinTime(request.getParameter("joinTime"));
			}
			if(iutil.isNull(request.getParameter("position"))){
				wm.setPosition(request.getParameter("position"));
			}
			if(iutil.isNull(request.getParameter("gatherId"))){
				Gather g = new Gather();
				g.setId(new BigInteger(request.getParameter("gatherId")));
				wm.setGatherId(g);
			}
			wm.setIsnetworking(Integer.parseInt(request.getParameter("isnetworking")));
			wm.setTypeId(Integer.parseInt(request.getParameter("tId")));
			Insframework ins = new Insframework();
			ins.setId(new BigInteger(request.getParameter("iId")));
			wm.setInsframeworkId(ins);
			wm.setStatusId(Integer.parseInt(request.getParameter("sId")));
			//修改焊机状态为启用时，结束所有维修任务
			int sid = wm.getStatusId();
			if(sid == 31){
				List<WeldingMaintenance> list =  maintain.getEndtime(wm.getId());
				for(WeldingMaintenance w : list){
					if(w.getMaintenance().getEndTime()==null || w.getMaintenance().getEndTime()==""){
						maintain.updateEndtime(w.getId());
					}
				}
			}
			
			EquipmentManufacturer em = new EquipmentManufacturer();
			em.setId(new BigInteger(request.getParameter("manuno")));
			wm.setManufacturerId(em);
			wm.setModifier(myuser.getUsername());
			wmm.editWeldingMachine(wm);
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	/**
	 * 删除焊机设备
	 * @param wid
	 * @return
	 */
	@RequestMapping("/removeWeldingMachine")
	@ResponseBody
	private String removeWeldingMachine(@RequestParam String wid){
		JSONObject obj = new JSONObject();
		try{
			wmm.deleteWeldingChine(new BigInteger(wid));
			List<WeldingMaintenance> list = maintain.getMaintainByWeldingMachinId(new BigInteger(wid));
			for(WeldingMaintenance wm : list){
				//删除维修记录
				maintain.deleteWeldingMaintenance(wm.getId());
				maintain.deleteMaintenanceRecord(wm.getMaintenance().getId());
			}
			obj.put("success", true);
		}catch(Exception e){
			obj.put("success", true);
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}
	
	@RequestMapping("/enovalidate")
	@ResponseBody
	private String enovalidate(@RequestParam String eno){
		boolean data = true;
		int count = wmm.getEquipmentnoCount(eno);
		if(count>0){
			data = false;
		}
		return data + "";
	}
	
	@RequestMapping("/gidvalidate")
	@ResponseBody
	private String gidvalidate(HttpServletRequest request){
		String gather = request.getParameter("gather");
		String itemid = request.getParameter("itemid");
		BigInteger item = null;
		if(iutil.isNull(itemid)){
			item = new BigInteger(itemid);
		}
		boolean data = true;
		int count = wmm.getGatheridCount(item,gather);
		if(count>0){
			data = false;
		}
		return data + "";
	}
	
}
