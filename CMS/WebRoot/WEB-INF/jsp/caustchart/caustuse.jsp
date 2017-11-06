<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>事业部单台设备运行数据统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/load.js"></script>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/echarts.js"></script>
	<script type="text/javascript" src="resources/js/caustchart/caustuse.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div id="body" region="center"  hide="true"  split="true" title="事业部单台设备运行数据统计" style="background: witch; height: 335px;">
	  	<div id="caustUse_btn">
			<div style="margin-bottom: 5px;">
				<input  name="afresh" id="afresh" type="hidden" value="${afreshLogin }"/>
				时间：
				<input class="easyui-datetimebox" name="dtoTime1" id="dtoTime1">--
				<input class="easyui-datetimebox" name="dtoTime2" id="dtoTime2">
				<input class="easyui-combobox" name="type" id="type"/>
				<a href="javascript:serachcaustUse();" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
			</div>
		</div>
		
		<div id="caustUseChart" style="height:300px;width:600px; margin: auto;margin-bottom: 20px; margin-top: 20px"></div>
		
	    <table id="caustUseTable" style="table-layout: fixed; width:100%;"></table>
	</div>
  </body>
</html>
