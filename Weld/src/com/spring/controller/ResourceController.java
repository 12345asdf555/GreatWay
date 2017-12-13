package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.enums.WeldEnum;
import com.greatway.page.Page;
import com.spring.model.Resources;
import com.spring.model.User;
import com.spring.service.ResourceService;
import com.spring.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/resource",produces = { "text/json;charset=UTF-8" })
public class ResourceController {
	
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/AllResource")
	public String AllResource(HttpServletRequest request){
		return "resource/allResource";
	}
	@RequestMapping("/getAllResource")
	@ResponseBody
	public String getAllResource(HttpServletRequest request){
		
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String search = request.getParameter("searchStr");
		
		page = new Page(pageIndex,pageSize,total);
		List<Resources> findAll = resourceService.findAll(page,search);
		long total = 0;
		if(findAll != null){
			PageInfo<Resources> pageinfo = new PageInfo<Resources>(findAll);
			total = pageinfo.getTotal();
		}
		
		request.setAttribute("resourceList", findAll);
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(Resources resource:findAll){
				json.put("id", resource.getId());
				json.put("resources_name", resource.getResourceName());
				json.put("resources_type", resource.getResourceType());
				json.put("resources_address", resource.getResourceAddress());
				json.put("resources_desc",resource.getResourceDesc());
				if(31==resource.getStatus()){
				json.put("status", "启用");
				}
				else{
				json.put("status", "停用");
				}
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	/**
	 * 跳转到添加用户界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAddResource")
	public String toAddResource(HttpServletRequest request){
		
		return "resource/addResource";
	}
	/**
	 * 添加用户并重定向
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/addResource")
	@ResponseBody
	public String addResource(Resources resource,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
		resource.setStatus(Integer.parseInt(request.getParameter("status")));
		resourceService.save(resource);
		obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
	}
	
	/**
	 *编辑用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateResource")
	@ResponseBody
	public String updateResource(Resources resource,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		resource.setStatus(Integer.parseInt(request.getParameter("status")));
		try{
			resourceService.update(resource);
			obj.put("success", true);
			}catch(Exception e){
				obj.put("success", false);
				obj.put("errorMsg", e.getMessage());
			}
			return obj.toString();

	}
	/**
	 * 根据id查询单个用户
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getResource")
	public String getResource(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("resource", resourceService.findById(new Integer(id)));
		return "resource/editResource";
	}
	
	@RequestMapping("/desResource")
	public String desResource(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("resource", resourceService.findById(new Integer(id)));
		return "resource/destroyResource";
	}
	/**
	 * 删除用户
	 * @param id
	 * @param request
	 * @param response
	 * @return 
	 */
	@RequestMapping("/delResource")
	@ResponseBody
	public String delResource(@RequestParam int id){

			JSONObject obj = new JSONObject();
			try{
				Resources resource = resourceService.findById(new Integer(id));
				resourceService.delete(new Integer(resource.getId()));
				 obj.put("success", true);
			}catch(Exception e){
				obj.put("success", false);
				obj.put("errorMsg", e.getMessage());
			}
			return obj.toString();
	}
	
	@RequestMapping("/resourcenamevalidate")
	@ResponseBody
	private String resourcenamevalidate(@RequestParam String resourceName){
		boolean data = true;
		int count = resourceService.getResourcenameCount(resourceName);
		if(count>0){
			data = false;
		}
		return data + "";
	}
	
	@RequestMapping("/getStatusAll")
	@ResponseBody
	public String getStatusAll(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			//获取枚举值
			List<Integer> key = new ArrayList<Integer>();
			key.add(31);
			key.add(32);
			/*key.add(33);*/
			for(Integer k:key){
				json.put("id", k);
				json.put("name", WeldEnum.getValue(k));
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("ary", ary);
		return obj.toString();
	}
}