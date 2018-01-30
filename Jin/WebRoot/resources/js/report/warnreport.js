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
		}, {
			field : 'currentwelder',
			title : '焊工姓名',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'warninfo',
			title : '报警信息',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'boottime',
			title : '开始时间',
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
			title : '持续时间',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'ele',
			title : '电流',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'vol',
			title : '电压',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'option',
			title : '操作',
			width : 130,
			halign : "center",
			align : "left",
			formatter:function(value,row,index){
			var str = "";
			str += '<a id="option" class="easyui-linkbutton" href="javascript:"/>';
			return str;
			}
		}]],
		toolbar : '#toolbar',
		onLoadSuccess:function(data){
	        $("a[id='option']").linkbutton({text:'停机',plain:true,iconCls:'icon-Role'});
	        }
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