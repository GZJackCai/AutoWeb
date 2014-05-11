package com.care.domain;

import java.util.List;

public class UIWidgetType {
	private String type;
	private List<UIWidget> widgets;
	private int sStatus;
	
	public int getsStatus() {
		return sStatus;
	}
	public void setsStatus(int sStatus) {
		this.sStatus = sStatus;
	}
	public UIWidgetType(String type, List<UIWidget> widgets) {
		super();
		this.type = type;
		this.widgets = widgets;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<UIWidget> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<UIWidget> widgets) {
		this.widgets = widgets;
	}
	
	
}
