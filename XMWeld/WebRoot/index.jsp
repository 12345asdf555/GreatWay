<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%response.setHeader("Cache-Control","no-store");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="resources/css/iconfont.css">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	<style type="text/css">
		a{text-decoration:none;color:inherit;outline:none;}
	</style>
  </head>

  <body class="easyui-layout">
  	<!-- 头部 -->
  	<div region="north" split="true" style="height: 128px;" id="north">
		<div class="head-wrap">
			<a href="" class="logo"></a>
			<div class="search-wrap">
				<div class="search">
					<input type="" placeholder='公司内部' class=''>
					<button><i class="iconfont icon-search ver-a-m"></i></button>
				</div>
			</div>
			<div class="box clearfix">
				<div class="box-lef fl"></div>
				<div class="box-rig fl" id="boxrig">
					<a href="javascript:void(0)" >首页</a>
					<a href="javascript:void(0)" id="main" class="easyui-menubutton" data-options="menu:'#production'">信息管理</a>
					<a href="javascript:void(0)" id="main" class="easyui-menubutton" style="margin-right:50%;" data-options="menu:'#efficiency'">报表统计</a>
					<a href="javascript:void(0)" id="userInsframework"></a>
					<a href="user/logout">注销</a>
				</div>
			</div>
		</div>
		<div id="efficiency" style="width:150px;">
		    <div onclick="openCompanyTd()">实时监控</div>
		    <div onclick="openCompanyLoads()">负载率</div>
		    <div onclick="openCompanyNoLoads()">空载率</div>
		    <div onclick="openCompanyHour()">焊口焊接工时</div>
		    <div onclick="openCompanyoverproof()">焊接工艺超标</div>
		    <div onclick="openWeldingmachineMax()">焊机工时最高</div>
		    <div onclick="openWeldingmachineMin()">焊机工时最低</div>
		    <div onclick="openWelderMax()">焊工工时最高</div>
		    <div onclick="openWelderMin()">焊工工时最低</div>
		</div>
		<div id="production" style="width:150px;">   
		    <div onclick="openPerson()">焊工管理</div>
		    <div onclick="openWedJunction()">焊口管理</div>
		    <div onclick="openWeldingMachine()">焊机设备管理</div>
		    <div onclick="openGather()">采集模块管理</div>
		</div>
  	</div>
  	
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west">
	  	<div class="easyui-accordion" fit="true" border="false" id="accordiondiv">
			<div title="信息管理中心">
				<ul>
			        <li><a href="javascript:openWelder()"><i class="iconfont icon-bijiben"></i>焊工管理</a></li>
			        <li><a href="javascript:openWedJunction()"><i class="iconfont icon-bijiben"></i>焊缝管理</a></li>
					<li><a href="javascript:openWeldingMachine()"><i class="iconfont icon-bijiben"></i>焊机设备管理</a></li>
			        <li><a href="javascript:openGather()"><i class="iconfont icon-bijiben"></i>采集模块管理</a></li>
		        </ul>
		    </div>
		    
			<div title="报表统计中心">
				<ul>
					<li><a href="javascript:openCompanyTd()"><i class="iconfont icon-bijiben"></i>实时监控</a></li>
					<li><a href="javascript:openCompanyLoads()"><i class="iconfont icon-bijiben"></i>负载率</a></li>
					<li><a href="javascript:openCompanyNoLoads()"><i class="iconfont icon-bijiben"></i>空载率</a></li>
					<li><a href="javascript:oid(0)"><i class="iconfont icon-bijiben"></i>历史曲线</a></li>
					<li><a href="javascript:openCompanyHour()"><i class="iconfont icon-bijiben"></i>焊缝焊接工时</a></li>
					<li><a href="javascript:openCompanyoverproof()"><i class="iconfont icon-bijiben"></i>焊接工艺超标</a></li>
				    <li><a href="javascript:openWeldingmachineMax()"><i class="iconfont icon-bijiben"></i>焊机工时最高</a></li>
			        <li><a href="javascript:openWeldingmachineMin()"><i class="iconfont icon-bijiben"></i>焊机工时最低</a></li>
			        <li><a href="javascript:openWelderMax()"><i class="iconfont icon-bijiben"></i>焊工工时最高</a></li>
			        <li><a href="javascript:openWelderMin()"><i class="iconfont icon-bijiben"></i>焊工工时最低</a></li>
		        </ul>
		    </div>
	    </div>
	</div>
    
	<div id="mainPanle" region="center" style="background: white; overflow-y: hidden;width:400px">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
		<div id="tabMenu" class="easyui-menu" style="width:150px">
			<div id="refreshtab">刷新</div>
			<div id="closetab">关闭标签页</div>
			<div id="closeLeft">关闭左侧标签页</div>
			<div id="closeRight">关闭右侧标签页</div>
			<div id="closeOther">关闭其他标签页</div>
			<div id="closeAll">关闭全部标签页</div>
	    </div>
	</div>
  </body>
</html>