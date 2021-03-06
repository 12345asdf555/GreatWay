<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统参数</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/system/para.js"></script>

  </head>
  
  <body>
  	<form id="fm" method="post" data-options="novalidate:true">
    <div style="margin-bottom:10px;display: none;">
        <input name="id" id="id" class="easyui-textbox" type="hidden">
    </div>
	<div style="line-height:22px;height:22px;background:#7FFFD4; color:#000">
		<label>参数设置</label>
	</div>
  	<style>
		.fit{border:3px solid #7FFFD4}
	</style>
  	<div class="fit" style="line-height:22px;height:22px;">
    	<lable>公司名称：</lable>
        	<input name="companyName" id="companyName" type="text" data-options="required:true">
    </div>
    <div class="fit" style="height:44px;">
        <div style="height:22px;">
    	<label>监测电流电压限定值有效<input name="term1" id="term1" type="checkbox" value="0"/></label>
    	<label>超限停机有效<input name="term2" id="term2" type="checkbox" value="1"/></label></br>
    	</div>
    	<div style="height:22px;">
    	<label>基础停机时间：</label>
    	<input name="hour1" id="hour1" type="text" style="width:50px;" data-options="required:true"/>
    	<label>时</label>
    	<input name="minute1" id="minute1" type="text" style="width:50px;" data-options="required:true"/>
    	<label>分</label>
    	<input name="second1" id="second1" type="text" style="width:50px;" data-options="required:true"/>
    	<label>秒</label>
    	<label>最大停机浮动时间：</label>
    	<input name="hour2" id="hour2" type="text" style="width:50px;" data-options="required:true"/>
    	<label>时</label>
    	<input name="minute2" id="minute2" type="text" style="width:50px;" data-options="required:true"/>
    	<label>分</label>
    	<input name="second2" id="second2" type="text" style="width:50px;" data-options="required:true"/>
    	<label>秒</label>
    	</div>
    </div>
    <div class="fit" style="height:44px;">
    
    	<lable>超限监测：</lable></br>
    	<lable>连续 [</lable>
       	<input name="hour3" id="hour3" type="text" style="width:50px;" data-options="required:true"/>
    	<label>时</label>
    	<input name="minute3" id="minute3" type="text" style="width:50px;" data-options="required:true"/>
    	<label>分</label>
    	<input name="second3" id="second3"type="text" style="width:50px;" data-options="required:true"/>
    	<label>秒 ]内，最大超限次数 </label>
    	<input name="times" id="times" type="text" style="width:50px;" data-options="required:true"/>
    </div>
    <div class="fit" style="height:44px;">
    	<div style="height:22px;">
    	<lable>焊丝重量：</lable>
    	</div>
    	<div style="height:22px;">
    	<lable>1.0</lable>
       	<input name="one" id="one" type="text" style="width:150px;" data-options="required:true"/>
    	<label>Kg/m 1.2</label>
    	<input name="two" id="two" type="text" style="width:150px;" data-options="required:true"/>
    	<label>Kg/m 1.6</label>
    	<input name="six" id="six" type="text" style="width:150px;" data-options="required:true"/>
    	<label>Kg/m 0.8</label>
    	<input name="eight" id="eight" type="text" style="width:150px;" data-options="required:true"/>
    	<label>Kg/m</label>
    	</div>
    </div>
    <div class="fit" style="height:110px;">
    	<div style="height:22px;">
    	<lable>汇总信息：</lable>
		</div>
		<div style="height:22px;">
    	<lable>气流量：</lable>
       	<input name="airflow" id="airflow" type="text" style="width:150px;" data-options="required:true"/>
    	<label>L/min</label>
    	</div>
    	<div style="height:22px;">
    	<lable>送丝速度：</lable>
    	<input name="speed" id="speed" type="text" style="width:150px;" data-options="required:true"/>
    	<label>m/min</label>
    	</div>
    	<div style="height:22px;">
    	<lable>焊接功率=焊接电流*焊接电压*</lable>
    	<input name="weld" id="weld" type="text" style="width:150px;" data-options="required:true"/>
    	</div>
    	<div style="height:22px;">
    	<lable>待机功率=</lable>
    	<input name="wait" id="wait" type="text" style="width:150px;" data-options="required:true"/>
    	<label>w</label>
    	</div>
    </div>
    <div style="line-height:22px;height:22px;background:#7FFFD4; color:#000">
		<label>班制：修改</label>
	</div>
	<div class="fit" style="height:88px;">
	<div style="height:22px;">
    	<lable>开始工作时间</lable>
    	</div>
    	<div style="height:22px;">
    	<lable>白班</lable>
       	<input name="day" id="day" type="text" style="width:150px;" data-options="required:true"/>
       	</div>
       	<div style="height:22px;">
    	<label>中班</label>
    	<input name="after" id="after" type="text" style="width:150px;" data-options="required:true"/>
    	</div>
    	<div style="height:22px;">
    	<label>夜班</label>
    	<input name="night" id="night" type="text" style="width:150px;" data-options="required:true"/>
    	</div>
    </div>
    <div class="fit" style="line-height:44px;height:44px;">
    	<input type="button" value="确定" style="width:50px;float:right" onclick="savePara();"/>
    </div>
    </form>
  </body>
</html>
