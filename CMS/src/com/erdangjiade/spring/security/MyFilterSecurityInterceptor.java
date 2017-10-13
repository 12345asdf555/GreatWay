package com.erdangjiade.spring.security;  
 
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;  
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;  
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;  
 
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor  implements Filter {    
 
    @Resource    
    @Qualifier("MyInvocationSecurityMetadataSource")    
    private FilterInvocationSecurityMetadataSource securityMetadataSource;    
       
    
    @Resource    
    @Qualifier("MyAccessDecisionManager")    
    @Override    
    public void setAccessDecisionManager(    
            AccessDecisionManager accessDecisionManager) {    
        // TODO Auto-generated method stub    
        super.setAccessDecisionManager(accessDecisionManager);    
    }    
/*    @Resource  
    @Qualifier("customAccessDecisionManager")  
    public AccessDecisionManager accessDecisionManager;*/    
        
/*    @Resource  
    @Qualifier("authenticationManager")  
    public AuthenticationManager authenticationManager;*/    
        
        
    @Resource    
    @Qualifier("authenticationManager")    
    @Override    
    public void setAuthenticationManager(AuthenticationManager newManager) {    
        super.setAuthenticationManager(newManager);    
    }    
        
    /*  
     * <p>Title: doFilter</p>  
     * <p>Description: </p>  
     * @param arg0  
     * @param arg1  
     * @param arg2  
     * @throws IOException  
     * @throws ServletException  
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)  
     */    
    @Override    
    public void doFilter(ServletRequest request, ServletResponse response,    
            FilterChain chain) throws IOException, ServletException {    
        FilterInvocation fi = new FilterInvocation(request, response, chain);    
        infoke(fi);    
    
    }    
    
    /**  
     * TODO(这里用一句话描述这个方法的作用).  
     * @param fi   
     * @throws ServletException   
     * @throws IOException   
     */    
    private void infoke(FilterInvocation fi) throws IOException, ServletException {    
        InterceptorStatusToken token = super.beforeInvocation(fi);    
            
        try {    
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());    
        } finally {    
            super.afterInvocation(token, null);    
        }    
            
    }    
    
    /*  
     * <p>Title: init</p>  
     * <p>Description: </p>  
     * @param arg0  
     * @throws ServletException  
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)  
     */    
    @Override    
    public void init(FilterConfig arg0) throws ServletException {    
        // TODO Auto-generated method stub    
    
    }    
    
    /*  
     * <p>Title: getSecureObjectClass</p>  
     * <p>Description: </p>  
     * @return  
     * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#getSecureObjectClass()  
     */    
    @Override    
    public Class<?> getSecureObjectClass() {    
        // TODO Auto-generated method stub    
        return FilterInvocation.class;    
    }    
    
    /*  
     * <p>Title: obtainSecurityMetadataSource</p>  
     * <p>Description: </p>  
     * @return  
     * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#obtainSecurityMetadataSource()  
     */    
    @Override    
    public SecurityMetadataSource obtainSecurityMetadataSource() {    
        // TODO Auto-generated method stub    
        return this.securityMetadataSource;    
    }    
        
    /*  
     * <p>Title: destroy</p>  
     * <p>Description: </p>  
     * @see javax.servlet.Filter#destroy()  
     */    
    @Override    
    public void destroy() {    
        // TODO Auto-generated method stub    
    
    }    
        
    
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {    
        return securityMetadataSource;    
    }    
        
    
    public void setSecurityMetadataSource(    
            FilterInvocationSecurityMetadataSource securityMetadataSource) {    
        this.securityMetadataSource = securityMetadataSource;    
    }    
}