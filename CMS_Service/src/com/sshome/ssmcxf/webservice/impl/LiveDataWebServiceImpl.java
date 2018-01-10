package com.sshome.ssmcxf.webservice.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.ModelDto;
import com.spring.dto.WeldDto;
import com.spring.model.LiveData;
import com.spring.model.Td;
import com.spring.model.WeldedJunction;
import com.spring.service.LiveDataService;
import com.spring.service.TdService;
import com.sshome.ssmcxf.webservice.LiveDataWebService;

import net.sf.json.JSONObject;

@Transactional
@Service
@WebService(endpointInterface = "com.sshome.ssmcxf.webservice.LiveDataWebService", serviceName = "LiveDataWebService")
public class LiveDataWebServiceImpl implements LiveDataWebService {
	@Autowired
	private LiveDataService live;
	

	@Override
	public List<ModelDto> getCausehour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getCausehour(dto, new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ModelDto> getCompanyhour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getCompanyhour(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemhour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setParent(new BigInteger(json.getString("insfId")));
			return live.getItemhour(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getJunctionHous(String object) {
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
			return live.getJunctionHous(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCauseOverproof(String object) {
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
			return live.getCauseOverproof(dto, new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemOverproof(String object) {
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
			return live.getItemOverproof(dto, new BigInteger(json.getString("itemInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<LiveData> getAllInsf(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getAllInsf(new BigInteger(json.getString("insfId")), json.getInt("typeId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<LiveData> getAllTime(String object) {
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
			return live.getAllTime(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCompanyOverproof(String object) {
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
			return live.getCompanyOverproof(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getDatailOverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			return live.getDatailOverproof(dto, new BigInteger(json.getString("itemInsfId")));
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
	public List<ModelDto> getjunctionoverproof(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			String welderno = json.getString("welderNo");
			String machineno = json.getString("machineNo");
			String junctionno = json.getString("junctionNo");
			String time = json.getString("time");
			BigInteger itemid = new BigInteger(json.getString("itemInsfId"));
			return live.getjunctionoverproof(welderno, machineno, junctionno, time, itemid);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getcompanyOvertime(String object) {
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
			return live.getcompanyOvertime(dto, json.getString("number"), new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCaustOvertime(String object) {
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
			return live.getCaustOvertime(dto, json.getString("number"), new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemOvertime(String object) {
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
			return live.getItemOvertime(dto, json.getString("number"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<LiveData> getJunction(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getJunction(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getDetailovertime(String object) {
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
			return live.getDetailovertime(dto, json.getString("number"),json.getString("itemInsfId"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCompanyLoads(String object) {
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
			return live.getCompanyLoads(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCaustLoads(String object) {
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
			return live.getCaustLoads(dto, new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemLoads(String object) {
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
			return live.getItemLoads(dto, new BigInteger(json.getString("itemInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<LiveData> getMachine(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getMachine(new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getDetailLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			dto.setParent(new BigInteger(json.getString("itemInsfId")));
			return live.getDetailLoads(dto, null);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCompanyNoLoads(String object) {
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
			return live.getCompanyNoLoads(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCaustNOLoads(String object) {
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
			return live.getCaustNOLoads(dto, new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemNOLoads(String object) {
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
			return live.getItemNOLoads(dto, new BigInteger(json.getString("itemInsfId")), null);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCompanyIdle(String object) {
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
			return live.getCompanyIdle(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCaustIdle(String object) {
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
			return live.getCaustIdle(dto, new BigInteger(json.getString("insfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemIdle(String object) {
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
			return live.getItemIdle(dto, new BigInteger(json.getString("itemInsfId")));
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
	public List<ModelDto> getCompanyUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getCompanyUse(dto, new BigInteger(json.getString("caustInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getCaustUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getCaustUse(dto, new BigInteger(json.getString("ItemInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getItemUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getItemUse(dto, new BigInteger(json.getString("ItemInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlochour(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setSearch(json.getString("str"));
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getBlochour(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocOverproof(String object) {
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
			return live.getBlocOverproof(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocOvertime(String object) {
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
			return live.getBlocOvertime(dto, json.getString("number"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocLoads(String object) {
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
			return live.getBlocLoads(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocNoLoads(String object) {
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
			return live.getBlocNoLoads(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocIdle(String object) {
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
			return live.getBlocIdle(dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getBlocUse(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.getBlocUse(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<LiveData> getBlocChildren() {
		try{
			return live.getBlocChildren();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> caustEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.caustEfficiency(new BigInteger(json.getString("itemInsfId")), dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> companyEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.companyEfficiency(new BigInteger(json.getString("caustInsfId")), dto);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> blocEfficiency(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			return live.blocEfficiency(dto, new BigInteger(json.getString("companyInsfId")));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getEfficiencyChart(String object) {
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
			return efficiency;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getHousClassify(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			return live.getHousClassify(new BigInteger(json.getString("insfId")), json.getString("str"));
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ModelDto> getDetailNoLoads(String object) {
		try{
			JSONObject json = JSONObject.fromObject(object);
			WeldDto dto = new WeldDto();
			dto.setDtoTime1(json.getString("startTime"));
			dto.setDtoTime2(json.getString("endTime"));
			dto.setTime("%"+json.getString("weldTime")+"%");
			dto.setParent(new BigInteger(json.getString("itemInsfId")));
			return live.getDetailNoLoads(dto);
		}catch(Exception e){
			return null;
		}
	}
}
