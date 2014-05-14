package com.care.wink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.domain.UIWidget;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.service.ui.UIService;

@Path("/widget")
public class WidgetAction extends BaseAction {
	
	@GET
	@Path("listType/{brandId}-{typeId}-{volumeId}-{yearId}")
	public void listType(
			@PathParam("typeId") int typeId, 
			@PathParam("brandId") int brandId, 
			@PathParam("volumeId") int volumeId, 
			@PathParam("yearId") int yearId) throws ServletException, IOException{
		
		//查詢所有的配件信息
		UIService uiService = getCtx().getBean(UIService.class);
		
		List<AutoWidgetType> types = uiService.getAutoWidgetTypes(typeId, brandId, volumeId, yearId);
		
		List<UIWidgetType> uiWidgetTypes = new ArrayList<UIWidgetType>(types.size());
		for(AutoWidgetType type : types ){
			List<AutoWidget> widgets = uiService.getAutoWidgets(type.getId());
			List<UIWidget> uiWs = new ArrayList<UIWidget>(widgets.size());
			for(AutoWidget aw : widgets){
				uiWs.add(new UIWidget(aw));
			}
			UIWidgetType e = new UIWidgetType(type.getName(), uiWs );
			uiWidgetTypes.add(e );
		}
		
		//List<UIWidgetType> widgetList = uiService.allAutoWidgets();
		request.setAttribute("uiWidgetTypes", uiWidgetTypes);
		request.getRequestDispatcher("/widgetList.jsp").forward(request, response);
	}
	

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
		AutoWidget autoWidget = uiService.getAutoWidgetByKey(widgetId);
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
