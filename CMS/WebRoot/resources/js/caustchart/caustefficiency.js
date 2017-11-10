$(function(){
	CaustEfficiencyDatagrid();
	var afresh = $("#afresh").val();
	if(afresh!=null && afresh!=""){
		$.messager.confirm("提示",afresh,function(result){
			if(result){
				top.location.href = "/CMS/login.jsp";
			}
		});
	}
})
var chartStr = "";
$(document).ready(function(){
//	showcaustEfficiencyChart();
})

function showcaustEfficiencyChart(){
	var array1 = new Array();
	var array2 = new Array();
	var parent = $("#parent").val();
	var otype = $("input[name='otype']:checked").val();
	var Series = [];
	 $.ajax({  
         type : "post",  
         async : false,
         url : "caustChart/getCaustLoads?otype="+otype+"&parent="+parent+chartStr,
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {
            	 for(var i=0;i<result.arys.length;i++){
                  	array1.push(result.arys[i].weldTime);
            	 }
                 for(var i=0;i<result.arys1.length;i++){
                 	array2.push(result.arys1[i].name);
                 	Series.push({
                 		name : result.arys1[i].name,
                 		type :'line',//折线图
                 		data : result.arys1[i].loads,
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
             alert("图表请求数据失败啦!");  
         }  
    }); 
   	//初始化echart实例
	charts = echarts.init(document.getElementById("caustEfficiencyChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: ""//焊接工艺超标统计
		},
		tooltip:{
			trigger: 'axis'//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:array2
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
		]
	}
	option.series = Series;
	//为echarts对象加载数据
	charts.setOption(option);
	//隐藏动画加载效果
	charts.hideLoading();
}


function CaustEfficiencyDatagrid(){
	var parent = $("#parent").val();
	$("#caustEfficiencyTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#caustEfficiencyChart").height()-$("#caustEfficiency_btn").height()-40,
		width : $("#body").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "caustChart/getCaustEfficiency?parent="+parent+chartStr,
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
		pagination : true
	});
}

function serachEfficiencyCaust(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var otype = $("input[name='otype']:checked").val();
	chartStr = "&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2+"&otype"+otype;
	showcaustEfficiencyChart();
	CaustEfficiencyDatagrid();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#caustEfficiencyTable").datagrid('resize', {
		height : $("#body").height() - $("#caustEfficiencyChart").height()-$("#caustEfficiency_btn").height()-10,
		width : $("#body").width()
	});
}