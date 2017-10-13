$(function(){
	itemjunctionDatagrid();
})

function itemjunctionDatagrid(){
	var item = $("#item").val();
	var material = $("#material").val();
	var externalDiameter = $("#externalDiameter").val();
	var wallThickness = $("#wallThickness").val();
	var nextexternaldiameter = $("#nextexternaldiameter").val();
	$("#junctionHourTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#junctionHour_btn").height(),
		width : $("#body").width(),
		idField : 'id',
		url : "junctionChart/getJunctionHour?item="+item+"&material="+material+"&externalDiameter="+externalDiameter+"&wallThickness="+wallThickness+"&nextexternaldiameter="+nextexternaldiameter,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'name',
			title : '焊口',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'manhour',
			title : '焊接工时',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'dyne',
			title : '达因',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'itemid',
			title : '焊口id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}] ],
		toolbar : '#junctionHour_btn',
	});
}

function serachjunctionHour(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	$('#junctionHourTable').datagrid('load', {
		"dtoTime1" : dtoTime1,
		"dtoTime2" : dtoTime2
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#junctionHourTable").datagrid('resize', {
		height : $("#body").height() - $("#junctionHour_btn").height(),
		width : $("#body").width()
	});
}
