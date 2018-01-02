package com.spring.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.spring.dao.UserMapper;
import com.spring.model.User;
import com.spring.service.UserService;

import net.sf.json.JSONObject;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;
	
	public Boolean AddWeld(String aweld) {
		try{
		JSONObject json = JSONObject.fromObject(aweld);
		User user = new User();
		user.setFitemid(new BigInteger(json.getString("fItemID")));
		user.setFname(json.getString("fname"));
		user.setFwelder_no(json.getString("fwelder_no"));
		mapper.AddWeld(user);
		return true;
		}catch(Exception e){
		return false;
		}
	}

	public Boolean UpdateWeld(String uweld) {
		try{
		JSONObject json = JSONObject.fromObject(uweld);
		User user = new User();
		user.setFitemid(new BigInteger(json.getString("fItemID")));
		user.setFname(json.getString("fname"));
		user.setFwelder_no(json.getString("fwelder_no"));
		mapper.UpdateWeld(user);
		return true;
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean AddJunction(String ajunction) {
		// TODO Auto-generated method stub
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONObject json = JSONObject.fromObject(ajunction);
		User user = new User();
		user.setFwjn(json.getString("fwelded_junction_no"));
		user.setFsn(json.getString("fserial_no"));
		user.setFpn(json.getString("fpipeline_no"));
		user.setFrn(json.getString("froom_no"));
		user.setFunit(json.getString("funit"));
		user.setFarea(json.getString("farea"));
		user.setFsystems(json.getString("fsystems"));
		user.setFchildren(json.getString("fchildren"));
		user.setFed(json.getString("fexternal_diameter"));
		user.setFwt(json.getString("fwall_thickness"));
		user.setFdyne(Integer.parseInt(json.getString("fdyne")));
		user.setFspecification(json.getString("fspecification"));
		user.setFmaxele(new BigDecimal(json.getString("fmax_electricity")));
		user.setFminele(new BigDecimal(json.getString("fmin_electricity")));
		user.setFmaxval(new BigDecimal(json.getString("fmax_valtage")));
		user.setFminval(new BigDecimal(json.getString("fmin_valtage")));
		user.setFele_unit(json.getString("felectricity_unit"));
		user.setFval_unit(json.getString("fvaltage_unit"));
		user.setFitemid(new BigInteger(json.getString("fItemID")));
		user.setFmaterial(json.getString("fmeterial"));
		user.setFnd(json.getString("fnextExternal_diameter"));
		user.setFnt(json.getString("fnextwall_thickness"));
		user.setFnm(json.getString("fnextMeterial"));
		user.setFstart_time(sdf.parse(json.getString("fstart_time")));
		user.setFend_time(sdf.parse(json.getString("fend_time")));
/*		user.setFcreatetime(sdf.parse(json.getString("fcreatetime")));
		user.setFupdatetime(sdf.parse(json.getString("fupdatetime")));
		user.setFupdatecount(Integer.parseInt(json.getString("fupdatecount")));*/
		mapper.AddJunction(user);
		return true;
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean UpdateJunction(String ujunction) {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONObject json = JSONObject.fromObject(ujunction);
		User user = new User();
		user.setFwjn(json.getString("fwelded_junction_no"));
		user.setFsn(json.getString("fserial_no"));
		user.setFpn(json.getString("fpipeline_no"));
		user.setFrn(json.getString("froom_no"));
		user.setFunit(json.getString("funit"));
		user.setFarea(json.getString("farea"));
		user.setFsystems(json.getString("fsystems"));
		user.setFchildren(json.getString("fchildren"));
		user.setFed(json.getString("fexternal_diameter"));
		user.setFwt(json.getString("fwall_thickness"));
		user.setFdyne(Integer.parseInt(json.getString("fdyne")));
		user.setFspecification(json.getString("fspecification"));
		user.setFmaxele(new BigDecimal(json.getString("fmax_electricity")));
		user.setFminele(new BigDecimal(json.getString("fmin_electricity")));
		user.setFele_unit(json.getString("felectricity_unit"));
		user.setFval_unit(json.getString("fvaltage_unit"));
		user.setFmaxval(new BigDecimal(json.getString("fmax_valtage")));
		user.setFminval(new BigDecimal(json.getString("fmin_valtage")));
		user.setFitemid(new BigInteger(json.getString("fItemID")));
		user.setFmaterial(json.getString("fmeterial"));
		user.setFnd(json.getString("fnextExternal_diameter"));
		user.setFnt(json.getString("fnextwall_thickness"));
		user.setFnm(json.getString("fnextMeterial"));
		user.setFstart_time(sdf.parse(json.getString("fstart_time")));
		user.setFend_time(sdf.parse(json.getString("fend_time")));
/*		user.setFcreatetime(sdf.parse(json.getString("fcreatetime")));
		user.setFupdatetime(sdf.parse(json.getString("fupdatetime")));
		user.setFupdatecount(Integer.parseInt(json.getString("fupdatecount")));*/
		mapper.UpdateJunction(user);
		return true;
		}catch(Exception e){
			return false;
		}	
	}

	@Override
	public Boolean DeleteJunction(String djunction) {
		try{
		JSONObject json = JSONObject.fromObject(djunction);
		User user = new User();
		user.setFitemid(new BigInteger(json.getString("fItemID")));
		user.setFsn(json.getString("fserial_no"));
		mapper.DeleteJunction(user);
		return true;
		}catch(Exception e){
			return false;
		}	
	}

	public BigInteger FindIns_Id(String insname) {
		JSONObject json = JSONObject.fromObject(insname);
		User user = new User();
		user.setFname(json.getString("fname"));
		return mapper.FindIns_Id(user);
	}

}