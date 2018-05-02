$(function(){
	itemDataDatagrid();
})

var chartStr = "";
function setParam(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	chartStr += "?dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

function itemDataDatagrid(){
	setParam();
	$("#itemDataTable").datagrid( {
		fitColumns : true,
		height : $("body").height()-$("#ItemData_btn").height()-60,
		width : $("body").width(),
		idField : 'id',
		url : "datastatistics/getItemData",
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'name',
			title : '所属班组',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'total',
			title : '设备总数',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'startnum',
			title : '开机设备数',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'machinenum',
			title : '实焊设备数',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'useratio',
			title : '设备利用率',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'junctionnum',
			title : '焊接焊缝数',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'weldtime',
			title : '焊接时间',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'starttime',
			title : '工作时间',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'weldingproductivity',
			title : '焊接效率',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'wire',
			title : '焊丝消耗',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'electric',
			title : '电能消耗',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'air',
			title : '气体消耗',
			width : 100,
			halign : "center",
			align : "left"
		}] ],
		onLoadSuccess : function(index,row){
			if(!charts){
		         return;
		    }
		    //更新数据
		    var option = charts.getOption();
		    option.series[0].data = array2;
		    option.xAxis[0].data = array1;
		    charts.setOption(option);    
		 	$("#chartLoading").hide();
		},
		rowStyler: function(index,row){
            if ((index % 2)!=0){
            	//处理行代背景色后无法选中
            	var color=new Object();
                color.class="rowColor";
                return color;
            }
        }
	});
}

function serachItemData(){
	chartStr = "";
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#itemDataTable").datagrid('resize', {
		height : $("body").height()-$("#ItemData_btn").height()-60,
		width : $("body").width()
	});
}