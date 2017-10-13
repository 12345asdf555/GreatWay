$(function(){
	insframeworkDatagrid();
});
function insframeworkDatagrid(){
	$("#insframeworkTable").datagrid( {
		fitColumns : true,
		height : ($("#body").height() - $('#insframework_btn').height()),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "insframework/getInsframeworkList",
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		columns : [ [ {
			field : 'id',
			title : '序号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'name',
			title : '项目名称',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'logogram',
			title : '简写',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'code',
			title : '编码',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'parent',
			title : '上级项目',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'type',
			title : '类型',
			width : 100,
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
				str += '<a id="edit" class="easyui-linkbutton" href="insframework/goeditInsframework?id='+row.id+'"/>';
				str += '<a id="remove" class="easyui-linkbutton" href="insframework/goremoveInsframework?id='+row.id+'"/>';
				return str;
			}
		}] ],
		toolbar : '#insframework_btn',
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
	$("#insframeworkTable").datagrid('resize', {
		height : $("#body").height() - $("#insframework_btn").height() - 5,
		width : $("#body").width()
	});
}

