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
		
			$(function(){
				var we=8;
 			   $.ajax({
 			   type: "post", 
 			   url: "welders/getLeve?we="+we,
 			   dataType: "json",
 			   data: {},
 			   success: function (result) {
 			      if (result) {
 			         var optionstring = "";
 			         optionstring = "<option value='请选择'>请选择...</option>";
 			         //循环遍历 下拉框绑定
 			         for(var k=0;k<result.rows.length;k++){
 			         optionstring += "<option value=\"" + result.rows[k].leveid + "\" >" + result.rows[k].levename + "</option>";
 			         }
 			         $("#leveid").html(optionstring);
 			      } else {
 			         alert('部门加载失败');
 			      }
 			      $("#leveid").combobox();
 			   },
 			   error: function () {
 			      alert('error');
 			   }
 			});
		})
		
		$(function(){
			var wee=7;
 			   $.ajax({
 			   type: "post", 
 			   url: "welders/getLeve?we="+wee,
 			   dataType: "json",
 			   data: {},
 			   success: function (result) {
 			      if (result) {
 			         var optionstring = "";
 			         optionstring = "<option value='请选择'>请选择...</option>";
 			         //循环遍历 下拉框绑定
 			         for(var k=0;k<result.rows.length;k++){
 			         optionstring += "<option value=\"" + result.rows[k].quaid + "\" >" + result.rows[k].quaname + "</option>";
 			         }
 			         $("#quali").html(optionstring);
 			      } else {
 			         alert('部门加载失败');
 			      }
 			      $("#quali").combobox();
 			   },
 			   error: function () {
 			      alert('error');
 			   }
 			});
		})

        $("#fm").form("disableValidation");
 		var flag = 1; 
        function saveWelder(){
        flag = 1;
        var insframework = $('#Fowner').combobox('getValue');
        var leve = $('#leveid').combobox('getValue');
        var qua = $('#quali').combobox('getValue');
         var url;
          url = "welders/addWelder"+"?ins="+insframework+"&leve="+leve+"&qua="+qua;
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
                    window.location.href = encodeURI("/Jin/welders/AllWelder");
                    }
                }
            });
        }
        