/**
 * 
 */
       $(function(){
	    $("#dg").datagrid( {
		fitColumns : true,
		height : $("#body").height()*0.8,
		width : $("#body").width(),
		idField : 'id',
		toolbar : "#toolbar",
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "wps/getAllWps",
		rownumbers : true,
		pagination : true,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true
		},{
			field : 'FID',
			title : 'FID',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'FWPSNum',
			title : '工艺编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'Fweld_PreChannel',
			title : '预置通道',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'Fowner',
			title : '部门',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'Fback',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'Fname',
			title : '工艺参数名称',
			width : 100,
			halign : "center",
			align : "left"
        }]]
	});

})

function next(){
           var rows = $("#dg").datagrid("getSelections");
           if(rows.length==0){
        	   alert("请先选择工艺参数");
           }else{
           var str="";
           var pre="";
           for(var i=0; i<rows.length; i++){
  			str += rows[i].FID+",";
  			pre += rows[i].Fweld_PreChannel+",";
  			}
    	   var url = "wps/selectmachine?fid="+str+"&pre="+pre;
			var img = new Image();
		    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
		    url = img.src;  // 此时相对路径已经变成绝对路径
		    img.src = null; // 取消请求
			window.location.href = encodeURI(url);
           }
       }