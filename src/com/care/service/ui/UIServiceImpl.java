package com.care.service.ui;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.care.domain.SearchItem;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoTypeExample;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetExample;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoWidgetTypeExample;
import com.care.mybatis.bean.AutoYear;
import com.care.mybatis.bean.AutoYearExample;
import com.care.mybatis.dao.AutoBrandMapper;
import com.care.mybatis.dao.AutoTypeMapper;
import com.care.mybatis.dao.AutoWidgetMapper;
import com.care.mybatis.dao.AutoWidgetTypeMapper;
import com.care.mybatis.dao.AutoYearMapper;

@Service
public class UIServiceImpl implements UIService {
	
	@Resource
	private AutoBrandMapper autoBrandMapper;
	
	@Resource 
	private AutoTypeMapper autoTypeMapper;
	
	@Resource
	private AutoWidgetTypeMapper autoWidgetTypeMapper;
	
	@Resource
	private AutoWidgetMapper autoWidgetMapper;
	
	@Resource
	private AutoYearMapper autoYearMapper;
	
	@Override
	public SearchItem getSearchItem() {
		//获取配件搜索项
		List<AutoBrand> brands = autoBrandMapper.selectByExample(null);
		List<AutoType> types = autoTypeMapper.selectByExample(null);
		List<AutoWidgetType> widgetTypes = autoWidgetTypeMapper.selectByExample(null);
		
		List<AutoWidget> widgets = autoWidgetMapper.selectByExample(null);
		SearchItem searchItem = new SearchItem(brands, types, widgetTypes, widgets);
		return searchItem;
	}

	@Override
	public List<AutoBrand> getAllBrands() {
		List<AutoBrand> list = autoBrandMapper.selectByExample(null);
		return list;
	}

	@Override
	public List<AutoType> getAutoTypes(int brandId) {
		AutoTypeExample query = new AutoTypeExample();
		query.createCriteria().andBrandIdEqualTo(brandId);
		List<AutoType> list = autoTypeMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoYear> getAutoYears(int autoTypeId) {
		AutoYearExample query = new AutoYearExample();
		query.createCriteria().andTypeIdEqualTo(autoTypeId);
		List<AutoYear> list = autoYearMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoWidgetType> getAutoWidgetTypes(int autoYearId) {
		AutoWidgetTypeExample query = new AutoWidgetTypeExample();
		query.createCriteria().andYearIdEqualTo(autoYearId);
		List<AutoWidgetType> list = autoWidgetTypeMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoWidget> getAutoWidgets(int widgetTypeId) {
		AutoWidgetExample query = new AutoWidgetExample();
		query.createCriteria().andTypeEqualTo(widgetTypeId);
		List<AutoWidget> list = autoWidgetMapper.selectByExample(query);
		return list;
	}
	
	
	
}
