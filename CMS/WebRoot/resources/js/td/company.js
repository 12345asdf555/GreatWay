/**
 * 
 */

$(function(){
	newSearch();
})
var da;
function newSearch(){
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
				/*dd = msg.data;*/
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "td/getAllTdd1",  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(data){
			        	if (result){
			        		da = eval(data.rows);
			        	}
			        }
				})
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
		            	for(var index = 0;index < da.length;index++)
		            	{
			    var str = "<div id='div"+index+"' style='width:270px;heigth:250px;float:left;'>" +
				"<div>" +
				"<input id='btnReg"+index+"' type='button' value='xxx事业部' onclick='show()'/></div>&nbsp;" +
				"<div>" +
				"<label for='status' style='text-align:center;display:inline-block;width:20px'/>焊机总数</lable>&nbsp;" +
				"<input class='easyui-textbox' name='status"+index+"' id='status"+index+"'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#00FF00; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='on' style='text-align:center;display:inline-block'/>工作总数</lable>&nbsp;" +
				"<input class='easyui-textbox' name='on"+index+"' id='on"+index+"'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#FF0000; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='warning' style='text-align:center;display:inline-block'/>报警总数</lable>&nbsp;" +
				"<input class='easyui-textbox' name='warning"+index+"' id='warning"+index+"'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#0000CD; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='wait' style='text-align:center;display:inline-block'/>待机总数</lable>&nbsp;" +
				"<input class='easyui-textbox' name='wait"+index+"' id='wait"+index+"'/></div>&nbsp;" +
				"<div>" +
				"<div style=' width:17px; height:17px; background-color:#A9A9A9; border-radius:25px; float:left;' id='electricity"+index+"'/><div/>&nbsp;" +
				"<label for='off' style='text-align:center;display:inline-block'/>关机总数</lable>&nbsp;" +
				"<input class='easyui-textbox' name='off"+index+"' id='off"+index+"'/></div><div/>";
				$("#body").append(str);
				for(var k=0;k<p.length;k++){
				if(da[k].fprent==p[index].fd_id){
        		for(var l=0;l<c.length;l++){
        			if((da[index].fdname).equals(c[index].finsframework_id)){
        				if(c[l].fstatus_id == "00"){
        					num0 = num0+1;
        					document.getElementById("on"+index+"").value=num0;
        				}
        				else if(c[l].fstatus_id=="01"){
	            			num1=num1+1;
	            			document.getElementById("warning"+index+"").value=num1;
	            		}
	            		else if(c[l].fstatus_id=="10"){
	            			num2=num2+1;
	            			document.getElementById("wait"+index+"").value=num2;
	            		}
	            		else{
	            			num3=num3+1;
	            			document.getElementById("off"+index+"").value=num3;
	            		}
        			}
        		}
					}
				}
			document.getElementById("status"+index+"").value=num0 + num1 + num2 + num3;
			document.getElementById("status").value=document.getElementById("status").value+document.getElementById("status"+index+"").value;
			document.getElementById("on").value=document.getElementById("on").value+num0;
			document.getElementById("warning").value=document.getElementById("warning").value+num1;
			document.getElementById("wait").value=document.getElementById("wait").value+num2;
			document.getElementById("off").value=document.getElementById("off").value+num3;
		}
		/*document.getElementById("status"+index+"").value=(c.length)/3;*/
		/*			            for(var l=0;l<c.length;l+=3){
			if(c[l].finsframework_id==xxx){
				if(c[l].fstatus_id=="00"){
					num0=num0+1;
					document.getElementById("on").value=num0;
				}
				else if(c[l].fstatus_id=="01"){
					num1=num1+1;
					document.getElementById("warning").value=num1;
				}
				else if(c[l].fstatus_id=="10"){
					num2=num2+1;
					document.getElementById("wait").value=num2;
				}
				else{
					num3=num3+1;
					document.getElementById("off").value=num3;
				}
				}
		}*/
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

	function show(){
/*		var xx = document.getElementById("btnReg"+index+"").value;*/
		window.location.href="td/AllTdd";
	}
	

     
 