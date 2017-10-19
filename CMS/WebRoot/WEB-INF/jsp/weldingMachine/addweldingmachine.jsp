<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增焊机设备</title>
    
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
	<script type="text/javascript" src="resources/js/weldingMachine/addeditweldingmachine.js"></script>
  </head>
  
  <body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="新增焊机设备" style="background: white; height: 335px;">
		<div style="text-align: center ">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div class="fitem">
					<lable>设备编码</lable>
					<input class="easyui-textbox" name="equipmentNo" id="equipmentNo"  data-options="validType:['wmEnoValidate','length[4,4]'],required:true"/>
				</div>
				<div class="fitem">
					<lable>设备类型</lable>
					<input class="easyui-combobox" name="typeId" id="tId" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>入厂时间</lable>
					<input class="easyui-datetimebox" name="joinTime" id="joinTime"/>
				</div>
				<div class="fitem">
					<lable>所属项目</lable>
					<input class="easyui-combobox" name="iId" id="iId" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>生产厂商</lable>
					<input class="easyui-combobox" name="manuno" id="manuno" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>采集序号</lable>
					<input class="easyui-combobox" name="gatherId" id="gatherId" data-options="validType:['checkNumber','wmGatheridValidate']"/>
				</div>
				<div class="fitem">
					<lable>设备位置</lable>
					<input class="easyui-textbox" name="position" id="position"/>
				</div>
				<div class="fitem" >
					<lable>是否联网</lable>
					<input type="radio" name="isnetworking" value="0" checked="checked"/>是
					<input type="radio" name="isnetworking" value="1"/>否
				</div>
				<div class="fitem">
					<lable>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态</lable>
	   				<lable id="radios"></lable>
				</div>
				<div class="fitem">
					<a href="javascript:addWeldingMachine();" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="weldingMachine/goWeldingMachine" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>