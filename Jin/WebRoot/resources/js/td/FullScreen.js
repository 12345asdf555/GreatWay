/**
 * 
 */
var da;
var data1;
var dat;
var num = 0;
var num0 = 0;
var num1 = 0;
var num2 = 0;
var num3 = 0;
var on1=new Array();
var on=new Array();
var warn=new Array();
var wait=new Array();
var off=new Array();
var iname=0;
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
})
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
			for(var j = 0;j < 1;j++){
				for(var i = 0;i < dd.length;i+=53){
						if(hq == parseInt(dd.substring(4+i, 8+i),16)&&(dd.substring(8+i, 12+i))!="0000"){
						var defineStr = "var ele"+iname.toString();
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
						document.getElementById("macname").value=hq;
						for(var k=0;k<namex.length;k++){
							if(namex[k].fwelder_no==dd.substring(8+i, 12+i)){
								document.getElementById("welname").value=namex[k].fname;
							}
						}
						jj++;
						if(jj<=1){
							curve(); 
							curve1();
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
			var str = "<div id='div"+index+"' style='width:270px;heigth:240px;float:left;'>"+"<div/>";
			$("#body").append(str);

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
