package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spring.dto.ModelDto;
import com.spring.dto.WeldDto;
import com.spring.model.LiveData;
import com.spring.service.LiveDataService;
import com.sshome.ssmcxf.webservice.LiveDataWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
public class LiveDataWebServiceImpl implements LiveDataWebService {
	@Autowired
	private LiveDataService live;
	
	@Override
	public Object getCausehour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("STR"));
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getCausehour(dto, new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object getCompanyhour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("STR"));
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list =  live.getCompanyhour(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemhour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("STR"));
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setParent(new BigInteger(json.getString("INSFID")));
			List<ModelDto>list = live.getItemhour(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getJunctionHous(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setDtoItem(new BigInteger(json.getString("ITEMINSFID")));
			dto.setDtoMaterial(json.getString("MATERIAL"));
			dto.setDtoExternalDiameter(json.getString("EXTERNALDIAMETER"));
			dto.setDtoWallThickness(json.getString("WALLTHICKNESS"));
			dto.setDtoNextExternalDiameter(json.getString("NEXTEXTERNALDIAMETER"));
			dto.setNextmaterial(json.getString("NEXTMATERIAL"));
			dto.setNextwallthickness(json.getString("NEXTWALLTHICKNESS"));
			List<ModelDto> list = live.getJunctionHous(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCauseOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCauseOverproof(dto, new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemOverproof(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getAllInsf(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getAllInsf(new BigInteger(json.getString("INSFID")), json.getInt("TYPEID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getAllTime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<LiveData> list = live.getAllTime(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompanyOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyOverproof(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDatailOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setTime("%"+json.getString("WELDTIME")+"%");
			List<ModelDto> list = live.getDatailOverproof(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getCountTime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			String welderno = json.getString("WELDERNO");
			String machineno = json.getString("MACHINENO");
			String junctionno = json.getString("JUNCTIONNO");
			String time = json.getString("TIME");
			BigInteger id = new BigInteger(json.getString("ITEMINSFID"));
			return live.getCountTime(welderno, machineno, junctionno, time, id);
		}catch(Exception e){
			return -1;
		}		
	}

	@Override
	public Object getjunctionoverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			String welderno = json.getString("WELDERNO");
			String machineno = json.getString("MACHINENO");
			String junctionno = json.getString("JUNCTIONNO");
			String time = json.getString("TIME");
			BigInteger itemid = new BigInteger(json.getString("ITEMINSFID"));
			List<ModelDto> list = live.getjunctionoverproof(welderno, machineno, junctionno, time, itemid);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getcompanyOvertime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getcompanyOvertime(dto, json.getString("NUMBER"), new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustOvertime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustOvertime(dto, json.getString("NUMBER"), new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemOvertime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setParent(new BigInteger(json.getString("ITEMINSFID")));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemOvertime(dto, json.getString("NUMBER"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getJunction(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getJunction(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDetailovertime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getDetailovertime(dto, json.getString("NUMBER"),json.getString("ITEMINSFID"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompanyLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyLoads(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustLoads(dto, new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemLoads(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getMachine(new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDetailLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setTime("%"+json.getString("WELDTIME")+"%");
			dto.setParent(new BigInteger(json.getString("ITEMINSFID")));
			List<ModelDto> list = live.getDetailLoads(dto, null);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompanyNoLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyNoLoads(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustNOLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustNOLoads(dto, new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemNOLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemNOLoads(dto, new BigInteger(json.getString("ITEMINSFID")), null);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompanyIdle(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyIdle(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustIdle(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustIdle(dto, new BigInteger(json.getString("INSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemIdle(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemIdle(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getMachineCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getMachineCount(new BigInteger(json.getString("INSFID")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getCompanyUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getCompanyUse(dto, new BigInteger(json.getString("CAUSTINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getCaustUse(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getItemUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getItemUse(dto, new BigInteger(json.getString("ITEMINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlochour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("STR"));
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getBlochour(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getBlocOverproof(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocOvertime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getBlocOvertime(dto, json.getString("NUMBER"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getBlocLoads(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocNoLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getBlocNoLoads(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocIdle(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getBlocIdle(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			List<ModelDto> list = live.getBlocUse(dto, new BigInteger(json.getString("COMPANYINSFID")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocChildren() {
		try{
			List<LiveData> list = live.getBlocChildren();
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object caustEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
		    int min = json.getInt("MIN");
		    int max = json.getInt("MAX");
			List<ModelDto> list = live.caustEfficiency(new BigInteger(json.getString("ITEMINSFID")), dto,min,max);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object companyEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
		    int min = json.getInt("MIN");
		    int max = json.getInt("MAX");
			List<ModelDto> list = live.companyEfficiency(new BigInteger(json.getString("CAUSTINSFID")), dto,min,max);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object blocEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
		    int min = json.getInt("MIN");
		    int max = json.getInt("MAX");
			List<ModelDto> list = live.blocEfficiency(dto, new BigInteger(json.getString("COMPANYINSFID")),min,max);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getEfficiencyChart(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			BigInteger id = new BigInteger(json.getString("INSFID"));
			List<ModelDto> list = live.getEfficiencyChartNum(dto, id);
			List<ModelDto> efficiency = null;
			for(ModelDto m:list){
				efficiency = live.getEfficiencyChart(dto, id, m.getMinnum(), m.getAvgnum());
			}
			return JSON.toJSONString(efficiency);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getHousClassify(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<ModelDto> list = live.getHousClassify(new BigInteger(json.getString("INSFID")), json.getString("STR"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getDetailNoLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			dto.setTime("%"+json.getString("WELDTIME")+"%");
			dto.setParent(new BigInteger(json.getString("ITEMINSFID")));
			List<ModelDto> list = live.getDetailNoLoads(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getBlocMachineCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustMachineCount(dto, new BigInteger(json.getString("PARENT")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCompanyMachineCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustMachineCount(dto, new BigInteger(json.getString("PARENT")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getCaustMachineCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("STARTTIME"));
			dto.setDtoTime2(json.getString("ENDTIME"));
			int type = json.getInt("TYPEID");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustMachineCount(dto, new BigInteger(json.getString("PARENT")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}
}
