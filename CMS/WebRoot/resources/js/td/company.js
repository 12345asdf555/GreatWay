/**
 * 
 */
var da;
var dd;
var dat;
var dd1;
var ddd;
var num = 0;
var num0 = 0;
var num1 = 0;
var num2 = 0;
var num3 = 0;
var warningn=0;
var onn1=0;
var waitn=0;
var data1;
var ti=0;
var on=new Array();
var warn=new Array();
var wait=new Array();
var off=new Array();
var on1=new Array();
var warn1=new Array();
var wait1=new Array();
var off1=new Array();
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
        url : "td/getAllTddiv",  
        data : {},  
        dataType : "json", //返回数据形式为json  
        success : function(data) {
        	dd = eval(data.rows);
        }})
	newSearch();
})
function newSearch(){
  	$(function() {
		var socket;
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
				dat = msg.data;
/*				if(ti==0){
					ti++;
		                setInterval(function () {
		                	for(var index = 0;index < dd.length;index++){
		                		if($("#div"+index+"").length<=0){}else{
		        					document.getElementById("on"+index+"").value=0;
			            			document.getElementById("warning"+index+"").value=0;
			            			document.getElementById("wait"+index+"").value=0;
			            			document.getElementById("off"+index+"").value=0;
		                		}
		                	}
		                	warningn=0;
		                	onn1=0;
		                	waitn=0;
		                	document.getElementById("onn").value=0;
	            			document.getElementById("warningn").value=0;
	            			document.getElementById("waitn").value=0;
	            			document.getElementById("offn").value=0;
  		                }, 3000);
				} */    
				
				for(var n = 0;n < dat.length;n+=159){
					if((dat.substring(0+n, 2+n)=="03")||(dat.substring(0+n, 2+n)=="05")||(dat.substring(0+n, 2+n)=="07")||(dat.substring(0+n, 2+n)=="00")){		
						if(on1.length==0){
							var l1=1;
							var lo=0;
							for(var a1=0;a1<l1;a1++){
								if(dat.substring(4+n, 8+n)!=on1[a1]){
									on1.push(dat.substring(4+n, 8+n));		
								}else{
				                	for(var index = 0;index < dd.length;index++){
				                		if($("#div"+index+"").length<=0){}else{
				        					document.getElementById("on"+index+"").value=0;
					            			document.getElementById("warning"+index+"").value=0;
					            			document.getElementById("wait"+index+"").value=0;
					            			document.getElementById("off"+index+"").value=0;
				                		}
				                	}
				                	warningn=0;
				                	onn1=0;
				                	waitn=0;
								}
							}
						}else{
						l1=on1.length;
						var lo=0;
						for(var a1=0;a1<l1;a1++){
							/*alert(dd.substring(4+n, 8+n));*/
							if(dat.substring(4+n, 8+n)!=on1[a1]){
								lo++;	
								if(lo==on1.length){
								on1.push(dat.substring(4+n, 8+n));
								}		
							}else{
			                	for(var index = 0;index < dd.length;index++){
			                		if($("#div"+index+"").length<=0){}else{
			        					document.getElementById("on"+index+"").value=0;
				            			document.getElementById("warning"+index+"").value=0;
				            			document.getElementById("wait"+index+"").value=0;
				            			document.getElementById("off"+index+"").value=0;
			                		}
			                	}
			                	warningn=0;
			                	onn1=0;
			                	waitn=0;
			                	on1.length=0;
			                	on1.push(dat.substring(4+n, 8+n));
			                	break;
							}
						}
						}					
					}
					};
				
		            	for(var index = 0;index < dd.length;index++)
		            	{
		            		num=0;num0 = 0;num1 = 0;num2 = 0;num3 = 0;
	            			if($("#div"+index+"").length<=0)
            				{

			    var str = "<div id='div"+index+"' style='width:270px;heigth:250px;float:left;'>" +
				"<div>" +
				"<input class='liveInput' id='btnReg"+index+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
				"<div>" +
				"<label for='status' style='text-align:center;display:inline-block;width:20px'/>焊机总数</lable>&nbsp;" +
				"<input class='liveInput' type='text' name='status"+index+"' id='status"+index+"' value='0' readonly='true'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#00FF00; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='on' style='text-align:center;display:inline-block'/>工作总数</lable>&nbsp;" +
				"<input class='liveInput' type='text' name='on"+index+"' id='on"+index+"' value='0'/ readonly='true'></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#FF0000; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='warning' style='text-align:center;display:inline-block'/>报警总数</lable>&nbsp;" +
				"<input class='liveInput' type='text' name='warning"+index+"' id='warning"+index+"' value='0' readonly='true'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#0000CD; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='wait' style='text-align:center;display:inline-block'/>待机总数</lable>&nbsp;" +
				"<input class='liveInput' type='text' name='wait"+index+"' id='wait"+index+"' value='0' readonly='true'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#A9A9A9; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='off' style='text-align:center;display:inline-block'/>关机总数</lable>&nbsp;" +
				"<input class='liveInput' type='text' name='off"+index+"' id='off"+index+"' value='0' readonly='true'/></div><div/>";
				$("#body").append(str);
            	}
				document.getElementById("btnReg"+index+"").value=dd[index].fname;
				$.ajax({ 
					type : "post",  
			        async : false,
			        url : "td/getAllTdp1?ins="+dd[index].fid,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(data) {
			        	ddd = eval(data.rows);
			        }})
					for(var h = 0;h<ddd.length;h++){
			        for(var k=0;k<dat.length;k=k+159){
				if(dat.substring(2+k, 4+k)==ddd[h].fid){
					num++;
        				if(dat.substring(0+k, 2+k)=="03"||dat.substring(0+k, 2+k)=="05"){
        					num0++;
        					var oni=parseInt(document.getElementById("on"+index+"").value);
        					document.getElementById("on"+index+"").value=oni+num0;
        				}
        				else if(dat.substring(0+k, 2+k)=="07"){
        					num1++;
        					var wni=parseInt(document.getElementById("warning"+index+"").value);
	            			document.getElementById("warning"+index+"").value=wni+num1;
	            		}
        				else if(dat.substring(0+k, 2+k)=="00"){
	            			num2++;
	            			var wai=parseInt(document.getElementById("wait"+index+"").value);
	            			document.getElementById("wait"+index+"").value=wai+num2;	            		
	            		}
        				else{
	            			document.getElementById("off"+index+"").value=num-parseInt(document.getElementById("on"+index+"").value)-parseInt(document.getElementById("warning"+index+"").value)-parseInt(document.getElementById("wait"+index+"").value);
	            		}	            		
        			}       							
				}
				}
				document.getElementById("status"+index+"").value = num;	
		}					
		            	for(var q=0;q<dat.length;q=q+159){
        				if(dat.substring(0+q, q+2)=="03"||dat.substring(0+q, 2+q)=="05"){
        					onn1++;
        					document.getElementById("onn").value=onn1;
        				}
        				if(dat.substring(0+q, q+2)=="07"){
        					warningn++;
	            			document.getElementById("warningn").value=warningn;
	            		}
	            		if(dat.substring(0+q, q+2)=="00"){
	            			waitn++;
	            			document.getElementById("waitn").value=waitn;
	            		}
	            		document.getElementById("offn").value=(dat.length)/159-onn1-warningn-waitn;     	
		    			document.getElementById("statusn").value=Math.ceil((dat.length)/159);
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

	}

	function show(value){
/*		var xx = document.getElementById("btnReg"+index+"").value;*/
		window.location.href="/CMS/td/AllTdd?value="+value;
	}
	

     
 