<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>结算中心</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/shopping.css" />

</head>

<body>
	<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->

	<%
		UserOrder userOrder = (UserOrder) request.getAttribute("order");
	%>

	<div class="box">
		<div class="path">
			<span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><a
				href="#" target="_blank">购物车</a><em>》</em><span>结算中心</span>
		</div>
		<h1 class="shopping_title">结算中心</h1>
		<div class="s_border mt10">
			<div class="address_title">
				<h4 class="fl">收货地址</h4>
				<a class="fr bule" href="#" target="_blank">+新增收货地址</a>
			</div>
			<ul class="cl address_box">
				<%
					if (userOrder.getUserAddress() != null) {
						for (UserAddress addr : userOrder.getUserAddress()) {
				%>
				<li class="cl">
					<div class="fl">
						<input type="radio" name="addr" value="<%= addr.getId() %>" checked="<%= addr.getIsDefault() == 1 ? "checked" : ""%>"/> 
						<span><%=addr.getPostNo()%></span> <span><%=addr.getAddress()%></span>
						<span><%=addr.getUserName()%></span> <span><%=addr.getPhone()%></span>
					</div>
					<div class="fr">
						<a class="huang" href="#" target="_blank">设为默认地址</a><a
							class="bule" href="#"> 修改地址</a>
					</div>
				</li>
				<%
						}
					}
				%>
			</ul>
		</div>
		<div class="cl s_border mt10">
			<h2 class="dizhi">发票</h2>
			<div class="invoice cl">
				<input name="invoice" type="radio" checked="checked" value="-1" /><span>无</span>
				<input name="invoice" type="radio" value="0"/><span>个人</span>
				<input name="invoice" type="radio" value="1"/><span>单位</span>
				
				<input  name="invoice_name" class="text invoice_text" type="text"  id="invoice"value="" /> 
				<input class="invoice_btn"  type="button" onclick="saveInvoice()" value="确定" />
			</div>
		</div>
		<!--<ul class="shopping_th">
    	<li class="sth_01"><input type="checkbox" /><label>全选</label></li>
        <li class="sth_02">商品</li>
        <li class="sth_03">单价</li>
        <li class="sth_04">优惠</li>
        <li class="sth_05">数量</li>
        <li class="sth_06">操作</li>
    </ul>-->
		<div class="cl s_border mt10">
			<h2 class="dizhi">确认订单信息</h2>
			<table class="jiesuan">
				<tr>
					<th width="150">商品编号</th>
					<th width="350">商品</th>
					<th width="150">单价</th>
					<th width="100">数量</th>
					<th>操作</th>
				</tr>

				<%
					for (OrderItem item : userOrder.getOrderItems()) {
				%>
				<tr>
					<td><%=item.getpNo()%></td>
					<td class="bule js_text"><a href="#" target="_blank"> <%=item.getpName()%>
					</a></td>
					<td class="red">￥<%=item.getpPrice()%></td>
					<td><%=item.getpQuantity()%></td>
					<td class="bule"><a href="#">删除</a></td>
				</tr>

				<%
					}
				%>


			</table>
		</div>

		<div class="heji">
			<div class="monye_heji fr">
				<span>总计：</span><strong class="jg">￥<%=userOrder.getTotalPrice()%></strong>
			</div>
		</div>
		<ul class="shbox_btn fr">
			<li><a class="qxdd_btn" href="#" target="_blank">返回修改订单</a></li>
			<li><a class="settlement_btn tjdd_btn" href="javascript:submit()" target="_blank">提交订单</a></li>
		</ul>
	</div>


	<!-- 底部开始 -->
	<%@ include file="/WEB-INF/footer.jsp"%>
	<!-- 底部结束 -->
	
	<script>
	function saveInvoice(){
		url = g_contextPath+"/jaxrs/order/saveInvoice";
		var data = {};
		$.each( $("input[name='invoice']"), function(k, v){
			if($(v).attr('checked') == 'checked'){
				var invoice = $(v).attr('value');
				var invoice_name = $("input[name='invoice_name']").val();
				data[invoice] = invoice_name;
				console.log(invoice, invoice_name);
			}
		});
		
		$.post(url, data, function(response){
			console.log(data, response);
		}, 'json');
		
	}
	
	function submit(){
		var data = {};
		$.each( $("input[name='addr']"), function(k, v){
			if("checked" == $(v).attr("checked")){
				data[addrId] = $(v).val();
			}
		});
		
		url = g_contextPath+"/jaxrs/order/init";
		$.post(url, data, function(response){
			console.log(data, "->", response);
		},"json");
	}
	</script>
</body>
</html>
