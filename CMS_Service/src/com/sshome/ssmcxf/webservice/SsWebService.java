package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;

public interface SsWebService {
	
	public BigInteger FindIns_Id(String insname);
	public Boolean AddWeld(String aweld);
	public Boolean UpdateWeld(String uweld);
	public Boolean AddJunction(String ajunction);
	public Boolean UpdateJunction(String ujunction);
	public Boolean DeleteJunction(String djunction);
	
}
