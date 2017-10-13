$(function(){
	$("#wid").next().hide();
})

function removeWeldingMachine(){
	var wid = $("#wid").val();
	$.messager.confirm('提示', '此操作不可撤销并同时删除其维修记录，是否确认删除?', function(flag) {
		if (flag) {
			$.ajax({  
		        type : "post",  
		        async : false,
		        url : "weldingMachine/removeWeldingMachine?wid="+wid,  
		        data : {},  
		        dataType : "json", //返回数据形式为json  
		        success : function(result) {
		            if (result) {
		            	if (!result.success) {
							$.messager.show( {
								title : 'Error',
								msg : result.msg
							});
						} else {
							$.messager.alert("提示", "删除成功！");
							var url = "weldingMachine/goWeldingMachine";
							window.location.href = encodeURI(url);
						}
		            }  
		        },  
		        error : function(errorMsg) {  
		            alert("数据请求失败，请联系系统管理员!");  
		        }  
		   }); 
		}
	});
}