package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.page.Page;
import com.spring.model.MyUser;
import com.spring.model.User;
import com.spring.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/user",produces = { "text/json;charset=UTF-8" })
public class UserController {
	
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	@Autowired
	private UserService userService;
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/AllUser")
	public String AllUser(HttpServletRequest request){
		return "/allUser";
	}
	@RequestMapping("/getAllUser")
	@ResponseBody
	public String getAllUser(HttpServletRequest request){
		MyUser myuser = (MyUser) SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();
		System.out.println(myuser.getId());
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String search = request.getParameter("searchStr");
		
		page = new Page(pageIndex,pageSize,total);
		List<User> findAll = userService.findAll(page,search);
		long total = 0;
		
		if(findAll != null){
			PageInfo<User> pageinfo = new PageInfo<User>(findAll);
			total = pageinfo.getTotal();
		}

		request.setAttribute("userList", findAll);
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(User user:findAll){
				json.put("id", user.getId());
				json.put("users_name", user.getUserName());
				json.put("users_Login_Name", user.getUserLoginName());
				json.put("users_phone", user.getUserPhone());
				json.put("users_email",user.getUserEmail());
				json.put("users_position", user.getUserPosition());
				json.put("users_insframework", user.getInsname());
				if(1==user.getStatus()){
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
	@RequestMapping("/toAddUser")
	public String toAddUser(HttpServletRequest request){
		
		return "/addUser";
	}
	/**
	 * 添加用户并重定向
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(User user,HttpServletRequest request){
       
		JSONObject obj = new JSONObject();
		try{
		user.setUserInsframework(Long.parseLong(request.getParameter("userInsframework")));
        user.setStatus(Integer.parseInt(request.getParameter("status")));
        String str = request.getParameter("rid");
        if(null!=str&&""!=str)
        {
        String[] s = str.split(",");
        for (int i = 0; i < s.length; i++) {
            Integer id = Integer.parseInt(s[i]);
            user.setRoleName(userService.findByRoleId(id));
            userService.saveRole(user);
        }
        }
		userService.save(user);
		obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
			obj.put("errorMsg", e.getMessage());
		}
		return obj.toString();
/*		return "redirect:/user/AllUser";*/
	}
	
	/**
	 *编辑用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(HttpServletRequest request){
		User user = new User();
		JSONObject obj = new JSONObject();
		try{
			user.setUserName(request.getParameter("userName"));
			user.setUserPassword(request.getParameter("userPassword"));
			user.setUserLoginName(request.getParameter("userLoginName"));
			user.setUserPhone(request.getParameter("userPhone"));
			user.setUserEmail(request.getParameter("userEmail"));
			user.setUserPosition(request.getParameter("userPosition"));
	        user.setUserInsframework(Long.parseLong(request.getParameter("userInsframework")));
	        user.setStatus(Integer.parseInt(request.getParameter("status")));
			String str = request.getParameter("rid");
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			userService.deleteRole(userService.updateUserRole(uid));
			if(null!=str&&""!=str)
			{
	        String[] s = str.split(",");
	        for (int i = 0; i < s.length; i++) {
	            Integer id = Integer.parseInt(s[i]);
	            /*userService.deleteRole(userService.updateUserRole(uid));*/
	            user.setRoleName(userService.findByRoleId(id));
                userService.saveRole(user);
	        }
			}
		    userService.update(user);
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
	@RequestMapping("/getUser")
	public String getUser(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("user", userService.findById(new Integer(id)));
		return "/editUser";
	}
	
	@RequestMapping("/desUser")
	public String desUser(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("user", userService.findById(new Integer(id)));
		return "/destroyUser";
	}
	/**
	 * 删除用户
	 * @param id
	 * @param request
	 * @param response
	 * @return 
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public String delUser(@RequestParam int id){

			JSONObject obj = new JSONObject();
			try{
				 User user = userService.findById(new Integer(id));
				 userService.delete(new Integer(user.getId()));
				 obj.put("success", true);
			}catch(Exception e){
				obj.put("success", false);
				obj.put("errorMsg", e.getMessage());
			}
			return obj.toString();
	}
	@RequestMapping("/getAllRole")
	@ResponseBody
	public String getAllRole(HttpServletRequest request){
		
		List<User> findAllRole = userService.findAllRole();
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(User user:findAllRole){
				json.put("id", user.getId());
				json.put("roles_name", user.getRoleName());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("rows", ary);
		return obj.toString();
	}
	@RequestMapping("/getRole")
	@ResponseBody
	public String getRole(@RequestParam Integer id,HttpServletRequest request){
		
		List<User> findRole = userService.findRole(new Integer(id));
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(User user:findRole){
				json.put("id", user.getId());
				json.put("roles_name", user.getRoleName());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("rows", ary);
		return obj.toString();
	}
	
	@RequestMapping("/usernamevalidate")
	@ResponseBody
	private String usernamevalidate(@RequestParam String userName){
		boolean data = true;
		int count = userService.getUsernameCount(userName);
		if(count>0){
			data = false;
		}
		return data + "";
	}
	
	@RequestMapping("/getIns")
	@ResponseBody
	public String getIns(HttpServletRequest request){
       
		List<User> getIns = userService.getIns();
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(User user:getIns){
				json.put("insid", user.getInsid());
				json.put("insname", user.getInsname());
				ary.add(json);
			}
		}catch(Exception e){
			e.getMessage();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
/*		return "redirect:/user/AllUser";*/
	}
	
}
