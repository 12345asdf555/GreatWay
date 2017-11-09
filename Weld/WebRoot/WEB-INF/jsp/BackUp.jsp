<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>备份界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	<script type="text/javascript" src="resources/js/highcharts.js"></script>
	<script type="text/javascript" src="resources/js/exporting.js"></script>
	<script type="text/javascript" src="resources/js/td/BackUp.js"></script>

  </head>
  
<body class="easyui-layout">
	<div id="body" region="center"  hide="true"  split="true" title="备份界面" style="background: #eee; height: 335px;">
		<div id="body1" style="width:15%;height:100%;float:left">
			<div class="easyui-accordion" fit="true" border="false" id="accordiondiv">
			    <div title="设备位置" >
					<ul>
						<li><a href="javascript:()">1号位置</a></li>
						<li><a href="javascript:()">2号位置</a></li>
						<li><a href="javascript:()">3号位置</a></li>
						<li><a href="javascript:()">4号位置</a></li>
			        </ul>
			    </div>
			</div>
		</div>
		<div id="body2" style="width:15%;height:30%;float:left">
			<div style="height:25%;"></div>
			<div>
				<label region="center" style="font-size:10px;">电压</label>
			</div>
			<div style="height:15%;">
				<input style="height:25px" readly="true">
			</div>
			<div style="height:15%;"></div>
			<div>
				<label region="center" style="font-size:10px;">电流</label>
			</div>
			<div style="height:20%;">
				<input style="height:25px" readly="true">
			</div>
			<div style="height:25%;"></div>
		</div>
		<div id="body3" style="width:70%;height:300px;float:left"></div>
		<div id="body4" style="width:85%;height:70%%;float:left">
			 <table id="dg" style="table-layout:fixed;width:100%"></table>
		</div>
	</div>
</body>
</html>
 
 
