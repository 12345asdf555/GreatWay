/**
 * 
 */
        $(function(){
	    $("#tt").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'resources_name',
		url : "authority/getAllResource",
		rownumbers : false,
		showPageList : false,
		checkOnSelect:true,
		selectOnCheck:true,
		columns : [ [ {
		    field:'ck',
			checkbox:true,
		},{
			field : 'id',
			title : 'id',
			width : 100,
			halign : "center",
			align : "left",
			hidden:true
		},{
			field : 'resources_name',
			title : '权限名',
			width : 100,
			halign : "center",
			align : "left"
		}]],
		
	});
})

        function saveAuthority(){
         var status = $('#status').combobox('getValue');
         var rows = $("#tt").datagrid("getSelections");
         var str="";
		for(var i=0; i<rows.length; i++){
			str += rows[i].id+",";
			}
         var url;
          url = "authority/addAuthority"+"?status="+status+"&rid="+str;
            $('#fm').form('submit',{
                url: url,
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