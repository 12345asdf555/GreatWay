package com.greatway.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.WeldedJunctionManager;
import com.greatway.model.Insframework;
import com.greatway.model.WeldedJunction;
import com.greatway.page.Page;
import com.greatway.util.IsnullUtil;
import com.spring.model.MyUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/weldedjunction", produces = { "text/json;charset=UTF-8" })
public class WeldedJunctionControll {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	
	@Autowired
	private WeldedJunctionManager wjm;
	IsnullUtil iutil = new IsnullUtil();
	
	@RequestMapping("/goWeldedJunction")
	public String goWeldedJunction(){
		return "weldingjunction/weldedjunction";
	}
	
	@RequestMapping("/goShowMoreJunction")
	public String goShowMoreJunction(HttpServletRequest request,@RequestParam String id){
		try{
			WeldedJunction wj = wjm.getWeldedJunctionById(new BigInteger(id));
			request.setAttribute("wj", wj);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "weldingjunction/showmore";
	}

	@RequestMapping("/goAddWeldedJunction")
	public String goAddWeldedJunction(){
		return "weldingjunction/addweldedjunction";
	}

	@RequestMapping("/goEditWeldedJunction")
	public String goEditWeldedJunction(HttpServletRequest request){
		WeldedJunction wj = wjm.getWeldedJunctionById(new BigInteger(request.getParameter("id")));
		request.setAttribute("wj", wj);
		return "weldingjunction/editweldedjunction";
	}

	@RequestMapping("/goRemoveWeldedJunction")
	public String goRemoveWeldedJunction(HttpServletRequest request){
		WeldedJunction wj = wjm.getWeldedJunctionById(new BigInteger(request.getParameter("id")));
		request.setAttribute("wj", wj);
		return "weldingjunction/removeweldedjunction";
	}
	
	@RequestMapping("/getWeldedJunctionList")
	@ResponseBody
	public String getWeldedJunctionList(HttpServletRequest request){
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String serach = request.getParameter("searchStr");
		
		page = new Page(pageIndex,pageSize,total);
		List<WeldedJunction> list = wjm.getWeldedJunctionAll(page, serach);
		long total = 0;
		
		if(list != null){
			PageInfo<WeldedJunction> pageinfo = new PageInfo<WeldedJunction>(list);
			total = pageinfo.getTotal();
		}
		
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(WeldedJunction w:list){
				json.put("id", w.getId());
				json.put("weldedJunctionno", w.getWeldedJunctionno());
				json.put("serialNo", w.getSerialNo());
				json.put("pipelineNo", w.getPipelineNo());
				json.put("roomNo", w.getRoomNo());
				json.put("unit", w.getUnit());
				json.put("area", w.getArea());
				json.put("systems", w.getSystems());
				json.put("children", w.getChildren());
				json.put("externalDiameter", w.getExternalDiameter());
				json.put("wallThickness", w.getWallThickness());
				json.put("dyne", w.getDyne());
				json.put("specification", w.getSpecification());
				json.put("maxElectricity", w.getMaxElectricity());
				json.put("minElectricity", w.getMinElectricity());
				json.put("maxValtage", w.getMaxValtage());
				json.put("minValtage", w.getMinValtage());
				json.put("material", w.getMaterial());
				json.put("nextexternaldiameter", w.getNextexternaldiameter());
				json.put("itemname", w.getItemid().getName());
				json.put("startTime", w.getStartTime());
				json.put("endTime", w.getEndTime());
				json.put("creatTime", w.getCreatTime());
				json.put("updateTime", w.getUpdateTime());
				json.put("updatecount", w.getUpdatecount());
				json.put("nextwall_thickness", w.getNextwall_thickness());
				json.put("next_material", w.getNext_material());
				json.put("electricity_unit", w.getElectricity_unit());
				json.put("valtage_unit", w.getValtage_unit());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}

	@RequestMapping("/addWeldedJunction")
	@ResponseBody
	public String addWeldedJunction(HttpServletRequest request){
		WeldedJunction wj = new WeldedJunction();
		JSONObject obj = new JSONObject();
		try{
			MyUser user = (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			wj.setCreator(new BigInteger(user.getId()+"").toString());
			wj.setWeldedJunctionno(request.getParameter("weldedJunctionno"));
			wj.setSerialNo(request.getParameter("serialNo"));
			wj.setUnit(request.getParameter("unit"));
			wj.setArea(request.getParameter("area"));
			wj.setSystems(request.getParameter("systems"));
			wj.setChildren(request.getParameter("children"));
			wj.setDyne(Integer.parseInt(request.getParameter("dyne")));
			wj.setSpecification(request.getParameter("specification"));
			wj.setPipelineNo(request.getParameter("pipelineNo"));
			wj.setRoomNo(request.getParameter("roomNo"));
			wj.setExternalDiameter(request.getParameter("externalDiameter"));
			wj.setNextexternaldiameter(request.getParameter("nextexternaldiameter"));
			wj.setWallThickness(request.getParameter("wallThickness"));
			wj.setNextwall_thickness(request.getParameter("nextwall_thickness"));
			wj.setMaterial(request.getParameter("material"));
			wj.setNext_material(request.getParameter("next_material"));
			wj.setMaxElectricity(Double.parseDouble(request.getParameter("maxElectricity")));
			wj.setMinElectricity(Double.parseDouble(request.getParameter("minElectricity")));
			wj.setMaxValtage(Double.parseDouble(request.getParameter("maxValtage")));
			wj.setMinValtage(Double.parseDouble(request.getParameter("minValtage")));
			wj.setElectricity_unit(request.getParameter("electricity_unit"));
			wj.setValtage_unit(request.getParameter("valtage_unit"));
			String starttime = request.getParameter("startTime");
			String endtime = request.getParameter("endTime");
			if(iutil.isNull(starttime)){
				wj.setStartTime(starttime);
			}
			if(iutil.isNull(endtime)){
				wj.setEndTime(endtime);
			}
			Insframework ins = new Insframework();
			String itemid = request.getParameter("itemid");
			if(iutil.isNull(itemid)){
				ins.setId(new BigInteger(itemid));
				wj.setItemid(ins);
			}
			wjm.addJunction(wj);
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	

	@RequestMapping("/editWeldedJunction")
	@ResponseBody
	public String editWeldedJunction(HttpServletRequest request){
		WeldedJunction wj = new WeldedJunction();
		JSONObject obj = new JSONObject();
		try{
			MyUser user = (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			wj.setModifier(new BigInteger(user.getId()+"").toString());
			wj.setId(new BigInteger(request.getParameter("id")));
			wj.setWeldedJunctionno(request.getParameter("weldedJunctionno"));
			wj.setSerialNo(request.getParameter("serialNo"));
			wj.setUnit(request.getParameter("unit"));
			wj.setArea(request.getParameter("area"));
			wj.setSystems(request.getParameter("systems"));
			wj.setChildren(request.getParameter("children"));
			wj.setDyne(Integer.parseInt(request.getParameter("dyne")));
			wj.setSpecification(request.getParameter("specification"));
			wj.setPipelineNo(request.getParameter("pipelineNo"));
			wj.setRoomNo(request.getParameter("roomNo"));
			wj.setExternalDiameter(request.getParameter("externalDiameter"));
			wj.setNextexternaldiameter(request.getParameter("nextexternaldiameter"));
			wj.setWallThickness(request.getParameter("wallThickness"));
			wj.setNextwall_thickness(request.getParameter("nextwall_thickness"));
			wj.setMaterial(request.getParameter("material"));
			wj.setNext_material(request.getParameter("next_material"));
			wj.setMaxElectricity(Double.parseDouble(request.getParameter("maxElectricity")));
			wj.setMinElectricity(Double.parseDouble(request.getParameter("minElectricity")));
			wj.setMaxValtage(Double.parseDouble(request.getParameter("maxValtage")));
			wj.setMinValtage(Double.parseDouble(request.getParameter("minValtage")));
			wj.setElectricity_unit(request.getParameter("electricity_unit"));
			wj.setValtage_unit(request.getParameter("valtage_unit"));
			String starttime = request.getParameter("startTime");
			String endtime = request.getParameter("endTime");
			if(iutil.isNull(starttime)){
				wj.setStartTime(starttime);
			}
			if(iutil.isNull(endtime)){
				wj.setEndTime(endtime);
			}
			Insframework ins = new Insframework();
			String itemid = request.getParameter("itemid");
			if(iutil.isNull(itemid)){
				ins.setId(new BigInteger(itemid));
				wj.setItemid(ins);
			}
			wjm.updateJunction(wj);
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	

	@RequestMapping("/removeWeldedJunction")
	@ResponseBody
	public String removeWeldedJunction(HttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
			wjm.deleteJunction(new BigInteger(request.getParameter("id")));
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	
	@RequestMapping("/wjNoValidate")
	@ResponseBody
	private String wjNoValidate(@RequestParam String wjno){
		boolean data = true;
		int count = wjm.getWeldedjunctionByNo(wjno);
		if(count>0){
			data = false;
		}
		return data + "";
	}

}
