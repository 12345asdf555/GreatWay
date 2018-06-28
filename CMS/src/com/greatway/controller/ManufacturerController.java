package com.greatway.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.DictionaryManager;
import com.greatway.manager.ManufacturerManager;
import com.greatway.model.Dictionarys;
import com.greatway.model.EquipmentManufacturer;
import com.greatway.page.Page;
import com.spring.model.MyUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/manufacturer", produces = { "text/json;charset=UTF-8" })
public class ManufacturerController {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	
	@Autowired
	private ManufacturerManager mm;

	@Autowired
	private DictionaryManager dm;
	
	@RequestMapping("/goManufacturer")
	public String goManufacturer(){
		return "manufacturer/manufacturer";
	}
	
	@RequestMapping("/goaddManufacturer")
	public String goaddManufacturer(){
		return "manufacturer/addmanufacturer";
	}
	
	@RequestMapping("/goeditManufacturer")
	public String goeditManufacturer(HttpServletRequest request,@RequestParam String id){
		request.setAttribute("m", mm.getManuById(new BigInteger(id)));
		return "manufacturer/editmanufacturer";
	}
	
	@RequestMapping("/goremoveManufacturer")
	public String goremoveManufacturer(HttpServletRequest request,@RequestParam String id){
		request.setAttribute("m", mm.getManuById(new BigInteger(id)));
		return "manufacturer/removemanufacturer";
	}
	
	@RequestMapping("/getManufacturerList")
	@ResponseBody
	public String getManufacturerList(HttpServletRequest request){
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String searchStr = request.getParameter("searchStr");
		page = new Page(pageIndex, pageSize, total);
		List<EquipmentManufacturer> list = mm.getmanuAll(page, searchStr);
		long total = 0;
		if(list!=null){
			PageInfo<EquipmentManufacturer> pageinfo = new PageInfo<EquipmentManufacturer>(list);
			total = pageinfo.getTotal();
		}
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		try{
			for(int i=0;i<list.size();i++){
				json.put("id", list.get(i).getId());
				json.put("name", list.get(i).getName());
				json.put("type", list.get(i).getType());
				json.put("typevalue", list.get(i).getTypeValue());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}

	@RequestMapping("/addManufacturer")
	@ResponseBody
	public String addManufacturer(HttpServletRequest request,@ModelAttribute("manufacturer") EquipmentManufacturer manufacturer){
		JSONObject obj = new JSONObject();
		try{
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			manufacturer.setCreator(myuser.getId()+"");
			mm.addManu(manufacturer);
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}

	@RequestMapping("/editManufacturer")
	@ResponseBody
	public String editManufacturer(HttpServletRequest request,@ModelAttribute("manufacturer") EquipmentManufacturer manufacturer){
		JSONObject obj = new JSONObject();
		try{
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			manufacturer.setModifier(myuser.getId()+"");
			mm.editManu(manufacturer);
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}

	@RequestMapping("/removeManufacturer")
	@ResponseBody
	public String removeManufacturer(HttpServletRequest request,@RequestParam String id){
		JSONObject obj = new JSONObject();
		try{
			mm.deleteManu(new BigInteger(id));
			obj.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	

	/**
	 * 获取生产厂商类型
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
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
	

	/**
	 * 校验生产厂商是否存在
	 * @param name
	 * @return
	 */
	@RequestMapping("/getManuCount")
	@ResponseBody
	public String getManuCount(HttpServletRequest request,@RequestParam String name,@RequestParam int type){
		boolean flag = true;
		int count = mm.getManuCount(name, type);
		if(count > 0){
			flag = false;
		}
		return flag + "";
	}
}
