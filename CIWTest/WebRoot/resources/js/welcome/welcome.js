$(function(){
	workRankDatagrid();
	getNowDate();
	getHierarchy();
})

var companylen=0,caustlen=0;
function getHierarchy(){
	$.ajax({
		type:'post',
		asyn:false,
		url:'hierarchy/getHierarchy',
		dataType:'json',
		success:function(result){
			var str1 = "", str2 = "", str3 = "";
			companylen = result.ary1.length,caustlen=result.ary2.length;
			for(var i=0;i<result.ary1.length;i++){
				//显示公司
				str1 = '<div class="wcrightinsframework" id="company'+i+'" onclick="companyclick('+i+')">'+
					'<div class="wcrighttitle">'+result.ary1[i].companyname+'</div><div class="wcrighticon"><img src="resources/images/arrow.png" id="imgcompany'+i+'"/></div></div>';
				$("#autoshowdiv").append(str1);
				for(var j=0;j<result.ary2.length;j++){
					if(result.ary1[i].companyid == result.ary2[j].companyid ){
						//显示事业部
						if(i==0){//显示第一个公司下的所有事业部
							str2 = '<div class="wcrightinsframework" id="caust'+j+'" name="cnode'+i+'" onclick="caustclick('+j+')">'+
								'<div class="wcrighttitle">&nbsp;&nbsp;'+result.ary2[j].caustname+'</div><div class="wcrighticon"><img src="resources/images/arrow.png" id="imgcaust'+j+'"/></div></div>';
							$("#company"+i).after(str2);
						}else{
							str2 = '<div class="wcrightinsframework" hidden="true" id="caust'+j+'" name="cnode'+i+'" onclick="caustclick('+j+')">'+
								'<div class="wcrighttitle">&nbsp;&nbsp;'+result.ary2[j].caustname+'</div><div class="wcrighticon"><img src="resources/images/arrow.png" id="imgcaust'+j+'"/></div></div>';
							$("#company"+i).after(str2);
						}
						str3 = '<div class="wcul" style="padding-bottom:20px;" id="item'+j+'"  hidden="true"><ul>';
						var flag = 0;
						for(var x=0;x<result.ary3.length;x++){
							if(result.ary2[j].caustid == result.ary3[x].caustid ){
								str3 += '	<li onclick="itemclick('+result.ary3[x].itemid+')">'+result.ary3[x].itemname+'</li>';
								flag = 1;
							}
						}
						if(flag==1){
							//显示项目部
							str3 += '</ul></div>';
							$("#caust"+j).after(str3);
						}else{
							str3 = '<div class="wcul" style="padding-bottom:40px;" id="item'+j+'"  hidden="true"><ul><li>暂无</li></ul></div>';
							$("#caust"+j).after(str3);
						}
					}
				}
				rightshow();
			}
		},
		error:function(errorMsg){
			alert("数据请求失败，请联系系统管理员!");
		}
	})
}

function getNowDate(){
	//获取当前时间
	var now = new Date();  
	now.setDate(now.getDate());
    var year = now.getFullYear();//年  
    var month = now.getMonth() + 1;//月  
    var day = now.getDate();//日
    
    var nowtime = year + "-";
      
    if(month < 10){
        nowtime += "0";
    }
    nowtime += month + "-";
      
    if(day < 10){
        nowtime += "0";
    }          
    nowtime += day + " ";
	$(".wcdate").append(nowtime);
}

//右侧初始状态
function rightshow(){
	$("#mesimg").css("transform","rotate(180deg)");//展开按钮旋转180度
	$("#onlineimg").css("transform","rotate(180deg)");
	$("#imgcompany0").css("transform","rotate(180deg)");
	$("#imgcaust0").css("transform","rotate(180deg)");
	$("#item0").slideDown();
}

//任务情况点击事件
function onlineclick(){
	if($("#wconline").is(":hidden")){
	    $("#wconline").slideDown();
		$("#onlineimg").css("transform","rotate(180deg)");
	}else{
	    $("#wconline").slideUp();
		$("#onlineimg").css("transform","rotate(0deg)");
	}
}

//公司信息栏点击事件
function companymesclick(){
	if($("#company0").is(":hidden")){
		for(var i=0;i<companylen;i++){
			$("#company"+i).slideDown();
			$("#imgcompany"+i).css("transform","rotate(0deg)");
		}
		$("#mesimg").css("transform","rotate(180deg)");
	}else{
		for(var i=0;i<companylen;i++){
			$("#company"+i).slideUp();
		}
		for(var i=0;i<caustlen;i++){
			$("#caust"+i).slideUp();
			$("#item"+i).slideUp();
		}
		$("#mesimg").css("transform","rotate(0deg)");
	}
}

function companyclick(index){
	//关闭其它公司层内容
	for(var i=0;i<caustlen;i++){
		$("#caust"+i).slideUp();
		$("#item"+i).slideUp();
	}
	for(var i=0;i<companylen;i++){
		$("#imgcompany"+i).css("transform","rotate(0deg)");
	}
	//根据name获取属性id
	var obj = document.getElementsByName("cnode"+index);
    for(i=0;i<obj.length;i++){
    	if($("#"+obj[i].id).is(":hidden")){
            $("#"+obj[i].id).slideDown();
            for(var j=0;j<caustlen;j++){
    			if("caust"+j == obj[i].id){
    	            $("#imgcaust"+j).css("transform","rotate(0deg)");
    			}
    		}
    		$("#imgcompany"+index).css("transform","rotate(180deg)");
    	}else{
            $("#"+obj[i].id).slideUp();
    		for(var j=0;j<caustlen;j++){
    			if("caust"+j == obj[i].id){
        			$("#item"+j).slideUp();
    			}
    		}
    		$("#imgcompany"+index).css("transform","rotate(0deg)");
    	}
    }
}

function caustclick(index){
	//关闭其它事业层内容
	for(var i=0;i<caustlen;i++){
		if(i != index){
			$("#item"+i).slideUp();
			$("#imgcaust"+i).css("transform","rotate(0deg)");
		}
	}
	if($("#item"+index).is(":hidden")){
		$("#item"+index).slideDown();
		$("#imgcaust"+index).css("transform","rotate(180deg)");
	}else{
		$("#item"+index).slideUp();
		$("#imgcaust"+index).css("transform","rotate(0deg)");
	}
}

function itemclick(id){
	alert("点击项目部："+id);
}

function workRankDatagrid(){
	$("#workRankTable").datagrid( {
		fitColumns : true,
		scrollbarSize:0,//舍去表格右侧多余留白
		height : $("#wcleft1_2").height(),
		width : $("#wcleft1_2").width()-'2%',
		url : "datastatistics/getWorkRank",
		singleSelect : true,
		columns : [ [ {
			field : 'rownum',
			title : '排名',
			width : 100,
			halign : "center",
			align : "center"
		}, {
			field : 'welderno',
			title : '工号',
			width : 100,
			halign : "center",
			align : "center"
		}, {
			field : 'name',
			title : '姓名',
			width : 100,
			halign : "center",
			align : "center"
		}, {
			field : 'item',
			title : '班组',
			width : 150,
			halign : "center",
			align : "center"
		}, {
			field : 'hour',
			title : '累计焊接工时',
			width : 100,
			halign : "center",
			align : "center"
		}] ],
		 rowStyler: function(index, row) {
	        return 'background-color:#A7D6BD;';  
	    } 
	});
}