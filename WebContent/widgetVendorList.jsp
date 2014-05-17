<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择配件</title>
</head>

<body>
	<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->

	<div class="box">
		<div class="path">
			<span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><a
				href="#" target="_blank">配件大全</a><em>》</em><a href="#"
				target="_blank">配件大全品牌</a><em>》</em><span>配件大全车型</span>
		</div>
		<div class="fitting_bz1"></div>

		<%
			AutoWidgetAbs widgetAbs = (AutoWidgetAbs) request.getAttribute("widgetAbs");
		%>

		<div class="fitting_list_title">

			<h1><%=widgetAbs.getName()%></h1>
		</div>
		<p class="fitting_list_text">
			<%=widgetAbs.getDescr()%>
		</p>
		<div class="fitting_list_title">
			<h1></h1>
		</div>

		<ul class="fitting_list_box">
			<%
				List<AutoWidget> widgets = (List<AutoWidget>) request.getAttribute("widgets");
				Map<Integer, AutoVendor> vendorMap = (Map<Integer, AutoVendor>) request.getAttribute("vendorMap");
				for (AutoWidget w : widgets) {
			%>
			<li>
				<dl class="fl">
					<dt>
						<a href="#" target="_blank"><img src="<%= w.getImg() %>"
							width="110" height="110" alt="" /></a>
					</dt>
					<dd>
						<h3>
							<a href="<%=request.getContextPath() %>/jaxrs/widget/detail/<%=w.getId() %>" target="_blank"><%=w.getName()%></a>
						</h3>
						<p class="jianjie"><%=w.getDescr()%></p>
						<p class="xinxi">
							<strong>[<%= vendorMap.get(w.getVendorId()).getCity() %>]</strong><label><%=vendorMap.get(w.getVendorId()).getName()%></label><span>[未核实]</span><span>[未注册]</span>
						</p>
					</dd>
				</dl>
				<div class="fitting_list_money fr">
					￥<%=w.getPrice()%></div>
			</li>
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
