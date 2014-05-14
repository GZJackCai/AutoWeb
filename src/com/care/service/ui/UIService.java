package com.care.service.ui;

import java.util.List;

import com.care.domain.SearchItem;
import com.care.domain.UIWidgetType;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoVolume;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoYear;

public interface UIService {

	SearchItem getSearchItem();

	List<AutoBrand> getAllBrands();
	
	AutoBrand getAutoBrandById(int brandId);

	List<AutoType> getAutoTypes(int brandId);

	List<AutoYear> getAutoYears(int autoTypeId);

	List<AutoWidgetType> getAutoWidgetTypes(int typeId, int brandId, int volumeId, int yearId);

	List<AutoWidget> getAutoWidgets(int widgetTypeId);


	List<UIWidgetType> listAutoWidgetTypes( int sStatus, Boolean hot,
			boolean face);

	List<UIWidgetType> allAutoWidgets();

	AutoWidget getAutoWidgetByKey(int widgetId);

	AutoWidgetType getAutoWidgetTypeByKey(Integer type);

	AutoType getAutoTypeById(Integer autoType);

	AutoWidgetType getAutoWidgetType(Integer type);

	List<AutoVolume> getAutoVolumes(int typeId);

}