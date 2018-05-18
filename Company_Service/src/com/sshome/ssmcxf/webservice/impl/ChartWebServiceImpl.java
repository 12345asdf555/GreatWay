package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.ModelDto;
import com.spring.service.ChartService;
import com.sshome.ssmcxf.webservice.ChartWebService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
@Transactional
public class ChartWebServiceImpl implements ChartWebService {
	@Autowired
	private ChartService cs;
	
	@Override
	public String getEfficiency(String object) {
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		try{
			JSONObject obj = JSONObject.fromObject(object);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date(obj.getString("TIME")))+"%";
			List<ModelDto> list = cs.getEfficiency(time);
			for(ModelDto m : list){
				json.put("caustname",m.getFname());
				json.put("itemname",m.getIname());
				json.put("weldername",m.getWname());
				json.put("welderid",m.getFwelder_id());
				String[] str = m.getJidgather().split(",");
				String search = "and (";
				for(int i=0;i<str.length;i++){
					search += " fid = "+str[i];
					if(i<str.length-1){
						search += " or";
					}
				}
				search += " )";
				BigInteger dyne = cs.getDyneByJunctionno(search);
				json.put("dyne",dyne);
				double weldtime = (double)Math.round(Double.valueOf(m.getWeldTime())*100)/100;
				json.put("weldtime",weldtime);
				json.put("num",str.length);
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(ary.isEmpty()){
			ary.add("{\"caustname\":\"\",\"itemname\":\"\",\"weldername\":\"\",\"welderid\":\"\",\"dyne\":\"\",\"weldtime\":\"\",\"num\":\"\"}");
		}
		return ary.toString();
	}

	@Override
	public String getHour(String object) {
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		try{
			JSONObject obj = JSONObject.fromObject(object);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date(obj.getString("TIME")))+"%";
			List<ModelDto> list = cs.getHour(time,obj.getString("STR"));
			for(ModelDto l:list){
				json.put("blocname",l.getIname());
				json.put("itemname",l.getFname());
				String[] str = l.getJidgather().split(",");
				if(l.getJidgather().equals("0")){
					json.put("junctionnum", "0");
					json.put("avgtime", 0);
					json.put("dyne",0);
				}else{
					json.put("junctionnum", str.length);
					double hour = (double)Math.round(l.getHous().doubleValue()/str.length*100)/100;
					json.put("avgtime", hour);
					String strsql = "and (";
					for(int i=0;i<str.length;i++){
						strsql += " fid = "+str[i];
						if(i<str.length-1){
							strsql += " or";
						}
					}
					strsql += " )";
					BigInteger dyne = cs.getDyneByJunctionno(strsql);
					json.put("dyne",dyne);
				}
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(ary.isEmpty()){
			ary.add("{\"blocname\":\"\",\"itemname\":\"\",\"junctionnum\":\"\",\"avgtime\":\"\",\"dyne\":\"\"}");
		}
		return ary.toString();
	}

	@Override
	public String getHourClassify(String object) {
		JSONArray ary = new JSONArray();
		JSONObject json = new JSONObject();
		try{
			JSONObject obj = JSONObject.fromObject(object);
			List<ModelDto> list = cs.getHourClassify(obj.getString("STR"));
			for(ModelDto m : list){
				json.put("material",m.getMaterial());
				json.put("nextmaterial",m.getNextmaterial());
				json.put("wall_thickness",m.getWallThickness());
				json.put("nextwall_thickness",m.getNextwallThickness());
				json.put("external_diameter",m.getExternalDiameter());
				json.put("nextExternal_diameter",m.getNextexternaldiameter());
				ary.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(ary.isEmpty()){
			ary.add("{\"material\":\"\",\"nextmaterial\":\"\",\"wall_thickness\":\"\",\"nextwall_thickness\":\"\",\"external_diameter\":\"\",\"nextExternal_diameter\":\"\"}");
		}
		return ary.toString();
	}
	

	@Override
	public String getOverproof(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOvertime(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoads(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoLoads(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdle(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUse(String object) {
		// TODO Auto-generated method stub
		return null;
	}

}
