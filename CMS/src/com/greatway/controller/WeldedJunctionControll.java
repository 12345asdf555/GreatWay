package com.greatway.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.WeldedJunctionManager;
import com.greatway.model.WeldedJunction;
import com.greatway.page.Page;
import com.greatway.util.IsnullUtil;

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
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}

}
