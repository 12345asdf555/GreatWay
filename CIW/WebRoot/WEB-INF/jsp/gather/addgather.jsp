<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增采集模块</title>
    
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
<!-- 	<script type="text/javascript" src="resources/js/insframework/insframeworktree.js"></script> -->
	<script type="text/javascript" src="resources/js/gather/addeditgather.js"></script>
  </head>
  
  <body  class="easyui-layout" style="background:#ffffff;">
  	<div class="divborder">
  		<div class="divtitle">新增焊机设备</div>
  	</div>
<%--   	<jsp:include  page="../insframeworktree.jsp"/> --%>
    <div  id="body" region="north"  hide="true"  split="true" style="background: white;height:80%;margin-top:70px;">
		<div style="text-align: center;height:80%;">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div class="fitem">
					<lable><span class="required">*</span>采集模块编号</lable>
					<input class="easyui-textbox" name="gatherNo" id="gatherNo" data-options="validType:['checkNumber','gathernoValidate','length[4,4]'],required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>所属项目</lable>
					<select class="easyui-combobox" name="itemid" id="itemid" data-options="required:true,editable:false"></select>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>采集模块状态</lable>
					<select class="easyui-combobox" name="status" id="status" data-options="required:true,editable:false"></select>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>采集模块通讯协议</lable>
					<select class="easyui-combobox" name="protocol" id="protocol" data-options="required:true,editable:false"></select>
				</div>
				<div class="fitem">
					<lable>采集模块IP地址</lable>
					<input class="easyui-textbox" name="ipurl" id="ipurl"/>
				</div>
				<div class="fitem">
					<lable>采集模块MAC地址</lable>
					<input class="easyui-textbox" name="macurl" id="macurl" />
				</div>
				<div class="fitem">
					<lable>采集模块出厂时间</lable>
					<input class="easyui-datetimebox" name="leavetime" id="leavetime"/>
				</div>
				<div class="weldbutton">
					<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:addGather();" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="gather/goGather" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
					</lable>
				</div>
			</form>
		</div>
  		<jsp:include  page="../tenghanbottom.jsp"/>
	</div>
  </body>
</html>
