package com.care.service.ui;

import java.util.List;

import com.care.domain.SearchItem;
import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;
import com.care.mybatis.bean.AutoYear;

public interface UIService {

	SearchItem getSearchItem();

	List<AutoBrand> getAllBrands();

	List<AutoType> getAutoTypes(int brandId);

	List<AutoYear> getAutoYears(int autoTypeId);

	List<AutoWidgetType> getAutoWidgetTypes(int autoYearId);

	List<AutoWidget> getAutoWidgets(int widgetTypeId);

}