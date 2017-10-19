$(function(){
	otypecombobox();
	BlocIdleDatagrid();
})
var chartStr = "";
$(document).ready(function(){
	showblocIdleChart();
})

function showblocIdleChart(){
	var array1 = new Array();
	var array2 = new Array();
	var otype = $('#otype').combobox('getValue');
	 $.ajax({  
         type : "post",  
         async : false, //同步执行  
         url : "blocChart/getBlocIdle?otype="+otype+chartStr,
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {  
                 for(var i=0;i<result.rows.length;i++){
                 	array1.push(result.rows[i].fname);
                 	array2.push(result.rows[i].idle);
                 }
             }  
         },  
        error : function(errorMsg) {  
             alert("图表请求数据失败啦!");  
         }  
    }); 
   	//初始化echart实例
	charts = echarts.init(document.getElementById("blocIdleChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: "焊机闲置率"
		},
		tooltip:{
			trigger: 'axis'//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:['数量']
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


function BlocIdleDatagrid(){
	var otype = $('#otype').combobox('getValue');
	$("#blocIdleTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#blocIdle_btn").height()-$("#blocIdle_btn").height()-40,
		width : $("#body").width(),
		idField : 'id',
		url : "blocChart/getBlocIdle?otype="+otype,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'fname',
			title : '公司',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				return  '<a href="companyChart/goCompanyIdle?parent='+row.fid+'">'+value+'</a>';
			}
		}, {
			field : 'idle',
			title : '数量',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fid',
			title : '公司id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}] ]
	});
}

function otypecombobox(){
	var optionFields = "<option value='1'>一年</option>" +
	"<option value='2'>一月</option>" +
	"<option value='4'>一周</option>";
	$("#otype").html(optionFields);
	$("#otype").combobox();
	$('#otype').combobox('select',"2");
}

function serachBlocIdle(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	$('#blocIdleTable').datagrid('load', {
		"dtoTime1" : dtoTime1,
		"dtoTime2" : dtoTime2
	});
	chartStr = "&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
	showblocIdleChart();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#blocIdleTable").datagrid('resize', {
		height : $("#body").height() - $("#blocIdleChart").height()-$("#blocIdle_btn").height()-10,
		width : $("#body").width()
	});
}
