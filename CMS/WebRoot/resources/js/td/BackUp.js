/**
 * 
 */
var machine = new Array();
var time = new Array();
var ele = new Array();
var vol = new Array();
var work = new Array();
var wait = new Array();
var dglength;
var websocketURL;
var welderName;
var symbol=0;
var symbol1=0;
var sym=0;
var timerele;
var timervol;
var socket;
var redata;
var rowdex=0;
var maxele=0;
var minele=0;
var maxvol=0;
var minvol=0;
var rows;
var sint=0;
var led=["0,1,2,4,5,6","2,5","0,2,3,4,6","0,2,3,5,6","1,2,3,5","0,1,3,5,6","0,1,3,4,5,6","0,2,5","0,1,2,3,4,5,6","0,1,2,3,5,6"];
$(function(){
	var width = $("#treeDiv").width();
	$(".easyui-layout").layout({
		onCollapse:function(){
			$("#dg").datagrid({
				height : $("#body").height(),
				width : $("#body").width()
			})
		},
		onExpand:function(){
			$("#dg").datagrid({
				height : $("#body").height(),
				width : $("#body").width()
			})
		}
	});
	$("#myTree").tree({  
		onClick : function(node){
			$("#dg").datagrid('load',{
				"parent" : node.id
			})
		 }
	})
	$.ajax({  
	      type : "post",  
	      async : false,
	      url : "td/AllTdbf",  
	      data : {},  
	      dataType : "json", //返回数据形式为json  
	      success : function(result) {
	          if (result) {
	        	  websocketURL = eval(result.web_socket);
	          }  
	      },
	      error : function(errorMsg) {  
	          alert("数据请求失败，请联系系统管理员!");  
	      }  
	 });
	$.ajax({  
	      type : "post",  
	      async : false,
	      url : "td/allWeldname",  
	      data : {},  
	      dataType : "json", //返回数据形式为json  
	      success : function(result) {
	          if (result) {
	        	  welderName=eval(result.rows);
	          }  
	      },
	      error : function(errorMsg) {  
	          alert("数据请求失败，请联系系统管理员!");  
	      }  
	 });
    websocket();
})
    function websocket() {
		if(typeof(WebSocket) == "undefined") {
			alert("您的浏览器不支持WebSocket");
			return;
		}
		webclient();
	};
	function webclient(){
		try{
			socket = new WebSocket(websocketURL);
		}catch(err){
			alert("地址请求错误，请清除缓存重新连接！！！")
		}
		setTimeout(function(){
			if(socket.readyState!=1){
				alert("与服务器连接失败,请检查网络设置!");
			}
		},10000);
		socket.onopen = function() {
			datatable();
			//监听加载状态改变  
			document.onreadystatechange = completeLoading();  
			   
			//加载状态为complete时移除loading效果 
			function completeLoading() {
			        var loadingMask = document.getElementById('loadingDiv');  
			        loadingMask.parentNode.removeChild(loadingMask);  
			}
			setTimeout(function(){
				if(symbol==0){
					alert("连接成功，但未接收到任何数据");
				}
			},5000);
		};
		socket.onmessage = function(msg) {
			redata=msg.data;
			
    		for(var i = 0;i < redata.length;i+=69){
    			if(redata.substring(8+i, 12+i)!="0000"){
    				if(redata.substring(0+i,2+i)=="03"||redata.substring(0+i,2+i)=="05"||redata.substring(0+i,2+i)=="07"){
    					if(work.length==0){
    						work.push(redata.substring(4+i, 8+i));
    					}else{
    						for(var j=0;j<work.length;j++){
    							if(work[j]!=redata.substring(4+i, 8+i)){
    								if(j==work.length-1){
    									work.push(redata.substring(4+i, 8+i));
    								}
    							}else{
    								break;
    							}
    						}
    					}
    			  }
    			if(redata.substring(0+i,2+i)=="00"){
    				if(wait.length==0){
    					wait.push(redata.substring(4+i, 8+i));
    				}else{
    					for(var j=0;j<wait.length;j++){
    						if(wait[j]!=redata.substring(4+i, 8+i)){
    							if(j==wait.length-1){
    								wait.push(redata.substring(4+i, 8+i));
    							}
    						}else{
    							break;
    						}
    					}
    				}
    			}
    		};
    		//新增定时器
			
			rows = $('#dg').datagrid("getRows");
    		if(symbol1==0){
    			dglength = rows.length;
    			window.setInterval(function() {
    				work.length=0;
    				wait.length=0;
    			}, 2950)
    		}
    		symbol1=1;
    		}
    		$("#on").textbox("setValue", work.length);
    		$("#wait").textbox("setValue", wait.length);
    		$("#off").textbox("setValue", dglength-wait.length-work.length);
			for(var i = 0;i < redata.length;i+=69){
				if(redata.substring(8+i, 12+i)!="0000"){
					if(machine.length==0){
						machine.push(redata.substring(4+i, 8+i));
					}else{
						for(var n=0;n<rows.length;n++){
						for(var j=0;j<machine.length;j++){
							if(machine[j]!=redata.substring(4+i, 8+i)&&redata.substring(4+i, 8+i)==rows[n].fequipment_no){
								if(j==machine.length-1){
									machine.push(redata.substring(4+i, 8+i));
								}
							}else{
								break;
							}
							}
						}
					}
				}
			};
			iview(machine[0],symbol);
			for(var g = 0;g < redata.length;g+=69*3){
			for(var dex=0;dex<rows.length;dex++){
		    if((redata.substring(8+g, 12+g)!="0000")&&(redata.substring(4+g, 8+g)==rows[dex].fequipment_no)){
			rows[dex].fwelder_no=redata.substring(8+g, 12+g);
			rows[dex].fstatus_id=redata.substring(0+g, 2+g);
			for(var k=0;k<welderName.length;k++){
				if(welderName[k].fwelder_no==redata.substring(8+g, 12+g)){
					rows[dex].fname=welderName[k].fname;
				}
			}
			$('#dg').datagrid('refreshRow', dex);
			$("a[id='view']").linkbutton({text:'查看',plain:true,iconCls:'icon-view'});
		    }
    		}
    	    }
			if((rowdex<machine.length)&&(rows.length!=0)){
			for(var dex1=0;dex1<rows.length;dex1++){
				if(machine[rowdex]==rows[dex1].fequipment_no){    
				        $('#dg').datagrid('insertRow', {  
				            index:0,  
				            row:rows[dex1],  
				        });     
				        $('#dg').datagrid('deleteRow', dex1+1);//删除一行
				}
			}
			rowdex++;
			}
			if(symbol==0){
				window.setInterval(function() {
					sint++;
					if(sint<machine.length){
						iview(machine[sint],0);
					}else{
						sint=0;
					}
				}, 10*60*1000)
			}
		};
		//关闭事件
		socket.onclose = function(e) {
            if (e.code == 4001 || e.code == 4002 || e.code == 4003 || e.code == 4005 || e.code == 4006){
                //如果断开原因为4001 , 4002 , 4003 不进行重连.
                return;
            }else{
                return;
            }
            // 重试3次，每次之间间隔5秒
            if (tryTime < 3) {
                setTimeout(function () {
                    socket = null;
                    tryTime++;
                    var _PageHeight = document.documentElement.clientHeight,  
                    _PageWidth = document.documentElement.clientWidth;   
                    var _LoadingTop = _PageHeight > 61 ? (_PageHeight - 61) / 2 : 0,  
                    	_LoadingLeft = _PageWidth > 215 ? (_PageWidth - 215) / 2 : 0;  
                    var _LoadingHtml = '<div id="loadingDiv" style="position:absolute;left:0;width:100%;height:' + _PageHeight + 'px;top:0;background:#f3f8ff;opacity:0.8;filter:alpha(opacity=80);z-index:10000;"><div style="position: absolute; cursor1: wait; left: ' + _LoadingLeft + 'px; top:' + _LoadingTop + 'px; width: auto; height: 57px; line-height: 57px; padding-left: 50px; padding-right: 5px; background: #fff url(resources/images/load.gif) no-repeat scroll 5px 10px; border: 2px solid #95B8E7; color: #696969;">""正在尝试第"'+tryTime+'"次重连，请稍候..."</div></div>';  
                	document.write(_LoadingHtml);
                    ws();
                }, 5000);
            } else {
                tryTime = 0;
            }
        };
		//发生了错误事件
		socket.onerror = function() {
			aler("发生异常，正在尝试重新连接服务器！！！");
		}
	}
	
	function datatable(){
	    $("#dg").datagrid( {
			fitColumns : true,
			height : ($("#body4").height()),
			width : $("#body4").width(),
			idField : 'id',
/*			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],*/
			url : 'td/getAllPosition',
			singleSelect : false,
			rownumbers : true,
			pagination : false,
			showPageList : false,
			columns : [ [ {
				field : 'fid',
				title : '焊机id',
				width : 100,
				halign : "center",
				align : "left",
				hidden : true
			}, {
				field : 'fequipment_no',
				title : '焊机编号',
				width : 100,
				halign : "center",
				align : "left"
			}, {
				field : 'fwelder_no',
				title : '焊工编号',
				width : 100,
				halign : "center",
				align : "left"
			}, {
				field : 'fname',
				title : '焊工姓名',
				width : 100,
				halign : "center",
				align : "left"
			}, {
				field : 'fposition',
				title : '设备位置',
				width : 100,
				halign : "center",
				align : "left"
			},{
				field : 'fci',
				title : '组织机构id',
				width : 100,
				halign : "center",
				align : "left",
				hidden : true
			},{
				field : 'fcn',
				title : '组织机构名称',
				width : 100,
				halign : "center",
				align : "left",
				hidden : true
			},{
				field : 'fstatus_id',
				title : '设备状态',
				width : 100,
				halign : "center",
				align : "left",
				hidden : true
			},{
				field : 'view',
				title : '实时监测',
				width : 130,
				halign : "center",
				align : "left",
				formatter:function(value,row,index){
				var str = "";
				str += '<a id="view" class="easyui-linkbutton" href="javascript:iview('+row.fequipment_no+',0)"/>';
				return str;
				}
			}]],
			toolbar : '#toolbar',
			onLoadSuccess:function(data){
		        $("a[id='view']").linkbutton({text:'查看',plain:true,iconCls:'icon-view'});
		        },
	        rowStyler:function(index,row){
	            if ((row.fstatus_id=="03")||(row.fstatus_id=="05")||(row.fstatus_id=="07")){
	                return 'background-color:#00FF00;color:black;';
	            }
/*	            else if (row.fstatus_id=="07"){
	                return 'background-color:#FF0000;color:black;';
	            }*/
	            else if (row.fstatus_id=="00"){
	                return 'background-color:#0000CD;color:black;';
	            }
	            else{
	                return 'background-color:#A9A9A9;color:black;';
	            }
	        }
		});
	};
	
	function elecurve(){
  		Highcharts.setOptions({
  		    global: {
  		        useUTC: false
  		    }
  		});
  		function activeLastPointToolip(chart) {
  		    var points = chart.series[0].points;
  		    chart.yAxis[0].removePlotLine('plot-line-1');
  		    chart.yAxis[0].removePlotLine('plot-line-2');
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
  		  	});
  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
  		  		value:minele, //在值为2的地方 
  		  		width:2, //标示线的宽度为2px 
  		  		color: 'red', //标示线的颜色 
  		  	    dashStyle:'longdashdot',
  		  		id: 'plot-line-2', //标示线的id，在删除该标示线的时候需要该id标示 });
		          label:{
    		            text:'最低电流',     //标签的内容
    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
    		            x:10                     //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
    		        }
  		  	})	  	
  		}
 
  		$('#body31').highcharts({
  		    chart: {
  		        type: 'spline',
  		        animation: false, // don't animate in old IE
  		        marginRight: 70,
  		        events: {
  		            load: function () {
  		                // set up the updating of the chart each second
  		                var series = this.series[0],
  		                    chart = this,
  		                    z=0;
  		                	timerele = window.setInterval(function () {
  		                    /*var x = (new Date()).getTime()+t,*/ // current time
  		                		if(time.length!=0){
		  		                    var x = time[z],
		  		                        y = ele[z];
		  		                    z++;
		  		                    series.addPoint([x, y], true, true);
		  		                    activeLastPointToolip(chart);
  		                		}
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
  		        }
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
  		                /*time = new Date(Date.parse("0000-00-00 00:00:00")),*/
  		                i;
  		            for (i = -19; i <= 0; i += 1) {
  		                data.push({
  		                    x: time[0]-1000+i*1000,
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
	
	function volcurve(){
  		Highcharts.setOptions({
  		    global: {
  		        useUTC: false
  		    }
  		});
  		function activeLastPointToolip(chart) {
  		    var points = chart.series[0].points;
  		    chart.yAxis[0].removePlotLine('plot-line-3');
  		    chart.yAxis[0].removePlotLine('plot-line-4');
/*  		    chart.tooltip.refresh(points[points.length -1]);
  		    chart.tooltip.refresh(points1[points1.length -1]);*/
  		  	chart.yAxis[0].addPlotLine({ //在y轴上增加 
  		  		value:maxvol, //在值为2的地方 
  		  		width:2, //标示线的宽度为2px 
  		  		color: 'black', //标示线的颜色 
  		  	    dashStyle:'longdashdot',
  		  		id: 'plot-line-3', //标示线的id，在删除该标示线的时候需要该id标示 });
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
  		  		id: 'plot-line-4', //标示线的id，在删除该标示线的时候需要该id标示 });
		          label:{
    		            text:'最低电压',     //标签的内容
    		            align:'center',                //标签的水平位置，水平居左,默认是水平居中center
    		            x:10                         //标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
    		        }
  		  	})
  		  	  		  	
  		}
 
  		$('#body32').highcharts({
  		    chart: {
  		        type: 'spline',
  		        animation: false, // don't animate in old IE
  		        marginRight: 70,
  		        events: {
  		            load: function () {
  		                // set up the updating of the chart each second
  		                var series = this.series[0],
  		                    chart = this,
		                    z=0;
		                	timervol = window.setInterval(function () {
		                    /*var x = (new Date()).getTime()+t,*/ // current time
		                		if(time.length!=0){
	  		                    var x = time[z],
	  		                        y = vol[z];
	  		                    z++;
	  		                    series.addPoint([x, y], true, true);
	  		                    activeLastPointToolip(chart);
		                		}
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
  		            // generate an array of random data
  		            var data = [],
		                /*time = new Date(Date.parse("0000-00-00 00:00:00")),*/
		                i;
		            for (i = -19; i <= 0; i += 1) {
		                data.push({
		                    x: time[0]-1000+i*1000,
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
	
	function modiflyNum(id,value)
	{	
		var elm=document.getElementById('time'+id.toString()).getElementsByTagName('li');
		var str=led[value];
		var cc=str.split(',');
		for(var i=0;i<7;i++)
		{
			elm[i].getElementsByTagName('img')[0].src="resources/images/back.png";
		}
		for(var i=0;i<cc.length;i++)
		{
			elm[parseInt(cc[i])].getElementsByTagName('img')[0].src="resources/images/purple.png";
		}
	}
	function modiflyNum1(id,value)
	{	
		var elm=document.getElementById('time'+id.toString()).getElementsByTagName('li');
		var str=led[value];
		var cc=str.split(',');
		for(var i=0;i<7;i++)
		{
			elm[i].getElementsByTagName('img')[0].src="resources/images/back.png";
		}
		for(var i=0;i<cc.length;i++)
		{
			elm[parseInt(cc[i])].getElementsByTagName('img')[0].src="resources/images/blue.png";
		}
	}
	function iview(value,value1){
		if(value1==0){
		window.clearInterval(timerele);
		window.clearInterval(timervol);
		$('#body31').html("");
		$('#body32').html("");
		vol.length=0;
		ele.length=0;
		time.length=0;
		}
		for(var i = 0;i < redata.length;i+=69){
			if(redata.substring(8+i, 12+i)!="0000"){
				if(parseInt(redata.substring(4+i, 8+i),16)==value){
					ele.push(parseInt(redata.substring(12+i, 16+i),16));
					vol.push(parseFloat((parseInt(redata.substring(16+i, 20+i),16)/10).toFixed(2)));
					time.push(Date.parse(redata.substring(20+i, 39+i)));
					maxele = parseInt(redata.substring(41+i, 44+i));
					minele = parseInt(redata.substring(44+i, 47+i));
					maxvol = parseInt(redata.substring(47+i, 50+i));
					minvol = parseInt(redata.substring(50+i, 53+i));
					var backele=parseInt(redata.substring(12+i, 16+i),16).toString();
					if(backele.length<4){
						var elelen=backele.length;
						for(var na=0;na<4-elelen;na++){
							backele="0"+backele;
						}
					}
					var backvol=parseInt(redata.substring(16+i, 20+i),16).toString();
					if(backvol.length<4){
						var vollen=backvol.length;
						for(var nan=0;nan<4-vollen;nan++){
							backvol="0"+backvol;
						}
					}
					modiflyNum(1,parseInt(backele.charAt(0)));
					modiflyNum(2,parseInt(backele.charAt(1)));
					modiflyNum(3,parseInt(backele.charAt(2)));
					modiflyNum(4,parseInt(backele.charAt(3)));
					modiflyNum1(5,parseInt(backvol.charAt(0)));
					modiflyNum1(6,parseInt(backvol.charAt(1)));
					modiflyNum1(7,parseInt(backvol.charAt(2)));
					modiflyNum1(8,parseInt(backvol.charAt(3)));
					document.getElementById("macname").value=value;
					for(var k=0;k<welderName.length;k++){
						if(welderName[k].fwelder_no==redata.substring(8+i, 12+i)){
							document.getElementById("welname").value=welderName[k].fname;
						}
					}
					for(var n=0;n<rows.length;n++){
						if(rows[n].fci==parseInt(redata.substring(2+i, 4+i))){
							$("#zu").textbox("setValue", rows[n].fcn);
							break;
						}
					}
				}
			}
		};
		if((time.length)%3==1){
			ele[time.length] = ele[time.length-1];
			ele[time.length+1] = ele[time.length-1];
			vol[time.length] = vol[time.length-1];
			vol[time.length+1] = vol[time.length-1];
			time[time.length] = time[time.length-1]+1000;
			time[time.length+1] = time[time.length-1]+2000;
		}
		if(time.length%3==2){
			ele[time.length] = ele[time.length-1];
			vol[time.length] = vol[time.length-1];
			time[time.length] = time[time.length-1]+1000;
		}
		if(value1==0){
			elecurve();
			volcurve();
			symbol++;
		}
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
  	