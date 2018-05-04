<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>实时界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/iconfont.css">
	
	<script type="text/javascript" src="resources/js/loading.js"></script>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/easyui-extend-check.js"></script>
	<script type="text/javascript" src="resources/js/highcharts.js"></script>
	<script type="text/javascript" src="resources/js/exporting.js"></script>
	<script type="text/javascript" src="resources/js/td/nextCurve.js"></script>

  </head>
  
<body class="easyui-layout">
	<div id="bodys" region="center"  hide="true"  split="true" title="实时界面" style="background: #eee; height: 335px;">
		<div class="x-component x-fieldset-header-text x-component-default" style="width:25%;height:25%;float:left;">点击示意图返回
			<img id="mrjpg" src="resources/images/WDgj.png" onclick="javascript:back()" width="100%" height="80%">
		</div>
		<div class="x-component x-fieldset-header-text x-component-default" style="width:50%;height:25%;float:left;">基本参数
			<table>
				<tbody>
					<tr>
						<td align="center" width="50%">
							<label id="la1">设备序号</label>
							<input id="in1" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">
						</td>
						<td align="center" width="50%">
							<label id="la2">设备编号</label>
							<input id="in2" value="${value}" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">
						</td>
					</tr>
					<tr>
						<td align="center" width="50%">
							<label id="la3">机型</label>
							<input id="in3" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">
						</td>
						<td id="td1" align="center" width="50%">
							<label id="la4">设备状态</label>
							<input id="in4" value="关机" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">
						</td>
					</tr>
					<tr>
						<td align="center" width="50%">
							<label id="la5">预置电流</label>
							<input id="in5" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">A
						</td>
						<td align="center" width="50%">
							<label id="la6">预置电压</label>
							<input id="in6" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">V
						</td>
					</tr>
					<tr>
						<td align="center" width="50%">
							<label id="la7">焊接电流</label>
							<input id="in7" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">A
						</td>
						<td align="center" width="50%">
							<label id="la8">焊接电压</label>
							<input id="in8" value="" type="text" disabled="true" style="text-align:center;color:#000000;width:160px;height:50px;font-size:20px;background-color:#EEEEEE;border:0px;">V
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="overflow-x: auto; overflow-y: auto;width:25%;height:95%;float:left;">属性列表
			<table>
			<tbody>
			<tr>
			<td align="center" width="50%">
			<label id="la9">关机时间:</label>
			</td>
			<td>
			<input id="in9">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la10">开机时间:</label>
			</td>
			<td>
			<input id="in10">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la11">焊接时间:</label>
			</td>
			<td>
			<input id="in11">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la12">工作时间:</label>
			</td>
			<td>
			<input id="in12">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la13">焊工:</label>
			</td>
			<td>
			<input id="in13">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la14">焊缝编号:</label>
			</td>
			<td>
			<input id="in14">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la15">当前通道:</label>
			</td>
			<td>
			<input id="in15">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la16">通道总数:</label>
			</td>
			<td>
			<input id="in16">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la17">报警代码:</label>
			</td>
			<td>
			<input id="in17">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la18">焊接控制:</label>
			</td>
			<td>
			<input id="in18">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la19">焊接方式:</label>
			</td>
			<td>
			<input id="in19">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la20">电焊时间:</label>
			</td>
			<td>
			<input id="in20">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la21">初期电流:</label>
			</td>
			<td>
			<input id="in21">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la22">收弧电流:</label>
			</td>
			<td>
			<input id="in22">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la23">工件温度:</label>
			</td>
			<td>
			<input id="in23">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la24">气体流量:</label>
			</td>
			<td>
			<input id="in24">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la25">瞬时功率:</label>
			</td>
			<td>
			<input id="in25">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la26">预置峰值电流:</label>
			</td>
			<td>
			<input id="in26">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la27">脉冲比率:</label>
			</td>
			<td>
			<input id="in27">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la28">脉冲频率:</label>
			</td>
			<td>
			<input id="in28">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la29">清洁宽度:</label>
			</td>
			<td>
			<input id="in29">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la30">AC频率:</label>
			</td>
			<td>
			<input id="in30">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la31">Mix频率:</label>
			</td>
			<td>
			<input id="in31">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la32">Mix(AC)频率:</label>
			</td>
			<td>
			<input id="in32">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la33">焊接方法:</label>
			</td>
			<td>
			<input id="in33">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la34">交流波形:</label>
			</td>
			<td>
			<input id="in34">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la35">提前送气时间:</label>
			</td>
			<td>
			<input id="in35">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la36">滞后停气时间:</label>
			</td>
			<td>
			<input id="in36">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la37">上升时间:</label>
			</td>
			<td>
			<input id="in37">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la38">下降时间:</label>
			</td>
			<td>
			<input id="in38">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la39">机器人模式:</label>
			</td>
			<td>
			<input id="in39">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la40">机器人运转状态:</label>
			</td>
			<td>
			<input id="in40">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la41">机器人程序名:</label>
			</td>
			<td>
			<input id="in41">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la42">机器人位置编码:</label>
			</td>
			<td>
			<input id="in42">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la43">机器人位置名称:</label>
			</td>
			<td>
			<input id="in43">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la44">机器人移动速度:</label>
			</td>
			<td>
			<input id="in44">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la45">机器人型号:</label>
			</td>
			<td>
			<input id="in45">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la46">制造编码:</label>
			</td>
			<td>
			<input id="in46">
			</td>
			</tr>
						<tr>
			<td align="center" width="50%">
			<label id="la47">软件版本:</label>
			</td>
			<td>
			<input id="in47">
			</td>
			</tr>
			</tbody>
			</table>		
		</div>
		<div class="x-component x-fieldset-header-text x-component-default" style="width:75%;height:74%;float:left;position:absolute;top:26%;">实时曲线
			<div id="body31" style="width:100%;height:50%;"></div>
			<div id="body32" style="width:100%;height:48%;"></div>
		</div>
	</div>
</body>
</html>
 
 