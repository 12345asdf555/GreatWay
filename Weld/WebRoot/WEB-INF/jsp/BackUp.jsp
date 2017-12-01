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
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/iconfont.css">
	
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
			    <div id="body11" title="设备位置" ></div>
			</div>
		</div>
		<div id="body2" style="width:20%;height:15%;float:left;">
		<div style="position:absolute;left:16%;top:10%;"><label>电流：</label></div>
		<div class="wrap">
		<div class="clock">
<!-- 			<div style="height:25%;"></div>
			<div>
				<label region="center" style="font-size:15px;">电压</label>
			</div>
			<div style="height:15%;">
				<input id="voltage1" name="voltage1" style="height:25px;width:200px" type="text" readonly="readonly">
			</div>
			<div style="height:15%;"></div>
			<div>
				<label region="center" style="font-size:15px;">电流</label>
			</div>
			<div style="height:20%;" region="center">
				<input id="electricity1" name="electricity1" style="height:25px;width:200px" type="text" readonly="readonly">
			</div>
			<div style="height:25%;"></div> -->
			
			<ul>
			<li>
				<ul id="time1">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
					<li>
				<ul id="time2">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
				<li>
				<ul id="time3">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
			<li>
				<ul id="time4">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
		</ul>
		</div>
		</div>
		</div>
		<div id="body3" style="width:65%;height:250px;float:left">
			<!-- <label style="text-align:center;display:inline-block">设备采集id</label> <input class="liveInput" name="machid" id="machid" value="" type="text"/> -->
			<div id="body33"></div>
		</div>
		<div id="body5" style="width:15%;height:15%;position:absolute;left:14.9%;top:18%;">
		<div style="position:absolute;left:7%;top:35%;"><label>电压：</label></div>
		<div class="wrap">
		<div class="clock">
<!-- 			<div style="height:25%;"></div>
			<div>
				<label region="center" style="font-size:15px;">电压</label>
			</div>
			<div style="height:15%;">
				<input id="voltage1" name="voltage1" style="height:25px;width:200px" type="text" readonly="readonly">
			</div>
			<div style="height:15%;"></div>
			<div>
				<label region="center" style="font-size:15px;">电流</label>
			</div>
			<div style="height:20%;" region="center">
				<input id="electricity1" name="electricity1" style="height:25px;width:200px" type="text" readonly="readonly">
			</div>
			<div style="height:25%;"></div> -->
			
			<ul>
			<li>
				<ul id="time5">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
					<li>
				<ul id="time6">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
				<li>
				<ul id="time7">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
			<li>
				<ul id="time8">
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
					<li><img src="resources/images/front.png" width="30%" height="30%"></li>
				</ul>
			</li>
		</ul>
		</div>
		</div>
		</div>
		<div id="body4" style="width:84%;height:60%;float:left">
			 <table id="dg" style="table-layout:fixed;width:100%"></table>
		</div>
	</div>
</body>
</html>
 
 