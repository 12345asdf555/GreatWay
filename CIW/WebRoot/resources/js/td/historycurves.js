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
var result1 = new Array();
function Junction(){
	setParam();
	$("#dg").datagrid( {
		fitColumns : true,				
		height : $("#dgtb").height(),
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
        	$('#body1').html("");
			$('#body2').html("");
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
					    		  time1[i] = Date.parse(date[i].time);
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
	});
}


function eleChart(){
	Highcharts.setOptions({
	    global: {
	        useUTC: false
	    },
        lang: {
            resetZoom: '重置',
            resetZoomTitle: '重置缩放比例'
        }
	});
	$('#body1').highcharts({
	    title: {
	        text: '电流电压历史回溯'
	    },
	    chart: {
            panning: true,
            panKey: 'ctrl',
	    	zoomType: 'x',
	        type: 'spline',
	        animation: false, // don't animate in old IE
	        marginRight: 70
	    },
	    plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            },
	    	series:{
	    		turboThreshold:0
	    	}
        },
	    title: {
	        text: false
	    },
        mapNavigation: {
            enabled: true,
            enableButtons: false
        },
	    xAxis: {
	        type: 'datetime',
	        tickPixelInterval: 150
	    },
	    yAxis: [{
            max:650, // 定义Y轴 最大值  
            min:0, // 定义最小值  
            minPadding: 0.2,   
            maxPadding: 0.2,  
            tickInterval:130,
            color:'#A020F0',
	        title: {
	            text: '电流',
                style: {  
                    color: '#A020F0'  
                }  
	        }
	    }],
	    tooltip: {
	        formatter: function () {
	            return '<b>' + this.series.name + '</b><br/>' +
	                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
	                Highcharts.numberFormat(this.y, 2);
	        },
	    },
	    legend: {
	        enabled: false
	    },
	    exporting: {
	        enabled: false
	    },
	    credits:{
	      enabled:false // 禁用版权信息
	    },
	    series: [{
	    	color:'#A020F0',
	        name: '电流',
	        data: (function () {
	            var data = [];
	            for (i = 0; i < time1.length; i += 1) {
	                data.push({
	                    x: time1[i],
	                    y: ele[i]
	                });
	            }
	            return data;
	        }()),
	      
	    }]
	});

}

function volChart(){
	Highcharts.setOptions({
	    global: {
	        useUTC: false
	    },
        lang: {
            resetZoom: '重置',
            resetZoomTitle: '重置缩放比例'
        }
	});
	$('#body2').highcharts({
		    chart: {
	            panning: true,
	            panKey: 'ctrl',
		    	zoomType: 'x',
		        type: 'spline',
		        animation: false, // don't animate in old IE
		        marginRight: 70,
		    },
		    plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false
                },
		    	series:{
		    		turboThreshold:0
		    	}
            },
		    title: {
		        text: false
		    },
	        mapNavigation: {
	            enabled: true,
	            enableButtons: false
	        },
		    xAxis: {
		        type: 'datetime',
		        tickPixelInterval: 150
		    },
		    yAxis: [{
            max:150, // 定义Y轴 最大值  
            min:0, // 定义最小值  
            minPadding: 0.2,   
            maxPadding: 0.2,  
            tickInterval:30,
            color:'#87CEFA',
		    	title: {
		            text: '电压',
	                style: {  
	                    color: '#87CEFA'  
	                }  
		        },
		    }],
		    tooltip: {
		        formatter: function () {
		            return '<b>' + this.series.name + '</b><br/>' +
		                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
		                Highcharts.numberFormat(this.y, 2);
		        },
		    },
		    legend: {
		        enabled: false
		    },
		    exporting: {
		        enabled: false
		    },
		    credits:{
		      enabled:false // 禁用版权信息
		    },
		    series: [{
		        name: '电压',
		        data: (function () {
		            var data = [];
		            for (i = 0; i < time1.length; i += 1) {
		                data.push({
		                    x: time1[i],
		                    y: vol[i]
		                });
		            }
		            return data;
		        }()),
		      
		    }]
		});
}
