$(function(){
	ItemEfficiencyDatagrid();
})
var chartStr = "";

function setParam(){
	var nextparent = $("#nextparent").val();
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var max = $("#max").val();
	var min = $("#min").val();
	var time1 = $("#time1").val();
	var time2 = $("#time2").val();
	chartStr = "?nextparent="+nextparent+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2+"&min="+min+"&max="+max+"&time1="+time1+"&time2="+time2;
}

function ItemEfficiencyDatagrid(){
	setParam();
	$("#itemEfficiencyTable").datagrid( {
		fitColumns : true,
		height : $("#body").height(),
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "itemChart/getItemEfficiency"+chartStr,
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		columns : [ [ {
			field : 'iname',
			title : '项目部',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'wname',
			title : '焊工姓名',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'wid',
			title : '焊工编号',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'weldtime',
			title : '焊接时长(h)',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'num',
			title : '完成焊口数',
			width : 150,
			halign : "center",
			align : "left"
		}, {
			field : 'dyne',
			title : '总达因值',
			width : 150,
			halign : "center",
			align : "left"
		}] ],
		toolbar : '#itemEfficiency_btn',
		pagination : true
	});
}

function serachEfficiencyItem(){
	chartStr = "";
	var time1 = $("#time1").val("");
	var time2 = $("#time2").val("");
	ItemEfficiencyDatagrid();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#itemEfficiencyTable").datagrid('resize', {
		height : $("#body").height(),
		width : $("#body").width()
	});
}
