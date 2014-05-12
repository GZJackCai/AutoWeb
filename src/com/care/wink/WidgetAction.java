package com.care.wink;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.care.domain.UIWidgetType;
import com.care.service.ui.UIService;

@Path("/widget")
public class WidgetAction extends BaseAction {
	
	@GET
	@Path("list")
	public void list() throws ServletException, IOException{
		//查詢所有的配件信息
		UIService uiService = getCtx().getBean(UIService.class);
		List<UIWidgetType> widgetList = uiService.allAutoWidgets();
		request.setAttribute("widgetList", widgetList);
		request.getRequestDispatcher("/widgetList.jsp").forward(request,response);
	}
}
