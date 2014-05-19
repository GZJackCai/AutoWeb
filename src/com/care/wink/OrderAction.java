package com.care.wink;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.care.domain.UserOrder;
import com.care.mybatis.bean.Orders;
import com.care.mybatis.bean.UserAddress;
import com.care.service.OrderService;

@Path("/order")
public class OrderAction extends BaseAction {

	@POST
	@Path("saveInvoice")
	public String saveInvoice(@FormParam("invoice") int invoice, @FormParam("invoice_name") String invoiceName) {
		UserOrder uo = (UserOrder) request.getSession().getAttribute("order");
		Orders o = uo.getOrders();
		if (o != null) {
			o.setInvoice(invoice);
			o.setInvoiceName(invoiceName);
		}
		return "OK";
	}

	/**
	 * 结算
	 * 
	 * @param addrId
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@GET
	@Path("init")
	public void initOrder(@QueryParam("addrId") int addrId) throws ServletException, IOException {
		UserOrder order = (UserOrder) request.getSession().getAttribute("order");
		List<UserAddress> address = order.getUserAddress();

		for (UserAddress a : address) {
			if (a.getId() == addrId) {
				order.getOrders().setAddrId(addrId);
				break;
			}
		}

		// 保存订单信息
		OrderService orderService = getCtx().getBean(OrderService.class);
		orderService.saveOrder(order, order.getOrderItems());

		// 前往支付界面，选择支付方式
		response.sendRedirect(request.getContextPath()+"/jaxrs/pay/list");
	}

	@GET
	@Path("removeItem/{pid}")
	public String removeItem(@PathParam("pid") int pid) {
		UserOrder order = (UserOrder) request.getSession().getAttribute("order");
		order.remove(pid);
		// 重定向到支付页面
		return "OK";
	}

}
