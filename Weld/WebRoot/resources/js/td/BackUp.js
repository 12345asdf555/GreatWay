/**
 * 
 */
	var ele = new Array();
	var vol = new Array();
	var weld = new Array();
	var param = new Array();
	var back = new Array();
	var led=["0,1,2,4,5,6","2,5","0,2,3,4,6","0,2,3,5,6","1,2,3,5","0,1,3,5,6","0,1,3,4,5,6","0,2,5","0,1,2,3,4,5,6","0,1,2,3,5,6"];
	var timer,timer1,timer2;
	var vaa1;
	var e=0;
	var stri;
	var gg="";
	var va;
	var po;
	var bhq;
    var h=0;
	var hq;
	var bh;
	var bq=0;
    var status;
	var mach;
	var weld;
	var name;
	var status = new Array();
	var pos;
	var position;
	var z=0;
	var jj=0;
	var dd;
	var bb=0;
	var tt=0;
	var time1 = new Array();
	var maxele;
	var maxvol;
	var minele;
	var minvol;
	var socket;
	var data1;
	$(function(){
		$.ajax({  
		      type : "post",  
		      async : false,
		      url : "td/AllTdbf",  
		      data : {},  
		      dataType : "json", //返回数据形式为json  
		      success : function(result) {
		          if (result) {
		        	  data1 = eval(result.web_socket);
		          }  
		      },
		      error : function(errorMsg) {  
		          alert("数据请求失败，请联系系统管理员!");  
		      }  
		 });
		$.ajax({  
		      type : "post",  
		      async : false,
		      url : "td/getAllPosition",  
		      data : {},  
		      dataType : "json", //返回数据形式为json  
		      success : function(result) {
		    	  if (result) {
		    		  position = eval(result.rows);
		          }  
		      },
		      error : function(errorMsg) {  
		          alert("数据请求失败，请联系系统管理员!");  
		      }  
		 });
		w();
	})
    function w() {
		if(typeof(WebSocket) == "undefined") {
			alert("您的浏览器不支持WebSocket");
			return;
		}
		$(function() {
			//实现化WebSocket对象，指定要连接的服务器地址与端口
			socket = new WebSocket(data1);
			//打开事件
			socket.onopen = function() {
//				alert("Socket 已打开");
				//socket.send("这是来自客户端的消息" + location.href + new Date());
			};
			//获得消息事件
			socket.onmessage = function(msg) {
				/*alert(msg.data);*/
				dd = msg.data;		
				/*alert(dd);*/
				
				for(var b=0;b<position.length;b++){
		    		  if($("#pposition"+b+"").length<=0){
		    			  var str = "<a id='pposition"+b+"' href='javascript:void(0);' onclick='rece1(\""+position[b].fpositin+"\")'><i class='iconfont icon-bijiben'></i>"+position[b].fpositin+"</a></br>";
		    			  $("#body11").append(str);
		    		  }
	    		 }

				for(var n = 0;n < dd.length;n+=53){
					if(dd.substring(8+n, 12+n)!="0000"){		
						if(back.length==0){
							var l=1;
							var ll=0;
							for(var a=0;a<l;a++){
								if(dd.substring(4+n, 8+n)!=back[a]){
									back.push(dd.substring(4+n, 8+n));		
								}else{
									continue;
								}
							}
						}else{
						l=back.length;
						var ll=0;
						for(var a=0;a<l;a++){
							/*alert(dd.substring(4+n, 8+n));*/
							if(dd.substring(4+n, 8+n)!=back[a]){
								ll++;	
								if(ll==back.length){
								back.push(dd.substring(4+n, 8+n));
								}		
							}else{
								continue;
							}
						}
						}
					}};
			
				if(bb==0){
				rece();
				}
				else if(bb==1){
					rece1(0);
				}
				else{
					rece2(0);
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
	function rece1(value2){
		bb=1;
		h=0;
		if(value2!=0){
			a=0;
			jj=0;
			z=0;
			ele=[];
			vol=[];
			time1=[];
			bhq = value2;
			$("#body3").empty();
			window.clearInterval(timer);
			datatable();
		}
/*		if(a==0){
			var vaa;
			for(var n = 0;n < dd.length;n+=53){
		        $.ajax({  
		            type : "post",  
		            async : false,
		            url : "td/getPosition?equip="+dd.substring(4+n, 8+n),  
		            data : {},  
		            dataType : "json", //返回数据形式为json  
		            success : function(result) {
		            	var fposition = eval(result.rows);
		            		vaa = fposition[0].fpositin;
		            }})
				if((dd.substring(8+n, 12+n)!="0000")&&(vaa==bhq)){
					stri = dd.substring(4+n,8+n);
				}
				else{
					var r=0;
					if(vaa==bhq&&r==0){
						stri = dd.substring(4+n,8+n);
						r++;
					}
				}};
		a++;
		}*/
		for(var j = 0;j < 1;j++){
			for(var i = 0;i < dd.length;i+=53){
		        $.ajax({  
		            type : "post",  
		            async : false,
		            url : "td/getPosition?equip="+dd.substring(4+i, 8+i),  
		            data : {},  
		            dataType : "json", //返回数据形式为json  
		            success : function(result) {
		            	var fposition = eval(result.rows);
		            		va = fposition[0].fpositin;
		            }})
				if((va==bhq)){
				po=va;
			    if(h<3){
				    status = parseInt(dd.substring(0+i, 2+i),16);
					mach = parseInt(dd.substring(4+i, 8+i),16);
					weld = dd.substring(8+i, 12+i);
					maxele = parseInt(dd.substring(41+i, 44+i));
					minele = parseInt(dd.substring(44+i, 47+i));
					maxvol = parseInt(dd.substring(47+i, 50+i));
					minvol = parseInt(dd.substring(50+i, 53+i));
					var xx = dd.substring(12+i, 16+i);
					ele[jj] = parseInt(xx,16);
					vol[jj] = parseInt(dd.substring(16+i, 20+i),16);
					var dati = dd.substring(20+i, 39+i);
					var val = Date.parse(dati);
					time1[jj] = val;
					var ele1=parseInt(dd.substring(12+i, 16+i),16);
					var ele2=ele1.toString();
					if(ele2.length<4){
						var len=ele2.length;
						for(var na=0;na<4-len;na++){
							ele2="0"+ele2;
						}
					}
					var vol1=parseInt(dd.substring(16+i, 20+i),16);
					var vol2=vol1.toString();
					if(vol2.length<4){
						var len1=vol2.length;
						for(var nan=0;nan<4-len1;nan++){
							vol2="0"+vol2;
						}
					}
					modiflyNum(1,parseInt(ele2.charAt(0)));
					modiflyNum(2,parseInt(ele2.charAt(1)));
					modiflyNum(3,parseInt(ele2.charAt(2)));
					modiflyNum(4,parseInt(ele2.charAt(3)));
					modiflyNum1(5,parseInt(vol2.charAt(0)));
					modiflyNum1(6,parseInt(vol2.charAt(1)));
					modiflyNum1(7,parseInt(vol2.charAt(2)));
					modiflyNum1(8,parseInt(vol2.charAt(3)));
/*					document.getElementById("electricity1").value=ele[jj];
					document.getElementById("voltage1").value=vol[jj];*/
					h++;
					jj++;
					if(jj==1){
						curve();
						/*datatable();*/
					}
			    }
				}	
			}
			if(jj%3==1){
				ele[jj] = ele[jj-1];
				ele[jj+1] = ele[jj-1];
				vol[jj] = vol[jj-1];
				vol[jj+1] = vol[jj-1];
				time1[jj] = time1[jj-1]+1000;
				time1[jj+1] = time1[jj-1]+2000;
				jj=jj+2;
			}
			if(jj%3==2){
				ele[jj] = ele[jj-1];
				vol[jj] = vol[jj-1];
				time1[jj] = time1[jj-1]+1000;
				jj++;
			}
			}
		var columns = $('#dg').datagrid("options").columns;
		var rows = $('#dg').datagrid("getRows"); 
		for(var dex=0;dex<rows.length;dex++){
			/*alert(rows[dex][columns[0][0].field]);*/
			for(var g = 0;g < dd.length;g+=53){
		    if((dd.substring(8+g, 12+g)!="0000")&&(dd.substring(4+g, 8+g)==rows[dex][columns[0][0].field])){
			rows[dex][columns[0][1].field]=dd.substring(8+g, 12+g);
			$('#dg').datagrid('refreshRow', dex);
			$("a[id='view']").linkbutton({text:'查看',plain:true,iconCls:'icon-view'});
		    }
		}
	    }
	}
	function rece2(value1){
		bb=2;
		if(value1!=0){
			hq=value1;
			jj=0;
			z=0;
			ele=[];
			vol=[];
			time1=[];
			$("#body3").empty();
			window.clearInterval(timer);
/*            $.ajax({  
            type : "post",  
            async : false,
            url : "td/getPosition?equip="+hq,  
            data : {},  
            dataType : "json", //返回数据形式为json  
            success : function(result) {
            	var ffposition = eval(result.rows);
            		vaa1 = ffposition[0].fpositin;
            }})*/
		}
		for(var j = 0;j < 1;j++){
			for(var i = 0;i < dd.length;i+=53){
					if(hq == parseInt(dd.substring(4+i, 8+i),16)&&dd.substring(8+i, 12+i)!="0000"){
					var mach = parseInt(dd.substring(4+i, 8+i),16);
					var weld = dd.substring(8+i, 12+i);
					var xx = dd.substring(12+i, 16+i);
					ele[jj] = parseInt(xx,16);
					vol[jj] = parseInt(dd.substring(16+i, 20+i),16);
					var dati = dd.substring(20+i, 39+i);
					var val = Date.parse(dati);
					time1[jj] = val;
					maxele = parseInt(dd.substring(41+i, 44+i));
					minele = parseInt(dd.substring(44+i, 47+i));
					maxvol = parseInt(dd.substring(47+i, 50+i));
					minvol = parseInt(dd.substring(50+i, 53+i));
					var ele1=parseInt(dd.substring(12+i, 16+i),16);
					var ele2=ele1.toString();
					if(ele2.length<4){
						var len=ele2.length;
						for(var na=0;na<4-len;na++){
							ele2="0"+ele2;
						}
					}
					var vol1=parseInt(dd.substring(16+i, 20+i),16);
					var vol2=vol1.toString();
					if(vol2.length<4){
						var len1=vol2.length;
						for(var nan=0;nan<4-len1;nan++){
							vol2="0"+vol2;
						}
					}
					modiflyNum(1,parseInt(ele2.charAt(0)));
					modiflyNum(2,parseInt(ele2.charAt(1)));
					modiflyNum(3,parseInt(ele2.charAt(2)));
					modiflyNum(4,parseInt(ele2.charAt(3)));
					modiflyNum1(5,parseInt(vol2.charAt(0)));
					modiflyNum1(6,parseInt(vol2.charAt(1)));
					modiflyNum1(7,parseInt(vol2.charAt(2)));
					modiflyNum1(8,parseInt(vol2.charAt(3)));
/*					document.getElementById("electricity1").value=ele[jj];
					document.getElementById("voltage1").value=vol[jj];*/
					jj++;
					if(jj<=1){
						curve(); 
					}
					}	
			}
			if(jj%3==1){
				ele[jj] = ele[jj-1];
				ele[jj+1] = ele[jj-1];
				vol[jj] = vol[jj-1];
				vol[jj+1] = vol[jj-1];
				time1[jj] = time1[jj-1]+1000;
				time1[jj+1] = time1[jj-1]+2000;
				jj=jj+2;
			}
			if(jj%3==2){
				ele[jj] = ele[jj-1];
				vol[jj] = vol[jj-1];
				time1[jj] = time1[jj-1]+1000;
				jj++;
			}
			}
	}
	function rece(){
		/*online(position[0].fpositin);*/
    	for(var i = 0;i < dd.length;i+=53){
   		 $.ajax({  
		            type : "post",  
		            async : false,
		            url : "td/getPosition?equip="+dd.substring(4+i, 8+i),  
		            data : {},  
		            dataType : "json", //返回数据形式为json  
		            success : function(result) {
		            	var fposition = eval(result.rows);
		            		va = fposition[0].fpositin;
		            }})
		            if(va==position[0].fpositin){
		            po=va;
		            }
    	}
		datatable();
		rece2(back[0]);
		var t=1;
		timer1=window.setInterval(function(){
    		if(t<back.length){
    		rece2(back[t]);
    		t++;
    		}else{
    			t=0;
    			/*rece2(back[t]);*/
    		}
    	}, 300000);
    	timer2=window.setInterval(function (){
    		var columns = $('#dg').datagrid("options").columns;
    		var rows = $('#dg').datagrid("getRows"); 
    		for(var dex=0;dex<rows.length;dex++){
    			/*alert(rows[dex][columns[0][0].field]);*/
    			for(var g = 0;g < dd.length;g+=53){
    		    if((dd.substring(8+g, 12+g)!="0000")&&(dd.substring(4+g, 8+g)==rows[dex][columns[0][0].field])){
    			rows[dex][columns[0][1].field]=dd.substring(8+g, 12+g);
    			$('#dg').datagrid('refreshRow', dex);
    			$("a[id='view']").linkbutton({text:'查看',plain:true,iconCls:'icon-view'});
    		    }
    		}
    	    }
    	},1000);
	}
	
	function datatable(){
	    $("#dg").datagrid( {
			fitColumns : true,
			height : ($("#body4").height()),
			width : $("#body4").width(),
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			url : 'td/isnull?dd='+dd+'&posit='+po,
			singleSelect : false,
			rownumbers : true,
			pagination : true,
			showPageList : false,
			columns : [ [ {
				field : 'fequipment_no',
				title : '采集模块编号',
				width : 100,
				halign : "center",
				align : "left"
/*				formatter:function(value,row,index){
						return mach;
				}*/
			}, {
				field : 'fwelder_no',
				title : '焊工编号',
				width : 100,
				halign : "center",
				align : "left"
/*				formatter:function(value,row,index){
	                	setInterval(function () {
	            			for(var n = 0;n < stri.length;n+=53){
	            				if((stri.substring(4+n, 8+n)==row.fequipment_no)&&stri.substring(8+n, 12+n)!="0000"){
	            					var no=stri.substring(8+n, 12+n);
	            					return no;
	            				}else{
	            					return "";
	            				}}
  		                }, 3000);
				}*/
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
				str += '<a id="view" class="easyui-linkbutton" href="javascript:rece2('+row.fequipment_no+')"/>';
				return str;
				}
			}]],
			toolbar : '#toolbar',
			onLoadSuccess:function(data){
		        $("a[id='view']").linkbutton({text:'查看',plain:true,iconCls:'icon-view'});
		        },
	        rowStyler:function(index,row){
	            if ((row.fstatus_id=="03")||(row.fstatus_id=="05")){
	                return 'background-color:#00FF00;color:black;';
	            }
	            if (row.fstatus_id=="07"){
	                return 'background-color:#FF0000;color:black;';
	            }
	            if (row.fstatus_id=="00"){
	                return 'background-color:#0000CD;color:black;';
	            }
	            if (row.fstatus_id=="09"){
	                return 'background-color:#A9A9A9;color:black;';
	            }
	        }
		});
	};
	
	function curve(){
  		Highcharts.setOptions({
  		    global: {
  		        useUTC: false
  		    }
  		});
  		function activeLastPointToolip(chart) {
  		    var points = chart.series[0].points;
  		    var	points1 = chart.series[1].points;
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
  		  	chart.yAxis[1].addPlotLine({ //在y轴上增加 
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
  		  	chart.yAxis[1].addPlotLine({ //在y轴上增加 
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
 
  		$('#body3').highcharts({
  		    chart: {
  		        type: 'spline',
  		        animation: false, // don't animate in old IE
  		        marginRight: 70,
  		        events: {
  		            load: function () {
  		                // set up the updating of the chart each second
  		                var series = this.series[0],
  		                	series1 = this.series[1],
  		                    chart = this;
  		                	timer=window.setInterval(function () {
  		                    /*var x = (new Date()).getTime()+t,*/ // current time
  		                  var x = time1[z],
  		                        y = ele[z];
  		                    var y1 = vol[z];
  		                    z++;
  		                    series.addPoint([x, y], true, true);
  		                    series1.addPoint([x, y1], true, true);
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
  		        tickPixelInterval: 150
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
  		    },{
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
  		      opposite: true  
  		    }],
  		    tooltip: {
  		        formatter: function () {
  		            return '<b>' + this.series.name + '</b><br/>' +
  		                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
  		                Highcharts.numberFormat(this.y, 2);
  		        },
  		    },
  		    legend: {
  		        enabled: true
  		    },
  		    exporting: {
  		        enabled: false
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
  		    },{

  		        name: '电压',
  		        yAxis: 1,
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
  	