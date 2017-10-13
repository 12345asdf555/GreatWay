$(function(){
	detailloadsDatagrid();
})

function detailloadsDatagrid(){
	var machineno = $("#machineno").val();
	var otype = $("input[name='otype']:checked").val();
	$("#detailLoadsTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#detailLoad_btn").height(),
		width : $("#body").width(),
		idField : 'id',
		url : "junctionChart/getDetailLoads?machineno="+machineno+"&otype="+otype,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'iname',
			title : '事业部',
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
			title : '负荷率',
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
		toolbar : '#detailLoad_btn',
	});
}

function serachdetailloads(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var otype = $("input[name='otype']:checked").val();
	$('#detailLoadsTable').datagrid('load', {
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
	$("#detailLoadsTable").datagrid('resize', {
		height : $("#body").height() - $("#detailLoad_btn").height(),
		width : $("#body").width()
	});
}
