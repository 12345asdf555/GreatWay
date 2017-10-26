<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户</title>
    
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
<div  id="body" region="center"  hide="true"  split="true" title="修改用户" style="background: white; height: 335px;">
    <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">用户编辑</div>
            <div style="margin-bottom:10px;display: none;">
                <input name="id" id="id" class="easyui-textbox" type="hidden" value="${user.id}">
            </div>
            <div style="margin-bottom:10px">	
                <input name="userName" id="userName" class="easyui-textbox" value="${user.userName}" data-options="required:true" label="用户名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input id="userLoginName" name="userPassword" class="easyui-textbox" type="password" data-options="required:false" value="${user.userPassword}" label="密&nbsp;&nbsp;&nbsp;&nbsp;码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
            	<input id="validName" type="hidden" value="${user.userLoginName}">
                <input id="userLoginName" name="userLoginName" class="easyui-textbox" data-options="validType:'userValidate',required:true"  value="${user.userLoginName}" label="登录名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input id="userPhone" name="userPhone" class="easyui-textbox" data-options="required:false"  value="${user.userPhone}" label="电&nbsp;&nbsp;&nbsp;&nbsp;话:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input id="userEmail" name="userEmail" class="easyui-textbox" data-options="required:false"  value="${user.userEmail}" label="邮&nbsp;&nbsp;&nbsp;&nbsp;箱:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input id="userPosition" name="userPosition" class="easyui-textbox" data-options="required:true" value="${user.userPosition}" label="岗&nbsp;&nbsp;&nbsp;&nbsp;位:" style="width:100%">
            </div>

            <div style="margin-bottom:20px">
				<lable>部门:</lable>
				<input class="easyui-combobox" name="userInsframework" id="userInsframework" value="${user.userInsframework}" data-options="required:true"/>
        	</div>

        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="status" name="status" data-options="required:true" label="状态:" labelPosition="left">
                <option value="${user.status==1?"启用":"停用"}">${user.status==1?"启用":"停用"}</option>
                <option value="1">启用</option>
                <option value="0">停用</option>
            </select>
        </div>
        
        <div style="margin-bottom:20px" align="center">
        <table id="tt" title="角色列表" checkbox="true" style="table-layout:fixed;width:100%"></table>
        </div>

        </form>
    </div> 
    
    <div id="dlg-buttons" align="center">
        <a href="javascript:saveUser();" class="easyui-linkbutton c6" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="user/AllUser" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
    
    <script type="text/javascript">
            $(function(){
		    showdatagrid();
		})
		
		function showdatagrid(){
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
					field : 'roles_name',
					title : '角色名',
					width : 100,
					halign : "center",
					align : "left"
				}]],      
				 onLoadSuccess:function(data){                
			        if(data){
			        $.each(data.rows, function(index, item){
			        	    var a = $("#id").val();
			        	    var b;
			        	    var c
						    $.ajax( {
							url : 'user/getRole?id='+a,
							data : {
							},
							type : 'post',
							async : false,
							dataType : 'json',
							success : function(result) {
							b = result.rows;
							},
							error : function() {
								alert("获取数据失败，请联系系统管理员！");
							}
						});
						c = eval(b);
					for(var i=0;i<c.length;i++)
					{
			        if(item.roles_name==c[i].roles_name){
			        $('#tt').datagrid('checkRow', index);
			        }
			        }
			        });
			        }
			        }                   
			});
		}
		
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
			      $("#userInsframework").combobox('select',document.getElementById("userInsframework").value);
			   },
			   error: function () {
			      alert('error');
			   }
			});
		})
		
		var flag = 2;
		 function saveUser(){
		 flag = 2;
         var insframework = $('#userInsframework').combobox('getValue');
         var status;
         var status1 = $('#status').combobox('getValue');
         if(status1==("启用")){
         status = 1;
         }
         else{
         status = 0;
         }
         var uid = $('#id').val();
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "user/updateUser"+"?userInsframework="+insframework+"&status="+status+"&rid="+str+"&uid="+uid;
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
                    	window.location.href = encodeURI("/CMS/user/AllUser");
                    }
                }
            });
        }
         
    </script>
    </div>
</body>
</html>