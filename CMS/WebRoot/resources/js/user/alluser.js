/**
 * 
 */
        $(function(){
	    $("#tt").datagrid( {
		fitColumns : true,
		height : ($("#body").height() - $('#toolbar').height()),
		width : $("#body").width(),
		idField : 'roles_name',
		url : "user/getAllRole",
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true
		},{
			field : 'roles_name',
			title : '角色名',
			width : 100,
			halign : "center",
			align : "left"
		}]]
			});
		})   

       $(function(){
	    $("#dg").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'id',
		toolbar : "#toolbar",
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "user/getAllUser",
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
			field : 'users_name',
			title : '用户名',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'users_Login_Name',
			title : '登录名',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'users_phone',
			title : '电话',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'users_email',
			title : '邮箱',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'users_position',
			title : '岗位',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'users_insframework',
			title : '部门',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'status',
			title : '状态',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'role',
			title : '角色',
			width : 100,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
			var str = "";
			str += '<a id="role" class="easyui-linkbutton" href="javascript:role('+row.id+')"/>';
			return str; 
			}
		}, {
			field : 'edit',
			title : '编辑',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
			var str = "";
			str += '<a id="edit" class="easyui-linkbutton" href="user/getUser?id='+row.id+'"/>';
			str += '<a id="remove" class="easyui-linkbutton" href="user/desUser?id='+row.id+'"/>';
			return str;
			}
		}]],
		toolbar : '#toolbar',
		onLoadSuccess:function(data){
	        $("a[id='edit']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
	        $("a[id='remove']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
	        $("a[id='role']").linkbutton({text:'角色列表',plain:true,iconCls:'icon-Role'});
	        }
	});
})
     
       function removeUser(id){
		$.messager.confirm('提示', '此操作不可撤销，是否确认删除?', function(flag) {
			if (flag) {
				$.ajax({  
			        type : "post",  
			        async : false,
			        url : "user/delUser?id="+id,  
			        data : {},  
			        dataType : "json", //返回数据形式为json  
			        success : function(result) {
			            if (result) {
			            	if (!result.success) {
								$.messager.show( {
									title : 'Error',
									msg : result.msg
								});
							} else {
								$.messager.alert("提示", "删除成功！");
								var url = "user/AllUser";
								var img = new Image();
							    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
							    url = img.src;  // 此时相对路径已经变成绝对路径
							    img.src = null; // 取消请求
								window.location.href = encodeURI(url);
							}
			            }  
			        },  
			        error : function(errorMsg) {  
			            alert("数据请求失败，请联系系统管理员!");  
			        }  
			   }); 
			}
		});
	}   
        
        function role(id){
        $('#div1').dialog('open').dialog('center').dialog('setTitle','角色列表');
        $("#ro").datagrid( {
		fitColumns : true,
		height : '300px',
		width : $("#div").width(),
		idField : 'id',
		url : "user/getRole?id="+id,
		rownumbers : false,
		showPageList : false,
		columns : [ [ {
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden: true
		},{
			field : 'roles_name',
			title : '角色名',
			width : 100,
			halign : "center",
			align : "left"
		}]]
		
			});

        }