package com.care.wink;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.service.ui.UIService;

@Path("/type")
public class TypeAction extends BaseAction {
	
	@GET
	@Path("{brandId}-{widgetAbsId}")
	public void listType(@PathParam("brandId") int brandId, @PathParam("widgetAbsId") int widgetAbsId) throws ServletException, IOException{
		
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoType> autoTypes = uiService.getAutoTypes(brandId);
		AutoBrand autoBrand = uiService.getAutoBrandById(brandId);
		request.setAttribute("autoBrand", autoBrand);
		request.setAttribute("autoTypes", autoTypes);
		request.setAttribute("brandId", brandId);
		request.setAttribute("widgetAbsId", widgetAbsId);
		//查詢所有的配件信息
		request.getRequestDispatcher("/typeList.jsp").forward(request, response);
	}
	
	
}
