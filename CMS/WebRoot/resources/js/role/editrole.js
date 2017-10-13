/**
 * 
 */
        $(function(){
		    showdatagrid();
		})
		
		function showdatagrid(){
	    $("#tt").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'authorities_name',
		url : "role/getAllAuthority",
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true,
		},{
			field : 'authorities_name',
			title : '权限名',
			width : 100,
			halign : "center",
			align : "left"
		}]],
				onLoadSuccess:function(data){                
			        if(data){
			        $.each(data.rows, function(index, item){
			        	    var a = $("#id").val();
			        	    var b;
			        	    var c
						    $.ajax( {
							url : 'role/getAuthority?id='+a,
							data : {
							},
							type : 'post',
							async : false,
							dataType : 'json',
							success : function(result) {
							b = result.rows;
							},
							error : function() {
								alert("获取数据失败，请联系系统管理员！");
							}
						});
						c = eval(b);
					for(var i=0;i<c.length;i++)
					{
			        if(item.authorities_name==c[i].authorities_name){
			        $('#tt').datagrid('checkRow', index);
			        }
			        }
			        });
			        }
			        }                   
	});
}
        function saveRole(){
         var status = $('#status').combobox('getValue');
        /*  var row = $('#tt').datagrid('getChecked'); */
         var url;
          url = "role/updateRole"+"?&status="+status;
            $('#fm').form('submit',{
                url: "role/updateRole",
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }