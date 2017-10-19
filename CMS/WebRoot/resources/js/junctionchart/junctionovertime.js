$(function(){
	junctionOvertimeDatagrid();
	var afresh = $("#afresh").val();
	if(afresh!=null && afresh!=""){
		$.messager.confirm("提示",afresh,function(result){
			if(result){
				top.location.href = "/CMS/login.jsp";
			}
		});
	}
})

function junctionOvertimeDatagrid(){
	var junctionno = $("#junctionno").val();
	var time1 = $("#time1").val();
	var time2 = $("#time2").val();
	var type = $("#type").val();
	var number = $("#number").val();
	$("#junctionOvertimeTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#junctionOvertime_btn").height(),
		width : $("#body").width(),
		idField : 'id',
		url : "junctionChart/getjunctionovertime?junctionno="+junctionno+"&time1="+time1+"&time2="+time2+"&type="+type+"&number="+number,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'weldtime',
			title : '日期',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'overtime',
			title : '时长',
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
			field : 'welderno',
			title : '焊工编号',
			width : 100,
			halign : "center",
			align : "left",
		}, {
			field : 'wname',
			title : '焊工姓名',
			width : 100,
			halign : "center",
			align : "left",
		}] ],
		toolbar : '#junctionOvertime_btn',
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#junctionOvertimeTable").datagrid('resize', {
		height : $("#body").height() - $("#junctionOvertime_btn").height(),
		width : $("#body").width()
	});
}
