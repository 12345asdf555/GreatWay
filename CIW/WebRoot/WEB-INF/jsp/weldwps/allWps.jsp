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
	<script type="text/javascript" src="resources/js/weldwps/allWps.js"></script>
	<script type="text/javascript" src="resources/js/search/search.js"></script>

  </head>
  
  <body >
   <div id="body">
        <div class="functiondiv">
        	<a href="javascript:addWps();" class="easyui-linkbutton" iconCls="icon-newadd">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:insertSearchWps();" class="easyui-linkbutton" iconCls="icon-select" >查找</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:giveWps()" class="easyui-linkbutton" iconCls="icon-select">工艺下发</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:history()" class="easyui-linkbutton" iconCls="icon-select" >下发历史</a>
    	</div>
	  	<div align="center">
        	<table id="dg" style="table-layout:fixed;width:100%"></table>
		</div>
    	<div id="searchdiv" class="easyui-dialog" style="width:800px; height:400px;" closed="true" buttons="#searchButton" title="自定义条件查询">
	    	<div id="div0">
		    	<select class="fields" id="fields"></select>
		    	<select class="condition" id="condition"></select>
		    	<input class="content" id="content"/>
		    	<select class="joint" id="joint"></select>
		    	<a href="javascript:newSearchWps();" class="easyui-linkbutton" iconCls="icon-add"></a>
		    	<a href="javascript:removeSerach();" class="easyui-linkbutton" iconCls="icon-remove"></a>
	    	</div>
	    </div>
	    <div id="searchButton">
			<a href="javascript:searchWps();" class="easyui-linkbutton" iconCls="icon-ok">查询</a>
			<a href="javascript:close();" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
		</div>
		<div id="historyDIV" class="easyui-dialog" style="width:800px; height:400px;" closed="true" title="下发历史">
		    <table id="history" name="history" style="table-layout:fixed;width:100%"></table>
	    </div>
    </div>
</body>
</html>
 
 
