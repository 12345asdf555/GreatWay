<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工艺管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resources/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/datagrid.css" />
	<link rel="stylesheet" type="text/css" href="resources/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/base.css" />
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="resources/js/specification/allSpe.js"></script>
	<script type="text/javascript" src="resources/js/search/search.js"></script>
	<script type="text/javascript" src="resources/js/specification/addSpe.js"></script>
	<script type="text/javascript" src="resources/js/specification/destroySpe.js"></script>
	<script type="text/javascript" src="resources/js/specification/specificationtree.js"></script>

  </head>
  
  <body class="easyui-layout">
  	<jsp:include  page="../specificationtree.jsp"/>
  	<div  id="bodys" region="center"  hide="true"  split="true" >
  		<div id=bodyy style="text-align:center"><p>欢迎使用！请先选择焊机。。。</p></div>
  		<div id="body">
	        <div class="fitem" region="left">
	            	<lable>通道号：</lable>
	                <select class="easyui-combobox" name="chanel" id="chanel">
	                	<option value="0"></option>
	                	<option value="1">通道号1</option>
					    <option value="2">通道号2</option>
					    <option value="3">通道号3</option>
					    <option value="4">通道号4</option>
					    <option value="5">通道号5</option>
					    <option value="6">通道号6</option>
					    <option value="7">通道号7</option>
					    <option value="8">通道号8</option>
					    <option value="9">通道号9</option>
					    <option value="10">通道号10</option>
					    <option value="11">通道号11</option>
					    <option value="12">通道号12</option>
					    <option value="13">通道号13</option>
					    <option value="14">通道号14</option>
					    <option value="15">通道号15</option>
					    <option value="16">通道号16</option>
					    <option value="17">通道号17</option>
					    <option value="18">通道号18</option>
					    <option value="19">通道号19</option>
					    <option value="20">通道号20</option>
					    <option value="21">通道号21</option>
					    <option value="22">通道号22</option>
					    <option value="23">通道号23</option>
					    <option value="24">通道号24</option>
					    <option value="25">通道号25</option>
					    <option value="26">通道号26</option>
					    <option value="27">通道号27</option>
					    <option value="28">通道号28</option>
					    <option value="29">通道号29</option>
					    <option value="30">通道号30</option>
	                </select>
	            </div>
        	    <div class="fitem" align="left">
	            	<lable>初期条件：</lable><input name="finitial" id="finitial" type="checkbox" value="61"/>
	            	<lable>熔深控制：</lable><input name="fcontroller" id="fcontroller" type="checkbox" value="61"/>
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>一元/个别：</lable>
	                <select class="easyui-combobox" name="fselect" id="fselect" data-options="editable:false" onChange="changeValue(current,old)">
	                	<option value="0"></option>
	                    <option value="102">个别</option>
					    <option value="101">一元</option>
	                </select>
	            	<lable><span class="required">*</span>收弧：</lable>
	                <select class="easyui-combobox" name="farc" id="farc" data-options="editable:false">
	                	<option value="111">无</option>
					    <option value="112">有</option>
					    <option value="113">反复</option>
					    <option value="114">点焊</option>
	                </select>
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>电弧特性：</lable>
	                <input id="fcharacter" name="fcharacter" class="easyui-numberbox">(±1)
	            	<lable>柔软电弧模式：</lable><input name="fmode" id="fmode" type="checkbox" value="61">
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>点焊时间：</lable>
	            	<input name="ftime" id="ftime" class="easyui-numberbox" data-options="precision:1">(0.1s)
	            	<lable><span class="required">*</span>焊丝材质：</lable>
	                <select class="easyui-combobox" name="fmaterial" id="fmaterial" data-options="editable:false">
	                	<option value="91">低碳钢实心</option>
					    <option value="92">不锈钢实心</option>
					    <option value="93">低碳钢药芯</option>
					    <option value="94">不锈钢药芯</option>
	                </select>
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>提前送气：</lable>
	                <input name="fadvance" id="fadvance" class="easyui-numberbox" data-options="precision:1">(0.1s)
	            	<lable><span class="required">*</span>气体：</lable>
	                <select class="easyui-combobox" name="fgas" id="fgas" data-options="editable:false">
	                	<option value="120"></option>
	                	<option value="121">CO2</option>
					    <option value="122">MAG</option>
	                </select>
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>滞后送气：</lable>
	                <input name="fhysteresis" id="fhysteresis" class="easyui-numberbox" data-options="precision:1">(0.1s)
	            	<lable><span class="required">*</span>焊丝直径：</lable>
	                <select class="easyui-combobox" name="fdiameter" id="fdiameter" data-options="editable:false">
	                	<option value="131">Φ1.0</option>
	                	<option value="132">Φ1.2</option>
	                	<option value="133">Φ1.4</option>
	                	<option value="134">Φ1.6</option>
	                </select>
	            </div>
	            <div class="fitem" align="left">
	            	<lable><span class="required">*</span>初期电流：</lable>
	                <input name="fini_ele" id="fini_ele" class="easyui-numberbox" data-options="required:true,precision:1">(A)
	            	<lable><span class="required">*</span>焊接电流：</lable>
	                <input name="fweld_ele" id="fweld_ele" class="easyui-numberbox" data-options="required:true,precision:1">(A)
	                <lable><span class="required">*</span>收弧电流：</lable>
	                <input name="farc_ele" id="farc_ele" class="easyui-numberbox" data-options="required:true,precision:1">(A)
	            </div>
	            <div class="fitem" id="yiyuan1" align="left">
	            	<lable><span class="required">*</span>初期电压（一元）：</lable>
	                <input name="fini_vol1" id="fini_vol1" class="easyui-numberbox" data-options="required:true">(±1)
	            	<lable><span class="required">*</span>焊接电压（一元）：</lable>
	                <input name="fweld_vol1" id="fweld_vol1" class="easyui-numberbox" data-options="required:true">(±1)
	                <lable><span class="required">*</span>收弧电压（一元）：</lable>
	                <input name="farc_vol1" id="farc_vol1" class="easyui-numberbox" data-options="required:true">(±1)
	            </div>
	            <div class="fitem" id="gebie1" align="left">
	            	<lable><span class="required">*</span>初期电压：</lable>
	                <input name="fini_vol" id="fini_vol" class="easyui-numberbox" data-options="required:true">(V)
	            	<lable><span class="required">*</span>焊接电压：</lable>
	                <input name="fweld_vol" id="fweld_vol" class="easyui-numberbox" data-options="required:true">(V)
	                <lable><span class="required">*</span>收弧电压：</lable>
	                <input name="farc_vol" id="farc_vol" class="easyui-numberbox" data-options="required:true">(V)
	            </div>
	            <div class="fitem" id="yiyuan2" align="left">
	            	<lable><span class="required">*</span>焊接电流微调：</lable>
	                <input name="fweld_tuny_ele" id="fweld_tuny_ele" class="easyui-numberbox" data-options="required:true,precision:1">(A)
	            	<lable><span class="required">*</span>收弧电流微调：</lable>
	                <input name="farc_tuny_ele" id="farc_tuny_ele" class="easyui-numberbox" data-options="required:true,precision:1">(A)
	            </div>
	            <div class="fitem" id="yiyuan3" align="left">
	            	<lable><span class="required">*</span>焊接电压微调(一元)：</lable>
	                <input name="fweld_tuny_vol1" id="fweld_tuny_vol1" class="easyui-numberbox" data-options="required:true">(%)
	            	<lable><span class="required">*</span>收弧电压微调（一元）：</lable>
	                <input name="farc_tuny_vol1" id="farc_tuny_vol1" class="easyui-numberbox" data-options="required:true">(%)
	            </div>
	            <div class="fitem" id="gebie3" align="left">
	            	<lable><span class="required">*</span>焊接电压微调：</lable>
	                <input name="fweld_tuny_vol" id="fweld_tuny_vol" class="easyui-numberbox" data-options="required:true">(V)
	            	<lable><span class="required">*</span>收弧电压微调：</lable>
	                <input name="farc_tuny_vol" id="farc_tuny_vol" class="easyui-numberbox" data-options="required:true">(V)
	            </div>
	            <div>
					<a href="javascript:suoqu();" class="easyui-linkbutton" iconCls="icon-ok">索取规范</a>
					<a href="javascript:save();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
					<a href="javascript:xiafa();" class="easyui-linkbutton" iconCls="icon-ok">下传规范</a>
					<a href="javascript:chushihua();" class="easyui-linkbutton" iconCls="icon-ok">恢复默认值</a>
				</div>
	    </div>
	    <div id="div1" class="easyui-dialog" style="width:400px;height:400px" closed="true" buttons="#dlg-ro"algin="center">
	        <table id="ro" style="table-layout:fixed;width:100%;" ></table>
        </div>
    </div>
</body>
</html>
 
 
