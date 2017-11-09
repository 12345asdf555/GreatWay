/**
 * 
 */
var da;
var dd;
var dd1;
var ddd;
var num = 0;
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
	newSearch();
})
function newSearch(){
  	$(function() {
		var socket;
//		$.ajax({ 
//			type : "post",  
//	        async : false,
//	        url : "td/AllTdbf",  
//	        data : {},  
//	        dataType : "json", //返回数据形式为json  
//	        success : function(data) {
//	        	data1 = eval(data.web_socket);
//	        	alert(data1);
//	        }})
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
				/*dd = msg.data;*/
				$.ajax({ 
					type : "post",  
			        async : false,
			        url : "td/getAllTddiv",  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(data) {
			        	dd = eval(data.rows);
			        }})
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "td/getAllTdp?data="+msg.data,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(result) {
		            if (result) {
		            	var num0 = 0;
		            	var num1 = 0;
		            	var num2 = 0;
		            	var num3 = 0;
		            	var r = result.rows;
		            	var c = eval(r);
/*			            	var array=new Array(dd.length);  
			            	for(var v=0;v<dd.length;v++){
			            		array[v] = 0;
			            	}*/
		            	console.log(result.rows);
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
			        for(var k=0;k<c.length;k=k+3){
				if(c[k].finsframework_id==ddd[h].fid){
					num++;
        				if(c[k].fstatus_id=="31"||c[k].fstatus_id=="32"){
        					num0 = num0+1;
        					document.getElementById("on"+index+"").value=num0;
        				}
        				if(c[k].maxvol>c[k].voltage||c[k].maxele>c[k].electricity){
	            			num1=num1+1;
	            			document.getElementById("warning"+index+"").value=num1;
	            		}
	            		if(c[k].fstatus_id=="33"){
	            			num2=num2+1;
	            			document.getElementById("wait"+index+"").value=num2;
	            		}
	            		if(c[k].fstatus_id=="00"){
	            			num3=num3+1;
	            			document.getElementById("off"+index+"").value=num3;
	            		}
        			}
        							
				}
				/*num0 = 0;num1 = 0;num2 = 0;num3 = 0;*/
				}
				document.getElementById("status"+index+"").value = num;
				
		}				
		            	num0 = 0;num1 = 0;num2 = 0;num3 = 0;
		            	for(var q=0;q<c.length;q=q+3){
        				if(c[q].fstatus_id=="31"||c[q].fstatus_id=="32"){
        					num0 = num0+1;
        					document.getElementById("onn").value=num0;
        				}
        				if(c[q].maxvol>c[q].voltage||c[q].maxele>c[q].electricity){
	            			num1=num1+1;
	            			document.getElementById("warningn").value=num1;
	            		}
	            		if(c[q].fstatus_id=="33"){
	            			num2=num2+1;
	            			document.getElementById("waitn").value=num2;
	            		}
	            		if(c[q].fstatus_id=="00"){
	            			num3=num3+1;
	            			document.getElementById("offn").value=num3;
	            		}  	
		            	}
		    			document.getElementById("statusn").value=Math.ceil((c.length)/3);
		}  
		},  
		error : function(errorMsg) {  
		alert("数据请求失败，请联系系统管理员!");  
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

	}

	function show(value){
/*		var xx = document.getElementById("btnReg"+index+"").value;*/
		window.location.href="/CMS/td/AllTdd?value="+value;
	}
	

     
 