/**
 * 
 */
        $(function(){
		    showdatagrid();
		})
		
		function showdatagrid(){
			$("#tt").datagrid( {
				fitColumns : true,
				height : '250px',
				width : '15%',
				idField : 'roles_name',
				url : "user/getAllRole",
				rownumbers : false,
				showPageList : false,
				checkOnSelect:true,
				selectOnCheck:true,
				columns : [ [ {
				    field:'ck',
					checkbox:true,
				},{
					field : 'roles_name',
					title : '角色名',
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
							url : 'user/getRole?id='+a,
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
			        if(item.roles_name==c[i].roles_name){
			        $('#tt').datagrid('checkRow', index);
			        }
			        }
			        });
			        }
			        }                   
			});
		}
         
        function saveUser(){
         var position = $('#userPosition').combobox('getValue');
         var status = $('#status').combobox('getValue');
         var url;
          url = "user/updateUser"+"?userPosition="+position+"&status="+status;
            $('#fm').form('submit',{
                url: "user/updateUser",
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