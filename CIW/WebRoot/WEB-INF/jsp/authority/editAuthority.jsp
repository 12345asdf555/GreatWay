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
	<link rel="stylesheet" type="text/css" href="resources/css/datagrid.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	
  </head>
  <body  class="easyui-layout" style="background:#ffffff;">
  	<div class="divborder">
  		<div class="divtitle">修改权限</div>
  	</div>
	<div  id="body" region="north"  hide="true"  split="true" style="background: white; height: 80%;margin-top: 70px;">
     <div id="toolbar" style="text-align: center ">
       <form action="" id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div class="fitem">
                <input name="id" id="id" type="hidden" value="${authority.id}">
            </div>
            <div class="fitem">
				<lable><span class="required">*</span>权限</lable>
           		<input id="validName" type="hidden" value="${authority.authorityName}">
                <input name="authorityName" class="easyui-textbox"  data-options="validType:'authorityValidate',required:true" value="${authority.authorityName}" style="width:100%">
            </div>
            <div class="fitem">
				<lable><span class="required">*</span>描述</lable>
                <input name="authorityDesc" class="easyui-textbox" data-options="required:true" value="${authority.authorityDesc}" style="width:100%">
            </div>
			<div class="fitem">
				<input id="status" type="hidden" value="${authority.status }"/>
				<lable>状态</lable>&nbsp;&nbsp;
   				<span id="radios"></span>
			</div>
	        <div style="margin-bottom:20px;margin-left:100px;" align="center">
	        <table id="tt" title="资源列表" checkbox="true" style="table-layout:fixed;width:100%"></table>
	        </div>
		    <div class="buttonoption">
				<lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="javascript:saveAuthority();" class="easyui-linkbutton c6" iconCls="icon-ok">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href="authority/AllAuthority" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		        </lable>
		    </div>
        </form>
    </div>
  	<jsp:include  page="../tenghanbottom.jsp"/>
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
			$("#fm").form("disableValidation");
		})
    
    		function statusRadio(){
			$.ajax({  
			    type : "post",  
			    async : false,
			    url : "role/getStatusAll",  
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
    
        function showdatagrid(){
	    $("#tt").datagrid( {
		fitColumns : true,
		height : '250px',
		width : '15%',
		idField : 'resources_name',
		url : "authority/getAllResource1?id="+$("#id").val(),
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true
		},{
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		},{
			field : 'symbol',
			title : 'symbol',
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
		rowStyler: function(index,row){
            if ((index % 2)!=0){
            	//处理行代背景色后无法选中
            	var color=new Object();
                color.class="rowColor";
                return color;
            }
        },
		 onLoadSuccess:function(data){ 
  			 if(data){
            	each(data.rows, function(index, item){
            	if(item.symbol==1){
        			('#tt').datagrid('checkRow', index);
         		}
             })
         }    
	}                   	
	});
}

var flag = 2;
       function saveAuthority(){
       flag = 2;
         var status;
          var sid = $("input[name='statusId']:checked").val();
         var aid = $('#id').val();
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "authority/updateAuthority"+"?status="+sid+"&sid="+str+"&aid="+aid;
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
						var img = new Image();
					    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
					    url = img.src;  // 此时相对路径已经变成绝对路径
					    img.src = null; // 取消请求
						window.location.href = encodeURI(url);
                    }
                }
            });
        }

    </script>
</body>
</html>