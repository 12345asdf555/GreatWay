<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>组织机构管理</title>
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
	<script type="text/javascript" src="resources/js/insframework/insframework.js"></script>
	<script type="text/javascript" src="resources/js/insframework/insframeworktree.js"></script>
	
  </head>
  
  <body  class="easyui-layout">
  	<jsp:include  page="insframeworktree.jsp"/>
  	<div id="body" region="center"  hide="true"  split="true" title="组织机构管理" style="background: witch; width:80%; height: 335px;">
	  	
	  	<div id="insframework_btn">
			<div style="margin-bottom: 5px;">
				<a href="insframework/goaddInsframework" class="easyui-linkbutton" iconCls="icon-add">新增</a>
				<a href="javascript:insertSearchInsf();" class="easyui-linkbutton" iconCls="icon-search" >查找</a>
			</div>
		</div>
		
	    <table id="insframeworkTable" style="table-layout: fixed; width:100%;"></table>
	    
	</div>
  </body>
</html>
