package com.greatway.model;

import java.math.BigInteger;

public class Fault {
	private BigInteger id;
	private String code;
	private String type;
	private String desc;
	private String creator;
	private String modifier;
	private String valuename;
	
	public String getValuename() {
		return valuename;
	}
	public void setValuename(String valuename) {
		this.valuename = valuename;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
}
