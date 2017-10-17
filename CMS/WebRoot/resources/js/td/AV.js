/**
 * 
 */
	var num1 = new Array(3);
	var num2 = new Array(3);
	var dd;
	var time1 = new Array(3);
	var maxele;
	var maxvol;
	var minele;
	var minvol;
	$(function(){
		w();
		q();
	})
    function w() {
		var socket;
		if(typeof(WebSocket) == "undefined") {
			alert("您的浏览器不支持WebSocket");
			return;
		}
		$(function() {
			//实现化WebSocket对象，指定要连接的服务器地址与端口
			socket = new WebSocket("ws://192.168.9.101:5554/SerialPortDemo/ws/张三");
			//打开事件
			socket.onopen = function() {
				alert("Socket 已打开");
				//socket.send("这是来自客户端的消息" + location.href + new Date());
			};
			//获得消息事件
			socket.onmessage = function(msg) {
				/*alert(msg.data);*/
				dd = msg.data;
				var va = document.getElementById("hid1").value;
				for(var j = 0;j < 3;j++){
					for(var i = 0;i < dd.length;i+=57){
						if(va = dd.substring(2+i, 4+i)){
						num1[j] = parseInt(dd.substring(16+i, 20+i),16);
						num2[j] = parseInt(dd.substring(20+i, 24+i),16);
						time1[j] = new Date(dd.substring(24+i, 45+i));
						maxele = dd.substring(45+i, 48+i);
						minele = dd.substring(48+i, 51+i);
						maxvol = dd.substring(51+i, 54+i);
						minvol = dd.substring(54+i, 57+i);
						}	
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
	};
  	

  	function q(){
	  	Highcharts.setOptions({
	  	    global: {
	  	        useUTC: false
	  	    }
	  	});
	  	function activeLastPointToolip(chart) {
	  	    var points = chart.series[0].points;
	  	    chart.tooltip.refresh(points[points.length -1]);
	  	}
	  	$('#body1').highcharts({
	  	    chart: {
	  	        type: 'spline',
	  	        animation: Highcharts.svg, // don't animate in old IE
	  	        marginRight: 80,
	  	        events: {
	  	            load: function () {
	  	                // set up the updating of the chart each second
	  	                var series = this.series[0],
	  	                    series1 = this.series[1],
	  	                    chart = this;
	  	                setInterval(function () {
	  	                    var x = (new Date()).getTime(), // current time
	  	                        y = Math.random();
	  	                    series.addPoint([x, y], true, true);
	  	                    series1.addPoint([x, y], true, true);
	  	                    activeLastPointToolip(chart)
	  	                }, 1000);
	  	            }
	  	        }
	  	    },
	  	    title: {
	  	        text: '动态模拟实时数据'
	  	    },
	  	    xAxis: {
	  	        type: 'datetime',
	  	        tickPixelInterval: 150
	  	    },
	  	    yAxis: [{
	  	    	max:maxele,
	  	    	min:minele,
	  	        title: {
	  	            text: '电流'
	  	        },
	  	        plotLines: [{
	  	            value: 0,
	  	            width: 1,
	  	            color: '#808080'
	  	        }],
	  	    },{
	  	    	max:maxvol,
	  	    	min:minvol,
	  	    	title: {
		            text: '电压'
		        },
		        plotLines: [{
		            value: 0,
		            width: 1,
		            color: '#0000CD'
	  	    }],
	  	    opposite: true  
	  	    }],
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
	  	        name: '随机数据1',
	  	        data: (function () {
	  	            // generate an array of random data
	  	            var data = [],
	  	                time = (new Date()).getTime(),
	  	                i,
	  	                e;
/*	  	            for (i = -19; i <= 0; i += 1) {
	  	                data.push({
	  	                    x: time + i * 1000,
	  	                    y: Math.random()
	  	                });
	  	            }*/
	  	            for (e = 0; e < 3; e++) {
	  	                data.push({
	  	                    x: time1[e],
	  	                    y: num1[e]
	  	                });
	  	            }
	  	            return data;
	  	        }())
	  	    },{
	  	        name: '随机数据2',
	  	        data: (function () {
	  	            // generate an array of random data
	  	            var data = [],
	  	                time = (new Date()).getTime(),
	  	                i,
	  	                v;
/*	  	            for (i = -19; i <= 0; i += 1) {
	  	                data.push({
	  	                    x: time + i * 1000,
	  	                    y: Math.random()
	  	                });
	  	            }*/
	  	            for (v = 0; v < 3; v++) {
	  	                data.push({
	  	                    x: time1[v],
	  	                    y: num1[v]
	  	                });
	  	            }
	  	            return data;
	  	        }()),
	  	        yAxis: 1
	  	    }]
	  	}, function(c) {
	  	    activeLastPointToolip(c)
	  	});
		    
  	}
  	
/*  	$(function(){
		   function t() {
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
			                    var series = this.series;
			                    setInterval(function () {
			                        $.ajax({
	                                      type: "POST",
	                                      url: "td/getAllTd?data="+dd,
	                                      async: false,
	                                      success: function(result){
	                  	        		    var r = result.rows;
	                		            	var c = eval(r);
	                		            	var va = document.getElementById("hid1").value;
	                  		        		for(var i = 0;i < c.length;i++){
	            		        				if(va == c[i].fequipment_no){					        					
	            		        					num1[i] = parseInt(c[i].voltage,16);
	            		        					num2[i] = parseInt(c[i].electricity);
		            		        				
	            		        				}
	            		        				var value = num1[i];
	                                            series[i].addPoint([(new Date()).getTime(), value], true, true);
	                                            }

	                                        
	                                      }
	                                }, false);				                       
			                        
			                    }, 1000);
			                }
			            }
			        },
			        title: {
			            text: '电压实时曲线图'
			        },
			        xAxis: {
			            type: 'datetime',
			            tickPixelInterval: 75
			        },
			        yAxis: {
			            title: {
			                text: 'Value'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080',
			                tickPositions: [100, 110, 120, 130,140,150]
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
			        series: create()
			    });
			};  
  	})
  	
  					function create() {
				    var series = new Array();
				    $.ajax({
				      type: "POST",
				      url: "td/getAllTd?data="+dd,
				      async: false, 
				      success: function(result){
	        		    var r = result.rows;
		            	var c = eval(r);
		            	var va = document.getElementById("hid1").value;
		        		for(var i = 0;i < c.length;i++){
		        				if(va == c[i].fequipment_no){					        					
		        					num1[i] = parseInt(c[i].voltage,16);
		        					num2[i] = parseInt(c[i].electricity);
		        					var value = num1[i];
						            var data = function() {
							            var data = [],
							            //  time = result.time,//x轴数据由后台决定。
							              time = (new Date()).getTime(),
							              i;
							            for(i=-9; i<=0; i++) {
							              data.push({
							                x: time + i * 1000,
							                y: value
							              });
							            }
							            return data;
							          }();
							          series.push({"data": data});
		        				}	
				        } 
				      }
				    }, false);  //false表示“遮罩”，前台不显示“请稍后”进度提示
				        return series;
				  }*/


