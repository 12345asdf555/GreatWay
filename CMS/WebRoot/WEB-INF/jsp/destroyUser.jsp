<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除用户</title>
    
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
<div  id="body" region="center"  hide="true"  split="true" title="删除用户" style="background: white; height: 335px;">
    <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">用户编辑</div>
            <div class="fitem">
                <input name="id" id="id" type="hidden" value="${user.id}">
            </div>
            <div class="fitem">
            	<lable>用户名</lable>
                <input name="userName" id="userName" class="easyui-textbox" value="${user.userName}"  readonly="true" data-options="required:true" style="width:100%">
            </div>
            <div class="fitem">
            	<lable>登录名</lable>
                <input name="userLoginName" class="easyui-textbox" readonly="true" data-options="required:true"  value="${user.userLoginName}" style="width:100%">
            </div>
            <div class="fitem">
            	<lable>密码</lable>
                <input name="userPassword" class="easyui-textbox" type="password" readonly="true" data-options="required:false" value="${user.userPassword}"style="width:100%">
            </div>
            <div class="fitem">
            	<lable>电话</lable>
                <input name="userPhone" class="easyui-textbox" readonly="true" data-options="required:false"  value="${user.userPhone}" style="width:100%">
            </div>
            <div class="fitem">
            	<lable>邮箱</lable>
                <input name="userEmail" class="easyui-textbox" readonly="true" data-options="required:false"  value="${user.userEmail}" style="width:100%">
            </div>
            <div class="fitem">
            	<lable>岗位</lable>
                <input id="userPosition" name="userPosition" class="easyui-textbox" readonly="true" value="${user.userPosition}" style="width:100%">
            </div>
            <div class="fitem">
            	<lable>部门</lable>
            	<select class="easyui-combobox" name="userInsframework" id="userInsframework" value="${user.userInsframework}"></select>
            </div>
			<div class="fitem">
				<input id="status" type="hidden" value="${role.roleStatus }"/>
				<lable>状态</lable>&nbsp;&nbsp;
   				<span id="radios"></span>
			</div>
	        <div style="margin-bottom:20px;margin-left:100px;" align="center">
	        <table id="tt" title="角色列表" checkbox="true" readonly="true" style="table-layout:fixed;width:100%"></table>
	        </div>
		    <div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveUser();" class="easyui-linkbutton" iconCls="icon-ok">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="user/AllUser" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
	    	</div>
        </form>
    </div> 
    
    <script type="text/javascript">
            $(function(){
		    showdatagrid();
		    statusRadio();
			var status = $("#status").val();
			$('[name="statusId"]:radio').each(function() { 
			if (this.value ==status ) { 
				this.checked = true;
			} 
			});
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
					checkbox:true
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
		
		function saveUser(){	
		var id = document.getElementById("id").value;
		$.messager.confirm('提示', '此操作不可撤销，是否确认删除?', function(flag) {
			if (flag) {
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "user/delUser?id="+id,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(result) {
			            if (result) {
			            	if (!result.success) {
								$.messager.show( {
									title : 'Error',
									msg : result.msg
								});
							} else {
								$.messager.alert("提示", "删除成功！");
								var url = "/CMS/user/AllUser";
								window.location.href = encodeURI(url);
							}
			            }  
			        },  
			        error : function(errorMsg) {  
			            alert("数据请求失败，请联系系统管理员!");  
			        }  
			   }); 
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
        
        		function statusRadio(){
			$.ajax({  
			    type : "post",  
			    async : false,
			    url : "user/getStatusAll",  
			    data : {},  
			    dataType : "json", //返回数据形式为json  
			    success : function(result) {
			    	if (result) {
			    		var str = "";
			    		for (var i = 0; i < result.ary.length; i++) {
			    			str += "<input type='radio' class='radioStyle' name='statusId' id='sId' value=\"" + result.ary[i].id + "\" />"  
		                    + result.ary[i].name+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			    		}
			            $("#radios").html(str);
			            $("input[name='statusId']").eq(0).attr("checked",true);
			        }  
			    },  
			    error : function(errorMsg) {  
			        alert("数据请求失败，请联系系统管理员!");  
			    }  
			});
		}
         
    </script>
    </div>
</body>
</html>