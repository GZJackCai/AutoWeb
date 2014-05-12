package com.care.wink;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
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
	
	@GET
	@Path("detail/{widgetId}")
	public void detail(@PathParam("widgetId") int widgetId) throws ServletException, IOException{
		//查詢所有的配件信息
		UIService uiService = getCtx().getBean(UIService.class);
		AutoWidget autoWidget = uiService.getWidgetByKey(widgetId);
		AutoType autoType =	 uiService.getAutoTypeById(autoWidget.getAutoType());
		AutoBrand autoBrand = uiService.getAutoBrandById(autoType.getBrandId());
		AutoWidgetType autoWidgetType = uiService.getAutoWidgetType(autoWidget.getType());
		
		request.setAttribute("autoType", autoType);
		request.setAttribute("autoBrand", autoBrand);
		request.setAttribute("autoWidget", autoWidget);
		request.setAttribute("autoWidgetType", autoWidgetType);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/widgetDetail.jsp");
		dispatcher.forward(request,response);
	}
}
