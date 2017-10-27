<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增权限</title>
    
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
	<!-- <script type="text/javascript" src="resources/js/authority/addauthority"></script> -->

  </head>
<body class="easyui-layout">
        <div  id="body" region="center"  hide="true"  split="true" title="新增权限" style="background: white; height: 335px;">
    <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">权限信息</div>
            <div style="margin-bottom:10px">
                <input name="authorityName" class="easyui-textbox" data-options="validType:'authorityValidate',required:true" label="权限:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="authorityDesc" class="easyui-textbox" data-options="required:true" label="描述:" style="width:100%">
            </div>
            <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="status" name="status" data-options="required:true" label="状态:" labelPosition="left">
                <option value="">--请选择--</option>
                <option value="1">启用</option>
                <option value="0">停用</option>
            </select>
        </div>
        <div style="margin-bottom:20px" align="center">
        <table id="tt" title="资源列表" checkbox="true" style="table-layout:fixed"></table>
        </div>
        </form>
    </div> 
    
    <div id="dlg-buttons" align="center">
        <a href="javascript:saveAuthority();" class="easyui-linkbutton c6" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="authority/AllAuthority" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
    <script type="text/javascript">
        $(function(){
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
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		},{
			field : 'resources_name',
			title : '资源名',
			width : 100,
			halign : "center",
			align : "left"
		}]],
		
	});
})

		$("#fm").form("disableValidation");
		var flag = 1;
        function saveAuthority(){
        flag = 1;
         var status = $('#status').combobox('getValue');
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "authority/addAuthority"+"?status="+status+"&rid="+str;
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
    </div>

</body>
</html>