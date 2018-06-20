<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改焊口</title>
    
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
  
  <body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="修改焊口" style="background: white; height: 335px;">
		<div style="text-align: center ">
			<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"><br/>
				<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">焊口编辑</div>
				<div class="fitem">
					<lable>编号</lable>
					<input type="hidden" id="id"  value="${wj.id }"  />
					<input type="hidden" id="oldno"  value="${wj.weldedJunctionno }"  />
					<input class="easyui-textbox" id="weldedJunctionno"  name="weldedJunctionno" value="${wj.weldedJunctionno }" data-options="validType:['wjNoValidate'],required:true" />
					<lable>机组</lable>
					<input class="easyui-textbox" id="unit" name="unit"  value="${wj.unit }" />
				</div>
				<div class="fitem">
					<lable>区域</lable>
					<input class="easyui-textbox" id="area" name="area"  value="${wj.area }" />
					<lable>规格</lable>
					<input class="easyui-textbox" id="specification" name="specification"  value="${wj.specification }" />
				</div>
				<div class="fitem">
					<lable>系统</lable>
					<input class="easyui-textbox" id="systems" name="systems" value="${wj.systems }" />
					<lable>子项</lable>
					<input class="easyui-textbox" id="children" name="children" value="${wj.children }" />
				</div>
				<div class="fitem">
					<lable>达因</lable>
					<input class="easyui-numberbox" id="dyne" name="dyne" data-options="required:true" value="${wj.dyne }" />
					<lable>序列号</lable>
					<input class="easyui-textbox" id="serialNo" name="serialNo" data-options="required:true" value="${wj.serialNo }" />
				</div>
				<div class="fitem">
					<lable>管线号</lable>
					<input class="easyui-textbox" id="pipelineNo"  name="pipelineNo"  value="${wj.pipelineNo }" />
					<lable>房间号</lable>
					<input class="easyui-textbox" id="roomNo" name="roomNo" value="${wj.roomNo }" />
				</div>
				<div class="fitem">
					<lable>上游外径</lable>
					<input class="easyui-textbox" id="externalDiameter" name="externalDiameter"  data-options="required:true" value="${wj.externalDiameter }" />
					<lable>下游外径</lable>
					<input class="easyui-textbox" id="nextexternaldiameter" name="nextexternaldiameter"  data-options="required:true" value="${wj.nextexternaldiameter }" />
				</div>
				<div class="fitem">
					<lable>上游璧厚</lable>
					<input class="easyui-textbox" id="wallThickness" name="wallThickness" data-options="required:true" value="${wj.wallThickness }" />
					<lable>下游璧厚</lable>
					<input class="easyui-textbox" id="nextwall_thickness" name="nextwall_thickness" data-options="required:true" value="${wj.nextwall_thickness }" />
				</div>
				<div class="fitem">
					<lable>上游材质</lable>
					<input class="easyui-textbox" id="material"  name="material" data-options="required:true" value="${wj.material }" />
					<lable>下游材质</lable>
					<input class="easyui-textbox" id="next_material" name="next_material" data-options="required:true"  value="${wj.next_material }" />
				</div>
				<div class="fitem">
					<lable>电流上限</lable>
					<input class="easyui-numberbox"  min="0.001" precision="3"  id="maxElectricity" name="maxElectricity" data-options="required:true"  value="${wj.maxElectricity }" />
					<lable>电流下限</lable>
					<input class="easyui-numberbox"  min="0.001" precision="3"  id="minElectricity" name="minElectricity" data-options="required:true"  value="${wj.minElectricity }" />
				</div>
				<div class="fitem">
					<lable>电压上限</lable>
					<input class="easyui-numberbox"  min="0.001" precision="3"  id="maxValtage" name="maxValtage" data-options="required:true"  value="${wj.maxValtage }" />
					<lable>电压下限</lable>
					<input class="easyui-numberbox"  min="0.001" precision="3"  id="minValtage"  name="minValtage" data-options="required:true"  value="${wj.minValtage }" />
				</div>
				<div class="fitem">
					<lable>电流单位</lable>
					<input class="easyui-textbox" id="electricity_unit"  name="electricity_unit" data-options="required:true"  value="${wj.electricity_unit }" />
					<lable>电压单位</lable>
					<input class="easyui-textbox" id="valtage_unit"  name="valtage_unit" data-options="required:true"  value="${wj.valtage_unit }" />
				</div>
				<div class="fitem">
					<lable>开始时间</lable>
					<input class="easyui-datetimebox" id="startTime"  name="startTime"  value="${wj.startTime }" />
					<lable>完成时间</lable>
					<input class="easyui-datetimebox" id="endTime"  name="endTime"  value="${wj.endTime }" />
				</div>
				<div class="fitem">
					<lable>所属项目</lable>
					<input type="hidden"  value="${wj.itemid.id }" id="iid">
					<select class="easyui-combobox" id="itemid"  name="itemid" data-options="required:true,editable:false"></select>
					<lable>&nbsp;</lable>
					<input type="text" readonly="readonly" />
				</div>
				<div class="weldbutton">
					<a href="javascript:editWeldedjunction();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
					<a href="weldedjunction/goWeldedJunction" class="easyui-linkbutton" iconCls="icon-cancel" >取消</a>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>
