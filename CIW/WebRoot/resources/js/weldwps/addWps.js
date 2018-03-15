/**
 * 
 */
		$(function(){
 			   $.ajax({
 			   type: "post", 
 		       async : false,
 			   url: "user/getIns",
 			   dataType: "json",
 			   data: {},
 			   success: function (result) {
 			      if (result) {
 			         var optionstring = "";
 			         optionstring = "<option value='请选择'>请选择...</option>";
 			         //循环遍历 下拉框绑定
 			         for(var k=0;k<result.rows.length;k++){
 			         optionstring += "<option value=\"" + result.rows[k].insid + "\" >" + result.rows[k].insname + "</option>";
 			         }
 			         $("#Fowner").html(optionstring);
 			      } else {
 			         alert('部门加载失败');
 			      }
 			      $("#Fowner").combobox();
 			   },
 			   error: function () {
 			      alert('error');
 			   }
 			});
 			$("#fm").form("disableValidation");
		})

        $("#fm").form("disableValidation");
 		var flag = 1; 
        function saveWps(){
        flag = 1;
        var fwn = $('#FWPSNum').val();
        var insframework = $('#Fowner').combobox('getValue');
         var url;
          url = "wps/addWps"+"?ins="+insframework+"&fwn="+fwn;
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
					var url = "wps/AllWps";
					var img = new Image();
				    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
				    url = img.src;  // 此时相对路径已经变成绝对路径
				    img.src = null; // 取消请求
					window.location.href = encodeURI(url);
                    }
                }
            });
        }
        