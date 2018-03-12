/**
 * 
 */
var z=0;
var jj=0;
var zz=0;
var time1 = new Array();
var vol = new Array();
var ele = new Array();
		$(function(){
			weldingMachineDatagrid();
		})
		
		var chartStr = "";
		function setParam(){
			var parent = $("#parent").val();
			var otype = $("input[name='otype']:checked").val();
			var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
			var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
			chartStr = "?otype="+otype+"&parent="+parent+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
		}
		function serachCompanyOverproof(){
			chartStr = "";
			var rows = $("#dg").datagrid("getSelections");
			if(rows.length==0){
				alert("请先选择焊机");
			}else{
				setParam();
				var fid = $('#dg').datagrid('getSelected').id;
				   $.ajax({
					   type: "post", 
					   url: "rep/historyCurve"+chartStr+"&fid="+fid,
					   dataType: "json",
					   data: {},
					   success: function (result) {
					      if (result) {
					    	  var date = eval(result.rows);
					    	  for(var i=0;i<date.length;i++){
					    		  ele[i] = date[i].ele;
					    		  vol[i] = date[i].vol;
					    		  time1[i] = Date.parse(date[i].time);
					    	  }

								curve();
								curve1();
					      }
					   },
					   error: function () {
					      alert('error');
					   }
					});
			}
		}
		
		function weldingMachineDatagrid(){
			$("#dg").datagrid( {
				height : $("#dgtb").height(),
				width : $("#dgtb").width(),
				idField : 'id',
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				url : "weldingMachine/getWedlingMachineList",
				singleSelect : true,
				rownumbers : true,
				showPageList : false, 
		        columns : [ [ {
				    field:'ck',
					checkbox:true
				},{
					field : 'id',
					title : '序号',
					width : 50,
					halign : "center",
					align : "left",
					hidden:true
				}, {
					field : 'equipmentNo',
					title : '固定资产编号',
					width : 80,
					halign : "center",
					align : "left"
				}, {
					field : 'typeName',
					title : '设备类型',
					width : 80,
					halign : "center",
					align : "left"
				}, {
					field : 'jointime',
					title : '入厂时间',
					width : 150,
					halign : "center",
					align : "left"
				}, {
					field : 'insframeworkName',
					title : '所属项目',
					width : 80,
					halign : "center",
					align : "left"
				}, {
					field : 'statusName',
					title : '状态',
					width : 80,
					halign : "center",
					align : "left"
				} , {
					field : 'manufacturerName',
					title : '厂家',
					width : 150,
					halign : "center",
					align : "left"
				}, {
					field : 'isnetworking',
					title : '是否在网',
					width : 80,
					halign : "center",
					align : "left"
				}, {
					field : 'gatherId',
					title : '采集序号',
					width : 100,
					halign : "center",
					align : "left"
				}, {
					field : 'position',
					title : '位置',
					width : 100,
					halign : "center",
					align : "left"
				}, {
					field : 'ip',
					title : 'ip地址',
					width : 100,
					halign : "center",
					align : "left"
				}, {
					field : 'model',
					title : '设备型号',
					width : 100,
					halign : "center",
					align : "left"
				}, {
					field : 'material',
					title : '焊件材质',
					width : 100,
					halign : "center",
					align : "left"
				},{
					field : 'thickness',
					title : '焊件厚度',
					width : 100,
					halign : "center",
					align : "left"
				},{
					field : 'coefficient',
					title : '校正系数',
					width : 100,
					halign : "center",
					align : "left"
				},{
					field : 'address',
					title : '地址',
					width : 100,
					halign : "center",
					align : "left"
				},{
					field : 'statusId',
					title : '状态id',
					width : 100,
					halign : "center",
					align : "left",
					hidden: true
				}, {
					field : 'isnetworkingId',
					title : '是否联网id',
					width : 100,
					halign : "center",
					align : "left",
					hidden: true
				}, {
					field : 'manufacturerId',
					title : '厂商id',
					width : 100,
					halign : "center",
					align : "left",
					hidden: true
				}, {
					field : 'typeId',
					title : '类型id',
					width : 100,
					halign : "center",
					align : "left",
					hidden: true
				}, {
					field : 'insframeworkId',
					title : '项目id',
					width : 100,
					halign : "center",
					align : "left",
					hidden: true
				}/*, {
					field : 'edit',
					title : '编辑',
					width : 250,
					halign : "center",
					align : "left",
					formatter:function(value,row,index){
						var str = "";
						str += '<a id="maintain" class="easyui-linkbutton" href="javascript:serachCompanyOverproof()"/>';
						return str;
					}
				}*/] ],
				toolbar : '#weldingmachineTable_btn',
				pagination : true,
				fitColumns : true/*,
				onLoadSuccess:function(data){
			        $("a[id='maintain']").linkbutton({text:'历史曲线查看',plain:true,iconCls:'icon-search'});
				}*/
			});
		}
		
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
//  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
//  		  		value:maxele, //在值为2的地方 
//  		  		width:2, //标示线的宽度为2px 
//  		  		color: 'red', //标示线的颜色 
//  		  	    dashStyle:'longdashdot',
//  		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
//		          label:{
//    		            text:'最高电流',     //标签的内容
//    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
//    		            x:10                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
//    		        }
//  		  	})
//  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
//  		  		value:minele, //在值为2的地方 
//  		  		width:2, //标示线的宽度为2px 
//  		  		color: 'red', //标示线的颜色 
//  		  	    dashStyle:'longdashdot',
//  		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
//		          label:{
//    		            text:'最低电流',     //标签的内容
//    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
//    		            x:10                     //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
//    		        }
//  		  	})	  	
  		}
 
  		$('#body1').highcharts({
  		    chart: {
  		        type: 'spline',
  		        animation: false, // don't animate in old IE
  		        marginRight: 70,
  		        events: {
  		            load: function () {
  		                // set up the updating of the chart each second
  		                var series = this.series[0],
  		                    chart = this;
  		                	window.setInterval(function () {
  		                    /*var x = (new Date()).getTime()+t,*/ // current time
  		                  var x = time1[z],
  		                        y = ele[z];
  		                    z++;
  		                    series.addPoint([x, y], true, true);
  		                    activeLastPointToolip(chart);
  		                }, 1000);
  		            }
  		        }
  		    },
  		    title: {
  		        text: '电压电流实时监测'
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
                max:800, // 定义Y轴 最大值  
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
  		            for (i = -19; i <= 0; i += 1) {
  		                data.push({
  		                    x: time1[0]-1000+i*1000,
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
//  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
//  		  		value:maxvol, //在值为2的地方 
//  		  		width:2, //标示线的宽度为2px 
//  		  		color: 'black', //标示线的颜色 
//  		  	    dashStyle:'longdashdot',
//  		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
//		          label:{
//    		            text:'最高电压',     //标签的内容
//    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
//    		            x:10  
//    		        }
//  		  	})
//  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
//  		  		value:minvol, //在值为2的地方 
//  		  		width:2, //标示线的宽度为2px 
//  		  		color: 'black', //标示线的颜色 
//  		  	    dashStyle:'longdashdot',
//  		  		id: 'plot-line-1', //标示线的id，在删除该标示线的时候需要该id标示 });
//		          label:{
//    		            text:'最低电压',     //标签的内容
//    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
//    		            x:10                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
//    		        }
//  		  	})
  		  	  		  	
  		}
 
  		$('#body2').highcharts({
  		    chart: {
  		        type: 'spline',
  		        animation: false, // don't animate in old IE
  		        marginRight: 70,
  		        events: {
  		            load: function () {
  		                // set up the updating of the chart each second
  		                var series = this.series[0],
  		                    chart = this;
  		                	timer5=window.setInterval(function () {
  		                    /*var x = (new Date()).getTime()+t,*/ // current time
  		                  var x = time1[zz],
  		                        y = vol[zz];
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
  		            for (i = -19; i <= 0; i += 1) {
  		                data.push({
  		                    x: time1[0]-1000+i*1000,
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
	
    //监听窗口大小变化
    window.onresize = function() {
    	setTimeout(domresize, 500);
    }

    //改变表格高宽
    function domresize() {
    	$("#dg").datagrid('resize', {
    		height : $("#body").height(),
    		width : $("#body").width()
    	});
    }