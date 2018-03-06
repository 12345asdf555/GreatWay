$(function(){
	weldDatagrid();
});

function weldDatagrid(){
	$("#welderTable").datagrid( {
		height : $("#body").height(),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "welders/getAllWelder",
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		pagination : true,
		fitColumns : true,
		columns : [ [ {
			field : 'id',
			title : '序号',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		}, {
			field : 'name',
			title : '姓名',
			width : 80,
			halign : "center",
			align : "left"
		}, {
			field : 'welderno',
			title : '编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'cellphone',
			title : '手机',
			width : 100,
			halign : "center",
			align : "left"
		},{
			field : 'leveid',
			title : '级别',
			width : 100,
			halign : "center",
			align : "left"
		},{
			field : 'cardnum',
			title : '卡号',
			width : 100,
			halign : "center",
			align : "left"
		},{
			field : 'quali',
			title : '资质',
			width : 100,
			halign : "center",
			align : "left"
		},{
			field : 'createdate',
			title : '创建时间',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'updatedate',
			title : '修改时间',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'owner',
			title : '部门',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'back',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
		}
//		,{
//			field : 'edit',
//			title : '编辑',
//			width : 130,
//			halign : "center",
//			align : "left",
//			formatter:function(value,row,index){
//			var str = "";
//			str += '<a id="edit" class="easyui-linkbutton" href="welders/toUpdateWelder?fid='+row.id+'"/>';
//			str += '<a id="remove" class="easyui-linkbutton" href="welders/toDestroyWelder?fid='+row.id+'"/>';
//			return str;
//			}}
		] ],
		rowStyler: function(index,row){
            if ((index % 2)==0){
                return 'background-color:#eaf2ff';
            }
        },
		nowrap : false,
		toolbar : '#welderTable_btn'//,
//		onLoadSuccess:function(data){
//	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
//	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
//	        }
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#welderTable").datagrid('resize', {
		height : $("#body").height(),
		width : $("#body").width()
	});
}

function addWelder(){
	   var url = "welders/toAddWelder";
		var img = new Image();
	    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
	    url = img.src;  // 此时相对路径已经变成绝对路径
	    img.src = null; // 取消请求
		window.location.href = encodeURI(url);
}
