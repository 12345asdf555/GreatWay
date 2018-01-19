<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团焊机闲置率</title>
    
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
	<script type="text/javascript" src="resources/js/getTimeByYear.js"></script>
	<script type="text/javascript" src="resources/js/blocchart/blocidle.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div id="body" region="center"  hide="true"  split="true" title="集团焊机闲置率" style="background: witch; height: 335px;">
	  	<div id="blocIdle_btn">
			<div style="margin-bottom: 5px;">
				时间：
				<input class="easyui-datetimebox" name="dtoTime1" id="dtoTime1">--
				<input class="easyui-datetimebox" name="dtoTime2" id="dtoTime2">
				闲置时长：
				<select class="easyui-combobox" name="otype" id="otype"></select>
				<a href="javascript:serachBlocIdle();" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
			</div>
		</div>
		<div id="explain" style="table-layout: fixed; width:240px; float:left;margin-top: 120px;margin-left:10px;">
		按组织机构和日期对设备闲置率趋势统计：<br/>
		统计时间段内的各部门设备闲置趋势；<br/>
		X轴：日期<br/>
		Y轴：显示数量(台)<br/></div>
		<div id="blocIdleChart" style="height:300px;width:60%; margin: 21%;margin-bottom: 20px; margin-top: 20px;"></div>
		
	    <table id="blocIdleTable" style="table-layout: fixed; width:100%;"></table>
	</div>
  </body>
</html>
