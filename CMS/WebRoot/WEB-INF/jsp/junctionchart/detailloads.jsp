<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>焊机负荷率明细</title>
    
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
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/echarts.js"></script>
	<script type="text/javascript" src="resources/js/junctionchart/detailloads.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div id="body" region="center"  hide="true"  split="true" title="焊机负荷率明细" style="background: witch; height: 335px;">
	  	<div id="detailLoad_btn">
			<div style="margin-bottom: 5px;">
				<input  name="machineno" id="machineno" type="hidden" value="${machineno }"/>
				<input  name="afresh" id="afresh" type="hidden" value="${afreshLogin }"/>
				时间：
				<input class="easyui-datetimebox" name="dtoTime1" id="dtoTime1">--
				<input class="easyui-datetimebox" name="dtoTime2" id="dtoTime2">
				时间跨度:
				<input type="radio" name="otype" value="1" />年
				<input type="radio" name="otype" value="2" checked="checked" />月
				<input type="radio" name="otype" value="3" />日
				<input type="radio" name="otype" value="4" />周
				<a href="javascript:serachdetailloads();" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
			</div>
		</div>
		<div><h2>${str }</h2></div>
	    <table id="detailLoadsTable" style="table-layout: fixed; width:100%;"></table>
	</div>
  </body>
</html>
