/**
 * 
 */
		var flag = 2;
		 function saveProcess(){
		 flag = 2;
		 var id = $('#id').val();
         var url;
          url = "product/destroyProcess"+"?id="+id;
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
              			$.messager.alert("提示", "删除成功");
                    	window.location.href = encodeURI("/Jin/product/AllProcess");
                    }
                }
            });
        }