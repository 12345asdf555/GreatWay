<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	
	<style type="text/css">
	  	ul li{
	  		list-style-type:none;
	  		font-size:12px;
	  		padding-bottom: 5px;
	  	}
	  	ul li a{
	  		text-decoration:none;
	  		color:black;
	  	}
  	</style>
  </head>

  <body class="easyui-layout">
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west">
	  	<div class="easyui-accordion" fit="true" border="false">
		    <div title="管理员" >
			<ul>
				<li><a href="javascript:openUser()">用户管理</a></li>
				<li><a href="javascript:openRole()">角色管理</a></li>
				<li><a href="javascript:openAuthority()">权限管理</a></li>
				<li><a href="javascript:openResource()">资源管理</a></li>
				<li><a href="javascript:openWeldingMachine()">焊机设备管理</a></li>
			    <li><a href="javascript:openMachine()">维修记录管理</a></li>
		        <li><a href="javascript:openWedJunction()">焊口管理</a></li>
		        <li><a href="javascript:openWelder()">焊工管理</a></li>
		        <li><a href="javascript:openInsframework()">组织机构管理</a></li>
		        <li><a href="javascript:openGather()">采集模块管理</a></li>
	        </ul>
		    </div>
		    <div title="集团">
		    	<ul>
		    		<li><a href="javascript:openBlocHour()">集团焊口焊接工时</a></li>
		    		<li><a href="javascript:openBlocoverproof()">集团焊接工艺超标统计</a></li>
		    		<li><a href="javascript:openBlocovertime()">集团超时待机统计</a></li>
		    		<li><a href="javascript:openBlocLoads()">集团设备负荷率</a></li>
		    		<li><a href="javascript:openBlocNoLoads()">集团设备空载率</a></li>
		    		<li><a href="javascript:openBlocIdle()">集团设备闲置率</a></li>
		    		<li><a href="javascript:openBlocUse()">集团单台设备运行数据统计</a></li>
		    	</ul>
		    </div>
		    <div title="公司">
		    	<ul>
		    		<li><a href="javascript:openCompanyHour()">公司焊口焊接工时</a></li>
		    		<li><a href="javascript:openCompanyoverproof()">公司焊接工艺超标统计</a></li>
		    		<li><a href="javascript:openCompanyovertime()">公司超时待机统计</a></li>
		    		<li><a href="javascript:openCompanyLoads()">公司设备负荷率</a></li>
		    		<li><a href="javascript:openCompanyNoLoads()">公司设备空载率</a></li>
		    		<li><a href="javascript:openCompanyIdle()">公司设备闲置率</a></li>
		    		<li><a href="javascript:openCompanyUse()">公司单台设备运行数据统计</a></li>
		    		<li><a href="javascript:openCompanyTd()">实时监测</a></li>
		    	</ul>
		    </div>
		    <div title="事业部">
		    	<ul>
		    		<li><a href="javascript:openCaustHour()">事业部焊口焊接工时</a></li>
		    		<li><a href="javascript:openCaustoverproof()">事业部焊接工艺超标统计</a></li>
		    		<li><a href="javascript:openCaustovertime()">事业部超时待机统计</a></li>
		    		<li><a href="javascript:openCaustLoads()">事业部设备负荷率</a></li>
		    		<li><a href="javascript:openCaustNoLoads()">事业部设备空载率</a></li>
		    		<li><a href="javascript:openCaustIdle()">事业部设备闲置率</a></li>
		    		<li><a href="javascript:openCaustUse()">事业部单台设备运行数据统计</a></li>
		    	</ul>
		    </div>
		    <div title="项目部">
		    	<ul>
		    		<li><a href="javascript:openItemHour()">项目部焊口焊接工时</a></li>
		    		<li><a href="javascript:openDetailoverproofs()">焊接工艺超标明细</a></li>
		    		<li><a href="javascript:openItemovertime()">项目部超时待机统计</a></li>
		    		<li><a href="javascript:openItemLoads()">项目部设备负荷率</a></li>
		    		<li><a href="javascript:openItemNoLoads()">项目部设备空载率</a></li>
		    		<li><a href="javascript:openTd()">实时监测</a></li>
		    	</ul>
		    </div>
		</div>
	</div>
	<div id="mainPanle" region="center" style="background: white; overflow-y: hidden">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
			</div>
	</div>
	<div id="tabMenu" class="easyui-menu" style="width:150px">
<!-- 		<div id="refreshtab">刷新</div> -->
		<div id="closetab">关闭标签页</div>
		<div id="closeLeft">关闭左侧标签页</div>
		<div id="closeRight">关闭右侧标签页</div>
		<div id="closeOther">关闭其他标签页</div>
		<div id="closeAll">关闭全部标签页</div>
	</div>
  </body>
</html>
