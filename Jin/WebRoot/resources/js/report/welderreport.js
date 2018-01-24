/**
 * 
 */
        $(function(){
        	var width = $("#treeDiv").width();
    		$(".easyui-layout").layout({
    			onCollapse:function(){
    				$("#dg").datagrid({
    					height : $("#body").height(),
    					width : $("#body").width()
    				})
    			},
    			onExpand:function(){
    				$("#dg").datagrid({
    					height : $("#body").height(),
    					width : $("#body").width()
    				})
    			}
    		});
        	insframeworkTree();
		})   

       $(function(){
	    $("#dg").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'id',
		toolbar : "#toolbar",
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "user/getAllUser",
		singleSelect : true,
		rownumbers : true,
		pagination : true,
		showPageList : false,
		columns : [ [ {
			field : 'currentwelder',
			title : '焊工姓名',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'machinestatus',
			title : '焊机状态',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'phone',
			title : '手机号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'weldernum',
			title : '焊工号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'back',
			title : '备注信息',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'firsttime',
			title : '首次焊接时间',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'valuetime',
			title : '有效焊接时间',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'wsid',
			title : '车间号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'teamid',
			title : '班组号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'machineid',
			title : '焊机号',
			width : 100,
			halign : "center",
			align : "left"
		},{
			field : 'machinemodel',
			title : '焊机型号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'inspower',
			title : '瞬时功率',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'afv',
			title : '气流量',
			width : 100,
			halign : "center",
			align : "left"
        },{
			field : 'boottime',
			title : '开机时间',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'offtime',
			title : '关机时间',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'onlinetime',
			title : '在线时间',
			width : 100,
			halign : "center",
			align : "left"
        }]],
		toolbar : '#toolbar'
	});

})
        
        function insframeworkTree(){
        	$("#myTree").tree({  
        		onClick : function(node){
        			$("#dg").datagrid('load',{
        				"parent" : node.id
        			})
        		 }
        	})
        }

        //监听窗口大小变化
          window.onresize = function() {
          	setTimeout(domresize, 500);
          }

          //改变表格高宽
          function domresize() {
          	$("#dg").datagrid('resize', {
          		height : $("#body").height(),
          		width : $("#body").width()
          	});
          }