$(function(){
	weldedJunctionDatagrid();
});

function weldedJunctionDatagrid(){
	$("#weldedJunctionTable").datagrid( {
		height : ($("#body").height() - $('#disctionaryTable_btn').height()),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "weldedjunction/getWeldedJunctionList",
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
			field : 'weldedJunctionno',
			title : '编号',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'serialNo',
			title : '序列号',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'pipelineNo',
			title : '管线号',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'roomNo',
			title : '房间号',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'unit',
			title : '机组',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'area',
			title : '区域',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'systems',
			title : '系统',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'children',
			title : '子项',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'externalDiameter',
			title : '外径',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'wallThickness',
			title : '壁厚',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'dyne',
			title : '达因',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'specification',
			title : '规格',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'maxElectricity',
			title : '电流上限',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'minElectricity',
			title : '电流下限',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'maxValtage',
			title : '电压上限',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'minValtage',
			title : '电压下限',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'itemname',
			title : '所属项目',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'material',
			title : '材质',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'nextexternaldiameter',
			title : '下游外径',
			width : 50,
			halign : "center",
			align : "left"
		}, {
			field : 'startTime',
			title : '开始时间',
			width : 70,
			halign : "center",
			align : "left"
		}, {
			field : 'endTime',
			title : '完成时间',
			width : 70,
			halign : "center",
			align : "left"
		}] ],
		toolbar : '#disctionaryTable_btn',
		pagination : true,
		fitColumns : true
	});
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

