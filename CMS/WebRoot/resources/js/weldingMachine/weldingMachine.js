$(function(){
	weldingMachineDatagrid();
});

function weldingMachineDatagrid(){
	$("#weldingmachineTable").datagrid( {
		fitColumns : true,
		height : ($("#body").height() - $('#weldingmachineTable_btn').height()),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "weldingMachine/getWedlingMachineList",
		singleSelect : true,
		rownumbers : true,
		showPageList : false, 
        columns : [ [ {
			field : 'id',
			title : '序号',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'equipmentNo',
			title : '设备编码',
			width : 80,
			halign : "center",
			align : "left"
		}, {
			field : 'typeName',
			title : '设备类型',
			width : 80,
			halign : "center",
			align : "left"
		}, {
			field : 'jointime',
			title : '入厂时间',
			width : 150,
			halign : "center",
			align : "left"
			
		}, {
			field : 'insframeworkName',
			title : '所属项目',
			width : 80,
			halign : "center",
			align : "left"
		}, {
			field : 'statusName',
			title : '状态',
			width : 80,
			halign : "center",
			align : "left"
		} , {
			field : 'manufacturerName',
			title : '厂家',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'isnetworking',
			title : '是否在网',
			width : 80,
			halign : "center",
			align : "left"
		}, {
			field : 'gatherId',
			title : '采集序号',
			width : 100,
			halign : "center",
			align : "left",
		}, {
			field : 'position',
			title : '位置',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'statusId',
			title : '状态id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'isnetworkingId',
			title : '是否联网id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'manufacturerId',
			title : '厂商id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'typeId',
			title : '类型id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'insframeworkId',
			title : '项目id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'edit',
			title : '编辑',
			width : 250,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				var str = "";
				str += '<a id="edit" class="easyui-linkbutton" href="weldingMachine/goEditWeldingMachine?wid='+row.id+'"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="weldingMachine/goremoveWeldingMachine?wid='+row.id+'"/>';
				str += '<a id="maintain" class="easyui-linkbutton" href="weldingMachine/goMaintain?wid='+row.id+'"/>';
				return str;
			}
		}] ],
		toolbar : '#weldingmachineTable_btn',
		pagination : true,
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
	        $("a[id='maintain']").linkbutton({text:'维修记录',plain:true,iconCls:'icon-edit'});
		}
	});
}

//导出到excel
function exportWeldingMachine(){
	$.ajax({  
        type : "post",  
        async : false,
        url : "export/exporWeldingMachine",  
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
					$('#weldingmachineTable').datagrid('reload');
					$.messager.alert("提示", "导出成功。");
				}
            }  
        },  
        error : function(errorMsg) {  
            alert("数据请求失败，请联系系统管理员!");  
        }  
   });
}

//导入
function importclick(){
	$("#importdiv").dialog("open").dialog("setTitle","从excel导入数据");
}

function importWeldingMachine(){
	var file = $('input[name="file"][type="file"]').prop('files')[0];
	if(file == null){
		$.messager.alert("提示", "请选择要上传的文件！");
		return false;
	}else{
		$('#importfm').form('submit', {
			url : "import/importWeldingMachine",
			success : function(result) {
				if(result){
					var result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show( {
							title : 'Error',
							msg : result.msg
						});
					} else {
						$('#importdiv').dialog('close');
						$('#weldingmachineTable').datagrid('reload');
						$.messager.alert("提示", result.msg);
					}
				}
				
			},  
		    error : function(errorMsg) {  
		        alert("数据请求失败，请联系系统管理员!");  
		    } 
		});
	}
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#weldingmachineTable").datagrid('resize', {
		height : $("#body").height() - $("#weldingmachineTable_btn").height() - 5,
		width : $("#body").width()
	});
}
