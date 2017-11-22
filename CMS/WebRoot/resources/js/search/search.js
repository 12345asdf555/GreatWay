var index = 0;
var searchStr = "";
var field="";
var condition="";
var content="";
var joint = "";
var flag = true;
//组织机构进入查询
function insertSearchInsf(){
	$("#searchdiv").dialog("open");
	searchInsfCombobox();
	initSearch();
}

//组织机构下拉框
function searchInsfCombobox(){
	var optionFields = 
		"<option value='fname'>名称</option>" +
		"<option value='flogogram'>简写</option>" +
		"<option value='fcode'>编码</option>" +
		"<option value='fparent'>上级项目</option>" +
		"<option value='ftype'>类型</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

//新增组织机构查询条件
function newSearchInsf(){
	fillcontent();
	newSearch();
	searchInsfCombobox();
	initSearch();
}

//组织机构执行查询
function searchInsf(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#insframeworkTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

//新增采集模块查询条件
function newSearchGather(){
	fillcontent();
	newSearch();
	searchGatherCombobox();
	initSearch();
}

//采集模块进入查询
function insertSearchGather(){
	$("#searchdiv").dialog("open");
	searchGatherCombobox();
	initSearch();
}
//采集模块下拉框
function searchGatherCombobox(){
	var optionFields = 
		"<option value='fgather_no'>采集模块编号</option>" +
		"<option value='fstatus'>采集模块状态</option>" +
		"<option value='fprotocol'>采集模块通讯协议</option>" +
		"<option value='fipurl'>采集模块IP地址</option>" +
		"<option value='fmacurl'>采集模块MAC地址</option>" +
		"<option value='fleavetime'>采集模块出厂时间</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

//新增采集模块查询条件
function newSearchGather(){
	fillcontent();
	newSearch();
	searchGatherCombobox();
	initSearch();
}

//采集模块执行查询
function searchGather(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#gatherTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

//新增焊接设备查询条件
function newSearchWeldingMachine(){
	fillcontent();
	newSearch();
	searchWeldingMachineCombobox();
	initSearch();
}

//焊接设备下拉框
function searchWeldingMachineCombobox(){
	var optionFields = 
		"<option value='fequipment_no'>固定资产编号</option>" +
		"<option value='ftype_id'>设备类型</option>" +
		"<option value='fjoin_time'>入厂时间</option>" +
		"<option value='i.fname'>所属项目</option>" +
		"<option value='fstatus_id'>状态</option>" +
		"<option value='m.fname'>厂家</option>" +
		"<option value='fisnetworking'>是否在网</option>" +
		"<option value='fposition'>位置</option>" +
		"<option value='fgather_id'>采集序号</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

//焊机设备进入查询dialog
function insertSearchWeldingMachine(){
	$("#searchdiv").dialog("open");
	searchWeldingMachineCombobox();
	initSearch();
}

//焊机设备执行查询
function searchWeldingmachine(e){
	fillcontent();
	for(var i=0;i<=index;i++){
		var fieldId =$(".fields").eq(i).attr("id");
		var field = $("#"+fieldId+"").combobox('getValue');
		var conditionId =$(".condition").eq(i).attr("id");
		var condition = $("#"+conditionId+"").combobox('getValue');
		var contentId =$(".content").eq(i).attr("id");
		var content = $("#"+contentId+"").val();
		var jointId =$(".joint").eq(i).attr("id");
		var joint = $("#"+jointId+"").combobox('getValue');
		if(field=="fisnetworking"){
			if(content=="是"){
				content="0";
			}else if(content=="否"){
				content=1;
			}else{
				content="9999";
			}
		}
		//如果类型发生变化，需要修改这里的值
		if(field=="ftype_id"){
			if(content=="氩弧焊"){
				content=41;
			}else if(content=="手工焊"){
				content=42;
			}else if(content=="气保焊"){
				content=43;
			}else if(content=="埋弧焊"){
				content=44;
			}else{
				contend="9999";
			}
		}
		//如果类型发生变化，需要修改这里的值
		if(field=="fstatus_id"){
			if(content=="启用"){
				content=31;
			}else if(content=="停用"){
				content=32;
			}else if(content=="维护中"){
				content=33;
			}else{
				contend="9999";
			}
		}
		if(field==null || field=="" || condition==null || condition=="" || content==null || content==""){
			alert('请输入完整的查询条件！');
			e.preventDefault();//取消事件的默认动作，return false的一部分，但是避免了return false带来的隐患
		}
		if(joint==null || joint==""){
			joint = "and";
		}
		if(condition == "like"){
			content = "%"+content+"%";
		}
		if(i==index){
			searchStr +=" "+field+" "+condition+" '"+content+"'";
		}else{
			searchStr +=" "+field+" "+condition+" '"+content+"' "+joint;
		}
	}
	$('#weldingmachineTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr = "";
}
	

//新增维修记录查询条件
function newSearchMaintain(){
	fillcontent();
	newSearch();
	searchMaintainCombobox();
	initSearch();
}

//维修记录下拉框
function searchMaintainCombobox(){
	var optionFields = 
		"<option value='fequipment_no'>固定资产编号</option>" +
  		"<option value='r.ftype_id'>维修类型</option>" +
  		"<option value='fviceman'>维修人员</option>" +
  		"<option value='fdesc'>维修说明</option>" +
  		"<option value='fstart_time'>维修起始时间</option>" +
  		"<option value='fend_time'>维修结束时间</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

//维修记录进入查询dialog
function insertSearchMaintain(){
	$("#searchdiv").dialog("open");
	searchMaintainCombobox();
	initSearch();
}

//维修记录执行查询
function searchMaintain(e){
	fillcontent();
	for(var i=0;i<=index;i++){
		var fieldId =$(".fields").eq(i).attr("id");
		var field = $("#"+fieldId+"").combobox('getValue');
		var conditionId =$(".condition").eq(i).attr("id");
		var condition = $("#"+conditionId+"").combobox('getValue');
		var contentId =$(".content").eq(i).attr("id");
		var content = $("#"+contentId+"").val();
		var jointId =$(".joint").eq(i).attr("id");
		var joint = $("#"+jointId+"").combobox('getValue');
		if(field=="r.ftype_id"){
			if(content=="日常维修"){
				content=51;
			}else if(content=="二级保养"){
				content=52;
			}else if(content=="大修"){
				content=53;
			}else{
				content="9999";
			}
		}
		if(field==null || field=="" || condition==null || condition=="" || content==null || content==""){
			alert('请输入完整的查询条件！');
			e.preventDefault();//取消事件的默认动作，return false的一部分，但是避免了return false带来的隐患
		}
		if(joint==null || joint==""){
			joint = "and";
		}
		if(condition == "like"){
			content = "%"+content+"%";
		}
		if(i==index){
			searchStr +=" "+field+" "+condition+" '"+content+"'";
		}else{
			searchStr +=" "+field+" "+condition+" '"+content+"' "+joint;
		}
	}
	$('#maintainTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

//新增焊工查询条件
function newSearchWelder(){
	fillcontent();
	newSearch();
	searchWelderCombobox();
	initSearch();
}

function newSearchUser(){
	fillcontent();
	newSearch();
	searchUserCombobox();
	initSearch();
}

function newSearchRole(){
	fillcontent();
	newSearch();
	searchRoleCombobox();
	initSearch();
}

function newSearchAuthority(){
	fillcontent();
	newSearch();
	searchAuthorityCombobox();
	initSearch();
}

function newSearchResource(){
	fillcontent();
	newSearch();
	searchResourceCombobox();
	initSearch();
}

//焊工信息下拉框
function searchWelderCombobox(){
	var optionFields = 
  		"<option value='fname'>名称</option>" +
  		"<option value='fwelder_no'>编号</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

function searchUserCombobox(){
	var optionFields = "<option value='users_name'>用户名</option>" +
  		"<option value='users_Login_Name'>登录名</option>" +
  		"<option value='users_phone'>电话</option>"+
  		"<option value='users_email'>邮箱</option>" +
  		"<option value='users_insframework'>岗位</option>" +
  		"<option value='users_position'>部门</option>" +
  		"<option value='status'>状态</option>" ;
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

function searchRoleCombobox(){
	var optionFields = "<option value='roles_name'>角色名</option>" +
  		"<option value='users_desc'>描述</option>"+
  		"<option value='status'>状态</option>" ;
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

function searchAuthorityCombobox(){
	var optionFields = "<option value='authorities_name'>权限名</option>" +
  		"<option value='authorities_desc'>描述</option>"+
  		"<option value='status'>状态</option>" ;
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

function searchResourceCombobox(){
	var optionFields = "<option value='resources_name'>资源名</option>" +
  		"<option value='resources_type'>类型</option>"+
  		"<option value='resources_address'>地址</option>" +
  		"<option value='resources_desc'>描述</option>" +
  		"<option value='status'>状态</option>" ;
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}

//焊工信息进入查询dialog
function insertSearchWelder(){
	$("#searchdiv").dialog("open");
	searchWelderCombobox();
	initSearch();
}

function insertSearchUser(){
	$("#searchdiv").dialog("open");
	searchUserCombobox();
	initSearch();
}

function insertSearchRole(){
	$("#searchdiv").dialog("open");
	searchRoleCombobox();
	initSearch();
}

function insertSearchAuthority(){
	$("#searchdiv").dialog("open");
	searchAuthorityCombobox();
	initSearch();
}

function insertSearchResource(){
	$("#searchdiv").dialog("open");
	searchResourceCombobox();
	initSearch();
}


//焊工信息执行查询
function searchWelder(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#welderTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

function searchUser(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

function searchRole(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

function searchAuthority(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

function searchResource(){
	fillcontent();
	if(!getContent()){
		return;
	}
	$('#dg').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}

//新增焊口查询条件
function newSearchWJ(){
	fillcontent();
	newSearch();
	searchWJCombobox();
	initSearch();
}

//焊口下拉框
function searchWJCombobox(){
	var optionFields = 
		"<option value='fwelded_junction_no'>编号</option>" +
		"<option value='fserial_no'>序列号</option>" +
		"<option value='fpipeline_no'>管线号</option>" +
		"<option value='froom_no'>房间号</option>" +
		"<option value='funit'>机组</option>" +
		"<option value='farea'>区域</option>" +
		"<option value='fsystems'>系统</option>" +
		"<option value='fchildren'>子项</option>" +
		"<option value='fexternal_diameter'>外径</option>" +
		"<option value='fwall_thickness'>壁厚</option>" +
		"<option value='fdyne'>达因</option>" +
		"<option value='fspecification'>规格</option>" +
		"<option value='fmax_electricity'>电流上限</option>" +
		"<option value='fmin_electricity'>电流下限</option>" +
		"<option value='fmax_valtage'>电压上限</option>" +
		"<option value='fmin_valtage'>电压下限</option>" +
		"<option value='fstart_time'>开始时间</option>" +
		"<option value='fend_time'>完成时间</option>" +
		"<option value='fcreatetime'>创建时间</option>" +
		"<option value='	fupdatetime'>修改时间</option>" +
		"<option value='fupdatecount'>修改次数</option>";
	$(".fields").html(optionFields);
	$(".fields").combobox();
	createSearchCombobox();
}


//进入焊口查询
function insertsearchWJ(){
	$("#searchdiv").dialog("open");
	searchWJCombobox();
	initSearch();
}

//焊口执行查询
function searchWJ(){
	fillcontent();
	if(!getContent()){
		return; 
	}
	$('#weldedJunctionTable').datagrid('load', {
		"searchStr" : searchStr
	});
	$("#searchdiv").dialog("close");
	searchStr="";
}


//----------------------------------------------------
//删除查询条件
function removeSerach(e){
	if(index == 0){
		e.preventDefault();//取消事件的默认动作，return false的一部分，但是避免了return false带来的隐患
	}
	$("#div"+index).remove();
	index -= 1;
}

//下拉框赋值
function createSearchCombobox(){
	var optionCondition = "<option value='>'>大于</option>" +
			"<option value='<'>小于</option>" +
			"<option value='='>等于</option>" +
			"<option value='like'>包含</option>";
	$(".condition").html(optionCondition);
	$(".condition").combobox();
	
	var optionJoint = "<option value='and'>并且</option>" +
			"<option value='or'>或者</option>";
	$(".joint").html(optionJoint);
	$(".joint").combobox();
}

function fillcontent(){
	field="";
	condition="";
	content="";
	joint = "";
	//此处用来处理页面点击+按钮后自动清空已添加好的条件
	for(var i=0;i<=index;i++){
		var fieldId =$(".fields").eq(i).attr("id");
		field += $("#"+fieldId+"").combobox('getValue')+",";
		var conditionId =$(".condition").eq(i).attr("id");
		condition += $("#"+conditionId+"").combobox('getValue')+",";
		var contentId =$(".content").eq(i).attr("id");
		content += $("#"+contentId+"").val()+",";
		var jointId =$(".joint").eq(i).attr("id");
		joint += $("#"+jointId+"").combobox('getValue')+",";
	}
}

function newSearch(){
	index += 1;
	var str = "<div style='margin-top:5px' id='div"+index+"'>" +
			"<select class='fields' id='fields"+index+"'></select>&nbsp;" +
			"<select class='condition' id='condition"+index+"'></select>&nbsp;" +
			"<input class='content' id='content"+index+"'/>&nbsp;" +
			"<select class='joint' id='joint"+index+"'></select><div/>";
	$("#searchdiv").append(str);
}

function initSearch(){
	for(var i=0;i<=index;i++){
		var fid = field.split(",");
		var fieldId =$(".fields").eq(i).attr("id");
		$("#"+fieldId+"").combobox('setValue',fid[i]);
		var cnid = condition.split(",");
		var conditionId =$(".condition").eq(i).attr("id");
		$("#"+conditionId+"").combobox('setValue',cnid[i]);
		var ctid = content.split(",");
		var contentId =$(".content").eq(i).attr("id");
		$("#"+contentId+"").val(ctid[i]);
		var jid = joint.split(",");
		var jointId =$(".joint").eq(i).attr("id");
		$("#"+jointId+"").combobox('setValue',jid[i]);
	}
}

//获取值
function getContent(e){
	for(var i=0;i<=index;i++){
		var fieldId =$(".fields").eq(i).attr("id");
		var field = $("#"+fieldId+"").combobox('getValue');
		var conditionId =$(".condition").eq(i).attr("id");
		var condition = $("#"+conditionId+"").combobox('getValue');
		var contentId =$(".content").eq(i).attr("id");
		var content = $("#"+contentId+"").val();
		var jointId =$(".joint").eq(i).attr("id");
		var joint = $("#"+jointId+"").combobox('getValue');
		if(field==null || field=="" || condition==null || condition=="" || content==null || content==""){
			alert('请输入完整的查询条件！');
			e.preventDefault();//取消事件的默认动作，return false的一部分，但是避免了return false带来的隐患
		}
		if(joint==null || joint==""){
			joint = "and";
		}
		if(condition == "like"){
			content = "%"+content+"%";
		}
		if(i==index){
			searchStr +=" "+field+" "+condition+" '"+content+"'";
		}else{
			searchStr +=" "+field+" "+condition+" '"+content+"' "+joint;
		}
	}
	return true;
}
//关闭查询div
function close(){
	$('#searchdiv').dialog('close');
}
