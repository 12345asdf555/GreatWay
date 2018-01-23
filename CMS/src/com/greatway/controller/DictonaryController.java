package com.greatway.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.DictionaryManager;
import com.greatway.model.Dictionarys;
import com.greatway.page.Page;
import com.spring.model.MyUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/Dictionary",produces = { "text/json;charset=UTF-8" })
public class DictonaryController {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	
	@Autowired
	private DictionaryManager dictionaryManager;
	
	@RequestMapping("/goDictionary")
	public String goDictionary(HttpServletRequest request){
		return "Dictionary/DictionaryList";
	}
	
	@RequestMapping("/goAddDictionary")
	public String goAddDictionary(HttpServletRequest request){
		return "Dictionary/addDictionary";
	}
	
	@RequestMapping("/goEditDictionary")
	public String goEditDictionary(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		Dictionarys dic=dictionaryManager.getDictionaryByFid(id);
		request.setAttribute("Dictionary",dic);
		return "Dictionary/editDictionary";
	}
	
	@RequestMapping("/goRemoveDictionary")
	public String goRemoveDictionary(@RequestParam int id,HttpServletRequest request){
		Dictionarys dic=dictionaryManager.getDictionaryByFid(id);
		request.setAttribute("Dictionary",dic);
		return "Dictionary/RemoveDictionary";
	}
	
	@RequestMapping("/getDictionaryAll")
	@ResponseBody
	public String getDictionaryAll(HttpServletRequest request){
		pageIndex=Integer.parseInt(request.getParameter("page"));
		pageSize=Integer.parseInt(request.getParameter("rows"));
		String search=request.getParameter("searchStr");
		
		
		request.getSession().setAttribute("searchStr", search);
		page=new Page(pageIndex,pageSize,total);
		
		List<Dictionarys> list=dictionaryManager.getAllDictionary(page, search);
		
		long total=0;
		if(list!=null){
			PageInfo<Dictionarys> pageInfo=new PageInfo<Dictionarys>(list);
			total=pageInfo.getTotal();
		}
		
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		
		try{
			for(Dictionarys d:list){
				json.put("id",d.getId());
				json.put("typeid",d.getTypeid());
				json.put("value", d.getValue());
				json.put("valueName", d.getValueName());
				json.put("back", d.getBack());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("total", total);
		obj.put("rows",ary);
		return obj.toString();
	}
	
	@RequestMapping("/addDictionary")
	@ResponseBody
	public String AddDictionary(Dictionarys dic, HttpServletRequest request){
		JSONObject obj=new JSONObject();
		try{
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			String backs=request.getParameter("back");
			dic.setBack(backs);
			dic.setCreator(myuser.getUsername());
			dictionaryManager.addDictionary(dic);
			obj.put("success",true);
		}catch(Exception e){
			obj.put("success",false);
			obj.put("errorMsg",e.getMessage());
		}
		return obj.toString();
	}
	@RequestMapping("/editDictionary")
	@ResponseBody
	public String EditDictionary(Dictionarys dic,HttpServletRequest request){
		JSONObject obj=new JSONObject();
		try{
			//获取当前用户
			Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUser myuser = (MyUser)object;
			String backs=request.getParameter("back");
			dic.setBack(backs);
			dic.setModifier(myuser.getUsername());
			dictionaryManager.editDictionary(dic);
			obj.put("success",true);
		}catch(Exception e){
			obj.put("success",false);
			obj.put("errorMsg",e.getMessage());
		}
		return obj.toString();
	}
	@RequestMapping("/deleteDictionary")
	@ResponseBody
	public String DeleteDictionary(@RequestParam int id){
		JSONObject obj=new JSONObject();
		try{
			dictionaryManager.deleteDictionary(id);
			obj.put("success",true);
		}catch(Exception e){
			obj.put("success",false);
			obj.put("errorMsg",e.getMessage());
		}
		return obj.toString();
	}
}
