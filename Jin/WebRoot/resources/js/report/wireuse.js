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
		
		var chartStr = "";
		function setParam(){
			var parent = $("#parent").val();
			var otype = $("input[name='otype']:checked").val();
			var dtoTime1 = $("#dtoTime1").datetimebox('getValue');
			var dtoTime2 = $("#dtoTime2").datetimebox('getValue');
			chartStr = "?otype="+otype+"&parent="+parent+"&dtoTime1="+dtoTime1+"&dtoTime2="+dtoTime2;
		}
		
		function serachCompanyOverproof(){
			chartStr = "";
			wireuse();
		}
		
		$(function(){
			wireuse();
		})
		
       function wireuse(){
    	setParam();
	    $("#dg").datagrid( {
		fitColumns : true,
		height : ($("#body").height()),
		width : $("#body").width(),
		idField : 'id',
		toolbar : "#toolbar",
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : "rep/getWireUse"+chartStr,
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
			field : 'machinestatus',
			title : '焊机状态',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'machinemodel',
			title : '焊机型号',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'diameter',
			title : '焊丝直径',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'speed',
			title : '送丝速度',
			width : 100,
			halign : "center",
			align : "left"
		}, {
			field : 'currentwelder',
			title : '当前焊工',
			width : 100,
			halign : "center",
			align : "left"
        }, {
			field : 'weldingtime',
			title : '焊接时间',
			width : 100,
			halign : "center",
			align : "left"
        }, {
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
    }

        function insframeworkTree(){
        	$("#myTree").tree({  
        		onClick : function(node){
        			$("#dg").datagrid('load',{
        				"insid" : node.id
        			})
        		 }
        	})
        }
        
    	$(function(){
			   $.ajax({
			   type: "post", 
			   url: "user/getIns",
			   dataType: "json",
			   data: {},
			   success: function (result) {
			      if (result) {
			         var optionstring = "";
			         optionstring = "<option value='请选择...'>请选择...</option>";
			         //循环遍历 下拉框绑定
			         for(var k=0;k<result.rows.length;k++){
			         optionstring += "<option value=\"" + result.rows[k].insid + "\" >" + result.rows[k].insname + "</option>";
			         }
			         $("#division").html(optionstring);
			      } else {
			         alert('车间号加载失败');
			      }
			      $("#division").combobox();
			      var data = $('#division').combobox('getData');
			      $("#division ").combobox('select',data[0].value);
			   },
			   error: function () {
			      alert('error');
			   }
			});
	})
	
		$(document).ready(function () {
			$("#division").combobox({
				onChange: function (n,o) {
				if(n!="请选择..."){
    			$("#dg").datagrid('load',{
    				"insid" : n
    			})
				}
				}
			});
		});
        
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