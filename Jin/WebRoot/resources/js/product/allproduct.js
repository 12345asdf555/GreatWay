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
		url : "product/getAllProduct",
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
			field : 'pro_mun',
			title : '产品编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'part_num',
			title : '零部件编号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'pro_info',
			title : '产品信息',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'part_info',
			title : '零部件信息',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'back_one',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'back_two',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'back_three',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'back_four',
			title : '备注',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'edit',
			title : '操作',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
			var str = "";
			str += '<a id="edit" class="easyui-linkbutton" href="product/toUpdateProduct?fid='+row.id+'"/>';
			str += '<a id="remove" class="easyui-linkbutton" href="product/toDestroyProduct?fid='+row.id+'"/>';
			str += '<a id="weldf" class="easyui-linkbutton" href="product/AllWeldf?fid='+row.id+'"/>';
			return str;
			}
		}]],
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
	        $("a[id='weldf']").linkbutton({text:'焊缝信息',plain:true,iconCls:'icon-search'});
	        }
	});

})

function addProduct(){
    	   var url = "product/toAddProduct";
			var img = new Image();
		    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
		    url = img.src;  // 此时相对路径已经变成绝对路径
		    img.src = null; // 取消请求
			window.location.href = encodeURI(url);
       }
