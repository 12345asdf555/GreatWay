$(function(){
	dgDatagrid();
})

var chartStr = "";
function setParam(){
	var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
	var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
	chartStr += "?dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
}

function dgDatagrid(){
	setParam();
	var column = new Array();
	$.ajax({  
        type : "post",  
        async : false,
        url : "datastatistics/getPersonData"+chartStr,
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
        				 url : "datastatistics/getPersonData"+chartStr,
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