package com.care.wink;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.domain.ShoppingCart;

@Path("/shopping")
public class ShoppingAction extends BaseAction {
	
	private static final String SHOPPING_KEY = "shoppingCart";
	
	void init(HttpSession session){
		ShoppingCart cart = (ShoppingCart) session .getAttribute(SHOPPING_KEY);
		if(cart == null){
			cart = new ShoppingCart(null);
			session.setAttribute(SHOPPING_KEY, cart);
		}
	}
	
	@GET
	@Path("add/{widgetId}")
	public void add(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		init(request.getSession());
		
	}
	
	
	@GET
	@Path("del/{widgetId}")
	public void del(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		
	}
	
	@GET
	@Path("remove")
	public void remove(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		
	}
	
	@POST
	@Path("commit")
	public void commit(@FormParam("widgetId") int widgetId) throws ServletException, IOException{
	}
}
