<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎使用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/echarts.js"></script>
	<script type="text/javascript" src="resources/js/welcome/online.js"></script>
	<script type="text/javascript" src="resources/js/welcome/welcome.js"></script>
  </head>
  
  <body style="background:#ffffff;">
  		<div id="wcleftdiv">
  			<div id="wcleft1_1">
  				<p class="wcdate"></p>
  				焊工工作量排行<br/>Welder Work Rank List
  			</div>
  			<div id="wcleft1_2">
  			</div>
  			<div id="wcleft2_1">
  				<p class="wcdate"></p>
  				班组设备利用率<br/>The Utilization Rate Of Group Equipment
  			</div>
  			<div id="wcleft2_2">
  			</div>
  			<div id="wcleft3_1">
  				<p class="wcdate"></p>
  				焊接规范负荷率<br/>The Load Rate Of Welding Standard
  			</div>
  			<div id="wcleft3_2"></div>
  		</div>
  		<div id="wcrightdiv">
  			<div id="autoshowdiv">
	  			<div class="wcright" onclick="companymesclick()">
	  				<div class="wcrighttitle">公司信息栏</div><div class="wcrighticon"><img src="resources/images/arrow.png" id="mesimg"/></div>
	  			</div>
  			</div>
<!-- 			<div class="wcul" style="padding-bottom:20px;" id="item"><ul><li>aaa项目部</li><li>bbb项目部</li><li>ccc项目部</li></ul></div> -->
  			<div class="wcright" style="margin-top:10px;" onclick="onlineclick()">
  				<div class="wcrighttitle">任务情况</div><div class="wcrighticon"><img src="resources/images/arrow.png" id="onlineimg"/></div>
  			</div>
  			<div id="wconline">
				<div id="person" style="float:left;height:100%;width:48%;"></div>
				<div id="welder" style="float:right;height:100%;width:48%;"></div>
  			</div>
  		</div>
  		
  
<!-- 	<div style="height:20%;width:100%;"></div> -->
<!-- 	<div id="person" style="float:left;height:70%;width:48%;"></div> -->
<!-- 	<div id="welder" style="float:right;height:70%;width:48%;"></div> -->
  </body>
</html>
