$(function(){
	DictionaryDataGrid();
	typeCombobox();
	$('#dlg').dialog( {
		onClose : function() {
			$("#fm").form("disableValidation");
		}
	})
	$("#fm").form("disableValidation");
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
			field:'typeid',
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
				str += '<a id="edit" class="easyui-linkbutton" href="javascript:editDictionary()"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="javascript:removeDictionary()"/>';
				return str;
			}
		}
		]],
		pagination : true,
		nowrap : false,
		rowStyler: function(index,row){
            if ((index % 2)!=0){
            	//处理行代背景色后无法选中
            	var color=new Object();
                color.class="rowColor";
                return color;
            }
		},
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-update'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-delete'});
		}
	});
}

var url = "";
var flag = 1;
function addDictionary(){
	flag = 1;
	$('#dlg').window( {
		title : "新增字典",
		modal : true
	});
	$('#dlg').window('open');
	$('#fm').form('clear');
	url = "Dictionary/addDictionary";
}

function editDictionary(){
	flag = 2;
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').window( {
			title : "修改字典",
			modal : true
		});
		$('#dlg').window('open');
		$('#fm').form('load', row);
		url = "Dictionary/editDictionary?id="+ row.id;
	}
}
//提交
function save(){
	var url2 = "";
	var back=$("#typeid").combobox('getText');
	if(flag==1){
		messager = "新增成功！";
		url2 = url+"?back="+back;
	}else{
		messager = "修改成功！";
		url2 = url+"&back="+back;
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
					$('#dg').datagrid('reload');
				}
			}
			
		},  
	    error : function(errorMsg) {  
	        alert("数据请求失败，请联系系统管理员!");  
	    } 
	});
}

function removeDictionary(){
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#rdlg').window( {
			title : "删除字典",
			modal : true
		});
		$('#rdlg').window('open');
		$('#rfm').form('load', row);
		url = "Dictionary/deleteDictionary?id="+row.id;
	}
}

function remove(){
	$.messager.confirm('提示', '此操作不可撤销，是否确认删除?', function(flag) {
		if (flag) {
			$.ajax({  
		        type : "post",  
		        async : false,
		        url : url,  
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
							$('#rdlg').dialog('close');
							$('#dg').datagrid('reload');
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

function searchDic(){
	var cols=$("#fields").combobox("getValue");
	var content=$("#content").val();
	var searchStr=cols+" like '%"+content+"%'";
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
}

//设备类型
function typeCombobox(){
	var optionStr = 
	"<option value='1'>账户类型</option>"+
	"<option value='2'>组织机构</option>"+
	"<option value='3'>焊机状态</option>"+
	"<option value='4'>焊机类型</option>"+
	"<option value='5'>维修类型</option>"+
	"<option value='6'>用户状态</option>"+
	"<option value='7'>焊工资质</option>"+
	"<option value='8'>焊工级别</option>"+
	"<option value='9'>焊接材质</option>";  
    $("#typeid").append(optionStr);
	$("#typeid").combobox();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#dg").datagrid('resize', {
		height : $("#body").height(),
		width : $("#body").width()
	});
}