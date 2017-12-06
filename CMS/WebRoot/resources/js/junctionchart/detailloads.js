$(function(){
	detailloadsDatagrid();
	var afresh = $("#afresh").val();
	if(afresh!=null && afresh!=""){
		$.messager.confirm("提示",afresh,function(result){
			if(result){
				top.location.href = "/CMS/login.jsp";
			}
		});
	}
})

function detailloadsDatagrid(){
	var parent = $("#parent").val();
	var weldtime = $("#weldtime").val();
	$("#detailLoadsTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#detailLoad_btn").height(),
		width : $("#body").width(),
		idField : 'id',
		url : "junctionChart/getDetailLoads?parent="+parent+"&weldtime="+weldtime,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
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
