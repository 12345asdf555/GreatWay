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
	<script type="text/javascript" src="resources/js/process/addprocess.js"></script>

  </head>
  <body  class="easyui-layout" style="background:#ffffff;">
	<div class="divborder">
  		<div class="divtitle">新增工艺</div>
  	</div>
    <div  id="body" region="north"  hide="true"  split="true" style="background: white;height:80%;margin-top:70px;">
		<div style="text-align: center ">
       	<form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div class="fitem">
            	<lable>工艺名称</lable>
                <input name="processname" id="processname" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>焊接位态</lable>
                <input name="weldposition" id="weldposition" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>材质</lable>
                <input name="material" id="material" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>规格</lable>
                <input name="format" id="format" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>焊接方法</lable>
                <input name="method" id="method" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>焊材烘干条件</lable>
                <input name="drying" id="drying" class="easyui-textbox" data-options="required:true">
            </div>
			<div class="fitem">
            	<lable>预热温度</lable>
                <input name="temperature" id="temperature" class="easyui-textbox" data-options="required:true">
            </div>
			<div class="fitem">
            	<lable>后热条件</lable>
                <input name="factor" id="factor" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>热处理条件</lable>
                <input name="require" id="require" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>无损检测合格级别</lable>
                <input name="lecel" id="lecel" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>员工资质</lable>
                <input name="qualify" id="qualify" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>线能量控制范围</lable>
                <input name="range" id="range" class="easyui-textbox" data-options="required:true">
            </div>
	    	<div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveProcess();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="product/AllProcess" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
	    	</div>
        </form>
  		<jsp:include  page="../tenghanbottom.jsp"/>
    </div> 
    </div>
</body>
</html>