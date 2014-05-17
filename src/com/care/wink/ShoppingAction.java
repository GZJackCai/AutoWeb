package com.care.wink;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;

import com.care.domain.ShoppingCart;
import com.care.domain.ShoppingCartItem;
import com.care.domain.UserOrder;
import com.care.mybatis.bean.AutoVendor;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.User;
import com.care.mybatis.bean.UserAddress;
import com.care.mybatis.bean.UserAddressExample;
import com.care.mybatis.dao.AutoVendorMapper;
import com.care.mybatis.dao.AutoWidgetMapper;
import com.care.mybatis.dao.UserAddressMapper;
import com.care.service.ui.UIService;

@Path("/shopping")
public class ShoppingAction extends BaseAction {

	public static final String SHOPPING_KEY = "shoppingCart";

	private ShoppingCart initCart(HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute(SHOPPING_KEY);
		if (cart == null) {
			cart = new ShoppingCart(null);
			session.setAttribute(SHOPPING_KEY, cart);
		}
		return cart;
	}

	@GET
	@Path("add/{widgetId}-{quantity}")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(@PathParam("widgetId") int widgetId,
			@PathParam("quantity") int quantity) throws ServletException,
			IOException {
		int code = 0;
		RetValue retValue = getRetValue("add");
		try {
			UIService uiService = getCtx().getBean(UIService.class);
			AutoWidget widget = uiService.getAutoWidgetByKey(widgetId);

			AutoVendorMapper vendorMapper = getCtx().getBean(
					AutoVendorMapper.class);
			AutoVendor autoVendor = vendorMapper.selectByPrimaryKey(widget
					.getVendorId());
			String v = null;
			if (autoVendor != null) {
				v = autoVendor.getName();
			} else {
				v = widget.getDescr();
			}
			ShoppingCart cart = initCart(request.getSession());
			ShoppingCartItem e = new ShoppingCartItem(widget.getId(),
					widget.getName(), widget.getPrice(), v, 1);
			cart.addItem(e);

			retValue.setMsg("OK");
		} catch (Exception e) {
			code = -1;
			retValue.setMsg("Failed");
		}

		retValue.setCode(code);
		return getRetValueJson(retValue);

	}

	@GET
	@Path("remove")
	public void remove() throws ServletException, IOException {
		initCart(request.getSession());
	}

	@GET
	@Path("viewCart")
	public void viewCart() throws ServletException, IOException {
		initCart(request.getSession());
		request.getRequestDispatcher("/shopCart.jsp")
				.forward(request, response);
	}

	@GET
	@Path("delItem/{itemId}")
	public void delItem(@PathParam("itemId") int itemId)
			throws ServletException, IOException {
		ShoppingCart cart = initCart(request.getSession());
		cart.remove(itemId);
	}

	@GET
	@Path("commit")
	public void commit() throws ServletException, IOException {
		ShoppingCart cart = initCart(request.getSession());

		LinkedList<ShoppingCartItem> items = cart.getItems();
		if (CollectionUtils.isEmpty(items))
			return;

		// 获取用户信息
		User user = (User) request.getSession().getAttribute(UserAction.SESSION_USER);
		if (user == null) {
			//跳转到登录页
			response.sendRedirect(request.getContextPath());
		}

		UserAddressMapper addressMapper = getCtx().getBean(
				UserAddressMapper.class);
		UserAddressExample example = new UserAddressExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		List<UserAddress> addrs = addressMapper.selectByExample(example);

		UserOrder order = new UserOrder(user);
		order.setUserAddress(addrs);
		
		
		AutoWidgetMapper autoWidgetMapper = getCtx().getBean(
				AutoWidgetMapper.class);

		// 获取用户选中的商品
		for (ShoppingCartItem item : items) {
			int wId = item.getId();
			int count = item.getCount();
			AutoWidget autoWidget = autoWidgetMapper.selectByPrimaryKey(wId);

			// 添加商品
			order.add(autoWidget, count);
		}
		
		request.getSession().setAttribute("order", order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/settlement.jsp").forward(request, response);
	}
	
	
}
