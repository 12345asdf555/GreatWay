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
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.getCausehour(dto, new BigInteger(json.getString("insfId")));
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
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list =  live.getCompanyhour(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setParent(new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setDtoItem(new BigInteger(json.getString("itemInsfId")));
			dto.setDtoMaterial(json.getString("material"));
			dto.setDtoExternalDiameter(json.getString("externalDiameter"));
			dto.setDtoWallThickness(json.getString("wallThickness"));
			dto.setDtoNextExternalDiameter(json.getString("nextexternaldiameter"));
			dto.setNextmaterial(json.getString("nextmaterial"));
			dto.setNextwallthickness(json.getString("nextwallthickness"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCauseOverproof(dto, new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemOverproof(dto, new BigInteger(json.getString("itemInsfId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getAllInsf(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getAllInsf(new BigInteger(json.getString("insfId")), json.getInt("typeId"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyOverproof(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			List<ModelDto> list = live.getDatailOverproof(dto, new BigInteger(json.getString("itemInsfId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getCountTime(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			String welderno = json.getString("welderNo");
			String machineno = json.getString("machineNo");
			String junctionno = json.getString("junctionNo");
			String time = json.getString("time");
			BigInteger id = new BigInteger(json.getString("itemInsfId"));
			return live.getCountTime(welderno, machineno, junctionno, time, id);
		}catch(Exception e){
			return -1;
		}		
	}

	@Override
	public Object getjunctionoverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			String welderno = json.getString("welderNo");
			String machineno = json.getString("machineNo");
			String junctionno = json.getString("junctionNo");
			String time = json.getString("time");
			BigInteger itemid = new BigInteger(json.getString("itemInsfId"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			int overtimetype = json.getInt("overtimetypeId");
			if(overtimetype==1){
				dto.setHour("hour");
			}else if(overtimetype==2){
				dto.setSecond("second");
			}
			List<ModelDto> list = live.getcompanyOvertime(dto, json.getString("number"), new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			int overtimetype = json.getInt("overtimetypeId");
			if(overtimetype==1){
				dto.setHour("hour");
			}else if(overtimetype==2){
				dto.setSecond("second");
			}
			List<ModelDto> list = live.getCaustOvertime(dto, json.getString("number"), new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setParent(new BigInteger(json.getString("itemInsfId")));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			int overtimetype = json.getInt("overtimetypeId");
			if(overtimetype==1){
				dto.setHour("hour");
			}else if(overtimetype==2){
				dto.setSecond("second");
			}
			List<ModelDto> list = live.getItemOvertime(dto, json.getString("number"));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getJunction(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getJunction(new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			int overtimetype = json.getInt("overtimetypeId");
			if(overtimetype==1){
				dto.setHour("hour");
			}else if(overtimetype==2){
				dto.setSecond("second");
			}
			List<ModelDto> list = live.getDetailovertime(dto, json.getString("number"),json.getString("itemInsfId"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyLoads(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustLoads(dto, new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemLoads(dto, new BigInteger(json.getString("itemInsfId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Object getMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			List<LiveData> list = live.getMachine(new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			dto.setParent(new BigInteger(json.getString("itemInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyNoLoads(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustNOLoads(dto, new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemNOLoads(dto, new BigInteger(json.getString("itemInsfId")), null);
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCompanyIdle(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getCaustIdle(dto, new BigInteger(json.getString("insfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setWeek("week");
			}
			List<ModelDto> list = live.getItemIdle(dto, new BigInteger(json.getString("itemInsfId")));
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int getMachineCount(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getMachineCount(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return -1;
		}
	}

	@Override
	public Object getCompanyUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.getCompanyUse(dto, new BigInteger(json.getString("caustInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.getCaustUse(dto, new BigInteger(json.getString("ItemInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.getItemUse(dto, new BigInteger(json.getString("ItemInsfId")));
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
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
			if(type==1){
				dto.setYear("year");
			}else if(type==2){
				dto.setMonth("month");
			}else if(type==3){
				dto.setDay("day");
			}else if(type==4){
				dto.setWeek("week");
			}
			int overtimetype = json.getInt("overtimetypeId");
			if(overtimetype==1){
				dto.setHour("hour");
			}else if(overtimetype==2){
				dto.setSecond("second");
			}
			List<ModelDto> list = live.getBlocOvertime(dto, json.getString("number"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			int type = json.getInt("typeId");
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.getBlocUse(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.caustEfficiency(new BigInteger(json.getString("itemInsfId")), dto);
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.companyEfficiency(new BigInteger(json.getString("caustInsfId")), dto);
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			List<ModelDto> list = live.blocEfficiency(dto, new BigInteger(json.getString("companyInsfId")));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			BigInteger id = new BigInteger(json.getString("insfId"));
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
			List<ModelDto> list = live.getHousClassify(new BigInteger(json.getString("insfId")), json.getString("str"));
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
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			dto.setParent(new BigInteger(json.getString("itemInsfId")));
			List<ModelDto> list = live.getDetailNoLoads(dto);
			return JSON.toJSONString(list);
		}catch(Exception e){
			return null;
		}
	}
}
