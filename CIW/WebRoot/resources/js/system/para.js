/**
 * 
 */

	
	$(function(){
		$.ajax({  
		    type : "post",  
		    async : false,
		    url : "pmt/getParameterAll",  
		    data : {},  
		    dataType : "json", //返回数据形式为json  
		    success : function(result) {
		    	var res = eval(result.rows);
		    	for(var i=0;i<res.length;i++){
		    		document.getElementById("id").value=res[i].id;
		    		document.getElementById("companyName").value=res[i].fcn;
	    			if(res[i].fvv=="0"){
	    				$("#term1").attr("checked",true);
	    				}else{
	    					$("#term2").attr("checked",true);
	    				}
	    			var time1=res[i].fst.split(':');
	    			document.getElementById("hour1").value=time1[0];
	    			document.getElementById("minute1").value=time1[1];
	    			document.getElementById("second1").value=time1[2];
	    			var time2=res[i].fsft.split(':');
	    			document.getElementById("hour2").value=time2[0];
	    			document.getElementById("minute2").value=time2[1];
	    			document.getElementById("second2").value=time2[2];
	    			var time3=res[i].fct.split(':');
	    			document.getElementById("hour3").value=time3[0];
	    			document.getElementById("minute3").value=time3[1];
	    			document.getElementById("second3").value=time3[2];
	    			document.getElementById("times").value=res[i].folt;
	    			var weight=res[i].fww.split(',');
	    			document.getElementById("one").value=weight[0];
	    			document.getElementById("two").value=weight[1];
	    			document.getElementById("six").value=weight[2];
	    			document.getElementById("eight").value=weight[3];
	    			document.getElementById("airflow").value=res[i].fafv;
	    			document.getElementById("speed").value=res[i].fspeed;
	    			document.getElementById("weld").value=res[i].fwc;
	    			document.getElementById("wait").value=res[i].fsp;
	    			document.getElementById("day").value=res[i].fds;
	    			document.getElementById("after").value=res[i].fas;
	    			document.getElementById("night").value=res[i].fns;
		    	}
		    },  
		    error : function(errorMsg) {  
		        alert("数据请求失败，请联系系统管理员!");  
		        }  
		   }); 
		
		$(document).ready(function(){
		    $('#fm').find('input[type=checkbox]').bind('click', function(){
		        $('#fm').find('input[type=checkbox]').not(this).attr("checked", false);
		    });
		});
	})
	
	function savePara(){
        $("#fm").form("disableValidation");
        var id = document.getElementById("id").value;
        var check=$("input[type='checkbox']:checked").val(); 
        var url;
        url = "pmt/editParameter?check="+check+"&id="+id;
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
					var url = "Dictionary/goParameter";
					var img = new Image();
				    img.src = url;  // 设置相对路径给Image, 此时会发送出请求
				    url = img.src;  // 此时相对路径已经变成绝对路径
				    img.src = null; // 取消请求
					window.location.href = encodeURI(url);
                    }
                }
            });
        }
	