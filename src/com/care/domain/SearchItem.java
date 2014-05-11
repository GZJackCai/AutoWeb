package com.care.domain;

import java.util.List;

import com.care.mybatis.bean.AutoBrand;
import com.care.mybatis.bean.AutoType;
import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.AutoWidgetType;

public class SearchItem {
	List<AutoBrand> brands;
	List<AutoType> types;
	List<	AutoWidgetType> widgetTypes; 
	List<	AutoWidget> widgets;
	
	
	public SearchItem(List<AutoBrand> brands, List<AutoType> types,
			List<AutoWidgetType> widgetTypes, List<AutoWidget> widgets) {
		super();
		this.brands = brands;
		this.types = types;
		this.widgetTypes = widgetTypes;
		this.widgets = widgets;
	}
	public List<AutoBrand> getBrands() {
		return brands;
	}
	public void setBrands(List<AutoBrand> brands) {
		this.brands = brands;
	}
	public List<AutoType> getTypes() {
		return types;
	}
	public void setTypes(List<AutoType> types) {
		this.types = types;
	}
	public List<AutoWidgetType> getWidgetTypes() {
		return widgetTypes;
	}
	public void setWidgetTypes(List<AutoWidgetType> widgetTypes) {
		this.widgetTypes = widgetTypes;
	}
	public List<AutoWidget> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<AutoWidget> widgets) {
		this.widgets = widgets;
	}
	
	
	
}
