package com.care.service.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.care.domain.SearchItem;
import com.care.domain.UIWidget;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoTypeExample;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetExample;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoWidgetTypeExample;
import com.care.mybatis.bean.AutoWidgetTypeExample.Criteria;
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
		if(brandId > 0){
			query.createCriteria().andBrandIdEqualTo(brandId);			
		}
		List<AutoType> list = autoTypeMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoYear> getAutoYears(int autoTypeId) {
		AutoYearExample query = new AutoYearExample();
		if(autoTypeId > 0){
			query.createCriteria().andTypeIdEqualTo(autoTypeId);
		}
		List<AutoYear> list = autoYearMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoWidgetType> getAutoWidgetTypes(int autoYearId) {
		AutoWidgetTypeExample query = new AutoWidgetTypeExample();
		if (autoYearId > 0){
			query.createCriteria().andYearIdEqualTo(autoYearId);			
		}
		List<AutoWidgetType> list = autoWidgetTypeMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<AutoWidget> getAutoWidgets(int widgetTypeId) {
		AutoWidgetExample query = new AutoWidgetExample();
		if (widgetTypeId > 0){
			query.createCriteria().andTypeEqualTo(widgetTypeId);			
		}
		List<AutoWidget> list = autoWidgetMapper.selectByExample(query);
		return list;
	}

	@Override
	public List<UIWidgetType> listAutoWidgetTypes( int sStatus, Boolean hot, boolean face) {
	
		List<UIWidgetType> ret = new ArrayList<UIWidgetType>();
		
		AutoWidgetTypeExample query = new AutoWidgetTypeExample();
		Criteria criteria1 = query.createCriteria();
		criteria1.andSStatusEqualTo(sStatus).andFaceEqualTo(face);
		if(hot != null){
			criteria1.andHotEqualTo(hot);
		}
		List<AutoWidgetType> list = autoWidgetTypeMapper.selectByExample(query);
		for(AutoWidgetType type : list){
			String _type = type.getName();
			AutoWidgetExample query2 = new AutoWidgetExample();
			com.care.mybatis.bean.AutoWidgetExample.Criteria criteria2 = query2.createCriteria();
			criteria2.andFaceEqualTo(face);
			if(hot != null){
				criteria2.andHotEqualTo(hot);
			}
			criteria2.andTypeEqualTo(type.getId());
			List<AutoWidget> autoWidgets = autoWidgetMapper.selectByExample(query2);
			List<UIWidget> _uiWidgets = new ArrayList<UIWidget>(autoWidgets.size());
			for(AutoWidget aw : autoWidgets){
				_uiWidgets.add(new UIWidget(aw ));
			}
			UIWidgetType e = new UIWidgetType(_type, _uiWidgets);
			e.setsStatus(type.getsStatus());
			ret.add(e);
		}
		return ret;
	}

	@Override
	public List<UIWidgetType> allAutoWidgets() {
		List<UIWidgetType> ret = new ArrayList<UIWidgetType>();
		AutoWidgetTypeExample query = null;
		List<AutoWidgetType> list = autoWidgetTypeMapper.selectByExample(query );
		for(AutoWidgetType type : list){
			String _type = type.getName();
			AutoWidgetExample query2 = new AutoWidgetExample();
			com.care.mybatis.bean.AutoWidgetExample.Criteria criteria2 = query2.createCriteria();
			criteria2.andTypeEqualTo(type.getId());
			List<AutoWidget> autoWidgets = autoWidgetMapper.selectByExample(query2);
			List<UIWidget> _uiWidgets = new ArrayList<UIWidget>(autoWidgets.size());
			for(AutoWidget aw : autoWidgets){
				_uiWidgets.add(new UIWidget(aw ));
			}
			UIWidgetType e = new UIWidgetType(_type, _uiWidgets);
			e.setsStatus(type.getsStatus());
			ret.add(e);
		}
		return ret;
	}

	@Override
	public  AutoBrand  getBrandById(int brandId) {
		AutoBrand autoBrand = autoBrandMapper.selectByPrimaryKey(brandId);
		return autoBrand;
	}
}
