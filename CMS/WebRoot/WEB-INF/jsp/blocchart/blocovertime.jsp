<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团超时待机统计</title>
    
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
	<script type="text/javascript" src="resources/js/getTime.js"></script>
	<script type="text/javascript" src="resources/js/blocchart/blocovertime.js"></script>
  </head>
  
  <body class="easyui-layout">
	<div id="chartLoading" style="width:100%;height:100%;">
		<div id="chartShow" style="width:160px;" align="center"><img src="resources/images/load1.gif"/>数据加载中，请稍候...</div>
	</div>
    <div id="body" region="center"  hide="true"  split="true" title="集团超时待机统计" style="background: witch; height: 335px;">
	  	<div id="blocOvertime_btn">
			<div style="margin-bottom: 5px;">
				时间：
				<input class="easyui-datetimebox" name="dtoTime1" id="dtoTime1">--
				<input class="easyui-datetimebox" name="dtoTime2" id="dtoTime2">
				时间跨度:
				<input type="radio" class="radioStyle" name="otype" value="1" />年
				<input type="radio" class="radioStyle" name="otype" value="2" />月
				<input type="radio" class="radioStyle" name="otype" value="3" checked="checked" />日
				<input type="radio" class="radioStyle" name="otype" value="4" />周
				<input class="easyui-textbox" id="hours" name="hours" value="一天" readonly="readonly"/>
				超时待机:
				<input class="easyui-numberbox" name="number" id="number" value="30">分钟
				<a href="javascript:serachBlocOvertime();" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
			</div>
		</div>
		<div id="explain" style="table-layout: fixed; width:18%; float:left;margin-top: 120px;margin-left:10px;">
		按组织机构和日期对超时待机趋势统计：<br/>
		统计时间段内的各部门焊机超时待机趋势；<br/>
		X轴：日期<br/>
		Y轴：超时待机次数<br/></div>
		<div id="blocOvertimeChart" style="height:300px;width:65%; margin: 21%;margin-bottom: 20px; margin-top: 20px;"></div>
		
	    <table id="blocOvertimeTable" style="table-layout: fixed; width:100%;"></table>
	    
	</div>
  </body>
</html>
