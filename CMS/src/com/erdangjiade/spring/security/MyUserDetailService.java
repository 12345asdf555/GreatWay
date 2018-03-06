package com.erdangjiade.spring.security;  
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.model.MyUser;
import com.spring.service.UserService;

import net.sf.json.JSONObject;  

@Service("myUserDetailService")

public class MyUserDetailService implements UserDetailsService {   
 
		
		@Resource 
		@Autowired
	    private UserService userService;

	    /*  
	     * 根据用户名判断是否存在  
	     * <p>Title: loadUserByUsername</p>  
	     * <p>Description: </p>  
	     * @param arg0  
	     * @return  
	     * @throws UsernameNotFoundException  
	     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)  
	     */    
	 
	    @Override    
	    public UserDetails loadUserByUsername(String userName)    
	            throws UsernameNotFoundException {    
	    	long id=0;
	    	String password="";
	    	Collection<GrantedAuthority> auths = null;
			try {
		    	System.out.println(userName);
		    	HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				//当前层级
				String hierarchy = request.getSession().getServletContext().getInitParameter("hierarchy");
				String webserviceurl = "";
				if(hierarchy.equals("1")){
					webserviceurl = request.getSession().getServletContext().getInitParameter("blocurl");
				}else if(hierarchy.equals("2") || hierarchy.equals("3")){
					webserviceurl = request.getSession().getServletContext().getInitParameter("companyurl");
				}else{
					webserviceurl = request.getSession().getServletContext().getInitParameter("itemurl");
				}
				JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
				Client client = dcf.createClient(webserviceurl);
				String obj1 = "{\"CLASSNAME\":\"userWebServiceImpl\",\"METHOD\":\"LoadUser\"}";
				String obj2 = "{\"LOGINNAME\":\""+userName+"\"}";
				Object[] objects = client.invoke(new QName("http://webservice.ssmcxf.sshome.com/", "enterTheWS"), new Object[]{obj1,obj2});
				
				String result = objects[0].toString();
				System.out.println(result);
				JSONObject json = JSONObject.fromObject(result);
				id = json.getLong("id");
				password = json.getString("userPassword");
				System.out.println(id);
		        auths = new ArrayList<GrantedAuthority>();    
		        List<String> list = userService.getAuthoritiesByUsername(userName);    
		        System.out.println(list);
		        for (int j = 0; j < list.size(); j++) {    
		            auths.add(new GrantedAuthorityImpl(list.get(j)));    
		            System.out.println("loadUserByUsername : " + list.get(j));    
		        } 
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return new MyUser(id,userName, password, true, true, true, true, auths);    
	    }    
	    
    }