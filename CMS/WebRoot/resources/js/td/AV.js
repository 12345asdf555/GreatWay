/**
 * 
 */
  var va = request.getAttribute("av");

  	$(function() {
		var socket;
		if(typeof(WebSocket) == "undefined") {
			alert("您的浏览器不支持WebSocket");
			return;
		}
		$(function() {
			//实现化WebSocket对象，指定要连接的服务器地址与端口
			socket = new WebSocket("ws://192.168.9.101:5555/SerialPortDemo/ws/张三");
			//打开事件
			socket.onopen = function() {
				alert("Socket 已打开");
				//socket.send("这是来自客户端的消息" + location.href + new Date());
			};
			//获得消息事件
			socket.onmessage = function(msg) {
				/*alert(msg.data);*/
				dd = msg.data;
/*				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "td/AllTda?data="+msg.data,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
				})*/
				$.ajax({    
				       type: "POST",    
				       dataType: "JSON",    
				       url: "td/getAllTd?data="+msg.data,  //改成你的Action  
				           success : function(result){   
				        	   if(result)
				        		   {
				        		    var r = result.rows;
					            	var c = eval(r);
				/*	           		var str0="";
					                var str1="";
					                var str2="";
					        		for(var j=0; j<c.length; j++){
					        			str0 += c[j].fequipment_no+",";
					        			str1 += c[j].voltage+",";
					        			str2 += c[j].electricity+",";
					        			};*/
					        		for(var i = 0;i < c.length;i++)
					        			{
					        				if(va.equals(c[i].fequipment_no)){
					        					num1[i] = parseInt(c[i].voltage); 
					        					num2[i] = parseInt(c[i].electricity);
					        			}
					        			}
				        		   }

				   $(document).ready(function () {
				    Highcharts.setOptions({
				        global: {
				            useUTC: false
				        }
				    });
					var chart;
					
				    chart = Highcharts.chart({
				        chart: {
				        	renderTo: 'body1', 
				            type: 'spline',
				            animation: Highcharts.svg, // don't animate in old IE
				            marginRight: 10,
				            events: {
				                load: function () {

				                    // set up the updating of the chart each second
				                    var series = this.series[0];
				                    setInterval(function () {
				                        var x = (new Date()).getTime(), // current time
				                            y = num1;
				                        series.addPoint([x, y], true, true);
				                    }, 1000);
				                }
				            }
				        },
				        title: {
				            text: '电压实时曲线图'
				        },
				        xAxis: {
				            type: 'datetime',
				            tickPixelInterval: 150
				        },
				        yAxis: {
				            title: {
				                text: 'Value'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            formatter: function () {
				                return '<b>' + this.series.name + '</b><br/>' +
				                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
				                    Highcharts.numberFormat(this.y, 2);
				            }
				        },
				        legend: {
				            enabled: false
				        },
				        exporting: {
				            enabled: false
				        },
				        series: [{
				            name: 'Random data',
				            data: (function () {
				                // generate an array of random data
				                var data = [],
				                    time = (new Date()).getTime(),
				                    i;

				                for (i = -19; i <= 0; i += 1) {
				                    data.push({
				                        x: time + i * 1000,
				                        y: num1
				                    });
				                }
				                return data;
				            }())
				        }]
				    });
				});

				    $(document).ready(function () {
				    Highcharts.setOptions({
				        global: {
				            useUTC: false
				        }
				    });
					var chart;
					
				    chart = Highcharts.chart({
				        chart: {
				        	renderTo: 'body2', 
				            type: 'spline',
				            animation: Highcharts.svg, // don't animate in old IE
				            marginRight: 10,
				            events: {
				                load: function () {

				                    // set up the updating of the chart each second
				                    var series = this.series[0];
				                    setInterval(function () {
				                        var x = (new Date()).getTime(), // current time
				                            y = num2;
				                        series.addPoint([x, y], true, true);
				                    }, 1000);
				                }
				            }
				        },
				        title: {
				            text: '电流实时曲线图'
				        },
				        xAxis: {
				            type: 'datetime',
				            tickPixelInterval: 150
				        },
				        yAxis: {
				            title: {
				                text: 'Value'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            formatter: function () {
				                return '<b>' + this.series.name + '</b><br/>' +
				                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
				                    Highcharts.numberFormat(this.y, 2);
				            }
				        },
				        legend: {
				            enabled: false
				        },
				        exporting: {
				            enabled: false
				        },
				        series: [{
				            name: 'Random data',
				            data: (function () {
				                // generate an array of random data
				                var data = [],
				                    time = (new Date()).getTime(),
				                    i;

				                for (i = -19; i <= 0; i += 1) {
				                    data.push({
				                        x: time + i * 1000,
				                        y: num2
				                    });
				                }
				                return data;
				            }())
				        }]
				    });
				});
				    
				           }
				    })
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


/*var va = document.getElementById("Object1").value;
var num1 = [];
var num2 = [];
var data = document.getElementById("Object").value;

$(function(){    
	alert(data);
	alert(va);
    $.ajax({    
       type: "POST",    
       dataType: "JSON",    
       url: "td/getAllTd?data="+data,  //改成你的Action  
           success : function(result){   
        	   if(result)
        		   {
        		    var r = result.rows;
	            	var c = eval(r);
	           		var str0="";
	                var str1="";
	                var str2="";
	        		for(var j=0; j<c.length; j++){
	        			str0 += c[j].fequipment_no+",";
	        			str1 += c[j].voltage+",";
	        			str2 += c[j].electricity+",";
	        			};
	        		for(var i = 0;i < c.length;i++)
	        			{
	        				if(va.equals(c[i].fequipment_no)){
	        					num1[i] = parseInt(c[i].voltage); 
	        					num2[i] = parseInt(c[i].electricity);
	        			}
	        			}
        		   }

   $(document).ready(function () {
    Highcharts.setOptions({
        global: {
            useUTC: false
        }
    });
	var chart;
	
    chart = Highcharts.chart({
        chart: {
        	renderTo: 'body1', 
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            marginRight: 10,
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = num1;
                        series.addPoint([x, y], true, true);
                    }, 1000);
                }
            }
        },
        title: {
            text: '电压实时曲线图'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: 'Value'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                    Highcharts.numberFormat(this.y, 2);
            }
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'Random data',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y: num1
                    });
                }
                return data;
            }())
        }]
    });
});

    $(document).ready(function () {
    Highcharts.setOptions({
        global: {
            useUTC: false
        }
    });
	var chart;
	
    chart = Highcharts.chart({
        chart: {
        	renderTo: 'body2', 
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            marginRight: 10,
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = num2;
                        series.addPoint([x, y], true, true);
                    }, 1000);
                }
            }
        },
        title: {
            text: '电流实时曲线图'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: 'Value'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                    Highcharts.numberFormat(this.y, 2);
            }
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'Random data',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y: num2
                    });
                }
                return data;
            }())
        }]
    });
});
    
           }
    })
})*/
