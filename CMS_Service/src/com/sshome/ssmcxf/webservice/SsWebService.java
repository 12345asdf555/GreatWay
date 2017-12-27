package com.sshome.ssmcxf.webservice;

import java.math.BigInteger;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface SsWebService {
	
	public BigInteger FindIns_Id(@WebParam(name="insname") String insname);
	public Boolean AddWeld(@WebParam(name="aweld") String aweld);
	public Boolean UpdateWeld(@WebParam(name="uweld") String uweld);
	public Boolean AddJunction(@WebParam(name="ajunction") String ajunction);
	public Boolean UpdateJunction(@WebParam(name="ujunction") String ujunction);
	public Boolean DeleteJunction(@WebParam(name="djunction") String djunction);
	
}
