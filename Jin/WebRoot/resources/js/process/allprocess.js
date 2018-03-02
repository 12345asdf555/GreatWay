/**
 * 
 */
       $(function(){
	    $("#dg").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'id',
		toolbar : "#toolbar",
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "product/getAllProcess",
		singleSelect : false,
		rownumbers : true,
		pagination : true,
		showPageList : false,
		columns : [ [ {
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		}, {
			field : 'processname',
			title : '工艺名称',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'weldposition',
			title : '焊接位态',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'material',
			title : '材质',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'format',
			title : '规格',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'method',
			title : '焊接方法',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'drying',
			title : '焊材烘干条件',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'temperature',
			title : '预热温度',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'factor',
			title : '后热条件',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'require',
			title : '热处理条件',
			width : 100,
			halign : "center",
			align : "left"
        },{
			field : 'lecel',
			title : '无损检测合格级别',
			width : 100,
			halign : "center",
			align : "left"
        },{
			field : 'qualify',
			title : '员工资质',
			width : 100,
			halign : "center",
			align : "left"
        },{
			field : 'range',
			title : '线能量控制范围',
			width : 100,
			halign : "center",
			align : "left"
        },{
			field : 'edit',
			title : '操作',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
			var str = "";
			str += '<a id="edit" class="easyui-linkbutton" href="product/toUpdateProcess?fid='+row.id+'"/>';
			str += '<a id="remove" class="easyui-linkbutton" href="product/toDestroyProcess?fid='+row.id+'"/>';
			return str;
			}
		}]],
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
	        }
	});

})

function addProcess(){
    	   var url = "product/toAddProcess";
			var img = new Image();
		    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
		    url = img.src;  // 此时相对路径已经变成绝对路径
		    img.src = null; // 取消请求
			window.location.href = encodeURI(url);
       }
