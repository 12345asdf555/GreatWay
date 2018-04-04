<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增焊缝</title>
    
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
	<script type="text/javascript" src="resources/js/weldedjunction/addeditweldedjunction.js"></script>
  </head>
  
  <body  class="easyui-layout" style="background:#ffffff;">
  	<div class="divborder">
  		<div class="divtitle">新增焊缝</div>
  	</div>
    <div id="body" region="north" hide="true"  split="true" style="background: witch; height: 80%;margin-top: 70px;">
    	<div style="text-align:center;height:100%">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div class="fitem">
					<lable><span class="required">*</span>编号</lable>
					<input class="easyui-textbox" id="weldedjunctionno"  name="weldedjunctionno" data-options="validType:['wjNoValidate'],required:true" />
					<lable><span class="required">*</span>序列号</lable>
					<input class="easyui-textbox" id="serialNo" name="serialNo" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>机组</lable>
					<input class="easyui-textbox" id="unit" name="unit"/>
					<lable>区域</lable>
					<input class="easyui-textbox" id="area" name="area"/>
				</div>
				<div class="fitem">
					<lable>系统</lable>
					<input class="easyui-textbox" id="systems" name="systems"/>
					<lable>子项</lable>
					<input class="easyui-textbox" id="children" name="children"/>
				</div>
				<div class="fitem">
					<lable>达因</lable>
					<input class="easyui-textbox" id="dyne" name="dyne"/>
					<lable>规格</lable>
					<input class="easyui-textbox" id="specification" name="specification"/>
				</div>
				<div class="fitem">
					<lable>管线号</lable>
					<input class="easyui-textbox" id="pipelineNo"  name="pipelineNo" />
					<lable>房间号</lable>
					<input class="easyui-textbox" id="roomNo" name="roomNo"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>上游外径</lable>
					<input class="easyui-textbox" id="externalDiameter" name="externalDiameter"  data-options="required:true"/>
					<lable><span class="required">*</span>下游外径</lable>
					<input class="easyui-textbox" id="nextexternaldiameter" name="nextexternaldiameter"  data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>上游璧厚</lable>
					<input class="easyui-textbox" id="wallThickness" name="wallThickness" data-options="required:true"/>
					<lable><span class="required">*</span>下游璧厚</lable>
					<input class="easyui-textbox" id="nextwall_thickness" name="nextwall_thickness" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>上游材质</lable>
					<input class="easyui-textbox" id="material"  name="material" data-options="required:true"/>
					<lable><span class="required">*</span>下游材质</lable>
					<input class="easyui-textbox" id="next_material" name="next_material" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>电流上限</lable>
					<input class="easyui-textbox" id="maxElectricity" name="maxElectricity" data-options="required:true"/>
					<lable><span class="required">*</span>电流下限</lable>
					<input class="easyui-textbox" id="minElectricity" name="minElectricity" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>电压上限</lable>
					<input class="easyui-textbox" id="maxValtage" name="maxValtage" data-options="required:true"/>
					<lable><span class="required">*</span>电压下限</lable>
					<input class="easyui-textbox" id="minValtage"  name="minValtage" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>电流单位</lable>
					<input class="easyui-textbox" id="electricity_unit"  name="electricity_unit" data-options="required:true"/>
					<lable><span class="required">*</span>电压单位</lable>
					<input class="easyui-textbox" id="valtage_unit"  name="valtage_unit" data-options="required:true"/>
				</div>
				<div class="fitem">
					<lable>开始时间</lable>
					<input class="easyui-datetimebox" id="startTime"  name="startTime"/>
					<lable>完成时间</lable>
					<input class="easyui-datetimebox" id="endTime"  name="endTime"/>
				</div>
				<div class="fitem">
					<lable><span class="required">*</span>所属项目</lable>
					<select class="easyui-combobox" id="itemname"  name="itemname" data-options="required:true,editable:false"></select>
					<lable></lable>
					<input type="text" border="0" readonly="readonly"/>
				</div>
				<div style="margin-left:50px">
					<lable>
						<a href="javascript:addWeldedjunction();" class="easyui-linkbutton"	iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="weldedjunction/goWeldedJunction" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
					</lable>
				</div>
			</form>
			<jsp:include  page="../tenghanbottom.jsp"/>
		</div>
	</div>
  </body>
</html>
