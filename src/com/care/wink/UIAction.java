package com.care.wink;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.wink.common.annotations.Scope;
import org.apache.wink.common.annotations.Scope.ScopeType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

import com.care.domain.SearchItem;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoYear;
import com.care.mybatis.bean.UICorpDesc;
import com.care.mybatis.dao.UICorpDescMapper;
import com.care.service.ui.UIService;
import com.care.utils.JSONUtil;

@Path("/ui")
@Scope(ScopeType.SINGLETON)
public class UIAction extends BaseAction {
	@GET
	@Path("corpDesc")
	public String corpDesc() {
		UICorpDescMapper uiCorpDescMapper = getCtx().getBean(UICorpDescMapper.class);
		List<UICorpDesc> list = uiCorpDescMapper.selectByExample(null);
		return JSONUtil.toJson(list);
	}
	
	@GET
	@Path("allAutoBrands")
	public String allBrands(){
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoBrand> brands =	uiService.getAllBrands();
		return JSONUtil.toJson(brands);
	}
	
	@GET
	@Path("autoTypes/{autoBrand}")
	public String autoTypes(@PathParam("autoBrand") int brandId){
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoType> autoTypes =	uiService.getAutoTypes(brandId);
		return JSONUtil.toJson(autoTypes);
		
	}
	
	@GET
	@Path("autoYears/{autoType}")
	public String autoYears(@PathParam("autoType") int autoTypeId){
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoYear> autoYears =	uiService.getAutoYears(autoTypeId);
		return JSONUtil.toJson(autoYears);
		
	}
	
	@GET
	@Path("autoWidgetTypes/{autoYear}")
	public String autoWidgetTypes(@PathParam("autoYear") int autoYearId){
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoWidgetType> autoWidgetTypes = uiService.getAutoWidgetTypes(autoYearId);
		return JSONUtil.toJson(autoWidgetTypes);
		
	}
	
	@GET
	@Path("autoWidgets/{widgetType}")
	public String autoWidgets(@PathParam("widgetType") int widgetTypeId){
		UIService uiService = getCtx().getBean(UIService.class);
		List<AutoWidget> autoWidgets = uiService.getAutoWidgets(widgetTypeId);
		return JSONUtil.toJson(autoWidgets);
	}
	
	@GET
	@Path("autoWidgetList")
	public String autoWidgetList( ){
		 
		UIService uiService = getCtx().getBean(UIService.class);
		List<UIWidgetType> uiWidgetList0 =	uiService.listAutoWidgetTypes( 0, null, true);
		List<UIWidgetType> uiWidgetList1 =	uiService.listAutoWidgetTypes( 1, null, true);
		
		ArrayNode an = new ObjectMapper().createArrayNode();
		an.addPOJO(uiWidgetList0);
		an.addPOJO(uiWidgetList1);
		return JSONUtil.toJson(an);
		
	}
	
	@GET
	@Path("searchItem")
	public String searchItem(){
		UIService uiService = getCtx().getBean(UIService.class);
		SearchItem si =	uiService.getSearchItem();
		return JSONUtil.toJson(si);
	}
}
