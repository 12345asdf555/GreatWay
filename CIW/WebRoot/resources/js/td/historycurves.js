$(function(){
	Junction();
})

function setParam(){
	chartStr = "";
	var parent = $("#parent").val();
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	chartStr = "?parent="+parent+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

var time1 = new Array();
var vol = new Array();
var ele = new Array();
function Junction(){
	setParam();
	$("#dg").datagrid( {
		fitColumns : true,				
		height : $("#dgtb").height()/2,
		width : $("#dgtb").width(),
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "weldedjunction/getWeldingJun"+chartStr+"&wjno="+$("#wjno").val()+"&welderid="+$("#welderid").val(),
		singleSelect : true,
		rownumbers : true,
		showPageList : false,
		columns : [ [  {
		    field:'ck',
			checkbox:true
		}, {
			field : 'id',
			title : '序号',
			width : 30,
			halign : "center",
			align : "left",
			hidden:true
		}, {
			field : 'weldedJunctionno',
			title : '编号',
			width : 90,
			halign : "center",
			align : "left"
		}, {
			field : 'maxElectricity',
			title : '电流上限',
			width : 90,
			halign : "center",
			align : "left"
		}, {
			field : 'minElectricity',
			title : '电流下限',
			width : 90,
			halign : "center",
			align : "left"
		}, {
			field : 'maxValtage',
			title : '电压上限',
			width : 90,
			halign : "center",
			align : "left"
		}, {
			field : 'minValtage',
			title : '电压下限',
			width : 90,
			halign : "center",
			align : "left"
		}, {
			field : 'machine_num',
			title : '焊机编号',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'firsttime',
			title : '开始时间',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'lasttime',
			title : '终止时间',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'fweldingtime',
			title : '焊接时间(h)',
			width : 150,
			halign : "center",
			align : "left"
		},{
			field : 'machid',
			title : '焊机id',
			width : 90,
			halign : "center",
			align : "left",
			hidden:true
		}] ],
		pagination : true,
		rowStyler: function(index,row){
            if ((index % 2)!=0){
            	//处理行代背景色后无法选中
            	var color=new Object();
                color.class="rowColor";
                return color;
            }
        },
        onClickRow: function(index,row){
        	loadChart(row);
        },
        onSelect : function(index,row){
        	loadChart(row);
        }
	});
}

function loadChart(row){
	time1 = new Array();
	vol = new Array();
	ele = new Array();
	document.getElementById("load").style.display="block";
	var sh = '<div id="show" style="width:150px;" align="center"><img src="resources/images/load1.gif"/>数据加载中，请稍候...</div>';
	$("#body").append(sh);
	document.getElementById("show").style.display="block";
	chartStr = "";
	setParam();
	$.ajax({
		   type: "post", 
		   url: "rep/historyCurve"+chartStr+"&fid="+row.weldedJunctionno+"&mach="+row.machid+"&welderid="+$("#welderid").val(),
		   dataType: "json",
		   data: {},
		   success: function (result) {
		      if (result) {
		    	  var date = eval(result.rows);
		    	  if(date.length==0){
		    		  document.getElementById("load").style.display ='none';
		    		  document.getElementById("show").style.display ='none';
		    		  alert("该时间内未查询到相关数据")
		    	  }else{
			    	  for(var i=0;i<date.length;i++){
			    		  ele.push(date[i].ele);
			    		  vol.push(date[i].vol);
			    		  time1[i] = date[i].time;
			    	  }
			    	  eleChart();
			    	  volChart();
		    		  document.getElementById("load").style.display ='none';
		    		  document.getElementById("show").style.display ='none';
		    	  }
		      }
		   },
		   error: function () {
		      alert('error');
		   }
		});
}

function eleChart(){
    var myChart = echarts.init(document.getElementById('body1'));
    var option = {
        title : {
            text : '电流'
        },
        tooltip : {
            trigger : 'axis',
        },
        toolbox : {
            show : true,
            feature : {
                mark : {
                    show : false
                },
                dataView : {
                    show : false,
                    readOnly : false
                },
                restore : {
                    show : false
                }
            }
        },
        dataZoom : {//缩放
            show : true,
            start : 0
        },
        grid : {
            y2 : $("#body1").height()//图表高度
        },
        xAxis : [ {
			type:'category',
			data: time1
        } ],
        yAxis : [ {
            type : 'value',
            max : 650,
            min : 0
        } ],
        dataZoom: [
            {
                type: 'slider',
                show: true,
                xAxisIndex: [0],
                start: 1,
                end: 35,
            },
            {
                type: 'inside',
                xAxisIndex: [0],
                start: 1,
                end: 35,
            }
        ],
        series : [ {
            symbolSize : 5,//气泡大小
      		name : '电流',
      		type :'line',//折线图
      		data : ele,
      		itemStyle: {
      	        normal: {
      	            color: "#A020F0",
      	            lineStyle: {
      	                color: "#A020F0"
      	            }
      	        }
      	    },
        } ]
    };
    myChart.setOption(option);
}

function volChart(){
    var myChart = echarts.init(document.getElementById('body2'));
    var option = {
        title : {
            text : '电压'
        },
        tooltip : {
            trigger : 'axis',
        },
        toolbox : {
            show : true,
            feature : {
                mark : {
                    show : false
                },
                dataView : {
                    show : false,
                    readOnly : false
                },
                restore : {
                    show : false
                }
            }
        },
        dataZoom : {//缩放
            show : true,
            start : 0
        },
        grid : {
            y2 : $("#body2").height()//图表高度
        },
        xAxis : [ {
			type:'category',
			data: time1
        } ],
        yAxis : [ {
            type : 'value',
            max : 150,
            min : 0
        } ],
        dataZoom: [
            {
                type: 'slider',
                show: true,
                xAxisIndex: [0],
                start: 1,
                end: 35,
            },
            {
                type: 'inside',
                xAxisIndex: [0],
                start: 1,
                end: 35,
            }
        ],
        series : [ {
            symbolSize : 5,//气泡大小
      		name : '电压',
      		type :'line',//折线图
      		data : vol,
      		itemStyle: {
      	        normal: {
      	            color: "#87CEFA",
      	            lineStyle: {
      	                color: "#87CEFA"
      	            }
      	        }
      	    },
        } ]
    };
    myChart.setOption(option);
}

function serachCompanyOverproof(){
	Junction();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#dg").datagrid('resize', {
		height : $("#dgtb").height()/2,
		width : $("#dgtb").width()
	});
}