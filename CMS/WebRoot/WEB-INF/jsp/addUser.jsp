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
	<!-- <script type="text/javascript" src="resources/js/user/adduser"></script> -->

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="新增用户" style="background: white; height: 335px;">
		<div style="text-align: center ">
       	<form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">添加用户</div>
            <div style="margin-bottom:10px">
                <input name="userName" id="userName" class="easyui-textbox" data-options="required:true" label="用户名:">
            </div>
            <div style="margin-bottom:10px">
                <input name="userPassword" type="password" class="easyui-textbox" data-options="required:true" label="密&nbsp;&nbsp;&nbsp;&nbsp;码:">
            </div>
            <div style="margin-bottom:10px">
                <input name="userLoginName" class="easyui-textbox" data-options="validType:'userValidate',required:true"  label="登录名:">
            </div>
            <div style="margin-bottom:10px">
                <input name="userPhone" class="easyui-textbox" data-options="required:false"  label="电&nbsp;&nbsp;&nbsp;&nbsp;话:">
            </div>
            <div style="margin-bottom:10px">
                <input name="userEmail" class="easyui-textbox" data-options="required:false"  label="邮&nbsp;&nbsp;&nbsp;&nbsp;箱:">
            </div>
            <div style="margin-bottom:10px">
                <input name="userPosition" class="easyui-textbox" data-options="required:true" label="岗&nbsp;&nbsp;&nbsp;&nbsp;位:">
            </div>
            <div style="margin-bottom:20px">
				<lable>部门:</lable>
				<input class="easyui-combobox" name="userInsframework" id="userInsframework" data-options="required:true"/>
        	</div>

        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="status" name="status" label="状态:" data-options="required:true" labelPosition="left">
                <option value="">--请选择--</option>
                <option value="1">启用</option>
                <option value="0">停用</option>
            </select>
        </div>
        
        <div style="margin-bottom:20px" align="center">
        <table id="tt" name="tt" title="角色列表" checkbox="true" style="table-layout:fixed"></table>
        </div>

        </form>
    </div> 
    
    <div id="fitem" align="center">
        <a href="javascript:saveUser();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="user/AllUser" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
    <script type="text/javascript">
        $(function(){
	    $("#tt").datagrid( {
		fitColumns : true,
		height : '250px',
		width : '15%',
		idField : 'roles_name',
		url : "user/getAllRole",
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true,
		},{
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		},{
			field : 'roles_name',
			title : '角色名',
			width : 100,
			halign : "center",
			align : "left"
		}]],
		
	});
})

		$(function(){
			   $.ajax({
			   type: "post", 
			   url: "user/getIns",
			   dataType: "json",
			   data: {},
			   success: function (result) {
			      if (result) {
			         var optionstring = "";
			         optionstring = "<option value='请选择'>请选择...</option>";
			         //循环遍历 下拉框绑定
			         for(var k=0;k<result.rows.length;k++){
			         optionstring += "<option value=\"" + result.rows[k].insid + "\" >" + result.rows[k].insname + "</option>";
			         }
			         $("#userInsframework").html(optionstring);
			      } else {
			         alert('部门加载失败');
			      }
			      $("#userInsframework").combobox();
			   },
			   error: function () {
			      alert('error');
			   }
			});
		})

        $("#fm").form("disableValidation");
 		var flag = 1; 
        function saveUser(){
        flag = 1;
         var insframework = $('#userInsframework').combobox('getValue');
         var status = $('#status').combobox('getValue');
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "user/addUser"+"?userInsframework="+insframework+"&status="+status+"&rid="+str;
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
					$.messager.alert("提示", "新增成功");              					
						var url = "user/AllUser";
						var a = document.createElement('A');
						a.href = url;  // 设置相对路径给Image, 此时会发送出请求
						url = a.href;  // 此时相对路径已经变成绝对路径
						window.location.href = encodeURI(url);
                    }
                }
            });
        }
    </script>
    </div>
</body>
</html>