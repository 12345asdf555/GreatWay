<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增字典</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="resources/css/iconfont.css">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/Dictionary/Dictionary.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div id="body" region="center"  hide="true"  split="true" title="新增字典" style="background: #eee; height: 335px;">
    	<div style="text-align: center ">
    		<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
    			<div class="fitem">
    				<lable>名称</lable>
    				<input class="easyui-textbox" name="valueName" id="valueName" data-options="required:true"/>
    			</div>
    			<div class="fitem">
    				<lable>类型</lable>
    				<select class="easyui-combobox" name="typeid" id="typeid" data-options="required:true">
    					<option value="1">账户类型</option>
    					<option value="2">焊机状态</option>
    					<option value="3">维修类型</option>
    					<option value="4">焊机类型</option>
    				</select>
    			</div>
    			<div class="">
    				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:saveDictionary(1);" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="Dictionary/goDictionary" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
					</lable>
    			</div>
    		</form>
    	</div>
    </div>
  </body>
</html>
