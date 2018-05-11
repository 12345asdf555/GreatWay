$(function(){
	typecombobox();
	CaustUseDatagrid();
})
var chartStr = "";
$(document).ready(function(){
	showcompanyUseChart();
})

function setParam(){
	var type = $('#type').combobox('getValue');
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	chartStr = "?type="+type+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

var charts;
var array1 = new Array();
var array2 = new Array();
function showcompanyUseChart(){
   	//初始化echart实例
	charts = echarts.init(document.getElementById("companyUseChart"));
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
			trigger: 'axis',//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:['时长(h)']
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
				name:'时长(h)',
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

function CaustUseDatagrid(){
	setParam();
	$("#companyUseTable").datagrid( {
		fitColumns : true,
		height : $("body").height() - $("#companyUseChart").height()-$("#companyUse_btn").height()-60,
		width : $("body").width(),
		idField : 'id',
		url : "companyChart/getCompanyUse"+chartStr,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'fname',
			title : '厂家',
			width : 100,
			halign : "center",
			align : "left",
			formatter : function(value,row,index){
				array1.push(value);
             	return value;
			}
		}, {
			field : 'time',
			title : '焊接平均时长(h)',
			width : 100,
			halign : "center",
			align : "left",
			formatter : function(value,row,index){
				array2.push(value);
             	return value;
			}
		}, {
			field : 'num',
			title : '数量',
			width : 100,
			halign : "center",
			align : "left"
		}] ],
		rowStyler: function(index,row){
            if ((index % 2)!=0){
            	//处理行代背景色后无法选中
            	var color=new Object();
                color.class="rowColor";
                return color;
            }
		},
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
		}
	});
}

function typecombobox(){
	$.ajax({  
      type : "post",  
      async : false,
      url : "companyChart/getCaust",  
      data : {},  
      dataType : "json", //返回数据形式为json  
      success : function(result) {  
          if (result) {
              var optionStr = '';
              for (var i = 0; i < result.ary.length; i++) {  
                  optionStr += "<option value=\"" + result.ary[i].id + "\" >"  
                          + result.ary[i].name + "</option>";
              }
              $("#type").html(optionStr);
          }  
      },  
      error : function(errorMsg) {  
          alert("数据请求失败，请联系系统管理员!");  
      }  
	}); 
	$("#type").combobox();
	var data = $("#type").combobox('getData');
	$("#type").combobox('select',data[0].value);
}

function serachcompanyUse(){
	$("#chartLoading").show();
	array1 = new Array();
	array2 = new Array();
	chartStr = "";
	setTimeout(function(){
		CaustUseDatagrid();
	},500);
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#companyUseTable").datagrid('resize', {
		height : $("body").height() - $("#companyUseChart").height()-$("#companyUse_btn").height()-60,
		width : $("body").width()
	});
}
