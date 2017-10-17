package com.greatway.dto;

import java.math.BigInteger;

public class WeldDto {
	private BigInteger dtoId;
	private String dtoTime1;
	private String dtoTime2;
	private BigInteger dtoItem;
	private int dtoStatus;
	private String dtoMaterial;
	private String dtoExternalDiameter;
	private String dtoNextExternalDiameter;
	private String dtoWallThickness;
	private String year;
	private String month;
	private String day;
	private String week;
	private BigInteger uid;
	private BigInteger parent;
	private BigInteger companyid;
	
	public BigInteger getCompanyid() {
		return companyid;
	}
	public void setCompanyid(BigInteger companyid) {
		this.companyid = companyid;
	}
	public BigInteger getParent() {
		return parent;
	}
	public void setParent(BigInteger parent) {
		this.parent = parent;
	}
	public BigInteger getUid() {
		return uid;
	}
	public void setUid(BigInteger uid) {
		this.uid = uid;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDtoMaterial() {
		return dtoMaterial;
	}
	public void setDtoMaterial(String dtoMaterial) {
		this.dtoMaterial = dtoMaterial;
	}
	public String getDtoExternalDiameter() {
		return dtoExternalDiameter;
	}
	public void setDtoExternalDiameter(String dtoExternalDiameter) {
		this.dtoExternalDiameter = dtoExternalDiameter;
	}
	public String getDtoNextExternalDiameter() {
		return dtoNextExternalDiameter;
	}
	public void setDtoNextExternalDiameter(String dtoNextExternalDiameter) {
		this.dtoNextExternalDiameter = dtoNextExternalDiameter;
	}
	public String getDtoWallThickness() {
		return dtoWallThickness;
	}
	public void setDtoWallThickness(String dtoWallThickness) {
		this.dtoWallThickness = dtoWallThickness;
	}
	public BigInteger getDtoId() {
		return dtoId;
	}
	public void setDtoId(BigInteger dtoId) {
		this.dtoId = dtoId;
	}
	public String getDtoTime1() {
		return dtoTime1;
	}
	public void setDtoTime1(String dtoTime1) {
		this.dtoTime1 = dtoTime1;
	}
	public String getDtoTime2() {
		return dtoTime2;
	}
	public void setDtoTime2(String dtoTime2) {
		this.dtoTime2 = dtoTime2;
	}
	public BigInteger getDtoItem() {
		return dtoItem;
	}
	public void setDtoItem(BigInteger dtoItem) {
		this.dtoItem = dtoItem;
	}
	public int getDtoStatus() {
		return dtoStatus;
	}
	public void setDtoStatus(int dtoStatus) {
		this.dtoStatus = dtoStatus;
	}
	
}
