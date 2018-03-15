/**
 * 
 */
		$(function(){
			$("#fm").form("disableValidation");
		 })
 		var flag = 1; 
        function saveProduct(){
        flag = 1;
         var url;
          url = "product/addProduct";
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
					var url = "product/AllProduct";
					var img = new Image();
				    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
				    url = img.src;  // 此时相对路径已经变成绝对路径
				    img.src = null; // 取消请求
					window.location.href = encodeURI(url);
                    }
                }
            });
        }
