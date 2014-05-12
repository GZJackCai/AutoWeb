<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配件大全-车型</title>
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
    <div class="fitting_bz3"></div>
	<div class="fitting_models">
    	<h1><%=((AutoBrand)request.getAttribute("autoBrand")).getName() %>车型</h1>
        <p>提：示请选择汽车品牌</p>
    </div>
    <ul class="fitting_models_box fl">
    	<%
    	List<AutoType> autoTypes = (List<AutoType>)request.getAttribute("autoTypes");
    	for(AutoType type : autoTypes){
    		%>
    		
    			<li><a href="#" target="_blank"><%= type.getName() %> &gt;&gt; </a></li>	
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
