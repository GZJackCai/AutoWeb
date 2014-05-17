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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;

import com.care.mybatis.bean.AutoBrand;
import com.care.service.ui.UIService;
import com.care.utils.JSONUtil;

@Path("/brand")
public class BrandAction extends BaseAction {

	@GET
	@Path("list")
	public void list() throws ServletException, IOException {
		listBrand(-1);
	}
	
	@GET
	@Path("listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String list0() throws ServletException, IOException {
		Map<String, List<AutoBrand>> brands = getBrands();
		String json = JSONUtil.toJson(brands);
		return json;
	}

	@GET
	@Path("{widgetAbsId}")
	public void listBrand(@PathParam("widgetAbsId") int widgetAbsId) throws ServletException, IOException {
		Map<String, List<AutoBrand>> widgetListMap = getBrands();
		if (widgetAbsId > 0) {
			request.getSession().setAttribute("widgetAbsId", widgetAbsId);
			request.setAttribute("widgetAbsId", widgetAbsId);
		}
		request.setAttribute("widgetListMap", widgetListMap);
		request.getRequestDispatcher("/brandList.jsp").forward(request, response);
	}
	
	private Map<String, List<AutoBrand>> getBrands()  {
		// 查詢所有的配件信息
				Map<String, List<AutoBrand>> widgetListMap = new HashMap<String, List<AutoBrand>>();

				UIService uiService = getCtx().getBean(UIService.class);
				List<AutoBrand> brandList = uiService.getAllBrands();
				if (CollectionUtils.isNotEmpty(brandList)) {
					for (AutoBrand b : brandList) {
						String k = b.getPinyin();
						List<AutoBrand> list = widgetListMap.get(b.getPinyin());
						if (list == null) {
							list = new ArrayList<AutoBrand>();
							widgetListMap.put(k, list);
						}
						list.add(b);
					}
				}
				return widgetListMap;
	}

}
