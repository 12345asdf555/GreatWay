/**
 * 
 */
        $("#fm").form("disableValidation");
 		var flag = 1; 
        function saveProcess(){
        flag = 1;
         var url;
          url = "product/addProcess";
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('enableValidation').form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
					$.messager.alert("提示", "新增成功");
                    window.location.href = encodeURI("/Jin/product/AllProcess");
                    }
                }
            });
        }