$(function(){
	detailOverproofDatagrid();
})

function detailOverproofDatagrid(){
	var parent = $("#parent").val();
	$("#DetailOverproofTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#DetailOverproof_btn").height()-20,
		width : $("#body").width(),
		idField : 'id',
		url : "itemChart/getDatailOverproof?parent="+parent,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'iname',
			title : '项目部',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fmachine_id',
			title : '设备编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'wname',
			title : '焊工',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fwelder_id',
			title : '焊工编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fjunction_id',
			title : '焊口编号',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				return "<a href='junctionChart/gojunctionoverproof?welderno="+row.fwelder_id+"&machineno="+row.fmachine_id+"&junctionno="+row.fjunction_id+"&time="+row.weldtime+"&itemid="+row.iid+"'>"+value+"</a>"
			}
		}, {
			field : 'weldtime',
			title : '日期',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fmax_electricity',
			title : '最大电流',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'fmin_electricity',
			title : '最小电流',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'overproof',
			title : '超标率',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				var count = "1";
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "itemChart/getCountTime",  
			        data : {
			        	"welderno":row.fwelder_id,
			        	"machineno":row.fmachine_id,
			        	"junctionno":row.fjunction_id,
			        	"time":row.weldtime
			        },  
			        dataType : "json", 
			        success : function(result) {
			            if (result) {
			            	count =  ((value/result.count)*100).toFixed(2) + "%";
			            }else{
			            	count =  "0%";
			            }
			        },  
			        error : function(errorMsg) {  
			            alert("数据请求失败，请联系系统管理员!");  
			        }  
			   }); 
				return count;
			}
		}, {
			field : 'jid',
			title : '焊口id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		}, {
			field : 'iid',
			title : '项目id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		}, {
			field : 'iid',
			title : '总数据',
			width : 100,
			halign : "livecount",
			align : "left",
			hidden:true
		}] ],
	});
}

function serachDetailOverproof(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	$('#junctionHourTable').datagrid('load', {
		"dtoTime1" : dtoTime1,
		"dtoTime2" : dtoTime2
	});
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#DetailOverproofTable").datagrid('resize', {
		height : $("#body").height() - $("#DetailOverproof_btn").height(),
		width : $("#body").width()
	});
}
