<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择焊机</title>
    
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
	<script type="text/javascript" src="resources/js/weldwps/selectMachine.js"></script>

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="请选择焊机" style="background: white; height: 335px;">
		<div style="text-align: center ">
		<div align="center">
			<table id="dg" style="table-layout:fixed;width:50%"></table>
			</div>
	    	<div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div style="position:absolute;left:25%;top:85%">
			        	<a href="javascript:save();" class="easyui-linkbutton" data-options="size:'large'" iconCls="icon-ok">确认下发</a>
			        	</div>
			        <div style="position:absolute;left:65%;top:85%">
			        	<a href="wps/AllWps" class="easyui-linkbutton" data-options="size:'large'" iconCls="icon-cancel">取消</a>
			        	</div>
		        </lable>
	    	</div>
    </div>
    </div>
</body>
</html>