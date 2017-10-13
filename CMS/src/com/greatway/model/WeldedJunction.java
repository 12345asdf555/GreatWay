package com.greatway.model;

import java.math.BigInteger;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * 焊口
 * @author gpyf16
 *
 */
@Component
public class WeldedJunction {
	private BigInteger id;
	private String weldedJunctionno;
	private String serialNo;
	private String pipelineNo;
	private String roomNo;
	private String unit;
	private String area;
	private String systems;
	private String children;
	private String externalDiameter;
	private String wallThickness;
	private int dyne;
	private String specification;
	private double maxElectricity;
	private double minElectricity;
	private double maxValtage;
	private double minValtage;
	private String material;//材质（新增字段）
	private String nextexternaldiameter;//下游外径（新增字段）
	private String startTime;
	private String endTime;
	@Transient
	private Insframework itemid;//所属项目（新增字段）
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getWeldedJunctionno() {
		return weldedJunctionno;
	}
	public void setWeldedJunctionno(String weldedJunctionno) {
		this.weldedJunctionno = weldedJunctionno;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getPipelineNo() {
		return pipelineNo;
	}
	public void setPipelineNo(String pipelineNo) {
		this.pipelineNo = pipelineNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSystems() {
		return systems;
	}
	public void setSystems(String systems) {
		this.systems = systems;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
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
	public int getDyne() {
		return dyne;
	}
	public void setDyne(int dyne) {
		this.dyne = dyne;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public double getMaxElectricity() {
		return maxElectricity;
	}
	public void setMaxElectricity(double maxElectricity) {
		this.maxElectricity = maxElectricity;
	}
	public double getMinElectricity() {
		return minElectricity;
	}
	public void setMinElectricity(double minElectricity) {
		this.minElectricity = minElectricity;
	}
	public double getMaxValtage() {
		return maxValtage;
	}
	public void setMaxValtage(double maxValtage) {
		this.maxValtage = maxValtage;
	}
	public double getMinValtage() {
		return minValtage;
	}
	public void setMinValtage(double minValtage) {
		this.minValtage = minValtage;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public Insframework getItemid() {
		return itemid;
	}
	public void setItemid(Insframework itemid) {
		this.itemid = itemid;
	}
	
	
	
}
