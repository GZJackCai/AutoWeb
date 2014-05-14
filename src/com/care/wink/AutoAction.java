package com.care.wink;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoVolume;
import com.care.service.ui.UIService;

@Path("auto")
public class AutoAction extends BaseAction {
	@GET
	@Path("volume/{typeId}-{brandId}")
	public void volume(@PathParam("typeId") int typeId, @PathParam("brandId") int brandId) throws ServletException, IOException{
		//查詢所有的配件信息
		UIService uiService = getCtx().getBean(UIService.class);
		AutoBrand brand = uiService.getAutoBrandById(brandId);
		AutoType autoType = uiService.getAutoTypeById(typeId);
		List<AutoVolume> volumes = uiService.getAutoVolumes(typeId);
		
		request.setAttribute("autoVolumes", volumes);
		request.setAttribute("autoBrand", brand);
		request.setAttribute("autoType", autoType );
		
		request.getRequestDispatcher("/volumeList.jsp").forward(request,response);
	}
}
