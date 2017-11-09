$(function(){
	BlocHourDatagrid();
})
var chartStr = "";
$(document).ready(function(){
	showblocHourChart();
})

function showblocHourChart(){
	var array1 = new Array();
	var array2 = new Array();
	 $.ajax({  
         type : "post",  
         async : false, //同步执行  
         url : "blocChart/getBlocHour"+chartStr,
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {  
                 for(var i=0;i<result.rows.length;i++){
                 	array1.push(result.rows[i].name);
                 	array2.push(result.rows[i].manhour);
                 }
             }  
         },  
        error : function(errorMsg) {  
             alert("图表请求数据失败啦!");  
         }  
    }); 
   	//初始化echart实例
	charts = echarts.init(document.getElementById("blocHourChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: "焊口焊接工时"
		},
		tooltip:{
			trigger: 'axis'//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:['工时']
		},
		grid:{
			left:'10%',//组件距离容器左边的距离
			right:'4%',
			bottom:'7%',
			containLaber:true//区域是否包含坐标轴刻度标签
		},
		toolbox:{
			feature:{
				saveAsImage:{}//保存为图片
			},
			right:'2%'
		},
		xAxis:{
			type:'category',
			data: array1
		},
		yAxis:{
			type: 'value'//value:数值轴，category:类目轴，time:时间轴，log:对数轴
		},
		series:[
			{
				name:'工时',
				type:'bar',
				data:array2
			}
		]
	}
	//为echarts对象加载数据
	charts.setOption(option);
	//隐藏动画加载效果
	charts.hideLoading();
}


function BlocHourDatagrid(){
	$("#blocHourTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#blocHourChart").height()-$("#blocHour_btn").height()-40,
		width : $("#body").width(),
		idField : 'id',
		url : "blocChart/getBlocHour",
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'name',
			title : '公司',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				return  '<a href="companyChart/goCompanyHour?parent='+row.companyid+'">'+value+'</a>';
			}
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
			field : 'companyid',
			title : '公司id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}] ]
	});
}

function serachblocHour(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	$('#blocHourTable').datagrid('load', {
		"dtoTime1" : dtoTime1,
		"dtoTime2" : dtoTime2
	});
	chartStr = "?dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
	showblocHourChart();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#blocHourTable").datagrid('resize', {
		height : $("#body").height() - $("#blocHourChart").height()-$("#blocHour_btn").height()-10,
		width : $("#body").width()
	});
}
