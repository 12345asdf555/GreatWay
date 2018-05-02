package com.spring.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@Autowired
	private LiveDataService ls;

	@Autowired
	private InsframeworkService ins;

	IsnullUtil iutil = new IsnullUtil();
	private  final BigInteger HOUR_SECOND = new BigInteger("120");
	private  final BigInteger MINUTE_SECOND = new BigInteger("60");
	
	/**
	 * 跳转公司超标页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goItemData")
	public String goItemProductionData(HttpServletRequest request){
		return "datastatistics/itemdata";
	}
	
	@RequestMapping("/getItemData")
	public String getItemProductionData(HttpServletRequest request){
		pageIndex = Integer.parseInt(request.getParameter("page"));
		pageSize = Integer.parseInt(request.getParameter("rows"));
		String time1 = request.getParameter("dtoTime1");
		String time2 = request.getParameter("dtoTime2");
		page = new Page(pageIndex,pageSize,total);
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		JSONObject title = new JSONObject();
		WeldDto dto = new WeldDto();
		try{
			if(iutil.isNull(time1)){
				dto.setDtoTime1(time1);
			}
			if(iutil.isNull(time2)){
				dto.setDtoTime2(time2);
			}
			List<DataStatistics> list = dss.getItemMachineCount(page);
			long total = 0;
			
			if(list != null){
				PageInfo<DataStatistics> pageinfo = new PageInfo<DataStatistics>(list);
				total = pageinfo.getTotal();
			}
			for(DataStatistics i:list){
				json.put("name", i.getName());//所属班组
				json.put("total", i.getTotal());//设备总数
				if(i.getTotal()!=0){
					DataStatistics work = dss.getWorkNum(i.getId(), dto);//获取工作的焊机数,焊口数
					if(work!=null){
						if(work.getMachinenum()==0){
							ary.add(json);
							continue;
						}
					}
					int machinenum = dss.getStartingUpMachineNum(i.getId(),dto);//获取开机焊机总数
					BigInteger starttime = dss.getStaringUpTime(i.getId(), dto);//获取开机总时长
					BigInteger standytime = dss.getStandytime(i.getId(), dto);//获取待机总时长
					DataStatistics weldtime = dss.getWorkTimeAndEleVol(i.getId(),dto);//获取焊接时长，平均电流电压
					DataStatistics parameter = dss.getParameter();//获取参数
					if(work!=null){
						json.put("machinenum",work.getMachinenum() );//实焊设备数
						json.put("junctionnum", work.getJunctionnum());//焊接焊缝数
						json.put("weldtime", getTimeStrBySecond(weldtime.getWorktime()));//焊接时间
						double useratio =(double)Math.round(machinenum/i.getTotal()*100*100)/100;
						BigInteger weldingproductivity =weldtime.getWorktime().divide(starttime).multiply(new BigInteger("100"));
						json.put("useratio", useratio);//设备利用率
						json.put("weldingproductivity", weldingproductivity);//焊接效率
					}
					json.put("startnum", machinenum);//开机设备数
					json.put("starttime", getTimeStrBySecond(starttime));//工作时间
					if(parameter!=null){
						double  time = (weldtime.getWorktime().divide(new BigInteger("60"))).doubleValue();
						double standytimes = (standytime.divide(new BigInteger("60"))).doubleValue();
						String[] str = parameter.getWireweight().split(",");
						double wireweight =Double.valueOf(str[0]);
						double wire = wireweight*parameter.getSpeed()*time;
						double air = parameter.getAirflow()*time;
						double  electric = time*weldtime.getElectricity()*weldtime.getVoltage()+standytimes*parameter.getStandbypower();
						json.put("wire", wire);//焊丝消耗
						json.put("air", air);//气体消耗
						json.put("electric", electric);//电能消耗
					}
				}
				ary.add(json);
			}
//			title.put("title0", "所属班组");
//			title.put("title1", "设备总数");
//			title.put("title2", "开机设备数");
//			title.put("title3", "实焊设备数");
//			title.put("title4", "设备利用率(%)");
//			title.put("title5", "焊接焊缝数");
//			title.put("title6", "焊接时间");
//			title.put("title7", "工作时间");
//			title.put("title8", "焊接效率(%)");
//			title.put("title9", "焊丝消耗(KG)");
//			title.put("title10", "电能消耗(KWH)");
//			title.put("title11", "气体消耗(L)");
//			ary.add(title);
		}catch(Exception e){
			e.printStackTrace();
		}
		obj.put("total", total);
		obj.put("rows", ary);
		return obj.toString();
	}
	
	public String getTimeStrBySecond(BigInteger second) {
		BigInteger num = new BigInteger("0");
	    if (second.compareTo(num)<=0) {//compareTo：比较BigInteger类型的大小，大则返回1，小则返回-1 ，等于则返回0
	        return "00:00:00";
	    }

	    BigInteger hours = second.divide(HOUR_SECOND);//divide：BigInteger相除
	    if (hours.compareTo(num) > 0) {
	        second = second.subtract(hours.multiply(HOUR_SECOND));//subtract：BigInteger相减，multiply：BigInteger相乘
	    }

	    BigInteger minutes = second.multiply(MINUTE_SECOND);
	    if (minutes.compareTo(num)>0) {

	        second = second.subtract(minutes.multiply(MINUTE_SECOND));
	    }

		BigInteger ten = new BigInteger("10");
	    return (hours.compareTo(ten)>0 ? (hours + "")
	            : ("0" + hours) + ":" + (minutes.compareTo(ten)>0 ? (minutes + "") : ("0" + minutes)) + ":"
	                    + (second.compareTo(ten)>0 ? (second + "") : ("0" + second)));
	}
}


