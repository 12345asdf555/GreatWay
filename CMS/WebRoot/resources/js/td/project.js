/**
 * 
 */
/*       $(function(){
    	   document.getElementById('welderName').value="333";
    	   $("#welderName").val("aaa");
    	   $("#welderName").textbox('setValue','333');
})*/
var dd;
var name;
$(function(){
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
			socket = new WebSocket("ws://121.196.222.216:5554/SerialPortDemo/ws/张三");
			//打开事件
			socket.onopen = function() {
				alert("Socket 已打开");
				//socket.send("这是来自客户端的消息" + location.href + new Date());
			};
			//获得消息事件
			socket.onmessage = function(msg) {
				/*alert(msg.data);*/
				dd = msg.data;
				var pro = document.getElementById("project").value;
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "td/getAllTd?data="+msg.data,  
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
			            	for(var index = 0;index < c.length;index+=3)
			            	{
			            	var i = Math.floor(index/3);
		            		if(index%3==0){
		            			if($("#div"+i+"").length<=0)
		            				{
			            	var str = "<div id='div"+i+"' style='width:270px;heigth:300px;float:left;'>" +
			            			"<div>" +
			            			"<div style=' width:17px; height:17px; background-color:#0000CD; border-radius:25px; float:left;' id='fequipment_no"+i+"'/><div/>&nbsp;" +
			            			"<input id='btnReg"+i+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='vol' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压</lable>&nbsp;" +
			            			"<input class='easyui-textbox' id='voltage"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='ele' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</lable>&nbsp;" +
			            			"<input class='easyui-textbox' id='electricity"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='num' style='text-align:center;display:inline-block'/>焊工编号</lable>&nbsp;" +
			            			"<input class='easyui-textbox' id='welderNo"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='name' style='text-align:center;display:inline-block'/>焊工姓名</lable>&nbsp;" +
			            			"<input class='easyui-textbox' id='welderName"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='po' style='text-align:center;display:inline-block'/>设备位置</lable>&nbsp;" +
			            			"<input class='easyui-textbox' id='position"+i+"' readonly='true' value='"+c[index].fposition+"'/></div><div/>";
			            	$("#body").append(str);
		            				}
		            		}
		            		if(c[index].fwelder_no!="0000"){
		            		$.ajax({  
		    			        type : "post",  
		    			        async : false,
		    			        url : "td/getWeld?weldid="+c[index].fwelder_no,  
		    			        data : {},  
		    			        dataType : "json", //返回数据形式为json  
		    			        success : function(result) {
		    			        	var weldname = eval(result.rows);
		    			        	for(var b = 0;b < weldname.length;b++){
		    			        		name = weldname[b].fweldname;
		    			        	}
		    			        	document.getElementById("welderName"+i+"").value=name;
		    			        }})
		            		}
		            		document.getElementById("btnReg"+i+"").value=c[index].fequipment_no;
		            		document.getElementById("voltage"+i+"").value=parseInt(c[index].voltage,16);
		            		document.getElementById("electricity"+i+"").value=parseInt(c[index].electricity,16);
		            		document.getElementById("welderNo"+i+"").value=c[index].fwelder_no;
		            		
		            		/*document.getElementById("position"+i+"").value=c[index].fposition;*/
		            		var t = Date.now();  
		            		  
		            		function sleep(d){  
		            		    while(Date.now - t <= d);  
		            		}   
		            		sleep(1000); 
			            }
			            document.getElementById("statusn").value=(c.length)/3;
			            for(var l=0;l<c.length;l+=3){
			            	/*if(c[l].finsframework_id==document.getElementById("project").value){*/
			            		if(c[l].fstatus_id=="31"||c[l].fstatus_id=="32"){
			            			num0=num0+1;
			            			document.getElementById("onn").value=num0;
			            		}
			            		if(c[l].maxvol>c[l].voltage||c[l].maxele>c[l].electricity){
			            			num1=num1+1;
			            			document.getElementById("warningn").value=num1;
			            		}
			            		if(c[l].fstatus_id=="33"){
			            			num2=num2+1;
			            			document.getElementById("waitn").value=num2;
			            		}
			            		if(c[l].fstatus_id=="00"){
			            			num3=num3+1;
			            			document.getElementById("offn").value=num3;
			            		}
			            		/*}*/
			            }
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
   		window.location.href="td/AllTda?value="+value;
/*   		var st="";
        var str="";
        var str1="";
		for(var i=0; i<va.length; i++){
			st += va[i].fequipment_no+",";
			str += va[i].voltage+",";
			str1 += va[i].electricity+",";
			}*/
/*   		$.ajax({  
	        type : "post",  
	        async : false,
	        url : "td/AllTdad?a="+str1+"&v="+str2+"&value="+value+"&e="+str0,  
	        data : {},  
	        dataType : "json", //返回数据形式为json  
	        success : function(result) {
	        	if(result){
	        		var c = eval(result.rows);
	        		console.log(c);
	        		var str3="";
	                var str4="";
	        		for(var i=0; i<c.length; i++){
	        			str3 += c[i].voltage+","+c[i].electricity+",";
	        			str4 += c[i].electricity+",";
	        			}
	        		window.location.href="td/AllTda";
	        	}
	        	
	        }
   		})*/
	}
   	
 