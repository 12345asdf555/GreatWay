<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>字典列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/datagrid.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="resources/css/iconfont.css">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/Dictionary/Dictionary.js"></script>
  </head>
  
  <body>
    <div id="body">
    	<div class="functiondiv">
        	<a href="Dictionary/goAddDictionary" class="easyui-linkbutton" iconCls="icon-newadd">新增</a>
		    	<select class="easyui-combobox" id="fields" style="margin-left:100px;" data-options="editable:false">
		    		<option value='fvaluename'>名称</option>
		    		<option value='fback'>类型</option>
		    	</select>
		    	<input class="easyui-textbox" id="content"/>
		    	<a href="javascript:searchDic();" class="easyui-linkbutton" iconCls="icon-select">查询</a>
    	</div>
    	<table id="dg" style="table-layout:fixed;width:100%"></table>
    </div>
  </body>
</html>
