<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
	
  </head>
  
  <body>
	<form name="form1" method="post" action="" target="_self">
		<table width="90%">
		<tr>
		<td width="50%" height="30" align="right">用户名：</td>
		<td width="50%" height="30" align="left"> <input type="text" name="UserName"></td>
		</tr>
		<tr>
		<td width="50%" height="30" align="right">密码：</td>
		<td width="50%" height="30" align="left"> <input type="password" name="UserPassword"></td>
		</tr>
		<tr>
		<td width="100%" height="40" align="center" colspan="2">
		<input type="submit" name="sub" value="登录">  
		</td>
		</tr>
		</table>
	</form>
  </body>
</html>
