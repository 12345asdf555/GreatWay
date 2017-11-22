<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增组织机构</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	<script type="text/javascript" src="resources/js/insframework/addeditinsframework.js"></script>
	<script type="text/javascript" src="resources/js/insframework/insframeworktree.js"></script>
  </head>
  
  <body class="easyui-layout">
<%--   	<jsp:include  page="insframeworktree.jsp"/> --%>
    <div  id="body" region="center"  hide="true"  split="true" title="新增组织机构" style="background: white; height: 335px;">
		<div style="text-align: center ">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div class="fitem">
					<lable>名称</lable>
					<input class="easyui-textbox" name="name" id="name" data-options="validType:'insfnameValidate',required:true"/>
				</div>
				<div class="fitem">
					<lable>名称简写</lable>
					<input class="easyui-textbox" name="logogram" id="logogram"/>
				</div>
				<div class="fitem">
					<lable>项目编码</lable>
					<input class="easyui-textbox" name="code" id="code"/>
				</div>
				<div class="fitem">
					<lable>上级项目</lable>
					<select class="easyui-combobox" name="parent" id="parent"></select>
				</div>
				<div class="fitem">
					<lable>项目类型</lable>
					<select class="easyui-combobox" name="typeid" id="typeid" data-options="required:true"></select>
				</div>
				<div class="weldbutton">
					<a href="javascript:addInsframework();" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="insframework/goInsframework" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>
