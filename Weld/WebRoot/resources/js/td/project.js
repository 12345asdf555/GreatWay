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
var pos;
var i = 0;
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
				i = 0;
				var pro = document.getElementById("project").value;
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "td/getAllTdp2?div="+pro,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(data){
			        	if(data){
			        		da = eval(data.rows);
			        	}
			        }
				})
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
			            	
			            	for(var index = 0;index < c.length;index=index+3)
			            	{
			            	/*var i = Math.floor(index/3);*/
			            		if(c[index].finsframework_id == da[0].fid){
			            			i++;
			            		if(c[index].fstatus_id=="03"||c[index].fstatus_id=="05"){
		            			if($("#div"+i+"").length<=0)
		            			{
			            	var str = "<div id='div"+i+"' style='width:270px;heigth:300px;float:left;'>" +
			            			"<div>" +
			            			"<div style=' width:17px; height:17px; background-color:#00FF00; border-radius:25px; float:left;' id='fequipment_no"+i+"'/><div/>&nbsp;" +
			            			"<input class='liveInput' id='btnReg"+i+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='vol' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压</lable>&nbsp;" +
			            			"<input class='liveInput' type='text' id='voltage"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='ele' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</lable>&nbsp;" +
			            			"<input class='liveInput' type='text' id='electricity"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='num' style='text-align:center;display:inline-block'/>焊工编号</lable>&nbsp;" +
			            			"<input class='liveInput' type='text' id='welderNo"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='name' style='text-align:center;display:inline-block'/>焊工姓名</lable>&nbsp;" +
			            			"<input class='liveInput' type='text' id='welderName"+i+"' readonly='true' value=''/></div>&nbsp;" +
			            			"<div>" +
			            			"<label for='po' style='text-align:center;display:inline-block'/>设备位置</lable>&nbsp;" +
			            			"<input class='liveInput' type='text' id='position"+i+"' readonly='true' value=''/></div><div/>";
			            	$("#body").append(str);
		            		}
			            	}
			            		else if(c[q].fstatus_id=="07"){
			            			if($("#div"+i+"").length<=0)
			            			{
				            	var str = "<div id='div"+i+"' style='width:270px;heigth:300px;float:left;'>" +
				            			"<div>" +
				            			"<div style=' width:17px; height:17px; background-color:#FF0000; border-radius:25px; float:left;' id='fequipment_no"+i+"'/><div/>&nbsp;" +
				            			"<input class='liveInput' id='btnReg"+i+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='vol' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='voltage"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='ele' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='electricity"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='num' style='text-align:center;display:inline-block'/>焊工编号</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderNo"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='name' style='text-align:center;display:inline-block'/>焊工姓名</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderName"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='po' style='text-align:center;display:inline-block'/>设备位置</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='position"+i+"' readonly='true' value=''/></div><div/>";
				            	$("#body").append(str);
			            		}
			            		}
			            		else if(c[index].fstatus_id=="00"){
			            			if($("#div"+i+"").length<=0)
			            			{
				            	var str = "<div id='div"+i+"' style='width:270px;heigth:300px;float:left;'>" +
				            			"<div>" +
				            			"<div style=' width:17px; height:17px; background-color:#0000CD; border-radius:25px; float:left;' id='fequipment_no"+i+"'/><div/>&nbsp;" +
				            			"<input class='liveInput' id='btnReg"+i+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='vol' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='voltage"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='ele' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='electricity"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='num' style='text-align:center;display:inline-block'/>焊工编号</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderNo"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='name' style='text-align:center;display:inline-block'/>焊工姓名</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderName"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='po' style='text-align:center;display:inline-block'/>设备位置</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='position"+i+"' readonly='true' value=''/></div><div/>";
				            	$("#body").append(str);
			            		}
			            		}
			            		else{
			            			if($("#div"+i+"").length<=0)
			            			{
				            	var str = "<div id='div"+i+"' style='width:270px;heigth:300px;float:left;'>" +
				            			"<div>" +
				            			"<div style=' width:17px; height:17px; background-color:#A9A9A9; border-radius:25px; float:left;' id='fequipment_no"+i+"'/><div/>&nbsp;" +
				            			"<input class='liveInput' id='btnReg"+i+"' type='button' value='' onclick='show(this.value)'/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='vol' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='voltage"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='ele' style='text-align:center;display:inline-block'/>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='electricity"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='num' style='text-align:center;display:inline-block'/>焊工编号</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderNo"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='name' style='text-align:center;display:inline-block'/>焊工姓名</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='welderName"+i+"' readonly='true' value=''/></div>&nbsp;" +
				            			"<div>" +
				            			"<label for='po' style='text-align:center;display:inline-block'/>设备位置</lable>&nbsp;" +
				            			"<input class='liveInput' type='text' id='position"+i+"' readonly='true' value=''/></div><div/>";
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
		    			        		name = weldname[0].fweldname;
		    			        	document.getElementById("welderName"+i+"").value=name;
		    			        }})
		    			        $.ajax({  
		    			        type : "post",  
		    			        async : false,
		    			        url : "td/getPosition?equip="+c[index].fequipment_no,  
		    			        data : {},  
		    			        dataType : "json", //返回数据形式为json  
		    			        success : function(result) {
		    			        	var fposition = eval(result.rows);
		    			        		pos = fposition[0].fpositin;
		    			        	document.getElementById("position"+i+"").value=pos;
		    			        }})
			            		document.getElementById("btnReg"+i+"").value=parseInt(c[index].fequipment_no,16);
			            		document.getElementById("voltage"+i+"").value=parseInt(c[index].electricity,16);
			            		document.getElementById("electricity"+i+"").value=parseInt(c[index].voltage,16);
			            		document.getElementById("welderNo"+i+"").value=parseInt(c[index].fwelder_no,16);
		            		/*document.getElementById("position"+i+"").value=c[index].fposition;*/
		            		}
		            		else{
		            			document.getElementById("btnReg"+i+"").value=parseInt(c[index].fequipment_no,16);
		            		}
				            document.getElementById("statusn").value=i;
				            	/*if(c[l].finsframework_id==document.getElementById("project").value){*/
				            		if(c[index].fstatus_id=="03"||c[index].fstatus_id=="05"){
				            			num0=num0+1;
				            			document.getElementById("onn").value=num0;
				            		}
				            		if(c[q].fstatus_id=="07"){
				            			num1=num1+1;
				            			document.getElementById("warningn").value=num1;
				            		}
				            		if(c[index].fstatus_id=="00"){
				            			num2=num2+1;
				            			document.getElementById("waitn").value=num2;
				            		}
				            		if(c[index].fstatus_id=="09"){
				            			num3=num3+1;
				            			document.getElementById("offn").value=num3;
				            		}
				            		/*}*/
				            }
			              
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
   		window.location.href="/CMS/td/AllTda?value="+encodeURI(value);
	}
   	
 