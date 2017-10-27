<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改权限</title>
    
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
	
  </head>
<body class="easyui-layout">
	<div  id="body" region="center"  hide="true"  split="true" title="修改权限" style="background: white; height: 335px;">
     <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">权限信息</div>
            <div style="margin-bottom:10px;display: none;">
                <input name="id" id="id" class="easyui-textbox" type="hidden" value="${authority.id}">
            </div>
           <div style="margin-bottom:10px">
                <input name="authorityName" class="easyui-textbox" readonly="true" data-options="required:true" label="权限:" value="${authority.authorityName}" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="authorityDesc" class="easyui-textbox" required="true" label="描述:" value="${authority.authorityDesc}" style="width:100%">
            </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="status" name="status" value="${authority.status}" label="状态:" labelPosition="left">
                <option value="${authority.status}">${authority.status}</option>
                <option value="Status1">1</option>
                <option value="Status2">0</option>
            </select>
        </div>

        <div style="margin-bottom:20px" align="center">
        <table id="tt" title="资源列表" checkbox="true" style="table-layout:fixed;width:100%"></table>
        </div>
        </form>
    </div> 
    
    <div id="dlg-buttons" align="center">
        <a href="javascript:saveAuthority()" class="easyui-linkbutton c6" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="authority/AllAuthority" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
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
		idField : 'resources_name',
		url : "authority/getAllResource",
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true,
		},{
			field : 'resources_name',
			title : '资源名',
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
							url : 'authority/getResource?id='+a,
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
			        if(item.resources_name==c[i].resources_name){
			        $('#tt').datagrid('checkRow', index);
			        }
			        }
			        });
			        }
			        }                   	
	});
}

       function saveAuthority(){
         var status = $('#status').combobox('getValue');
         var aid = $('#id').val();
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "authority/updateAuthority"+"?status="+status+"&sid="+str+"&aid="+aid;
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
              			var url = "authority/AllAuthority";
						var a = document.createElement('A');
						a.href = url;  // 设置相对路径给Image, 此时会发送出请求
						url = a.href;  // 此时相对路径已经变成绝对路径
						window.location.href = encodeURI(url);
                    }
                }
            });
        }

    </script>
</body>
</html>