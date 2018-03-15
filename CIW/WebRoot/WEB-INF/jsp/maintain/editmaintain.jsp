<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改维修记录</title>
    
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
	<script type="text/javascript" src="resources/js/maintain/addeditmaintain.js"></script>
  </head>
  
  <body  class="easyui-layout" style="background:#ffffff;">
	<div class="divborder">
  		<div class="divtitle">修改维修记录</div>
  	</div>
    <div  id="body" region="north"  hide="true"  split="true" style="background: white;height:80%;margin-top:70px;">
		<div style="text-align: center ">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div class="fitem">
					<lable>固定资产编号</lable>
					<input class="easyui-textbox" id="mid" value="${wm.maintenance.id }"/>
					<input class="easyui-textbox" id="wid" value="${wm.welding.id }"/>
					<select class="easyui-combobox" name="equipmentNo" id="equipmentNo" readonly="readonly"></select>
				</div>
				<div class="fitem">
					<lable>维修类型</lable>
					<input class="easyui-textbox" id="type"  value="${wm.maintenance.typeId }"/>
					<select class="easyui-combobox" name="typeId" id="typeId" value="${wm.maintenance.typeId }" data-options="required:true,editable:false"></select>
				</div>
				<div class="fitem">
					<lable>维修人员</lable>
					<input class="easyui-textbox" name="viceman" id="viceman" value="${wm.maintenance.viceman }" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>起始时间</lable>
					<input class="easyui-datetimebox" name="startTime" id="startTime" value="${wm.maintenance.startTime }" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>结束时间</lable>
					<input class="easyui-datetimebox" name="endTime" id="endTime" value="${wm.maintenance.endTime }"/>
				</div>
				<div class="fitem">
					<lable>维修说明</lable>
					<textarea name="desc" id="desc" style="height:40px;width:150px">${wm.maintenance.desc }</textarea>
				</div>
				<div class="weldbutton">
					<a href="javascript:editMaintain();" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="maintain/goMaintain" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
				</div>
			</form>
		</div>
  		<jsp:include  page="../tenghanbottom.jsp"/>
	</div>
  </body>
</html>
