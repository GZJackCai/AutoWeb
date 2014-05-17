package com.care.wink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.domain.UIWidget;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoVendor;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetAbs;
import com.care.mybatis.bean.AutoWidgetExample;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.dao.AutoVendorMapper;
import com.care.mybatis.dao.AutoWidgetAbsMapper;
import com.care.mybatis.dao.AutoWidgetMapper;
import com.care.service.ui.UIService;

@Path("/widgetAbs")
public class WidgetAbsAction extends BaseAction {
	
	@GET
	@Path("listType/{brandId}-{typeId}-{volumeId}-{yearId}")
	public void listType(
			@PathParam("typeId") int typeId, 
			@PathParam("brandId") int brandId, 
			@PathParam("volumeId") int volumeId, 
			@PathParam("yearId") int yearId) throws ServletException, IOException{
		
		//配件已经选择,直接跳到详细列表.
		Integer widgetAbsId = (Integer) request.getSession().getAttribute("widgetAbsId");
		if(widgetAbsId != null){
			
			AutoWidgetAbsMapper autoWidgetAbsMapper = getCtx().getBean(AutoWidgetAbsMapper.class);
			AutoWidgetAbs widgetAbs = autoWidgetAbsMapper.selectByPrimaryKey(widgetAbsId);
			
			AutoWidgetMapper autoWidgetMapper = getCtx().getBean(AutoWidgetMapper.class);
			AutoWidgetExample example = new AutoWidgetExample();
			example.createCriteria().andAbsIdEqualTo(widgetAbsId);
			List<AutoWidget> widgets = autoWidgetMapper.selectByExample(example);
			
			Map<Integer , AutoVendor> vendorMap = new HashMap<Integer , AutoVendor>();
		
			AutoVendorMapper vendorMapper = getCtx().getBean(AutoVendorMapper.class);
			for(AutoWidget w : widgets ){
				AutoVendor autoVendor = vendorMapper.selectByPrimaryKey(w.getVendorId());
				vendorMap.put(w.getVendorId(), autoVendor);
			}
			
			//插入
			request.setAttribute("vendorMap", vendorMap);
			request.setAttribute("widgets", widgets);
			request.setAttribute("widgetAbs", widgetAbs);
			request.getRequestDispatcher("/widgetVendorList.jsp").forward(request, response);
			return;
		}
		
		//查詢所有的配件信息
		UIService uiService = getCtx().getBean(UIService.class);
		
		List<AutoWidgetType> types = uiService.getAutoWidgetTypes(typeId, brandId, volumeId, yearId);
		
		List<UIWidgetType> uiWidgetTypes = new ArrayList<UIWidgetType>(types.size());
		for(AutoWidgetType type : types ){
			List<AutoWidgetAbs> widgets = uiService.getAutoWidgetAbss(type.getId());
			List<UIWidget> uiWs = new ArrayList<UIWidget>(widgets.size());
			for(AutoWidgetAbs aw : widgets){
				uiWs.add(new UIWidget(aw));
			}
			UIWidgetType e = new UIWidgetType(type.getName(), uiWs );
			uiWidgetTypes.add(e );
		}
		
	
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
	
	
}
