package com.care.wink;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.ws.rs.Path;

@Path("pay")
public class PayAction extends BaseAction {
	
	@Path("list")
	public void list() throws ServletException, IOException {
		request.getRequestDispatcher("/payUI.jsp").forward(request, response);
	}
}
