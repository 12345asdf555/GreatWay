<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增资源</title>
    
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
<!-- 	<script type="text/javascript" src="resources/js/resource/addresource"></script> -->

  </head>
<body class="easyui-layout">
    <div  id="body" region="center"  hide="true"  split="true" title="新增资源" style="background: white; height: 335px;">
		<div style="text-align: center ">
       	<form action="" id="fm" method="post" data-options="novalidate:true" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">资源信息</div>
            <div style="margin-bottom:10px">
                <input name="resourceName" class="easyui-textbox" data-options="validType:'resourceValidate',required:true" label="资源名:">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceType" class="easyui-textbox" data-options="required:true" label="类&nbsp;&nbsp;&nbsp;&nbsp;型:">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceAddress" class="easyui-textbox" data-options="required:true"  label="地&nbsp;&nbsp;&nbsp;&nbsp;址:">
            </div>
            <div style="margin-bottom:10px">
                <input name="resourceDesc" class="easyui-textbox" data-options="required:false"  label="描&nbsp;&nbsp;&nbsp;&nbsp;述:">
            </div>

			<div class="fitem">
				<lable>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态</lable>
   				<lable id="radios"></lable>
			</div>
        </form>
    </div> 
    
    <div id="fitem" align="center">
        <a href="javascript:saveResource();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="resource/AllResource" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
    <script type="text/javascript">
        $(function(){
        statusRadio();
        })

        $("#fm").form("disableValidation");
        var flag = 1;
        function saveResource(){
        flag = 1;
         var sid = $("input[name='statusId']:checked").val();
         var url;
          url = "resource/addResource"+"?status="+sid;
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
                    	window.location.href = encodeURI("/CMS/resource/AllResource");
                    }
                }
            });
        }
        
        function statusRadio(){
		$.ajax({  
		    type : "post",  
		    async : false,
		    url : "resource/getStatusAll",  
		    data : {},  
		    dataType : "json", //返回数据形式为json  
		    success : function(result) {
		    	if (result) {
		    		var str = "";
		    		for (var i = 0; i < result.ary.length; i++) {
		    			str += "<input type='radio' name='statusId' id='sId' value=\"" + result.ary[i].id + "\" />"  
	                    + result.ary[i].name;
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