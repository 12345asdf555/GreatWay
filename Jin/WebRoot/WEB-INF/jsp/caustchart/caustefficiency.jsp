<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>事业部工效</title>
    
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
	<script type="text/javascript" src="resources/js/session-overdue.js"></script>
	<script type="text/javascript" src="resources/js/getTime.js"></script>
	<script type="text/javascript" src="resources/js/caustchart/caustefficiency.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div id="body" region="center"  hide="true"  split="true" title="事业部工效" style="background: witch; height: 335px;">
	  	<div id="caustEfficiency_btn">
			<div style="margin-bottom: 5px;">
				<input  name="nextparent" id="nextparent" type="hidden" value="${nextparent }"/>
				<input  name="afresh" id="afresh" type="hidden" value="${afreshLogin }"/>
				时间：
				<input class="easyui-datetimebox" name="dtoTime1" id="dtoTime1">--
				<input class="easyui-datetimebox" name="dtoTime2" id="dtoTime2">
				<select class="easyui-combobox" name="parent" id="parent"></select>
				<a href="javascript:serachEfficiencyCaust();" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
				
			</div>
		</div>
		<div><h2>${str }</h2></div>
		<div id="caustEfficiencyChart" style="height:300px;width:600px; margin: auto;margin-bottom: 20px; margin-top: 20px"></div>
		
	    <table id="caustEfficiencyTable" style="table-layout: fixed; width:100%;"></table>
	    
	</div>
  </body>
</html>