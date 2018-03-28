<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除焊缝</title>
    
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
	<script type="text/javascript" src="resources/js/weldedjunction/removeweldedjunction.js"></script>
  </head>
  
  <body  class="easyui-layout" style="background:#ffffff;">
  	<div class="divborder">
  		<div class="divtitle">删除焊缝</div>
  	</div>
    <div id="body" region="north" hide="true"  split="true" style="background: witch; height: 80%;margin-top: 70px;">
    	<div style="text-align:center;height:100%">
			<div class="fitem">
				<lable>编号</lable>
				<input type="hidden" id="id" value="${wj.id }"/>
				<input class="easyui-textbox" value="${wj.weldedJunctionno }"  readonly="readonly"/>
				<lable>序列号</lable>
				<input class="easyui-textbox" value="${wj.serialNo }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>机组</lable>
				<input class="easyui-textbox" value="${wj.unit }" readonly="readonly"/>
				<lable>区域</lable>
				<input class="easyui-textbox" value="${wj.area }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>系统</lable>
				<input class="easyui-textbox" value="${wj.systems }" readonly="readonly"/>
				<lable>子项</lable>
				<input class="easyui-textbox" value="${wj.children }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>达因</lable>
				<input class="easyui-textbox" value="${wj.dyne }"  readonly="readonly"/>
				<lable>规格</lable>
				<input class="easyui-textbox" value="${wj.specification }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>管线号</lable>
				<input class="easyui-textbox" value="${wj.pipelineNo }" readonly="readonly"/>
				<lable>房间号</lable>
				<input class="easyui-textbox" value="${wj.roomNo }" readonly="readonly"/>
			</div>
<!-- 			<div class="fitem"> -->
<!-- 				<lable>上游外径</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.externalDiameter }" readonly="readonly"/> --%>
<!-- 				<lable>下游外径</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.nextexternaldiameter }" readonly="readonly"/> --%>
<!-- 			</div> -->
<!-- 			<div class="fitem"> -->
<!-- 				<lable>上游璧厚</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.wallThickness }" readonly="readonly"/> --%>
<!-- 				<lable>下游璧厚</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.nextwall_thickness }" readonly="readonly"/> --%>
<!-- 			</div> -->
<!-- 			<div class="fitem"> -->
<!-- 				<lable>上游材质</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.material }" readonly="readonly"/> --%>
<!-- 				<lable>下游材质</lable> -->
<%-- 				<input class="easyui-textbox" value="${wj.next_material }" readonly="readonly"/> --%>
<!-- 			</div> -->
			<div class="fitem">
				<lable>电流上限</lable>
				<input class="easyui-textbox" value="${wj.maxElectricity }" readonly="readonly"/>
				<lable>电流下限</lable>
				<input class="easyui-textbox" value="${wj.minElectricity }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>电压上限</lable>
				<input class="easyui-textbox" value="${wj.maxValtage }" readonly="readonly"/>
				<lable>电压下限</lable>
				<input class="easyui-textbox" value="${wj.minValtage }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>电流单位</lable>
				<input class="easyui-textbox"  value="${wj.electricity_unit }" readonly="readonly"/>
				<lable>电压单位</lable>
				<input class="easyui-textbox" value="${wj.valtage_unit }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>开始时间</lable>
				<input class="easyui-textbox" value="${wj.startTime }" readonly="readonly"/>
				<lable>完成时间</lable>
				<input class="easyui-textbox" value="${wj.endTime }" readonly="readonly"/>
			</div>
			<div class="fitem">
				<lable>所属项目</lable>
				<input class="easyui-textbox" value="${wj.itemid.name }" readonly="readonly"/>
				<lable></lable>
				<input type="text" border="0" readonly="readonly"/>
			</div>
			<div style="margin-left:50px">
				<lable>
					<a href="javascript:removeWeldedjunction();" class="easyui-linkbutton"	iconCls="icon-remove">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="weldedjunction/goWeldedJunction" class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
				</lable>
			</div>
		<jsp:include  page="../tenghanbottom.jsp"/>
		</div>
	</div>
  </body>
</html>
