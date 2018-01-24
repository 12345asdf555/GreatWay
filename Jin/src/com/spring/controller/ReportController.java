package com.spring.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.manager.DictionaryManager;
import com.greatway.manager.InsframeworkManager;
import com.greatway.manager.WeldingMachineManager;
import com.greatway.model.Dictionarys;
import com.greatway.model.Insframework;
import com.greatway.model.WeldingMachine;
import com.greatway.page.Page;
import com.greatway.util.IsnullUtil;
import com.spring.model.MyUser;
import com.spring.model.Report;
import com.spring.model.User;
import com.spring.service.ReportService;
import com.spring.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/rep",produces = { "text/json;charset=UTF-8" })
public class ReportController {
	
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private WeldingMachineManager wmm;
	
	@Autowired
	private InsframeworkManager im;
	
	@Autowired
	private DictionaryManager dm;
	
	IsnullUtil iutil = new IsnullUtil();
	
	@RequestMapping("/weldpara")
	public String WeldPara(HttpServletRequest request){
		return "report/WeldParameter";
	}
	@RequestMapping("/warnreport")
	public String WarnRep(HttpServletRequest request){
		return "report/WarnReport";
	}
	@RequestMapping("/wireuse")
	public String WireUse(HttpServletRequest request){
		return "report/WireUse";
	}
	@RequestMapping("/welderreport")
	public String WelderRep(HttpServletRequest request){
		return "report/WelderReport";
	}
	
	@RequestMapping("/getWeldPara")
	@ResponseBody
	public String getAllUser(HttpServletRequest request){
/*		MyUser myuser = (MyUser) SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();
		System.out.println(myuser.getId());*/
		Report rap = new Report();
		Report rap1 = null;
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String search = request.getParameter("searchStr");
		String parentId = request.getParameter("parent");
		BigInteger parent = null;
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		page = new Page(pageIndex,pageSize,total);
		List<WeldingMachine> list = wmm.getWeldingMachineAll(page,parent,search);
		long total = 0;
		
		if(list != null){
			PageInfo<WeldingMachine> pageinfo = new PageInfo<WeldingMachine>(list);
			total = pageinfo.getTotal();
		}

		request.setAttribute("userList", list);
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(WeldingMachine wm:list){
				if(reportService.getWpsid(wm.getId())!=null){
					BigInteger wpsid=reportService.getWpsid(wm.getId());
					rap = reportService.getWps(wpsid);
				}
				rap1 = reportService.getSyspara();
				json.put("standardvol",rap.getFstandardvol());
				json.put("standardele",rap.getFstandardele());
				json.put("machineid", wm.getEquipmentNo());
				json.put("machinemodel",wm.getModel());
				json.put("inspower",rap1.getFinspower());
				json.put("afv",rap1.getFafv());
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