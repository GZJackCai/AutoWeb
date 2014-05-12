package com.care.service.ui;

import java.util.List;

import com.care.domain.SearchItem;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoYear;

public interface UIService {

	SearchItem getSearchItem();

	List<AutoBrand> getAllBrands();
	
	AutoBrand getAutoBrandById(int brandId);

	List<AutoType> getAutoTypes(int brandId);

	List<AutoYear> getAutoYears(int autoTypeId);

	List<AutoWidgetType> getAutoWidgetTypes(int autoYearId);

	List<AutoWidget> getAutoWidgets(int widgetTypeId);


	List<UIWidgetType> listAutoWidgetTypes( int sStatus, Boolean hot,
			boolean face);

	List<UIWidgetType> allAutoWidgets();

	AutoWidget getWidgetByKey(int widgetId);

	AutoWidgetType getWidgetTypeByKey(Integer type);

	AutoType getAutoTypeById(Integer autoType);

	AutoWidgetType getAutoWidgetType(Integer type);

}