package com.spring.model;

import java.math.BigInteger;

public class DataStatistics {
	private BigInteger id;
	private String name;
	private int total;
	private int num;
	private String wireweight;
	private double speed;
	private double airflow;
	private double standbypower;
	private int machinenum;
	private int junctionnum;
	private BigInteger worktime; 
	private double voltage;
	private double electricity;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWireweight() {
		return wireweight;
	}
	public void setWireweight(String wireweight) {
		this.wireweight = wireweight;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getAirflow() {
		return airflow;
	}
	public void setAirflow(double airflow) {
		this.airflow = airflow;
	}
	public double getStandbypower() {
		return standbypower;
	}
	public void setStandbypower(double standbypower) {
		this.standbypower = standbypower;
	}
	public int getMachinenum() {
		return machinenum;
	}
	public void setMachinenum(int machinenum) {
		this.machinenum = machinenum;
	}
	public int getJunctionnum() {
		return junctionnum;
	}
	public void setJunctionnum(int junctionnum) {
		this.junctionnum = junctionnum;
	}
	public BigInteger getWorktime() {
		return worktime;
	}
	public void setWorktime(BigInteger worktime) {
		this.worktime = worktime;
	}
	public double getVoltage() {
		return voltage;
	}
	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	public double getElectricity() {
		return electricity;
	}
	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}
	
}
