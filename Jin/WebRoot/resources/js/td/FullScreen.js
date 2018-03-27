/**
 * 
 */
var data={};
var data1={};
var data2={};
var iname=0;
var maxele;
var maxvol;
var minele;
var minvol;
var dd;
var jj;
var mach;
var ii;
var sock;
$(function(){
	$.ajax({  
	      type : "post",  
	      async : false,
	      url : "td/AllTdbf",  
	      data : {},  
	      dataType : "json", //返回数据形式为json  
	      success : function(result) {
	          if (result) {
	        	  sock = eval(result.web_socket);
	          }  
	      },
	      error : function(errorMsg) {  
	          alert("数据请求失败，请联系系统管理员!");  
	      }  
	 });
})
$(function() {
	var socket;
	if(typeof(WebSocket) == "undefined") {
		alert("您的浏览器不支持WebSocket");
		return;
	}
	$(function() {
		//实现化WebSocket对象，指定要连接的服务器地址与端口
		socket = new WebSocket(sock);
		//打开事件
		socket.onopen = function() {
//				alert("Socket 已打开");
			//socket.send("这是来自客户端的消息" + location.href + new Date());
		};
		//获得消息事件
		socket.onmessage = function(msg) {
			dd = msg.data;
			for(var j = 0;j < 1;j++){
				for(var i = 0;i < dd.length;i+=53){
						if((dd.substring(8+i, 12+i))!="0000"){
							if($("#div"+dd.substring(4+i, 8+i)+"").length<=0){
								var str = "<div id='div0"+dd.substring(4+i, 8+i)+"' style='width:31%;height:40%;float:left;'>"+
								"<div id='div"+dd.substring(4+i, 8+i)+"' style='height:50%;'></div>"+
								"<div id='div1"+dd.substring(4+i, 8+i)+"' style='height:50%;'></div>" +
										"<div/>";
								$("#body").append(str);
								ii = i;
							    data['ele'+dd.substring(4+ii, 8+ii)] = [];
							    data1['vol'+dd.substring(4+ii, 8+ii)] = [];
							    data2['time'+dd.substring(4+ii, 8+ii)] = [];
							    data['ele'+dd.substring(4+ii, 8+ii)].push(parseInt(dd.substring(12+i, 16+i),16));
							    data1['vol'+dd.substring(4+ii, 8+ii)].push(parseFloat((parseInt(dd.substring(16+i, 20+i),16)/10).toFixed(2)));
							    data2['time'+dd.substring(4+ii, 8+ii)].push(Date.parse(dd.substring(20+i, 39+i)));
								maxele = parseInt(dd.substring(41+i, 44+i));
								minele = parseInt(dd.substring(44+i, 47+i));
								maxvol = parseInt(dd.substring(47+i, 50+i));
								minvol = parseInt(dd.substring(50+i, 53+i));
								mach=dd.substring(4+ii, 8+ii);
								curve();
								curve1();
							}else{
							    data['ele'+dd.substring(4+ii, 8+ii)].push(parseInt(dd.substring(12+i, 16+i),16));
							    data1['vol'+dd.substring(4+ii, 8+ii)].push(parseFloat((parseInt(dd.substring(16+i, 20+i),16)/10).toFixed(2)));
							    data2['time'+dd.substring(4+ii, 8+ii)].push(Date.parse(dd.substring(20+i, 39+i)));
							}
						}	
				}
				jj=data2['time'+dd.substring(4+ii, 8+ii)].length;
				if(jj%3==1){
					data['ele'+dd.substring(4+ii, 8+ii)][jj] = data['ele'+dd.substring(4+ii, 8+ii)][jj-1];
					data['ele'+dd.substring(4+ii, 8+ii)][jj+1] = data['ele'+dd.substring(4+ii, 8+ii)][jj-1];
					data1['vol'+dd.substring(4+ii, 8+ii)][jj] = data1['vol'+dd.substring(4+ii, 8+ii)][jj-1];
					data1['vol'+dd.substring(4+ii, 8+ii)][jj+1] = data1['vol'+dd.substring(4+ii, 8+ii)][jj-1];
					data2['time'+dd.substring(4+ii, 8+ii)][jj] = data2['time'+dd.substring(4+ii, 8+ii)][jj-1]+1000;
					data2['time'+dd.substring(4+ii, 8+ii)][jj+1] = data2['time'+dd.substring(4+ii, 8+ii)][jj-1]+2000;
					jj=jj+2;
				}
				if(jj%3==2){
					data['ele'+dd.substring(4+ii, 8+ii)][jj+1][jj] = data['ele'+dd.substring(4+ii, 8+ii)][jj+1][jj-1];
					data1['vol'+dd.substring(4+ii, 8+ii)][jj+1][jj] = data1['vol'+dd.substring(4+ii, 8+ii)][jj+1][jj-1];
					data2['time'+dd.substring(4+ii, 8+ii)][jj] = data2['time'+dd.substring(4+ii, 8+ii)][jj-1]+1000;
					jj++;
				}
				}
		};
		//关闭事件
		socket.onclose = function() {
			alert("Socket已关闭");
		};
		//发生了错误事件
		socket.onerror = function() {
			alert("发生了错误");
		}
	});
	
	$("#btnSend").click(function() {
		socket.send("强哥");
	});

	$("#btnClose").click(function() {
		socket.close();
	});
});

function curve(){
		Highcharts.setOptions({
		    global: {
		        useUTC: false
		    }
		});
		function activeLastPointToolip(chart) {
		    var points = chart.series[0].points;
/*  		    chart.tooltip.refresh(points[points.length -1]);
		    chart.tooltip.refresh(points1[points1.length -1]);*/
		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
		  		value:maxele, //在值为2的地方 
		  		width:2, //标示线的宽度为2px 
		  		color: 'red', //标示线的颜色 
		  	    dashStyle:'longdashdot',
		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
	          label:{
		            text:'最高电流',     //标签的内容
		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
		            x:10                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
		        }
		  	})
		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
		  		value:minele, //在值为2的地方 
		  		width:2, //标示线的宽度为2px 
		  		color: 'red', //标示线的颜色 
		  	    dashStyle:'longdashdot',
		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
	          label:{
		            text:'最低电流',     //标签的内容
		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
		            x:10                     //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
		        }
		  	})	  	
		}
		$('#div'+dd.substring(4+ii, 8+ii)+'').highcharts({
		    chart: {
		        type: 'spline',
		        animation: false, // don't animate in old IE
		        marginRight: 70,
		        events: {
		            load: function () {
		                // set up the updating of the chart each second
		                var series = this.series[0],
		                    chart = this;
		                var z=0;
		                	window.setInterval(function () {
		                    /*var x = (new Date()).getTime()+t,*/ // current time
		                  var x = data2['time'+dd.substring(4+ii, 8+ii)][z],
		                       y = data['ele'+dd.substring(4+ii, 8+ii)][z];
		                    z++;
		                    series.addPoint([x, y], true, true);
		                    activeLastPointToolip(chart);
		                }, 1000);
		            }
		        }
		    },
		    title: {
		        text: mach
		    },
		    xAxis: {
		        type: 'datetime',
		        tickPixelInterval: 150,
		        lineColor:'#FFFFFF',
		        tickWidth:0,
  		    labels:{
  		    	enabled:false
  		    }
		    },
		    yAxis: [{
            max:280, // 定义Y轴 最大值  
            min:0, // 定义最小值  
            minPadding: 0.2,   
            maxPadding: 0.2,  
            tickInterval:40,
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
		            // generate an array of random data
		            var data = [],
		                time = (new Date()).getTime(),
		                /*time = new Date(Date.parse("0000-00-00 00:00:00")),*/
		                i;
		            for (i = -9; i <= 0; i += 1) {
		                data.push({
		                    x: data2['time'+dd.substring(4+ii, 8+ii)][0]-1000+i*1000,
		                	/*x: time + i*1000,*/
		                    y: 0
		                });
		            }
		            return data;
		        }())
		    }]
		}, function(c) {
		    activeLastPointToolip(c)
		});

}

function curve1(){
		Highcharts.setOptions({
		    global: {
		        useUTC: false
		    }
		});
		function activeLastPointToolip(chart) {
		    var points = chart.series[0].points;
/*  		    chart.tooltip.refresh(points[points.length -1]);
		    chart.tooltip.refresh(points1[points1.length -1]);*/
		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
		  		value:maxvol, //在值为2的地方 
		  		width:2, //标示线的宽度为2px 
		  		color: 'black', //标示线的颜色 
		  	    dashStyle:'longdashdot',
		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
	          label:{
		            text:'最高电压',     //标签的内容
		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
		            x:10  
		        }
		  	})
		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
		  		value:minvol, //在值为2的地方 
		  		width:2, //标示线的宽度为2px 
		  		color: 'black', //标示线的颜色 
		  	    dashStyle:'longdashdot',
		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
	          label:{
		            text:'最低电压',     //标签的内容
		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
		            x:10                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
		        }
		  	})
		  	  		  	
		}
		$('#div1'+dd.substring(4+ii, 8+ii)+'').highcharts({
		    chart: {
		        type: 'spline',
		        animation: false, // don't animate in old IE
		        marginRight: 70,
		        events: {
		            load: function () {
		                // set up the updating of the chart each second
		                var series = this.series[0],
		                    chart = this;
		                var zz=0
		                	window.setInterval(function () {
		                    /*var x = (new Date()).getTime()+t,*/ // current time
			                  var x = data2['time'+dd.substring(4+ii, 8+ii)][zz],
		                       y = data1['vol'+dd.substring(4+ii, 8+ii)][zz];
		                    zz++;
		                    series.addPoint([x, y], true, true);
		                    activeLastPointToolip(chart);
		                }, 1000);
		            }
		        }
		    },
		    title: {
		        text: false
		    },
		    xAxis: {
		        type: 'datetime',
		        tickPixelInterval: 150
		    },
		    yAxis: [{
            max:105, // 定义Y轴 最大值  
            min:0, // 定义最小值  
            minPadding: 0.2,   
            maxPadding: 0.2,  
            tickInterval:15,
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
		            // generate an array of random data
		            var data = [],
		                time = (new Date()).getTime(),
		                i;
		            for (i = -9; i <= 0; i += 1) {
		                data.push({
		                    x: data2['time'+dd.substring(4+ii, 8+ii)][0]-1000+i*1000,
		                    /*x: time + i*1000,*/
		                    y: 0
		                });
		            }
		            return data;
		        }()),
		      
		    }]
		}, function(c) {
		    activeLastPointToolip(c)
		});
}
