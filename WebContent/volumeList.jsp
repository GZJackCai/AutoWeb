<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>配件大全-排量</title>
</head>

<body>
<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->
<div class="box">
	<div class="path"><span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><a href="#" target="_blank">配件大全</a><em>》</em><a href="#" target="_blank">配件大全品牌</a><em>》</em><span>配件大全车型</span></div>
    <div class="fitting_bz5"></div>
	<div class="fitting_models">
		<%
		AutoType autoType = (AutoType) request.getAttribute("autoType");
		AutoBrand brand =(AutoBrand) request.getAttribute("autoBrand");
		%>
    	<h1><%= brand.getName() %> <%= autoType.getName() %></h1>
    </div>
    <ul class="fitting_models_box fl">
    <%
    List<AutoVolume> volumes = ( List<AutoVolume> )request.getAttribute("autoVolumes");
	
    for(AutoVolume v : volumes){
    	%>
    	<li><a href="<%=request.getContextPath() %>/jaxrs/widget/listType/<%= brand.getId() %>-<%= autoType.getId() %>-<%= v.getId() %>-<%= v.getYearId() %>" target="_blank"> <%= v.getYearId() %> | <%= v.getName() %> | <%= v.getDescr() %></a></li>
    	<%
    }
    %>
    </ul>
</div>
<!-- 底部开始 -->
<%@ include file="/WEB-INF/footer.jsp"%>
<!-- 底部结束 -->
</body>
</html>
