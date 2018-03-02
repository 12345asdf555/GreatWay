/**
 * 
 */
		var flag = 2;
		 function saveProduct(){
		 flag = 2;
		 var id = $('#id').val();
         var url;
          url = "product/updateProduct"+"?id="+id;
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
              			$.messager.alert("提示", "修改成功");
                    	window.location.href = encodeURI("/Jin/product/AllProduct");
                    }
                }
            });
        }