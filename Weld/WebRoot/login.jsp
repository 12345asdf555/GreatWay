<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> --%>
﻿<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
	<head>
<%-- 		<base href="<%=basePath%>"> --%>
		<title>管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
	 	<link rel="stylesheet" type="text/css" href="resources/css/login.css">

	</head>

	<body onLoad="document.f.j_username.focus();">
	    <c:if test="${not empty param.login_error}">
	       <font color="red">
	           登录失败，请重试.<br/><br/>
	           原因:<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
	       </font>
	    </c:if>
	   <form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
	        <h1>核电站焊接管理系统</h1>
	        <div class="logindiv">
	            <table>
	                <tr>
	                    <td colspan="3">
	                        <img src="resources/images/gongsilogo.png" />
	                    </td>
	                </tr>
	                <tr>
	                    <td rowspan="3">
	                        <div>
	                        </div>
	                    </td>
	                    <td>用户名:</td>
			            <td>
			                <input type='text' name='j_username' value='<c:if test="${not empty param.login_error}">
			                <c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
			            </td>
	                </tr>
	                <tr>
			            <td>密     码:</td>
			            <td><input type='password' name='j_password'></td>
	                </tr>
	                <tr>
			            <td>
			                <input type="checkbox" name="_spring_security_remember_me">
			            </td>
			            <td>
			            	两周内自动登录
			            </td>
	                </tr>
			        <tr>
			        	<td>
			            </td>
			            <td align="center">
			                <input name="submit" type="submit">
			                <input name="reset" type="reset">
			            </td>
			        </tr>
	            </table>
	        </div>
	    </form>
	    <div align="center" class="connect" style="height: 220px;">
			<span style="color: red;">${error}</span>
		</div>
	</body>
</html>