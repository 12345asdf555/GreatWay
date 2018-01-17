/**
 * 
 */
		$(function(){
 			   $.ajax({
 			   type: "post", 
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
                    window.location.href = encodeURI("/Jin/wps/AllWps");
                    }
                }
            });
        }
        