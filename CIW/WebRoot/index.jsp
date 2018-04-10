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
    
    <title>云智能焊接管控系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="resources/images/title.ico" type="img/x-icon" />
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
  	<div region="north" style="height: 98px;" id="north">
		<div class="head-wrap">
			<a href="" class="logo"><img src="resources/images/1_03.png" /></a>
			<div class="search-wrap">
                    <img src="resources/images/1_06.png" />
					<a href="user/logout" id="username">欢迎您，</a>&nbsp;|
					<a href="user/logout">注销</a>
			</div>					
		</div>
	</div>
  	
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west" data-options="iconCls:'icon-navigation'">
	  	<div class="easyui-accordion" border="false" id="accordiondiv">
			<div title="信息管理中心" data-options="iconCls:'icon-manager'">
				<ul>
					<li onclick="changeColor(this)"><a href="javascript:openUser()"><img src="resources/images/c-1.png" />&nbsp;&nbsp;用户管理</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openRole()"><img src="resources/images/c-2.png" />&nbsp;&nbsp;角色管理</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openAuthority()"><img src="resources/images/c-3.png" />&nbsp;&nbsp;权限管理</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openResource()"><img src="resources/images/c-4.png" />&nbsp;&nbsp;资源管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openDictionary()"><img src="resources/images/c-5.png" />&nbsp;&nbsp;字典管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openPerson()" ><img src="resources/images/c-6.png" />&nbsp;&nbsp;焊工管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWedJunction()"><img src="resources/images/c-7.png" />&nbsp;&nbsp;焊缝管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openProduct()"><img src="resources/images/c-8.png" />&nbsp;&nbsp;产品管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWps()"><img src="resources/images/c-9.png" />&nbsp;&nbsp;工艺管理</a></li>
				    <li onclick="changeColor(this)"><a href="javascript:openMachine()"><img src="resources/images/c-10.png" />&nbsp;&nbsp;维修记录管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openInsframework()"><img src="resources/images/c-11.png" />&nbsp;&nbsp;组织机构管理</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openWeldingMachine()"><img src="resources/images/c-12.png" />&nbsp;&nbsp;焊机设备管理</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openGather()"><img src="resources/images/c-13.png" />&nbsp;&nbsp;采集模块管理</a></li>
			        <li class="libottom"  onclick="changeColor(this)"><a href="javascript:openParameter()"><img src="resources/images/c-14.png" />&nbsp;&nbsp;参数设置</a></li>
		        </ul>
		    </div>
		    
			<div title="报表统计中心" data-options="iconCls:'icon-statement'">
				<ul>
					<li onclick="changeColor(this)"><a href="javascript:openCompanyTd()"><img src="resources/images/s-1.png" />&nbsp;&nbsp;实时监控</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openHistory()"><img src="resources/images/s-2.png" />&nbsp;&nbsp;历史曲线</a></li>
    				<li onclick="changeColor(this)"><a href="javascript:openCompanytEfficiency()"><img src="resources/images/s-3.png" />&nbsp;&nbsp;焊工工效</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openCompanyLoads()"><img src="resources/images/s-4.png" />&nbsp;&nbsp;焊机负载率</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openCompanyNoLoads()"><img src="resources/images/s-5.png" />&nbsp;&nbsp;焊机空载率</a></li>
    				<li onclick="changeColor(this)"><a href="javascript:openCompanyIdle()"><img src="resources/images/s-6.png" />&nbsp;&nbsp;设备闲置率</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWelderReport()"><img src="resources/images/s-7.png" />&nbsp;&nbsp;焊工维度表</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openCompanyHour()"><img src="resources/images/s-8.png" />&nbsp;&nbsp;焊缝焊接工时</a></li>
    				<li onclick="changeColor(this)"><a href="javascript:openCompanyovertime()"><img src="resources/images/s-9.png" />&nbsp;&nbsp;超时待机统计</a></li>
					<li onclick="changeColor(this)"><a href="javascript:openCompanyoverproof()"><img src="resources/images/s-10.png" />&nbsp;&nbsp;焊接工艺超标</a></li>
				    <li onclick="changeColor(this)"><a href="javascript:openWeldingmachineMax()"><img src="resources/images/s-11.png" />&nbsp;&nbsp;焊机工时最高</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWeldingmachineMin()"><img src="resources/images/s-12.png" />&nbsp;&nbsp;焊机工时最低</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWelderMax()"><img src="resources/images/s-13.png" />&nbsp;&nbsp;焊工工时最高</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWelderMin()"><img src="resources/images/s-14.png" />&nbsp;&nbsp;焊工工时最低</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWeldParameter()"><img src="resources/images/s-15.png" />&nbsp;&nbsp;焊接参数维度表</a></li>
			        <li onclick="changeColor(this)"><a href="javascript:openWireUse()"><img src="resources/images/s-16.png" />&nbsp;&nbsp;焊丝用量维度表</a></li>
    				<li class="libottom" onclick="changeColor(this)"><a href="javascript:openCompanyUse()"><img src="resources/images/s-17.png" />&nbsp;&nbsp;单台设备运行数据统计</a></li>
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
	
	<div data-options="region:'south',split:true" style="height:40px;">
   		<div class="tenghan-bottom">
	    	Copyright 1998-2017 上海腾悍智能科技有限公司
		</div>
	</div>

  </body>
</html>