$(function(){
	DictionaryDataGrid();
});
function DictionaryDataGrid(){
	$("#dg").datagrid({
		fitColumns:true,
		height:$("#body").height(),
		width:$("#body").width(),
		idField:'id',
		pageSize:10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url:"Dictionary/getDictionaryAll",
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		columns:[[{
			field:'id',
			title:'序号',
			width:100,
			halign : "center",
			align : "left",
			hidden:true
		},
		{
			field:'valueName',
			title:'名称',
			width:350,
			halign:"center",
			align:"left"
		}
		,{
			field:'back',
			title:'类型',
			width:350,
			halign:"center",
			align:"left"
		},
		{
			field:'edit',
			title:'编辑',
			width:250,
			halign:"center",
			align:"left",
			formatter:function(value,row,index){
				var str = "";
				str += '<a id="edit" class="easyui-linkbutton" href="Dictionary/goEditDictionary?id='+row.id+'"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="Dictionary/goRemoveDictionary?id='+row.id+'"/>';
				return str;
			}
		}
		]],
		toolbar:'#toolbar',
		pagination : true,
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
		}
	});
}
function saveDictionary(value){
	var url;
	var back=$("#typeid").combobox('getText');
	if(value==1){
		url="Dictionary/addDictionary?back="+back;
		messager = "新增成功！";
	}else if(value==2){
		url="Dictionary/editDictionary?back="+back;
		messager = "修改成功！";
	}
	$("#fm").form('submit',{
		url:url,
		onSubmit : function() {
			return $(this).form('enableValidation').form('validate');
		},
		success:function(result){
			if(result){
				var result=eval('(' + result + ')');
				if (!result.success) {
					$.messager.show( {
						title : 'Error',
						msg : result.errorMsg
					});
				} else {
					var time = 500;
					if(result.msg==null){
						$.messager.alert("提示", messager);
					}else{
						time = 2500;
						$.messager.show( {title : '提示',msg : result.msg});
					}
					window.setTimeout(function() {
						var url = "Dictionary/goDictionary";
						var img = new Image();
					    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
					    url = img.src;  // 此时相对路径已经变成绝对路径
					    img.src = null; // 取消请求
						window.location.href = encodeURI(url);
					}, time);
				}
			}
		},
		error : function(errorMsg) {  
	        alert("数据请求失败，请联系系统管理员!");  
	    } 
	})
}
function searchDic(){
	var cols=$("#fields").combobox("getValue");
	var content=$("#content").val();
	var searchStr=cols+" like '%"+content+"%'";
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
}