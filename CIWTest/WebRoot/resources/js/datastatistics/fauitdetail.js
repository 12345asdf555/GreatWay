$(function(){
	if($("#parenttime1").val()){
		$("#dtoTime1").datetimebox('setValue',$("#parenttime1").val());
	}
	if($("#parenttime2").val()){
		$("#dtoTime2").datetimebox('setValue',$("#parenttime2").val());
	}
	dgDatagrid();
})

var chartStr = "",dtoTime1,dtoTime2;
function setParam(){
	dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	var fauit = $("#fauit").val();
	var id = $("#id").val();
	chartStr += "?fauit="+fauit+"&id="+id+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

function dgDatagrid(){
	setParam();
	var column = new Array();
	$.ajax({  
        type : "post",  
        async : false,
        url : "datastatistics/getFauitDeatil"+chartStr,
        data : {},  
        dataType : "json", //返回数据形式为json  
        success : function(result) {
            if (result) {
            	 for(var i=0;i<result.ary.length;i++){
        			 column.push({field:"t"+i,title:result.ary[i].title,width:100,halign : "center",align : "left",sortable : true,
        				sorter : function(a,b){
        					return (a>b?1:-1);
        				}});
             	 }
            	 var grid = {
            			 fitColumns : true,
        				 height : $("#body").height(),
        				 width : $("#body").width(),
        				 url : "datastatistics/getFauitDeatil"+chartStr,
        				 pageSize : 10,
        				 pageList : [ 10, 20, 30, 40, 50 ],
        				 singleSelect : true,
        				 rownumbers : true,
        				 showPageList : false,
        				 pagination : true,
        				 remoteSort : false,
        				 nowrap : false,
        				 columns : [column],
        				 rowStyler: function(index,row){
        					 if ((index % 2)!=0){
        		            	 //处理行代背景色后无法选中
        		            	 var color=new Object();
        		                 color.class="rowColor";
        		                 return color;
        		             }
        		         },
        		         onBeforeLoad : function(param){
     		        		$("#chartLoading").hide();
        		         }
                 };
            	 $('#dg').datagrid(grid);  
            }  
        },  
        error : function(errorMsg) {  
            alert("数据请求失败，请联系系统管理员!");  
        }  
   }); 
}

function serach(){
	$("#parenttime1").val("");
	$("#parenttime2").val("");
	$("#chartLoading").show();
	chartStr = "";
	setTimeout(function(){
		dgDatagrid();
	},500);
}

//监听窗口大小变化
window.onresize = function() {
	setTimeout(domresize, 500);
}

//改变表格高宽
function domresize() {
	$("#dg").datagrid('resize', {
		height : $("#body").height(),
		width : $("#body").width()
	});
}