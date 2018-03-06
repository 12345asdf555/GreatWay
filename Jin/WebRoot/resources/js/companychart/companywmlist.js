$(function(){
	CompanyloadsDatagrid();
})
var chartStr = "";
$(document).ready(function(){
	showCompanyLoadsChart();
})

function setParam(){
	var parent = $("#parent").val();
	var status = $("#status").val();
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	chartStr = "?parent="+parent+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2+"&status="+status;
}

function showCompanyLoadsChart(){
	setParam();
	var array1 = new Array();
	var array2 = new Array();
	var Series = [];
	 $.ajax({  
         type : "post",  
         async : false,
         url : "companyChart/getCompanyWmList"+chartStr,
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {
            	 for(var i=0;i<result.rows.length;i++){
                  	array1.push(result.rows[i].equipment);
                  	array2.push(result.rows[i].num.toFixed(2));
            	 }
             }  
         },  
        error : function(errorMsg) {  
             alert("图表请求数据失败啦!");  
         }  
    }); 
   	//初始化echart实例
	charts = echarts.init(document.getElementById("companywmlistChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: ""//标题
		},
		tooltip:{
			trigger: 'axis',//坐标轴触发，即是否跟随鼠标集中显示数据
			formatter: function (params, ticket, callback) {
			    	return params[0].seriesName+"<br/>"+params[0].marker+params[0].name+":  "+params[0].value;
			}
		},
		legend:{
			data:['焊机工时(h)']
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
		series:[{
     		name :'焊机工时(h)',
     		type :'bar',//柱状图
     		data :array2
		},{
     		name :'焊机工时(h)',
     		type :'line',//折线图
     		data :array2,
     		itemStyle : {
     			normal: {
                    color:'#000000',  //折点颜色
     				label : {
     					show: true//显示每个折点的值
     				},
     				lineStyle:{  
                        color:'#000000'  //折线颜色
                    }  
     			}
     		}
     	}]
	}
	//为echarts对象加载数据
	charts.setOption(option);
	//隐藏动画加载效果
	charts.hideLoading();
}

function CompanyloadsDatagrid(){
	setParam();
	 $("#companywmlistTable").datagrid( {
			fitColumns : true,
			height : $("#body").height() - $("#companywmlistChart").height()-$("#companywmlist_btn").height()-40,
			width : $("#body").width(),
			idField : 'id',
			url : "companyChart/getCompanyWmList"+chartStr,
			singleSelect : true,
			rownumbers : true,
			columns : [ [ {
				field : 'equipment',
				title : '焊机编号',
				width : 100,
				halign : "center",
				align : "left",
			}, {
				field : 'num',
				title : '工时(h)',
				width : 100,
				halign : "center",
				align : "left",
				formatter:function(value,row,index){
					return value.toFixed(2);
				}
			}] ],
			rowStyler: function(index,row){
	            if ((index % 2)==0){
	                return 'background-color:#eaf2ff';
	            }
	        }
	 })
}

function serachCompanywmlist(){
	chartStr = "";
	showCompanyLoadsChart();
	CompanyloadsDatagrid();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#companywmlistTable").datagrid('resize', {
		height : $("#body").height() - $("#companywmlistChart").height()-$("#companywmlist_btn").height()-10,
		width : $("#body").width()
	});
}