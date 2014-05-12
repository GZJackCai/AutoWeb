<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配件大全-品牌</title>
</head>
<body>
	<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->
<div class="box">
	<div class="path"><span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><span>配件大全</span></div>
    <div class="fitting_bz2"></div>
	<div class="fitting_title">
    	<h1>汽配分类</h1>
    </div>
    <table class="fitting_box_PP" style="width:100%">
    	<% 
    	
    	Map<String, List<AutoBrand>> widgetList =(Map<String, List<AutoBrand>>) request.getAttribute("widgetListMap");
    	for(Map.Entry<String, List<AutoBrand>> e : widgetList.entrySet()){
    		%>
    		<tr>
    			<td>
    			<h3  class="pp_bg_b"><%=e.getKey() %></h3>
    			<ul class="fitting_nei">
    			<%
    				for(AutoBrand  brand : e.getValue()){
    					%>
							<a href="<%=request.getContextPath()%>/jaxrs/type/<%= brand.getId() %>-<%= request.getAttribute("widgetId") %>" target="_blank"><%= brand.getName()%></a><em>|</em>
    					<%
    				}
    			%>
    			</ul>
    			</td>
    		</tr>
    		<%
    	}
    	%>
    </table>
</div>
<!-- 底部开始 -->
<%@ include file="/WEB-INF/footer.jsp"%>
<!-- 底部结束 -->
</body>
</html>
