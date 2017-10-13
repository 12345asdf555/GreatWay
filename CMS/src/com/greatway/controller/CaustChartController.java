package com.greatway.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.greatway.dto.ModelDto;
import com.greatway.dto.WeldDto;
import com.greatway.manager.InsframeworkManager;
import com.greatway.manager.LiveDataManager;
import com.greatway.manager.WeldingMachineManager;
import com.greatway.model.Insframework;
import com.greatway.model.LiveData;
import com.greatway.page.Page;
import com.greatway.util.IsnullUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/caustChart", produces = { "text/json;charset=UTF-8" })
public class CaustChartController {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	//获取用户id
	private BigInteger uid = new BigInteger("1");
	
	@Autowired
	private LiveDataManager lm;
	@Autowired
	private InsframeworkManager insm;
	@Autowired
	private WeldingMachineManager wm;
	
	IsnullUtil iutil = new IsnullUtil();
	
	/**
	 * 跳转事业部工时页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustHour")
	public String goCaustHour(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustHour";
	}
	
	/**
	 * 跳转事业部超标页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustOverproof")
	public String goCaustOverproof(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustoverproof";
	}
	
	/**
	 * 跳转事业部超时页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustOvertime")
	public String goCaustOvertime(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustovertime";
	}
	
	/**
	 * 跳转事业部闲置率页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustIdle")
	public String goCaustIdle(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustidle";
	}
	
	/**
	 * 跳转事业部焊机负荷率页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustLoads")
	public String goCaustLoads(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustloads";
	}
	
	/**
	 * 跳转事业部空载率页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustNoLoads")
	public String goCaustNoLoads(HttpServletRequest request){
		String parent = request.getParameter("parent");
		insm.showParent(request, parent);
		request.setAttribute("parent",parent);
		return "caustchart/caustnoloads";
	}
	
	/**
	 * 跳转事业部单台设备运行数据统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/goCaustUse")
	public String goCaustUse(HttpServletRequest request){
		return "caustchart/caustuse";
	}
	
	/**
	 * 事业部工时报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustHour")
	@ResponseBody
	public String getCaustHour(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String parentId = request.getParameter("parent");
		WeldDto dto = new WeldDto();
		//数据权限处理
		int type = insm.getUserInsfType(uid);
		if(type==22){
			dto.setUid(uid);
		}
		BigInteger parent = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		page = new Page(pageIndex,pageSize,total);
		List<LiveData> list = lm.getCausehour(page,dto,parent);
		long total = 0;
		if(list != null){
			PageInfo<LiveData> pageinfo = new PageInfo<LiveData>(list);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(LiveData l:list){
				json.put("manhour", l.getHous());
				json.put("dyne", l.getDyne());
				json.put("name",l.getFname());
				json.put("itemid",l.getFid());
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
	 * 事业部超标报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustOverproof")
	@ResponseBody
	public String getCaustOverproof(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String parentId = request.getParameter("parent");
		String type = request.getParameter("otype");
		WeldDto dto = new WeldDto();
		BigInteger parent = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		if(iutil.isNull(type)){
			if(type.equals("1")){
				dto.setYear("year");
			}else if(type.equals("2")){
				dto.setMonth("month");
			}else if(type.equals("3")){
				dto.setDay("day");
			}else if(type.equals("4")){
				dto.setWeek("week");
			}
		}
		page = new Page(pageIndex,pageSize,total);
		List<LiveData> time = lm.getAllTime(page,dto);
		long total = 0;
		if(time != null){
			PageInfo<LiveData> pageinfo = new PageInfo<LiveData>(time);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONArray arys = new JSONArray();
		JSONArray arys1 = new JSONArray();
		try{
			List<ModelDto> list = lm.getCauseOverproof(dto,parent);
			List<LiveData> ins = lm.getAllInsf(parent,23);
			int[] num = null;
			for(LiveData live :time){
				json.put("weldTime",live.getWeldTime());
				arys.add(json);
			}
			for(int i=0;i<ins.size();i++){
				num = new int[time.size()];
				for(int j=0;j<time.size();j++){
					num[j] = 0;
					for(ModelDto l:list){
						if(ins.get(i).getFname().equals(l.getFname()) && time.get(j).getWeldTime().equals(l.getWeldTime())){
							num[j] = Integer.parseInt(l.getOverproof().toString());
						}
					}
				}
				json.put("overproof",num);
				json.put("name",ins.get(i).getFname());
				json.put("itemid",ins.get(i).getFid());
				arys1.add(json);
			}
			JSONObject object = new JSONObject();
			
			for(int i=0;i<time.size();i++){
				for(int j=0;j<arys1.size();j++){
					JSONObject js = (JSONObject)arys1.get(j);
					String overproof = js.getString("overproof").substring(1, js.getString("overproof").length()-1);
					String[] str = overproof.split(",");
					object.put("a"+j, str[i]);
				}
				ary.add(object);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		obj.put("arys", arys);
		obj.put("arys1", arys1);
		return obj.toString();
	}
	
	/**
	 * 事业部超时报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustOvertime")
	@ResponseBody
	public String getCaustOvertime(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String parentId = request.getParameter("parent");
		String type = request.getParameter("otype");
		String number = request.getParameter("number");
		WeldDto dto = new WeldDto();
		BigInteger parent = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		if(iutil.isNull(type)){
			if(type.equals("1")){
				dto.setYear("year");
			}else if(type.equals("2")){
				dto.setMonth("month");
			}else if(type.equals("3")){
				dto.setDay("day");
			}else if(type.equals("4")){
				dto.setWeek("week");
			}
		}
		page = new Page(pageIndex,pageSize,total);
		List<LiveData> time = lm.getAllTime(page,dto);
		long total = 0;
		if(time != null){
			PageInfo<LiveData> pageinfo = new PageInfo<LiveData>(time);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONArray arys = new JSONArray();
		JSONArray arys1 = new JSONArray();
		try{
			List<ModelDto> list = lm.getCaustOvertime(dto, number, parent);
			List<LiveData> ins = lm.getAllInsf(parent,23);
			int[] num = null;
			for(LiveData live :time){
				json.put("weldTime",live.getWeldTime());
				arys.add(json);
			}
			for(int i=0;i<ins.size();i++){
				num = new int[time.size()];
				for(int j=0;j<time.size();j++){
					num[j] = 0;
					for(ModelDto l:list){
						if(ins.get(i).getFname().equals(l.getFname()) && time.get(j).getWeldTime().equals(l.getWeldTime())){
							num[j] = Integer.parseInt(l.getOvertime().toString());;
						}
					}
				}
				json.put("overtime",num);
				json.put("name",ins.get(i).getFname());
				json.put("itemid",ins.get(i).getId());
				arys1.add(json);
			}
			JSONObject object = new JSONObject();
			
			for(int i=0;i<time.size();i++){
				for(int j=0;j<arys1.size();j++){
					JSONObject js = (JSONObject)arys1.get(j);
					String overproof = js.getString("overtime").substring(1, js.getString("overtime").length()-1);
					String[] str = overproof.split(",");
					object.put("a"+j, str[i]);
				}
				ary.add(object);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		obj.put("arys", arys);
		obj.put("arys1", arys1);
		return obj.toString();
	}

	/**
	 * 事业部负荷率报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustLoads")
	@ResponseBody
	public String getCaustLoads(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String parentId = request.getParameter("parent");
		String type = request.getParameter("otype");
		WeldDto dto = new WeldDto();
		BigInteger parent = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		if(iutil.isNull(type)){
			if(type.equals("1")){
				dto.setYear("year");
			}else if(type.equals("2")){
				dto.setMonth("month");
			}else if(type.equals("3")){
				dto.setDay("day");
			}else if(type.equals("4")){
				dto.setWeek("week");
			}
		}
		page = new Page(pageIndex,pageSize,total);
		List<LiveData> time = lm.getAllTime(page,dto);
		long total = 0;
		if(time != null){
			PageInfo<LiveData> pageinfo = new PageInfo<LiveData>(time);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONArray arys = new JSONArray();
		JSONArray arys1 = new JSONArray();
		try{
			List<ModelDto> list = lm.getCaustLoads(dto,parent);
			List<LiveData> ins = lm.getAllInsf(parent,23);
			double[] num = null;
			for(LiveData live :time){
				json.put("weldTime",live.getWeldTime());
				arys.add(json);
			}
			for(int i=0;i<ins.size();i++){
				num = new double[time.size()];
				for(int j=0;j<time.size();j++){
					num[j] = 0;
					for(ModelDto l:list){
						if(ins.get(i).getFname().equals(l.getFname()) && time.get(j).getWeldTime().equals(l.getWeldTime())){
							num[j] = (double)Math.round(l.getLoads()*100)/100;
						}
					}
				}
				json.put("loads",num);
				json.put("name",ins.get(i).getFname());
				json.put("itemid",ins.get(i).getId());
				arys1.add(json);
			}
			JSONObject object = new JSONObject();
			
			for(int i=0;i<time.size();i++){
				for(int j=0;j<arys1.size();j++){
					JSONObject js = (JSONObject)arys1.get(j);
					String overproof = js.getString("loads").substring(1, js.getString("loads").length()-1);
					String[] str = overproof.split(",");
					object.put("a"+j, str[i]+"%");
				}
				ary.add(object);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		obj.put("arys", arys);
		obj.put("arys1", arys1);
		return obj.toString();
	}
	
	/**
	 * 事业部空载率报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustNoLoads")
	@ResponseBody
	public String getCaustNoLoads(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String parentId = request.getParameter("parent");
		String type = request.getParameter("otype");
		WeldDto dto = new WeldDto();
		BigInteger parent = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(parentId)){
			parent = new BigInteger(parentId);
		}
		if(iutil.isNull(type)){
			if(type.equals("1")){
				dto.setYear("year");
			}else if(type.equals("2")){
				dto.setMonth("month");
			}else if(type.equals("3")){
				dto.setDay("day");
			}else if(type.equals("4")){
				dto.setWeek("week");
			}
		}
		page = new Page(pageIndex,pageSize,total);
		List<LiveData> time = lm.getAllTime(page,dto);
		long total = 0;
		if(time != null){
			PageInfo<LiveData> pageinfo = new PageInfo<LiveData>(time);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONArray arys = new JSONArray();
		JSONArray arys1 = new JSONArray();
		try{
			List<ModelDto> list = lm.getCaustNOLoads(dto, parent);
			List<LiveData> ins = lm.getAllInsf(parent,23);
			double[] num = null;
			for(LiveData live :time){
				json.put("weldTime",live.getWeldTime());
				arys.add(json);
			}
			for(int i=0;i<ins.size();i++){
				num = new double[time.size()];
				for(int j=0;j<time.size();j++){
					num[j] = 0;
					for(ModelDto l:list){
						if(ins.get(i).getFname().equals(l.getFname()) && time.get(j).getWeldTime().equals(l.getWeldTime())){
							num[j] = (double)Math.round(l.getLoads()*100)/100;
						}
					}
				}
				json.put("loads",num);
				json.put("name",ins.get(i).getFname());
				json.put("itemid",ins.get(i).getId());
				arys1.add(json);
			}
			JSONObject object = new JSONObject();
			
			for(int i=0;i<time.size();i++){
				for(int j=0;j<arys1.size();j++){
					JSONObject js = (JSONObject)arys1.get(j);
					String overproof = js.getString("loads").substring(1, js.getString("loads").length()-1);
					String[] str = overproof.split(",");
					object.put("a"+j, str[i]+"%");
				}
				ary.add(object);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		obj.put("arys", arys);
		obj.put("arys1", arys1);
		return obj.toString();
	}
	/**
	 * 事业部闲置率报表信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustIdle")
	@ResponseBody
	public String getCaustIdle(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String type = request.getParameter("otype");
		String parent = request.getParameter("parent");
		WeldDto dto = new WeldDto();
		BigInteger parentid = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(type)){
			if(type.equals("1")){
				dto.setYear("year");
			}else if(type.equals("2")){
				dto.setMonth("month");
			}else if(type.equals("4")){
				dto.setWeek("week");
			}
		}
		if(iutil.isNull(parent)){
			parentid = new BigInteger(parent);
		}
		page = new Page(pageIndex,pageSize,total);
		List<ModelDto> list = lm.getCaustIdle(page, dto,parentid);
		long total = 0;
		if(list != null){
			PageInfo<ModelDto> pageinfo = new PageInfo<ModelDto>(list);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(ModelDto l:list){
				json.put("idle", l.getIdle());
				json.put("fname", l.getFname());
				json.put("fid",l.getFid());
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
	 * 公司单台设备运行数据统计信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCaustUse")
	@ResponseBody
	public String getCaustUse(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		String type = request.getParameter("type");
		WeldDto dto = new WeldDto();
		BigInteger typeid = null;
		if(iutil.isNull(time1)){
			dto.setDtoTime1(time1);
		}
		if(iutil.isNull(time2)){
			dto.setDtoTime2(time2);
		}
		if(iutil.isNull(type)){
			typeid = new BigInteger(type);
		}
		page = new Page(pageIndex,pageSize,total);
		List<ModelDto> list = lm.getCaustUse(page, dto, typeid);
		long total = 0;
		if(list != null){
			PageInfo<ModelDto> pageinfo = new PageInfo<ModelDto>(list);
			total = pageinfo.getTotal();
		}
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			for(ModelDto l:list){
				json.put("time", l.getTime());
				json.put("fname", l.getFname());
				json.put("type", l.getType());
				json.put("fid",l.getFid());
				json.put("num", wm.getMachineCountByManu(l.getFid()));
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
	 * 事业部下拉框
	 * @return
	 */
	@RequestMapping("getItem")
	@ResponseBody
	public String getItem(){
		JSONObject json = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		try{
			List<Insframework> list = insm.getInsByType(23);
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

}
