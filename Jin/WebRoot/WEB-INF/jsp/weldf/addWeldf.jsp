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

	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	<script type="text/javascript" src="resources/js/weldf/addweldf.js"></script>

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="新增焊缝" style="background: white; height: 335px;">
		<div style="text-align: center ">
       	<form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">新增焊缝</div>
            <div class="fitem">
            	<lable>焊缝编号</lable>
                <input name="weldnum" id="weldnum" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>焊缝信息</lable>
                <input name="weldinfo" id="weldinfo" class="easyui-textbox" data-options="required:true">
            </div>
            <div class="fitem">
            	<lable>备注1</lable>
                <input name="remark1" id="remark1" class="easyui-textbox">
            </div>
            <div class="fitem">
            	<lable>备注2</lable>
                <input name="remark2" id="remark2" class="easyui-textbox">
            </div>
			<div class="fitem">
            	<lable>备注3</lable>
                <input name="remark3" id="remark3" class="easyui-textbox">
            </div>
			<div class="fitem">
            	<lable>备注4</lable>
                <input name="remark4" id="remark4" class="easyui-textbox">
            </div>
	    	<div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveWeldf();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="product/AllWeldf" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
	    	</div>
        </form>
    </div> 
    </div>
</body>
</html>