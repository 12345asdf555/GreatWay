package com.spring.dto;

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
	private BigInteger eid;
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
	private int maxnum;
	private int minnum;
	private int avgnum;
	private String externalDiameter;//外径
	private String wallThickness;//璧厚
	private String material;//材质
	private String nextexternaldiameter;//下游外径
	private String nextwallThickness;//下游璧厚
	private String nextmaterial;//下游材质
	private BigInteger itemid;//项目id
	private String jidgather;
	private BigInteger hous;//用来获取工时的总值
	private String starttime;
	private String endtime;
	public BigInteger getOverproof() {
		return overproof;
	}
	public void setOverproof(BigInteger overproof) {
		this.overproof = overproof;
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
	public BigInteger getEid() {
		return eid;
	}
	public void setEid(BigInteger eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
	public BigInteger getLivecount() {
		return livecount;
	}
	public void setLivecount(BigInteger livecount) {
		this.livecount = livecount;
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
	public double getLoads() {
		return loads;
	}
	public void setLoads(double loads) {
		this.loads = loads;
	}
	public BigInteger getIdle() {
		return idle;
	}
	public void setIdle(BigInteger idle) {
		this.idle = idle;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	public int getMinnum() {
		return minnum;
	}
	public void setMinnum(int minnum) {
		this.minnum = minnum;
	}
	public int getAvgnum() {
		return avgnum;
	}
	public void setAvgnum(int avgnum) {
		this.avgnum = avgnum;
	}
	public String getExternalDiameter() {
		return externalDiameter;
	}
	public void setExternalDiameter(String externalDiameter) {
		this.externalDiameter = externalDiameter;
	}
	public String getWallThickness() {
		return wallThickness;
	}
	public void setWallThickness(String wallThickness) {
		this.wallThickness = wallThickness;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getNextexternaldiameter() {
		return nextexternaldiameter;
	}
	public void setNextexternaldiameter(String nextexternaldiameter) {
		this.nextexternaldiameter = nextexternaldiameter;
	}
	public String getNextwallThickness() {
		return nextwallThickness;
	}
	public void setNextwallThickness(String nextwallThickness) {
		this.nextwallThickness = nextwallThickness;
	}
	public String getNextmaterial() {
		return nextmaterial;
	}
	public void setNextmaterial(String nextmaterial) {
		this.nextmaterial = nextmaterial;
	}
	public BigInteger getItemid() {
		return itemid;
	}
	public void setItemid(BigInteger itemid) {
		this.itemid = itemid;
	}
	public String getJidgather() {
		return jidgather;
	}
	public void setJidgather(String jidgather) {
		this.jidgather = jidgather;
	}
	public BigInteger getHous() {
		return hous;
	}
	public void setHous(BigInteger hous) {
		this.hous = hous;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
