package com.care.wink;

import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.care.domain.UserOrder;
import com.care.mybatis.bean.Order;
import com.care.mybatis.bean.UserAddress;
import com.care.mybatis.dao.OrderMapper;
import com.care.service.OrderService;

@Path("/order")
public class OrderAction extends BaseAction {

	@POST
	@Path("saveInvoice")
	public String saveInvoice(@FormParam("invoice") int invoice,
			@FormParam("invoice_name") String invoiceName) {
		UserOrder order = (UserOrder) request.getSession()
				.getAttribute("order");
		Order o = order.getOrder();
		if (o != null) {
			o.setInvoice(invoice);
			o.setInvoiceName(invoiceName);
		}
		return "OK";
	}

	@POST
	@Path("init")
	public String initOrder(@FormParam("addrId") int addrId) {
		UserOrder order = (UserOrder) request.getSession()
				.getAttribute("order");
		List<UserAddress> address = order.getUserAddress();

		for (UserAddress a : address) {
			if (a.getId() == addrId) {
				order.getOrder().setAddrId(addrId);
				break;
			}
		}

		// 保存订单信息
		OrderService orderService = getCtx().getBean(OrderService.class);
		orderService.saveOrder(order, order.getOrderItems());
		
		// 重定向到支付页面
		return "OK";
	}
}
