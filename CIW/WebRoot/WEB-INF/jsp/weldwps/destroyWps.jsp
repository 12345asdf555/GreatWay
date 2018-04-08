<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除工艺</title>
    
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
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	<script type="text/javascript" src="resources/js/weldwps/destroyWps.js"></script>
	
  </head>
  <body  class="easyui-layout" style="background:#ffffff;">
    <div  id="body" region="north"  hide="true"  split="true" style="background: white;height:80%;margin-top:70px;">
    <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">工艺删除</div>
            <div style="margin-bottom:10px;display: none;">
                <input name="FID" id="FID" class="easyui-textbox" type="hidden" value="${wps.fid}">
            </div>
            <div class="fitem">
            	<lable>工艺编号</lable>
                <input name="FWPSNum" id="FWPSNum" class="easyui-textbox" value="${wps.fwpsnum}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>标准焊接电流</lable>
                <input name="Fweld_I" class="easyui-textbox" value="${wps.fweld_i}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>标准焊接电压</lable>
                <input name="Fweld_V" type="easyui-textbox" value="${wps.fweld_v}" class="easyui-textbox" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最大焊接电流</lable>
                <input name="Fweld_I_MAX" class="easyui-textbox" value="${wps.fweld_i_max}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最小焊接电流</lable>
                <input name="Fweld_I_MIN" class="easyui-textbox" value="${wps.fweld_i_min}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最大焊接电压</lable>
                <input name="Fweld_V_MAX" class="easyui-textbox" value="${wps.fweld_v_max}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最小焊接电压</lable>
                <input name="Fweld_V_MIN" class="easyui-textbox" value="${wps.fweld_v_min}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>工艺参数名称</lable>
                <input name="Fname" value="${wps.fname}" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>报警电流</lable>
                <input name="Fweld_Alter_I" class="easyui-textbox" value="${wps.fweld_alter_i}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>报警电压</lable>
                <input name="Fweld_Alter_V" class="easyui-textbox" value="${wps.fweld_alter_v}" readonly="true" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>焊丝直径</lable>
                <input name="Fdiameter" class="easyui-textbox" value="${wps.fdiameter}" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>预置通道</lable>
                <input name="Fweld_PreChannel" class="easyui-textbox" value="${wps.fweld_prechannel}" readonly="true" data-options="required:true">
            </div>
<!--             <div class="fitem"> -->
<!--             	<lable>提交时间</lable> -->
<%--                 <input name="FCReateDate" class="easyui-textbox" value="${create}" readonly="true" data-options="required:true" > --%>
<!--             </div> -->
<!--              <div class="fitem"> -->
<!--             	<lable>修改时间</lable> -->
<%--                 <input name="FUpdateDate" class="easyui-textbox" value="${update}" readonly="true" data-options="required:true"> --%>
<!--             </div> -->
            <div class="fitem">
				<lable>部门</lable>
				<input name="Fowners" id="Fowners" class="easyui-textbox" value="${wps.insname}">
        	</div>
			<div class="fitem">
            	<lable>备注</lable>
                <input name="Fback" value="${wps.fback}" class="easyui-textbox">
            </div>
	    	<div>
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveWps();" class="easyui-linkbutton" iconCls="icon-ok">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="wps/AllWps" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
	    	</div>
        </div>
	</form>
	</div> 
    </div>
</body>
</html>