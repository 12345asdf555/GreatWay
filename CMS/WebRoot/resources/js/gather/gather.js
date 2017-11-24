$(function(){
	GatherDatagrid();
});

function GatherDatagrid(){
	$("#gatherTable").datagrid( {
		fitColumns : true,
		height : $("#body").height(),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "gather/getGatherList",
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
			field : 'gatherNo',
			title : '采集模块编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'status',
			title : '采集模块状态',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'protocol',
			title : '采集模块通讯协议',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'ipurl',
			title : '采集模块IP地址',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'macurl',
			title : '采集模块MAC地址',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'leavetime',
			title : '采集模块出厂时间',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'edit',
			title : '编辑',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				var str = "";
				str += '<a id="edit" class="easyui-linkbutton" href="gather/goeditGather?id='+row.id+'"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="gather/goremoveGather?id='+row.id+'"/>';
				return str;
			}
		}] ],
		toolbar : '#gather_btn',
		pagination : true,
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
		}
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#gatherTable").datagrid('resize', {
		height : $("#body").height(),
		width : $("#body").width()
	});
}

