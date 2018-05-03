package com.spring.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spring.dto.WeldDto;
import com.spring.model.DataStatistics;
import com.spring.page.Page;
import com.spring.service.DataStatisticsService;
import com.spring.service.InsframeworkService;
import com.spring.service.LiveDataService;
import com.spring.util.IsnullUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/datastatistics", produces = { "text/json;charset=UTF-8" })
public class DataStatisticsController {
	private Page page;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	
	@Autowired
	private DataStatisticsService dss;

	IsnullUtil iutil = new IsnullUtil();
	private  final BigInteger HOUR_SECOND = new BigInteger("120");
	private  final BigInteger MINUTE_SECOND = new BigInteger("60");
	
	/**
	 * 跳转班组生产数据页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goItemData")
	public String goItemProductionData(HttpServletRequest request){
		return "datastatistics/itemdata";
	}

	/**
	 * 跳转设备生产数据页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goMachineData")
	public String goMachineProductionData(HttpServletRequest request){
		return "datastatistics/machinedata";
	}
	
	/**
	 * 跳转人员生产数据页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goPersonData")
	public String goPersonProductionData(HttpServletRequest request){
		return "datastatistics/persondata";
	}
	
	/**
	 * 跳转班组生产数据报表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getItemData")
	@ResponseBody
	public String getItemProductionData(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		page = new Page(pageIndex,pageSize,total);
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		JSONObject title = new JSONObject();
		WeldDto dto = new WeldDto();
		JSONArray titleary = new JSONArray();
		long total = 0;
		try{
			if(iutil.isNull(time1)){
				dto.setDtoTime1(time1);
			}
			if(iutil.isNull(time2)){
				dto.setDtoTime2(time2);
			}
			List<DataStatistics> list = dss.getItemMachineCount(page);
			
			if(list != null){
				PageInfo<DataStatistics> pageinfo = new PageInfo<DataStatistics>(list);
				total = pageinfo.getTotal();
			}
			for(DataStatistics i:list){
				json.put("t0", i.getName());//所属班组
				json.put("t1", i.getTotal());//设备总数
				DataStatistics work = dss.getWorkNum(i.getId(), dto);//获取工作(焊接)的焊机数,焊口数
				if(i.getTotal()!=0 && work.getMachinenum()!=0){
					int machinenum = dss.getStartingUpMachineNum(i.getId(),dto);//获取开机焊机总数
					BigInteger starttime = dss.getStaringUpTime(i.getId(), dto);//获取开机总时长
					BigInteger standytime = dss.getStandytime(i.getId(), dto);//获取待机总时长
					DataStatistics weldtime = dss.getWorkTimeAndEleVol(i.getId(),dto);//获取焊接时长，平均电流电压
					DataStatistics parameter = dss.getParameter();//获取参数
					if(work!=null){
						json.put("t3",work.getMachinenum() );//实焊设备数
						json.put("t5", work.getJunctionnum());//焊接焊缝数
						json.put("t6", getTimeStrBySecond(weldtime.getWorktime()));//焊接时间
						double useratio =(double)Math.round(Double.valueOf(machinenum)/Double.valueOf(i.getTotal())*100*100)/100;
						double weldingproductivity = (double)Math.round(weldtime.getWorktime().doubleValue()/starttime.doubleValue()*100*100)/100;
						json.put("t4", useratio);//设备利用率
						json.put("t8", weldingproductivity);//焊接效率
					}
					json.put("t2", machinenum);//开机设备数
					json.put("t7", getTimeStrBySecond(starttime));//工作时间
					if(parameter!=null){
						double standytimes = 0;
						if(standytime!=null){
							standytimes = (standytime.divide(new BigInteger("60"))).doubleValue();
						}
						double  time = (weldtime.getWorktime().divide(new BigInteger("60"))).doubleValue();
						String[] str = parameter.getWireweight().split(",");
						double wireweight =Double.valueOf(str[0]);
						double wire = (double)Math.round(wireweight*parameter.getSpeed()*time*100)/100;//焊丝消耗量=焊丝|焊丝重量*送丝速度*焊接时间
						double air = (double)Math.round(parameter.getAirflow()*time*100)/100;//气体消耗量=气体流量*焊接时间
						double  electric = (double)Math.round(time*weldtime.getElectricity()*weldtime.getVoltage()+standytimes*parameter.getStandbypower()*100)/100;//电能消耗量=焊接时间*焊接平均电流*焊接平均电压+待机时间*待机功率
						json.put("t9", wire);//焊丝消耗
						json.put("t11", air);//气体消耗
						json.put("t10", electric);//电能消耗
					}
				}else{
					json.put("t3",0);//实焊设备数
					json.put("t5", 0);//焊接焊缝数
					json.put("t6", "00:00:00");//焊接时间
					json.put("t4", 0);//设备利用率
					json.put("t8", 0);//焊接效率
					json.put("t2", 0);//开机设备数
					json.put("t7","00:00:00");//工作时间
					json.put("t9", 0);//焊丝消耗
					json.put("t11", 0);//气体消耗
					json.put("t10", 0);//电能消耗
				}
				ary.add(json);
			}
			//表头
			String [] str = {"所属班组","设备总数","开机设备数","实焊设备数","设备利用率(%)","焊接焊缝数","焊接时间","工作时间","焊接效率(%)","焊丝消耗(KG)","电能消耗(KWH)","气体消耗(L)"};
			for(int i=0;i<str.length;i++){
				title.put("title", str[i]);
				titleary.add(title);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("ary", titleary);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	
	/**
	 * 跳转设备生产数据报表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMachineData")
	@ResponseBody
	public String getMachineProductionData(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		page = new Page(pageIndex,pageSize,total);
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		JSONObject title = new JSONObject();
		WeldDto dto = new WeldDto();
		JSONArray titleary = new JSONArray();
		long total = 0;
		try{
			if(iutil.isNull(time1)){
				dto.setDtoTime1(time1);
			}
			if(iutil.isNull(time2)){
				dto.setDtoTime2(time2);
			}
			List<DataStatistics> list = dss.getAllMachine(page);
			if(list != null){
				PageInfo<DataStatistics> pageinfo = new PageInfo<DataStatistics>(list);
				total = pageinfo.getTotal();
			}
			for(DataStatistics i:list){
				dto.setMachineid(i.getId());
				json.put("t0", i.getInsname());
				json.put("t1", i.getName());
				DataStatistics junctionnum = dss.getWorkNum(i.getInsid(), dto);
				if(junctionnum.getJunctionnum()!=0){
					json.put("t2", junctionnum.getJunctionnum());//焊接焊缝数
					DataStatistics weld = dss.getWorkTimeAndEleVol(i.getInsid(), dto);
					json.put("t3", getTimeStrBySecond(weld.getWorktime()));//焊接时间
					BigInteger worktime = dss.getStaringUpTime(i.getInsid(), dto);
					json.put("t4", getTimeStrBySecond(worktime));//工作时间
					double weldingproductivity = (double)Math.round(weld.getWorktime().doubleValue()/worktime.doubleValue()*100*100)/100;
					json.put("t5", weldingproductivity);//焊接效率
					DataStatistics parameter = dss.getParameter();
					BigInteger standytime = dss.getStandytime(i.getInsid(), dto);
					if(parameter!=null){
						double standytimes = 0;
						if(standytime!=null){
							standytimes = (standytime.divide(new BigInteger("60"))).doubleValue();
						}
						double  time = (weld.getWorktime().divide(new BigInteger("60"))).doubleValue();
						String[] str = parameter.getWireweight().split(",");
						double wireweight =Double.valueOf(str[0]);
						double wire = (double)Math.round(wireweight*parameter.getSpeed()*time*100)/100;//焊丝消耗量=焊丝|焊丝重量*送丝速度*焊接时间
						double air = (double)Math.round(parameter.getAirflow()*time*100)/100;//气体消耗量=气体流量*焊接时间
						double  electric = (double)Math.round(time*weld.getElectricity()*weld.getVoltage()+standytimes*parameter.getStandbypower()*100)/100;//电能消耗量=焊接时间*焊接平均电流*焊接平均电压+待机时间*待机功率
						json.put("t6", wire);//焊丝消耗
						json.put("t7", electric);//电能消耗
						json.put("t8", air);//气体消耗
					}
				}else{
					json.put("t2", 0);
					json.put("t3", "00:00:00");
					json.put("t4", "00:00:00");
					json.put("t5", 0);
					json.put("t6", 0);
					json.put("t7", 0);
					json.put("t8", 0);
				}
				ary.add(json);
			}
			//表头
			String [] str = {"所属班组","设备编号","焊接焊缝数","焊接时间","工作时间","焊接效率(%)","焊丝消耗(KG)","电能消耗(KWH)","气体消耗(L)"};
			for(int i=0;i<str.length;i++){
				title.put("title", str[i]);
				titleary.add(title);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("ary", titleary);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	
	/**
	 * 跳转人员生产数据报表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPersonData")
	@ResponseBody
	public String getPersonProductionData(HttpServletRequest request){
		if(iutil.isNull(request.getParameter("page"))){
			pageIndex = Integer.parseInt(request.getParameter("page"));
		}
		if(iutil.isNull(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		page = new Page(pageIndex,pageSize,total);
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		JSONObject title = new JSONObject();
		WeldDto dto = new WeldDto();
		JSONArray titleary = new JSONArray();
		long total = 0;
		try{
			if(iutil.isNull(time1)){
				dto.setDtoTime1(time1);
			}
			if(iutil.isNull(time2)){
				dto.setDtoTime2(time2);
			}
			List<DataStatistics> list = dss.getAllWelder(page);
			if(list != null){
				PageInfo<DataStatistics> pageinfo = new PageInfo<DataStatistics>(list);
				total = pageinfo.getTotal();
			}
			for(DataStatistics i:list){
				dto.setWelderno(i.getSerialnumber());
				json.put("t0", i.getSerialnumber());
				json.put("t1", i.getName());
				DataStatistics junctionnum = dss.getWorkNum(null, dto);
				if(junctionnum.getJunctionnum()!=0){
					json.put("t2", junctionnum.getJunctionnum());//焊接焊缝数
					DataStatistics weld = dss.getWorkTimeAndEleVol(null, dto);
					json.put("t3", getTimeStrBySecond(weld.getWorktime()));//焊接时间
					BigInteger worktime = dss.getStaringUpTime(null, dto);
					json.put("t4", getTimeStrBySecond(worktime));//工作时间
					double weldingproductivity = (double)Math.round(weld.getWorktime().doubleValue()/worktime.doubleValue()*100*100)/100;
					json.put("t5", weldingproductivity);//焊接效率
					DataStatistics parameter = dss.getParameter();
					BigInteger standytime = dss.getStandytime(null, dto);
					if(parameter!=null){
						double standytimes = 0;
						if(standytime!=null){
							standytimes = (standytime.divide(new BigInteger("60"))).doubleValue();
						}
						double  time = (weld.getWorktime().divide(new BigInteger("60"))).doubleValue();
						String[] str = parameter.getWireweight().split(",");
						double wireweight =Double.valueOf(str[0]);
						double wire = (double)Math.round(wireweight*parameter.getSpeed()*time*100)/100;//焊丝消耗量=焊丝|焊丝重量*送丝速度*焊接时间
						double air = (double)Math.round(parameter.getAirflow()*time*100)/100;//气体消耗量=气体流量*焊接时间
						double  electric = (double)Math.round(time*weld.getElectricity()*weld.getVoltage()+standytimes*parameter.getStandbypower()*100)/100;//电能消耗量=焊接时间*焊接平均电流*焊接平均电压+待机时间*待机功率
						json.put("t6", wire);//焊丝消耗
						json.put("t7", electric);//电能消耗
						json.put("t8", air);//气体消耗
					}
				}else{
					json.put("t2", 0);
					json.put("t3", "00:00:00");
					json.put("t4", "00:00:00");
					json.put("t5", 0);
					json.put("t6", 0);
					json.put("t7", 0);
					json.put("t8", 0);
				}
				ary.add(json);
			}
			//表头
			String [] str = {"焊工编号","焊工名称","焊接焊缝数","焊接时间","工作时间","焊接效率(%)","焊丝消耗(KG)","电能消耗(KWH)","气体消耗(L)"};
			for(int i=0;i<str.length;i++){
				title.put("title", str[i]);
				titleary.add(title);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("ary", titleary);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	public String getTimeStrBySecond(BigInteger timeParam ) {
		BigInteger[] str = timeParam.divideAndRemainder(new BigInteger("60"));//divideAndRemainder返回数组。第一个是商第二个时取模
		BigInteger second = str[1];
		BigInteger minuteTemp = timeParam.divide(new BigInteger("60"));//subtract：BigInteger相减，multiply：BigInteger相乘，divide : BigInteger相除
        if (minuteTemp.compareTo(new BigInteger("0"))>0) {//compareTo：比较BigInteger类型的大小，大则返回1，小则返回-1 ，等于则返回0
        	BigInteger[] minstr = minuteTemp.divideAndRemainder(new BigInteger("60"));
    		BigInteger minute = minstr[1];
    		BigInteger hour = minuteTemp.divide(new BigInteger("60"));
            if (hour.compareTo(new BigInteger("0"))>0) {
                return (hour.compareTo(new BigInteger("9"))>0 ? (hour + "") : ("0" + hour)) + ":" + (minute.compareTo(new BigInteger("9"))>0 ? (minute + "") : ("0" + minute))
                        + ":" + (second .compareTo(new BigInteger("9"))>0 ? (second + "") : ("0" + second));
            } else {
                return "00:" + (minute.compareTo(new BigInteger("9"))>0 ? (minute + "") : ("0" + minute)) + ":"
                        + (second .compareTo(new BigInteger("9"))>0 ? (second + "") : ("0" + second));
            }
        } else {
            return "00:00:" + (second .compareTo(new BigInteger("9"))>0 ? (second + "") : ("0" + second));
        }
	}
}


