package com.greatway.dto;

import java.math.BigInteger;

/**
 * 超标查询显示数据不全面的问题
 * 需要创建一个dto类（也就是該类）保存所查询的字段
 * @author gpyf16
 */
public class ModelDto {
	private BigInteger overproof;
	private String weldTime;
	private BigInteger fid;
	private BigInteger iid;
	private BigInteger jid;
	private String fname;
	private String fwelder_id;
	private String fmachine_id;
	private String fjunction_id;
	private String felectricity;
	private String fvoltage;
	private String iname;
	private String wname;
	private BigInteger livecount;
	private double fmax_electricity;
	private double fmin_electricity;
	private String overtime;
	private String uploaddatetime;
	private double loads;
	private BigInteger idle;
	private double time;
	private String type;
	private BigInteger dyne;
	private BigInteger num;
	
	public BigInteger getDyne() {
		return dyne;
	}
	public void setDyne(BigInteger dyne) {
		this.dyne = dyne;
	}
	public BigInteger getNum() {
		return num;
	}
	public void setNum(BigInteger num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public BigInteger getIdle() {
		return idle;
	}
	public void setIdle(BigInteger idle) {
		this.idle = idle;
	}
	public double getLoads() {
		return loads;
	}
	public void setLoads(double loads) {
		this.loads = loads;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getUploaddatetime() {
		return uploaddatetime;
	}
	public void setUploaddatetime(String uploaddatetime) {
		this.uploaddatetime = uploaddatetime;
	}
	public BigInteger getIid() {
		return iid;
	}
	public void setIid(BigInteger iid) {
		this.iid = iid;
	}
	public BigInteger getJid() {
		return jid;
	}
	public void setJid(BigInteger jid) {
		this.jid = jid;
	}
	public String getFwelder_id() {
		return fwelder_id;
	}
	public void setFwelder_id(String fwelder_id) {
		this.fwelder_id = fwelder_id;
	}
	public String getFmachine_id() {
		return fmachine_id;
	}
	public void setFmachine_id(String fmachine_id) {
		this.fmachine_id = fmachine_id;
	}
	public String getFjunction_id() {
		return fjunction_id;
	}
	public void setFjunction_id(String fjunction_id) {
		this.fjunction_id = fjunction_id;
	}
	public String getFelectricity() {
		return felectricity;
	}
	public void setFelectricity(String felectricity) {
		this.felectricity = felectricity;
	}
	public String getFvoltage() {
		return fvoltage;
	}
	public void setFvoltage(String fvoltage) {
		this.fvoltage = fvoltage;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public double getFmax_electricity() {
		return fmax_electricity;
	}
	public void setFmax_electricity(double fmax_electricity) {
		this.fmax_electricity = fmax_electricity;
	}
	public double getFmin_electricity() {
		return fmin_electricity;
	}
	public void setFmin_electricity(double fmin_electricity) {
		this.fmin_electricity = fmin_electricity;
	}
	public BigInteger getOverproof() {
		return overproof;
	}
	public void setOverproof(BigInteger overproof) {
		this.overproof = overproof;
	}
	public BigInteger getLivecount() {
		return livecount;
	}
	public void setLivecount(BigInteger livecount) {
		this.livecount = livecount;
	}
	public String getWeldTime() {
		return weldTime;
	}
	public void setWeldTime(String weldTime) {
		this.weldTime = weldTime;
	}
	public BigInteger getFid() {
		return fid;
	}
	public void setFid(BigInteger fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
