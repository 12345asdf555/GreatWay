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
			         $("#owner").html(optionstring);
			      } else {
			         alert('部门加载失败');
			      }
			      $("#owner").combobox();
			      $("#owner").combobox('select',document.getElementById("owners").value);
			   },
			   error: function () {
			      alert('error');
			   }
			});
		})
		
					$(function(){
				var we=6;
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
 			         $("#leve").html(optionstring);
 			      } else {
 			         alert('部门加载失败');
 			      }
 			      $("#leve").combobox();
 			      $("#leve").combobox('select',document.getElementById("leveid").value);
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
 			         $("#qua").html(optionstring);
 			      } else {
 			         alert('部门加载失败');
 			      }
 			      $("#qua").combobox();
 			      $("#qua").combobox('select',document.getElementById("quali").value);
 			   },
 			   error: function () {
 			      alert('error');
 			   }
 			});
		})
		
		var flag = 2;
		 function saveWps(){
		 flag = 2;
         var insframework = $('#owner').combobox('getValue');
         var leve = $('#leve').combobox('getValue');
         var qua = $('#qua').combobox('getValue');
          var url;
          url = "welders/updateWelder"+"?ins="+insframework+"&leve="+leve+"&qua="+qua;
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
                    	window.location.href = encodeURI("/Jin/welders/AllWelder");
                    }
                }
            });
        }
         