$(function(){
	parentCombobox();
	typeCombobox();
	$('#dlg').dialog( {
		onClose : function() {
			$("#fm").form("disableValidation");
		}
	})
	$("#fm").form("disableValidation");
})


var url = "";
var flag = 1;
function addInsframework(){
	flag = 1;
	$('#dlg').window( {
		title : "新增组织机构",
		modal : true
	});
	$('#dlg').window('open');
	$('#fm').form('clear');
	url = "insframework/addInsframework";
}

function editInsframework(){
	allparentCombobox();
	flag = 2;
	var row = $('#insframeworkTable').datagrid('getSelected');
	if (row) {
		$('#dlg').window( {
			title : "修改组织机构",
			modal : true
		});
		$('#dlg').window('open');
		$('#fm').form('load', row);
		$('#validname').val(row.name);
		url = "insframework/editInsframework?id="+row.id;
	}
}
//提交
function saveInsframework(){
	var parent = $("#parentid").combobox('getValue');
	var type = $("#typeid").combobox('getValue');
	var url2 = "";
	if(flag==1){
		messager = "新增成功！";
		url2 = url+"?parent="+parent+"&type="+type;
	}else{
		messager = "修改成功！";
		url2 = url+"&parent="+parent+"&type="+type;
	}
	$('#fm').form('submit', {
		url : url2,
		onSubmit : function() {
			return $(this).form('enableValidation').form('validate');
		},
		success : function(result) {
			if(result){
				var result = eval('(' + result + ')');
				if (!result.success) {
					$.messager.show( {
						title : 'Error',
						msg : result.errorMsg
					});
				} else {
					$.messager.alert("提示", messager);
					$('#dlg').dialog('close');
					$('#insframeworkTable').datagrid('reload');
//					var url = "insframework/goInsframework";
//					var img = new Image();
//				    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
//				    url = img.src;  // 此时相对路径已经变成绝对路径
//				    img.src = null; // 取消请求
//					window.location.href = encodeURI(url);
				}
			}
			
		},  
	    error : function(errorMsg) {  
	        alert("数据请求失败，请联系系统管理员!");  
	    } 
	});
}

//父节点
function parentCombobox(){
	$.ajax({  
        type : "post",  
        async : false,
        url : "insframework/getParent",  
        data : {},  
        dataType : "json", //返回数据形式为json  
        success : function(result) {
            if (result) {
                var optionStr = '';  
                for (var i = 0; i < result.ary.length; i++) {  
                    optionStr += "<option value=\"" + result.ary[i].id + "\" >"  
                            + result.ary[i].name + "</option>";  
                }  
                $("#parentid").html(optionStr);
            }  
        },  
        error : function(errorMsg) {  
            alert("数据请求失败，请联系系统管理员!");  
        }  
   }); 
	$("#parentid").combobox();
}

function allparentCombobox(){
	$.ajax({  
        type : "post",  
        async : false,
        url : "insframework/getParent?flag="+true,  
        data : {},  
        dataType : "json", //返回数据形式为json  
        success : function(result) {
            if (result) {
                var optionStr = '';  
                for (var i = 0; i < result.ary.length; i++) {  
                    optionStr += "<option value=\"" + result.ary[i].id + "\" >"  
                            + result.ary[i].name + "</option>";  
                }  
                $("#parentid").html(optionStr);
            }  
        },  
        error : function(errorMsg) {  
            alert("数据请求失败，请联系系统管理员!");  
        }  
   }); 
	$("#parentid").combobox();
}
//类型
function typeCombobox(){
	$.ajax({  
      type : "post",  
      async : false,
      url : "insframework/getType",  
      data : {},  
      dataType : "json", //返回数据形式为json  
      success : function(result) {
          if (result) {
              var optionStr = '';  
              for (var i = 0; i < result.ary.length; i++) {  
                  optionStr += "<option value=\"" + result.ary[i].id + "\" >"  
                          + result.ary[i].name + "</option>";  
              }
              $("#typeid").html(optionStr);
          }  
      },  
      error : function(errorMsg) {  
          alert("数据请求失败，请联系系统管理员!");  
      }  
 }); 
	$("#typeid").combobox();
}

