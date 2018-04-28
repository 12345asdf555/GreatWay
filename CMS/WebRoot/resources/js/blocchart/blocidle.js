$(function(){
	otypecombobox();
	BlocIdleDatagrid();
})
var chartStr = "";
$(document).ready(function(){
	showblocIdleChart();
})

function setParam(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var otype = $('#otype').combobox('getValue');
	chartStr = "?otype="+otype+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

var array1 = new Array();
var array2 = new Array();
var Series = [];
function showblocIdleChart(){
   	//初始化echart实例
	charts = echarts.init(document.getElementById("blocIdleChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: ""
		},
		tooltip:{
			trigger: 'axis'//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:array2
		},
		grid:{
			left:'6%',//组件距离容器左边的距离
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
		]
	}
	option.series = Series;
	//为echarts对象加载数据
	charts.setOption(option);
	//隐藏动画加载效果
	charts.hideLoading();
	$("#chartLoading").hide();
}

function BlocIdleDatagrid(){
	setParam();
	var column = new Array();
	 $.ajax({  
         type : "post",  
         async : false,
		 url : "blocChart/getBlocIdle"+chartStr,
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {
            	 var width=$("#body").width()/result.rows.length;
                 column.push({field:"w",title:"时间跨度(年/月/日/周)",width:width,halign : "center",align : "left"});

                 for(var x=0;x<result.arys.length;x++){
                 	array1.push(result.arys[x].weldTime);
                 }
                 for(var m=0;m<result.arys1.length;m++){
                	 column.push({field:"a"+m,title:"<a href='companyChart/goCompanyIdle?parent="+result.arys1[m].id+"'>"+result.arys1[m].name+"(台)</a>",width:width,halign : "center",align : "left"});
                	 array2.push(result.arys1[m].name);
                  	 column.push({field:"a"+m,title:result.arys1[m].name,width:width,halign : "center",align : "left"});
                  	 Series.push({
                 		name : result.arys1[m].name,
                 		type :'line',//折线图
                 		data : result.arys1[m].idle,
                 		itemStyle : {
                 			normal: {
                 				label : {
                 					show: true//显示每个折点的值
                 				}
                 			}
                 		}
                 	 });
                 }
             }  
         },  
        error : function(errorMsg) {  
             alert("请求数据失败啦,请联系系统管理员!");  
         }  
    }); 
	 $("#blocIdleTable").datagrid( {
			fitColumns : true,
			height : $("#body").height() - $("#blocIdle_btn").height()-$("#blocIdle_btn").height()-40,
			width : $("#body").width(),
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50],
			url : "blocChart/getBlocIdle"+chartStr,
			singleSelect : true,
			rownumbers : true,
			showPageList : false,
			pagination : true,
			columns :[column]
	 })
}

function otypecombobox(){
	var optionFields = "<option value='1'>一年</option>" +
	"<option value='2'>一月</option>" +
	"<option value='3'>一日</option>" +
	"<option value='4'>一周</option>";
	$("#otype").html(optionFields);
	$("#otype").combobox();
	$('#otype').combobox('select',"3");
}

function serachBlocIdle(){
	$("#chartLoading").show();
	array1 = new Array();
	array2 = new Array();
	Series = [];
	chartStr = "";
	setTimeout(function() {
		BlocIdleDatagrid();
		showblocIdleChart();
	}, 500)
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
