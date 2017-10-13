<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
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
	<script type="text/javascript" src="resources/js/authority/allauthority.js"></script>
	<script type="text/javascript" src="resources/js/search/search.js"></script>

  </head>

<body class="easyui-layout">
        <div id="body" region="center"  hide="true"  split="true" title="权限管理" style="background: #eee; height: 335px;">
        <div data-options="region:'center',title:'信息',iconCls:'icon-ok'">
        <table id="dg" style="table-layout:fixed;width:100%"></table>
        </div>
        <div id="div" class="easyui-dialog" style="width:15%;" closed="true" buttons="#dlg-buttons">
        <table id="so" title="资源" style="table-layout:fixed;width:100%"></table>
        </div>
        <div style="margin:20px 0;"></div>
    <div id="toolbar">
        <a href="authority/toAddAuthority" class="easyui-linkbutton" iconCls="icon-add" onclick="newAuthority()">新增</a>
        <a href="javascript:insertSearchAuthority();" class="easyui-linkbutton" iconCls="icon-search">查找</a> 
    </div>
   		<div id="searchdiv" class="easyui-dialog" style="width:800px; height:400px;" closed="true" buttons="#searchButton" title="自定义条件查询">
	    	<div id="div0">
		    	<input class="fields" id="fields"/>
		    	<input class="condition" id="condition"/>
		    	<input class="content" id="content"/>
		    	<input class="joint" id="joint"/>
		    	<a href="javascript:newSearchAuthority();" class="easyui-linkbutton" iconCls="icon-add"></a>
		    	<a href="javascript:removeSerach();" class="easyui-linkbutton" iconCls="icon-remove"></a>
	    	</div>
	    </div>
	    <div id="searchButton">
			<a href="javascript:searchAuthority();" class="easyui-linkbutton" iconCls="icon-ok">查询</a>
			<a href="javascript:$('#searchdiv').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		</div>
    </div>
</body>
</html>
 
 
