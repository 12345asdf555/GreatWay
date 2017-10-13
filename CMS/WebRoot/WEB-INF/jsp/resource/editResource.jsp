<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改资源</title>
    
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
	<!-- <script type="text/javascript" src="resources/js/user/edituser"></script> -->
	
  </head>
<body class="easyui-layout">
<div  id="body" region="center"  hide="true"  split="true" title="修改资源" style="background: white; height: 335px;">
    <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">资源编辑</div>
            <div style="margin-bottom:10px;display: none;">
                <input name="id" id="id" class="easyui-textbox" type="hidden" value="${resource.id}">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceName" id="userName" readonly="true" class="easyui-textbox" value="${resource.resourceName}" data-options="required:true" label="资源名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceType" class="easyui-textbox" data-options="required:true" value="${resource.resourceType}" label="类&nbsp;&nbsp;&nbsp;&nbsp;型:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceAddress" class="easyui-textbox" data-options="required:true"  value="${resource.resourceAddress}" label="地&nbsp;&nbsp;&nbsp;&nbsp;址:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceDesc" class="easyui-textbox" data-options="required:false"  value="${resource.resourceDesc}" label="描&nbsp;&nbsp;&nbsp;&nbsp;述:" style="width:100%">
            </div>

        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="status" name="status" value="${resource.status}" data-options="required:true" label="状态:" labelPosition="left">
                <option value="${resource.status}">${resource.status}</option>
                <option value="1">1</option>
                <option value="0">0</option>
            </select>
        </div>

        </form>
    </div> 
    
    <div id="dlg-buttons" align="center">
        <a href="javascript:saveResource();" class="easyui-linkbutton" iconCls="icon-ok" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="resource/AllResource" class="easyui-linkbutton" iconCls="icon-cancel" >取消</a>
    </div>
    
    <script type="text/javascript">
		
		 function saveResource(){
         var status = $('#status').combobox('getValue'); 
         var url;
          url = "resource/updateResource";
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                     return $(this).form('enableValidation').form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
              			$.messager.alert("提示", "修改成功");
                    	window.location.href = encodeURI("resource/AllResource");
                    }
                }
            });
        }
         
    </script>
    </div>
</body>
</html>