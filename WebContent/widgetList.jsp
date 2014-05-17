<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>

<%@page import="com.care.domain.UIWidgetType"%>
<%@page import="com.care.domain.UIWidget"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配件大全</title>
</head>

<body><!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->
<div class="box">
	<div class="path"><span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><span>配件大全</span></div>
    <div class="fitting_bz1"></div>
	<div class="fitting_title">
    	<h1>配件大全</h1>
    </div>
    <table class="fitting_box">
    	<%
   		List<UIWidgetType> widgetList = (List<UIWidgetType>)request.getAttribute("uiWidgetTypes");
   		for(UIWidgetType type : widgetList){
   			%>
  				<tr>
  					<td class="bg_b"><%= type.getType() %></td>
          			<td>
           			<ul class="fitting_nei">
		            	<%
		            	for(UIWidget widgetUI : type.getWidgets()){
		            		%>	
		            			<!-- 選擇配件名稱 widgetAbs/listType/{brandId}-{typeId}-{volumeId}-{yearId}-->
		            			<a href="<%=request.getContextPath()%>/jaxrs/widgetAbs/listType/<%=request.getAttribute("brandId") %>-<%= request.getAttribute("typeId") %>-<%= request.getAttribute("volumeId") %>-<%= request.getAttribute("yearId") %>?widgetAbsId=<%= widgetUI.getWidgetAbs().getId()%>"  >
		            				<%= widgetUI.getWidgetAbs().getName() %>
		            			</a>
		            			<em>|</em>
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
</div><!-- 底部开始 -->
<%@ include file="/WEB-INF/footer.jsp"%>
<!-- 底部结束 -->
</body>
</html>
