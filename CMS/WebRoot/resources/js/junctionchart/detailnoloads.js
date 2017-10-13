$(function(){
	detailnoloadsDatagrid();
})

function detailnoloadsDatagrid(){
	var machineno = $("#machineno").val();
	var otype = $("input[name='otype']:checked").val();
	$("#detailNoLoadsTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#detailNoLoad_btn").height(),
		width : $("#body").width(),
		idField : 'id',
		url : "junctionChart/getDetailNoLoads?machineno="+machineno+"&otype="+otype,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'iname',
			title : '序号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'name',
			title : '项目部',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'machineno',
			title : '设备编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'loads',
			title : '空载率',
			width : 100,
			halign : "center",
			align : "left",
		}, {
			field : 'weldtime',
			title : '日期',
			width : 100,
			halign : "center",
			align : "left",
		}] ],
		toolbar : '#detailNoLoad_btn',
	});
}

function serachdetailnoloads(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var otype = $("input[name='otype']:checked").val();
	$('#detailNoLoadsTable').datagrid('load', {
		"dtoTime1" : dtoTime1,
		"dtoTime2" : dtoTime2,
		"otype" : otype
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#detailNoLoadsTable").datagrid('resize', {
		height : $("#body").height() - $("#detailNoLoad_btn").height(),
		width : $("#body").width()
	});
}
