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
  	<div region="north" split="true" style="height: 100px;" id="north">
		<div class="head-wrap" style="background-color: #eaf2f5">
			<a href="" class="logo"></a>
			<div class="search-wrap" style="color:#ffffff;">
                    <img src="resources/images/1_06.png" />
					<a href="user/logout" id="username">欢迎您，</a>&nbsp;|
					<a href="user/logout">注销</a>
			</div>					
		</div>
	</div>
  	
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west" data-options="iconCls:'icon-setting'">
	  	<div class="easyui-accordion" fit="true" border="false" id="accordiondiv">
			<div title="信息管理中心" data-options="iconCls:'icon-manage'">
				<ul>
					<li><a href="javascript:openUser()"><img src="resources/images/1_35.png" />&nbsp;用户管理</a></li>
					<li><a href="javascript:openRole()"><img src="resources/images/1_35.png" />&nbsp;角色管理</a></li>
					<li><a href="javascript:openAuthority()"><img src="resources/images/1_35.png" />&nbsp;权限管理</a></li>
					<li><a href="javascript:openResource()"><img src="resources/images/1_35.png" />&nbsp;资源管理</a></li>
			        <li><a href="javascript:openDictionary()"><img src="resources/images/1_38.png" />&nbsp;字典管理</a></li>
			        <li><a href="javascript:openPerson()" ><img src="resources/images/1_35.png" />&nbsp;焊工管理</a></li>
			        <li><a href="javascript:openWedJunction()"><img src="resources/images/1_38.png" />&nbsp;焊缝管理</a></li>
			        <li><a href="javascript:openProduct()"><img src="resources/images/1_38.png" />&nbsp;产品管理</a></li>
			        <li><a href="javascript:openWps()"><img src="resources/images/1_38.png" />&nbsp;工艺管理</a></li>
				    <li><a href="javascript:openMachine()"><img src="resources/images/1_38.png" />&nbsp;维修记录管理</a></li>
			        <li><a href="javascript:openInsframework()"><img src="resources/images/1_38.png" />&nbsp;组织机构管理</a></li>
					<li><a href="javascript:openWeldingMachine()"><img src="resources/images/1_40.png" />&nbsp;焊机设备管理</a></li>
			        <li><a href="javascript:openGather()"><img src="resources/images/1_42.png" />&nbsp;采集模块管理</a></li>
			        <li><a href="javascript:openParameter()"><img src="resources/images/1_42.png" />&nbsp;参数设置</a></li>
		        </ul>
		    </div>
		    
			<div title="报表统计中心" data-options="iconCls:'icon-statistics',selected:true">
				<ul>
					<li><a href="javascript:openCompanyTd()"><img src="resources/images/1_48.png" />&nbsp;实时监控</a></li>
					<li><a href="javascript:openHistory()"><img src="resources/images/1_62.png" />&nbsp;历史曲线</a></li>
    				<li><a href="javascript:openCompanytEfficiency()"><img src="resources/images/1_59.png" />&nbsp;焊工工效</a></li>
					<li><a href="javascript:openCompanyLoads()"><img src="resources/images/1_53.png" />&nbsp;焊机负载率</a></li>
					<li><a href="javascript:openCompanyNoLoads()"><img src="resources/images/1_59.png" />&nbsp;焊机空载率</a></li>
    				<li><a href="javascript:openCompanyIdle()"><img src="resources/images/1_62.png" />&nbsp;设备闲置率</a></li>
			        <li><a href="javascript:openWelderReport()"><img src="resources/images/1_69.png" />&nbsp;焊工维度表</a></li>
					<li><a href="javascript:openCompanyHour()"><img src="resources/images/1_69.png" />&nbsp;焊缝焊接工时</a></li>
    				<li><a href="javascript:openCompanyovertime()"><img src="resources/images/1_62.png" />&nbsp;超时待机统计</a></li>
					<li><a href="javascript:openCompanyoverproof()"><img src="resources/images/1_67.png" />&nbsp;焊接工艺超标</a></li>
				    <li><a href="javascript:openWeldingmachineMax()"><img src="resources/images/1_69.png" />&nbsp;焊机工时最高</a></li>
			        <li><a href="javascript:openWeldingmachineMin()"><img src="resources/images/1_69.png" />&nbsp;焊机工时最低</a></li>
			        <li><a href="javascript:openWelderMax()"><img src="resources/images/1_69.png" />&nbsp;焊工工时最高</a></li>
			        <li><a href="javascript:openWelderMin()"><img src="resources/images/1_69.png" />&nbsp;焊工工时最低</a></li>
			        <li><a href="javascript:openWeldParameter()"><img src="resources/images/1_69.png" />&nbsp;焊接参数维度表</a></li>
			        <li><a href="javascript:openWireUse()"><img src="resources/images/1_69.png" />&nbsp;焊丝用量维度表</a></li>
    				<li><a href="javascript:openCompanyUse()"><img src="resources/images/1_62.png" />&nbsp;单台设备运行数据统计</a></li>
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