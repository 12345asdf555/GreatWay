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
				<div class="box-rig fl">
					<a href="javascript:void(0)">首页</a>
					<a href="javascript:void(0)">实时监控</a>
					<a href="javascript:void(0)">数据分析</a>
					<a href="user/logout" style="margin-right:-590px;">注销</a>
				</div>
			</div>
		</div>
  	</div>
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west">
	  	<div class="easyui-accordion" fit="true" border="false" id="accordiondiv"></div>
	</div>
	<!-- 管理员 -->
	<div id="admin">
		<ul>
			<li><a href="javascript:openUser()"><i class="iconfont icon-bijiben"></i>用户管理</a></li>
			<li><a href="javascript:openRole()"><i class="iconfont icon-bijiben"></i>角色管理</a></li>
			<li><a href="javascript:openAuthority()"><i class="iconfont icon-bijiben"></i>权限管理</a></li>
			<li><a href="javascript:openResource()"><i class="iconfont icon-bijiben"></i>资源管理</a></li>
			<li><a href="javascript:openWeldingMachine()"><i class="iconfont icon-bijiben"></i>焊机设备管理</a></li>
		    <li><a href="javascript:openMachine()"><i class="iconfont icon-bijiben"></i>维修记录管理</a></li>
	        <li><a href="javascript:openWedJunction()"><i class="iconfont icon-bijiben"></i>焊口管理</a></li>
	        <li><a href="javascript:openWelder()"><i class="iconfont icon-bijiben"></i>焊工管理</a></li>
	        <li><a href="javascript:openInsframework()"><i class="iconfont icon-bijiben"></i>组织机构管理</a></li>
	        <li><a href="javascript:openGather()"><i class="iconfont icon-bijiben"></i>采集模块管理</a></li>
        </ul>
    </div>
	<!-- 集团 -->
	<div id="bloc" >
    	<ul>
    		<li><a href="javascript:openBlocEfficiency()"><i class="iconfont icon-bijiben"></i>集团工效</a></li>
    		<li><a href="javascript:openBlocHour()"><i class="iconfont icon-bijiben"></i>集团焊口焊接工时</a></li>
    		<li><a href="javascript:openBlocoverproof()"><i class="iconfont icon-bijiben"></i>集团焊接工艺超标统计</a></li>
    		<li><a href="javascript:openBlocovertime()"><i class="iconfont icon-bijiben"></i>集团超时待机统计</a></li>
    		<li><a href="javascript:openBlocLoads()"><i class="iconfont icon-bijiben"></i>集团设备负荷率</a></li>
    		<li><a href="javascript:openBlocNoLoads()"><i class="iconfont icon-bijiben"></i>集团设备空载率</a></li>
    		<li><a href="javascript:openBlocIdle()"><i class="iconfont icon-bijiben"></i>集团设备闲置率</a></li>
    		<li><a href="javascript:openBlocUse()"><i class="iconfont icon-bijiben"></i>集团单台设备运行数据统计</a></li>
    	</ul>
    </div>
	<!-- 公司 -->
    <div id="company" >
    	<ul>
    		<li><a href="javascript:openCompanytEfficiency()"><i class="iconfont icon-bijiben"></i>公司工效</a></li>
    		<li><a href="javascript:openCompanyHour()"><i class="iconfont icon-bijiben"></i>公司焊口焊接工时</a></li>
    		<li><a href="javascript:openCompanyoverproof()"><i class="iconfont icon-bijiben"></i>公司焊接工艺超标统计</a></li>
    		<li><a href="javascript:openCompanyovertime()"><i class="iconfont icon-bijiben"></i>公司超时待机统计</a></li>
    		<li><a href="javascript:openCompanyLoads()"><i class="iconfont icon-bijiben"></i>公司设备负荷率</a></li>
    		<li><a href="javascript:openCompanyNoLoads()"><i class="iconfont icon-bijiben"></i>公司设备空载率</a></li>
    		<li><a href="javascript:openCompanyIdle()"><i class="iconfont icon-bijiben"></i>公司设备闲置率</a></li>
    		<li><a href="javascript:openCompanyUse()"><i class="iconfont icon-bijiben"></i>公司单台设备运行数据统计</a></li>
    		<li><a href="javascript:openCompanyTd()"><i class="iconfont icon-bijiben"></i>公司实时监测</a></li>
    	</ul>
    </div>
	<!-- 事业部 -->
    <div id="caust" >
    	<ul>
    		<li><a href="javascript:openCaustEfficiency()"><i class="iconfont icon-bijiben"></i>事业部工效</a></li>
    		<li><a href="javascript:openCaustHour()"><i class="iconfont icon-bijiben"></i>事业部焊口焊接工时</a></li>
    		<li><a href="javascript:openCaustoverproof()"><i class="iconfont icon-bijiben"></i>事业部焊接工艺超标统计</a></li>
    		<li><a href="javascript:openCaustovertime()"><i class="iconfont icon-bijiben"></i>事业部超时待机统计</a></li>
    		<li><a href="javascript:openCaustLoads()"><i class="iconfont icon-bijiben"></i>事业部设备负荷率</a></li>
    		<li><a href="javascript:openCaustNoLoads()"><i class="iconfont icon-bijiben"></i>事业部设备空载率</a></li>
    		<li><a href="javascript:openCaustIdle()"><i class="iconfont icon-bijiben"></i>事业部设备闲置率</a></li>
    		<li><a href="javascript:openCaustUse()"><i class="iconfont icon-bijiben"></i>事业部单台设备运行数据统计</a></li>
    		<li><a href="javascript:openTd()"><i class="iconfont icon-bijiben"></i>事业部实时监测</a></li>
    	</ul>
    </div>
	<!-- 项目部 -->
    <div  id="item" >
    	<ul>
    		<li><a href="javascript:openItemEfficiency()"><i class="iconfont icon-bijiben"></i>项目部工效</a></li>
    		<li><a href="javascript:openItemHour()"><i class="iconfont icon-bijiben"></i>项目部焊口焊接工时</a></li>
    		<li><a href="javascript:openDetailoverproofs()"><i class="iconfont icon-bijiben"></i>项目部焊接工艺超标明细</a></li>
    		<li><a href="javascript:openItemovertime()"><i class="iconfont icon-bijiben"></i>项目部超时待机统计</a></li>
    		<li><a href="javascript:openItemLoads()"><i class="iconfont icon-bijiben"></i>项目部设备负荷率</a></li>
    		<li><a href="javascript:openItemNoLoads()"><i class="iconfont icon-bijiben"></i>项目部设备空载率</a></li>
    		<li><a href="javascript:openTd()"><i class="iconfont icon-bijiben"></i>项目部实时监测</a></li>
    	</ul>
    </div>
	<div id="mainPanle" region="center" style="background: white; overflow-y: hidden">
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
