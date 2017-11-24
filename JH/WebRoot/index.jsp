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
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	<style type="text/css">
		a{text-decoration:none;color:inherit;outline:none;}
	</style>
  </head>

  <body class="easyui-layout">
  	<div region="west" hide="true" split="true" title="导航菜单" style="width: 200px;" id="west">
	  	<div class="easyui-accordion" fit="true" border="false" id="accordiondiv">
	  		<!-- 车间管理 -->
			<div id="plant" title="车间管理">
				<ul>
					<li><a href="javascript:void(0)">车间管理</a></li>
		        </ul>
		    </div>
		    <!-- 设备管理 -->
			<div id="equipment" title="设备管理">
				<ul>
					<li><a href="javascript:void(0)">设备管理</a></li>
		        </ul>
		    </div>
		    <!-- 工艺管理 -->
			<div id="technology" title="工艺管理">
				<ul>
					<li><a href="javascript:void(0)">工艺指导书</a></li>
					<li><a href="javascript:void(0)">焊接工艺</a></li>
					<li><a href="javascript:void(0)">上传历史</a></li>
		        </ul>
		    </div>
		    <!-- 信息监控 -->
			<div id="message" title="信息监控">
				<ul>
					<li><a href="javascript:void(0)">信息监控</a></li>
		        </ul>
		    </div>
		    <!-- 成本管理 -->
			<div id="cost" title="成本管理">
				<ul>
					<li><a href="javascript:void(0)">成本管理</a></li>
		        </ul>
		    </div>
		    <!-- 人员信息 -->
			<div id="people" title="人员信息">
				<ul>
					<li><a href="javascript:void(0)">人员信息</a></li>
		        </ul>
		    </div>
		    <!-- 质量管理 -->
			<div id="quality" title="质量管理">
				<ul>
					<li><a href="javascript:void(0)">报警管理</a></li>
					<li><a href="javascript:void(0)">历史曲线</a></li>
		        </ul>
		    </div>
		    <!-- 系统设置 -->
			<div id="system" title="系统设置">
				<ul>
					<li><a href="javascript:void(0)">参数设置</a></li>
		        </ul>
		    </div>
		    <!-- 帮助 -->
			<div id="help" title="帮助">
				<ul>
					<li><a href="javascript:void(0)">帮助</a></li>
		        </ul>
		    </div>
	  	</div>
	</div>
	
	<div id="mainPanle" region="center" style="background: white; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" >
			<div title="欢迎使用"  style="padding: 20px; overflow: hidden; color: red;">
				<div style="text-align:center">
					<h1>焊机群控管理系统欢迎您的到来！</h1>
				</div>
			</div>
		</div>
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
