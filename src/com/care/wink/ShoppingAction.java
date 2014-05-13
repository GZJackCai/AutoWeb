package com.care.wink;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.care.domain.ShoppingCart;
import com.care.domain.ShoppingCartItem;
import com.care.mybatis.bean.AutoWidget;
import com.care.service.ui.UIService;

@Path("/shopping")
public class ShoppingAction extends BaseAction {
	
	public static final String SHOPPING_KEY = "shoppingCart";
	
	private ShoppingCart initCart(HttpSession session){
		ShoppingCart cart = (ShoppingCart) session .getAttribute(SHOPPING_KEY);
		if(cart == null){
			cart = new ShoppingCart(null);
			session.setAttribute(SHOPPING_KEY, cart);
		}
		return cart;
	}
	
	@GET
	@Path("add/{widgetId}-{quantity}")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(@PathParam("widgetId") int widgetId, @PathParam("quantity") int quantity) throws ServletException, IOException{
		int code = 0;
		RetValue retValue = getRetValue("add");
		try {
			UIService uiService = getCtx().getBean(UIService.class);
			AutoWidget widget = uiService.getAutoWidgetByKey(widgetId);
			ShoppingCart cart = initCart(request.getSession());
			ShoppingCartItem e = new ShoppingCartItem();
			e.setCount(quantity);
			e.setId(widget.getId());
			e.setName(widget.getName());
			e.setPrice(widget.getPrice());
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
	@Path("del/{widgetId}")
	public void del(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		initCart(request.getSession());
	}
	
	@GET
	@Path("viewCart")
	public void viewCart() throws ServletException, IOException{
		initCart(request.getSession());
		request.getRequestDispatcher("/shopCart.jsp").forward(request, response);
	}
	
	@GET
	@Path("remove")
	public void remove(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		initCart(request.getSession());
	}
	
	@POST
	@Path("commit")
	public void commit(@FormParam("widgetId") int widgetId) throws ServletException, IOException{
		initCart(request.getSession());
	}
}
