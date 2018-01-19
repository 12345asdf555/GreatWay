$(function(){
	classifyDatagrid();
})
var chartStr = "";
var search;

function showItemHourChart(){
	var array1 = new Array();
	var array2 = new Array();
	var item = $("#item").val();
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	 $.ajax({  
         type : "post",  
         async : false, //同步执行
         url : encodeURI("itemChart/getitemHour?item="+item+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2+chartStr),
         data : {},  
         dataType : "json", //返回数据形式为json  
         success : function(result) {  
             if (result) {  
                 for(var i=0;i<result.rows.length;i++){
                 	array1.push(result.rows[i].material+"+"+result.rows[i].nextmaterial+"+"+result.rows[i].externalDiameter+"+"+result.rows[i].nextexternaldiameter+"+"+result.rows[i].wallThickness+"+"+result.rows[i].nextwall_thickness);
                 	if(result.rows[i].jidgather==0){
                     	array2.push(0);
                 	}else{
                     	var num = (result.rows[i].manhour/result.rows[i].jidgather).toFixed(2);
                     	array2.push(num);
                 	}
                 }
             }  
         },  
        error : function(errorMsg) {  
             alert("图表请求数据失败啦!");  
         }  
    });
   	//初始化echart实例
	charts = echarts.init(document.getElementById("itemHourChart"));
	//显示加载动画效果
	charts.showLoading({
		text: '稍等片刻,精彩马上呈现...',
		effect:'whirling'
	});
	option = {
		title:{
			text: "焊口焊接工时"
		},
		tooltip:{
			trigger: 'axis'//坐标轴触发，即是否跟随鼠标集中显示数据
		},
		legend:{
			data:['工时(s)']
		},
		grid:{
			left:'10%',//组件距离容器左边的距离
			right:'13%',
			bottom:'7%',
			containLaber:true//区域是否包含坐标轴刻度标签
		},
		toolbox:{
			feature:{
				saveAsImage:{}//保存为图片
			},
			right:'2%'
		},
		xAxis:{
			type:'category',
			data: array1,
			name:'组织机构'
		},
		yAxis:{
			type: 'value',//value:数值轴，category:类目轴，time:时间轴，log:对数轴
			name:'焊接时长(s)'
		},
		series:[
			{
				name:'工时(s)',
				type:'bar',
				data:array2
			}
		]
	}
	//为echarts对象加载数据
	charts.setOption(option);
	//隐藏动画加载效果
	charts.hideLoading();
}


function itemHourDatagrid(){
	var item = $("#item").val();
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	$("#itemHourTable").datagrid( {
		fitColumns : true,
		height : $("#body").height() - $("#itemHourChart").height()-$("#itemHour_btn").height()-40,
		width : $("#body").width(),
		idField : 'id',
		url : "itemChart/getitemHour?item="+item+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2+chartStr,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'name',
			title : '焊口',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				var str = row.material+"+"+row.nextmaterial+"+"+row.externalDiameter+"+"+row.nextexternaldiameter+"+"+row.wallThickness+"+"+row.nextwall_thickness;
				return '<a href="junctionChart/goJunctionHour?material='+encodeURI(row.material)+'&nextmaterial='+encodeURI(row.nextmaterial)+'&externalDiameter='+encodeURI(row.externalDiameter)+'&nextexternaldiameter='+encodeURI(row.nextexternaldiameter)+
				'&wallThickness='+encodeURI(row.wallThickness)+'&nextwall_thickness='+encodeURI(row.nextwall_thickness)+'&itemid='+row.itemid+'&time1='+dtoTime1+'&time2='+dtoTime2+'">'+str+'</a>';
			}
		}, {
			field : 'jidgather',
			title : '焊口数量',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'manhour',
			title : '焊接工时(s)',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
				if(row.jidgather==0){
                 	return 0;
             	}
				return (value/row.jidgather).toFixed(2);
			}
		}, {
			field : 'dyne',
			title : '达因',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'material',
			title : '上游材质',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'nextmaterial',
			title : '下游材质',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'nextexternaldiameter',
			title : '下游外径',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'externalDiameter',
			title : '上游外径',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'wallThickness',
			title : '上游璧厚',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'nextwall_thickness',
			title : '下游璧厚',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'itemid',
			title : '项目id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}] ]
	});
}

function classifyDatagrid(){
	var item = $("#item").val();
	$("#classify").datagrid( {
		fitColumns : true,
		height : $("#classifydiv").height(),
		width : $("#body").width()/2,
		idField : 'fid',
		url : "itemChart/getItemHousClassify?item="+item,
		pageSize : 5,
		pageList : [ 5, 10, 15, 20, 25],
		rownumbers : true,
		showPageList : false,
		pagination : true,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		},{
			field : 'fid',
			hidden : true
		},{
			field : 'material',
			title : '上游材质',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'nextmaterial',
			title : '下游材质',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'wall_thickness',
			title : '上游璧厚',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'nextwall_thickness',
			title : '下游璧厚',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'external_diameter',
			title : '上游外径',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'nextExternal_diameter',
			title : '下游外径',
			width : 100,
			halign : "center",
			align : "left"
		}] ],
		toolbar : '#classify_btn',
		onLoadSuccess: function(){
			$("#classify").datagrid("selectRow",0);
			showItemHourChart();
			itemHourDatagrid();
		}
	});
}
function commitChecked(){
	chartStr = "";
	search = "";
	var rows = $("#classify").datagrid("getSelections");
	if(rows==null || rows==""){
		alert("您还没有选中行！");
	}else{
		for(var i=0;i<rows.length;i++){
			if(i==0){
				search = "";
			}else{
				search += " or";
			}
			search += " (fmaterial='"+rows[i].material+"' and fexternal_diameter='"+rows[i].external_diameter+"' and fwall_thickness='"+rows[i].wall_thickness+"' and fnextExternal_diameter='"+rows[i].nextExternal_diameter+
			"' and fnextwall_thickness ='"+rows[i].nextwall_thickness+"' and Fnext_material ='"+rows[i].nextmaterial+"')";
		}
		chartStr = "&search="+search;
		showItemHourChart();
		itemHourDatagrid();
	}
}


function serachItemHour(){
	commitChecked();
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#itemHourTable").datagrid('resize', {
		height : $("#body").height() - $("#itemHourChart").height()-$("#itemHour_btn").height()-10,
		width : $("#body").width()
	});
}
