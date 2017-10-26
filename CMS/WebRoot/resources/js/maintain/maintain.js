$(function(){
	mainDatagrid();
});

function mainDatagrid(){
	$("#maintainTable").datagrid( {
		fitColumns : true,
		height : ($("#body").height() - $('#maintainTable_btn').height()),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "maintain/getMaintainList",
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		columns : [ [ {
			field : 'id',
			title : '序号',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		}, {
			field : 'equipmentNo',
			title : '设备编码',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'viceman',
			title : '维修人员',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'starttime',
			title : '维修起始时间',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'endtime',
			title : '维修结束时间',
			width : 150,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				if(value == null || value == ""){
					var str = '<a id="ok" class="easyui-linkbutton" href="javascript:okMaintain();"/>';
					return str;
				}
				return value;
			}
		}, {
			field : 'typename',
			title : '维修类型',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'desc',
			title : '维修说明',
			width : 100,
			halign : "center",
			align : "left"
		} , {
			field : 'typeid',
			title : '类型id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'wid',
			title : '设备id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'mid',
			title : '维修id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'edit',
			title : '编辑',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				var str = "";
				str += '<a id="edit" class="easyui-linkbutton" href="maintain/goEditMaintain?wid='+row.id+'"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="maintain/goremoveMaintain?wid='+row.id+'&tname='+row.typename+'"/>';
				return str;
			}
		}]],
		toolbar : '#maintainTable_btn',
		pagination : true,
		onLoadSuccess:function(data){
	        $("a[id='ok']").linkbutton({text:'完成',plain:true,iconCls:'icon-ok'});
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
		}
	});
}

//完成维修
function okMaintain(){
	var row = $("#maintainTable").datagrid('getSelected');
	$.ajax({  
	      type : "post",  
	      async : false,
	      url : "maintain/updateEndtime?wid="+row.mid+"&weldingid="+row.wid,
	      data : {},  
	      dataType : "json", 
	      success : function(result) {  
				if(result){
	              if(result.success){
						$('#maintainTable').datagrid('reload');
						$.messager.alert("提示", "已完成！");
	              }else{
	            	  $.messager.show( {
							title : 'Error',
							msg : result.errorMsg
						});
	              }
	          }  
	      },  
	      error : function(errorMsg) {  
	          alert("数据请求失败，请联系系统管理员!");  
	      }  
		});
}

//导出到excel
function exporMaintain(){
	$.messager.confirm("提示", "文件默认保存在浏览器的默认路径，<br/>如需更改路径请设置浏览器的<br/>“下载前询问每个文件的保存位置“属性！",function(result){
		if(result){
			window.location.href = encodeURI("/CMS/export/exporMaintain");
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
			url : "import/importMaintain",
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
						$('#maintainTable').datagrid('reload');
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
	$("#maintainTable").datagrid('resize', {
		height : $("#body").height() - $("#maintainTable_btn").height() - 5,
		width : $("#body").width()
	});
}

