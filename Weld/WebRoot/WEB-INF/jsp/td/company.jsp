<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增用户</title>
    
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
	<script type="text/javascript" src="resources/js/td/company.js"></script>
	<!-- <script type="text/javascript" src="resources/js/user/adduser"></script> -->

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="实时监控" style="background: white; height: 335px;">
    
       	<form id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px;">
            <div style="margin-bottom:10px;" align="left">
               <input class="liveInput" name="company" id="company" value="${insname}" readonly="true" type="text">
            </div>
            <div style="margin-bottom:10px" align="left">
               <label for="status" style="text-align:center;display:inline-block;width:65px">焊机总数</label> <input class="liveInput" name="statusn" id="statusn" value="0" readonly="true" type="text">
            </div>
            <div style="margin-bottom:10px;">
               <div style=" width:17px; height:17px; background-color:#00FF00; border-radius:25px; float:left"></div><label for="on" style="text-align:center;display:inline-block">工作总数</label> <input class="liveInput" name="onn" id="onn" value="0" readonly="true" type="text">
            </div>
            <div style="margin-bottom:10px">
               <div style=" width:17px; height:17px; background-color:#FF0000; border-radius:25px; float:left"></div><label for="warning" style="text-align:center;display:inline-block">报警总数</label> <input class="liveInput" name="warningn" id="warningn" value="0" readonly="true" type="text">
            </div>
            <div style="margin-bottom:10px">
               <div style=" width:17px; height:17px; background-color:#0000CD; border-radius:25px; float:left"></div><label for="wait" style="text-align:center;display:inline-block">待机总数</label> <input class="liveInput" name="waitn" id="waitn" value="0" readonly="true" type="text">
            </div>
            <div style="margin-bottom:10px">
                <div style=" width:17px; height:17px; background-color:#A9A9A9; border-radius:25px; float:left"></div><label for="off" style="text-align:center;display:inline-block">关机总数</label> <input class="liveInput" name="offn" id="offn" value="0" readonly="true" type="text">
            </div>
        </form>
        <input class="liveInput"  id="hid1" name="hid1" type="hidden" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.id}">
        </div>
</body>
</html>