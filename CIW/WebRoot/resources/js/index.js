$(function(){
	getUserInsframework();
	addTab("欢迎使用","welcome.jsp");
	tabsIncident();
})

function getUserInsframework(){
	$.ajax({
		type : "post",
		async : true,
		url : "hierarchy/getUserInsframework",
		data : {},
		dataType : "json",
		success : function(result){
			var str = "<span>"+result.uname+"</span>";
			$("#username").append(str);
		},
		error : function(errorMsg){
			alert("数据请求失败，请联系系统管理员!");
		}
	})
}

function openUser(){
	addTab("用户管理","user/AllUser");
}

function openRole(){
	addTab("角色管理","role/AllRole");
}

function openAuthority(){
	addTab("权限管理","authority/AllAuthority");
}

function openResource(){
	addTab("资源管理","resource/AllResource");
}

function openInsframework(){
	addTab("组织机构管理","insframework/goInsframework");
}

function openDictionary(){
	addTab("字典管理",'Dictionary/goDictionary');
}

function openCompanytEfficiency(){
	addTab("焊工工效","companyChart/goCompanyEfficiency");
}

function openCompanyUse(){
	addTab("单台设备运行数据统计","companyChart/goCompanyUse");
}
function openMachine(){
	addTab("维修记录管理","maintain/goMaintain");
}

function openCompanyovertime(){
	addTab("超时待机统计","companyChart/goCompanyOvertime");
}
function openCompanyIdle(){
	addTab("设备闲置率","companyChart/goCompanyIdle");
}
function openWeldParameter(){
	addTab("焊接参数维度表","rep/weldpara");
}

function openWireUse(){
	addTab("焊丝用量维度表","rep/wireuse");
}

function openWelderReport(){
	addTab("焊工维度表","rep/welderreport");
}

function openParameter(){
	addTab("参数设置","Dictionary/goParameter");
}

function openProduct(){
	addTab("产品管理","product/AllProduct");
}

function openWps(){
	addTab("工艺管理","wps/AllWps");
}

function openWeldingmachineMax(){
	addTab("焊机工时最高","companyChart/goCompanyWmMax");
}

function openWeldingmachineMin(){
	addTab("焊机工时最低","companyChart/goCompanyWmMin");
}

function openWelderMax(){
	addTab("焊工工时最高","companyChart/goCompanyWelderMax");
}

function openWelderMin(){
	addTab("焊工工时最低","companyChart/goCompanyWelderMin");
}

function openWeldingMachine(){
	addTab("焊机设备管理","weldingMachine/goWeldingMachine");
}

function openWedJunction(){
	addTab("焊缝管理","weldedjunction/goWeldedJunction");
}

function openPerson(){
	addTab("焊工管理","welders/AllWelder");
}

function openGather(){
	addTab("采集模块管理","gather/goGather");
}

function openCompanyHour(){
	addTab("焊缝焊接工时","companyChart/goCompanyHour");
}

function openCompanyoverproof(){
	addTab("焊接工艺超标","companyChart/goCompanyOverproof");
}

function openCompanyLoads(){
	addTab("设备负荷率","companyChart/goCompanyLoads");
}

function openCompanyNoLoads(){
	addTab("设备空载率","companyChart/goCompanyNoLoads");
}

function openCompanyTd(){
	window.open("td/AllTd");
}

function openHistory(){
	addTab("历史曲线","rep/history");
}

function addTab(title,url){
	//该面板是否已打开
	if(!$("#tabs").tabs('exists',title)){
		$("#tabs").tabs('add',{    
		    title:title,
		    content:createFrame(url),    
		    closable:true 
		});
	}else{
		$("#tabs").tabs('select',title);
	}
	// 为选项卡绑定右键
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#tabMenu').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#tabMenu').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
	
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}


//标签页事件
function tabsIncident(){
	//刷新
	$('#refreshtab').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		})
	})
	//关闭标签页
	$("#closetab").click(function(){
		var currtab_title = $('#tabMenu').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	})
	// 全部关闭
	$('#closeAll').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tabs').tabs('close', t);
		});
	});
	// 关闭其他标签页
	$('#closeOther').click(function() {
		$("#closeRight").click();
		$('#closeLeft').click();
	});
	//关闭右侧标签页
	$('#closeRight').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
	})
	//关闭左侧标签页
	$('#closeLeft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
	});
}

//选中时改变背景颜色
function changeColor(obj){
	$("ul li").css("backgroundColor","#ffffff");
	obj.style.background = "#fecf5d";
}

