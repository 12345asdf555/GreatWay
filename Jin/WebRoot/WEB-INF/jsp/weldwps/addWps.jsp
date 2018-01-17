<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增工艺</title>
    
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
	<script type="text/javascript" src="resources/js/weldwps/addWps.js"></script>

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="新增工艺" style="background: white; height: 335px;">
		<div style="text-align: center ">
       	<form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">添加工艺</div>
            <div class="fitem">
            	<lable>工艺编号</lable>
                <input name="FWPSNum" id="FWPSNum" class="easyui-textbox" data-options="validType:'wpsValidate',required:true">
            </div>
            <div class="fitem">
            	<lable>标准焊接电流</lable>
                <input name="Fweld_I" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>标准焊接电压</lable>
                <input name="Fweld_V" type="easyui-textbox" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最大焊接电流</lable>
                <input name="Fweld_I_MAX" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最小焊接电流</lable>
                <input name="Fweld_I_MIN" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最大焊接电压</lable>
                <input name="Fweld_V_MAX" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>最小焊接电压</lable>
                <input name="Fweld_V_MIN" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>报警电流</lable>
                <input name="Fweld_Alter_I" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>报警电压</lable>
                <input name="Fweld_Alter_V" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>预置通道</lable>
                <input name="Fweld_PreChannel" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
				<lable>部门</lable>
				<select class="easyui-combobox" name="Fowner" id="Fowner" data-options="required:true"></select>
<!-- 				<input type="hidden" id="insid"/>
				<input class="easyui-textbox" name="Fowner" id="Fowner"/> -->
        	</div>
			<div class="fitem">
            	<lable>备注</lable>
                <input name="Fback" class="easyui-textbox">
            </div>
            <div class="fitem">
            	<lable>工艺参数名称</lable>
                <input name="Fname" class="easyui-textbox" data-options="required:true">
            </div>
	    	<div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveWps();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="wps/AllWps" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
	    	</div>
        </form>
    </div> 
    </div>
</body>
</html>