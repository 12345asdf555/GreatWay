$(function(){
	updatetext();
	protocolCombobox();
	statusCombobox();
	$("#fm").form("disableValidation");
})


var url = "";
var flag = 1;
function addGather(){
	flag = 1;
	url = "gather/addGather";
	saveGather();
}

function editGather(){
	flag = 2;
	var id = $("#id").val();
	url = "gather/editGather?id="+id;
	saveGather();
}
//提交
function saveGather(){
	var status = $("#status").combobox('getValue');
	var protocol = $("#protocol").combobox('getValue');
	var url2 = "";
	if(flag==1){
		messager = "新增成功！";
		url2 = url;
	}else{
		messager = "修改成功！";
		url2 = url;
	}
	$('#fm').form('submit', {
		url : url2,
		onSubmit : function() {
			return $(this).form('enableValidation').form('validate');
		},
		success : function(result) {
			if(result){
				var result = eval('(' + result + ')');
				if (!result.success) {
					$.messager.show( {
						title : 'Error',
						msg : result.errorMsg
					});
				} else {
					$.messager.alert("提示", messager);
					var url = "gather/goGather";
					var a = document.createElement('A');
					a.href = url;  // 设置相对路径给Image, 此时会发送出请求
					url = a.href;  // 此时相对路径已经变成绝对路径
					window.location.href = encodeURI(url);
				}
			}
			
		},  
	    error : function(errorMsg) {  
	        alert("数据请求失败，请联系系统管理员!");  
	    } 
	});
}

function updatetext(){
	//隐藏文本框
	$("#id").next().hide();
	$("#validgatherno").next().hide();
}

//采集模块状态
function statusCombobox(){
    var optionStr = '';
    optionStr += "<option value='正常'>正常</option>"+
    		"<option value='维修'>维修</option>";  
    $("#status").html(optionStr);
	$("#status").combobox();
}

//采集模块通讯协议
function protocolCombobox(){
    var optionStr = ''; 
    optionStr += "<option value='串口'>串口</option>"+
    		"<option value='zigbee'>zigbee</option>"+
    		"<option value='wifi'>wifi</option>";  
  
    $("#protocol").html(optionStr);
	$("#protocol").combobox();
}

