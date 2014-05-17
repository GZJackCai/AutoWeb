package com.care.domain;

import com.care.mybatis.bean.AutoWidgetAbs;

public class UIWidget {
	private AutoWidgetAbs widgetAbs;

	public AutoWidgetAbs getWidgetAbs() {
		return widgetAbs;
	}

	public void setWidgetAbs(AutoWidgetAbs widgetAbs) {
		this.widgetAbs = widgetAbs;
	}

	public UIWidget(AutoWidgetAbs widgetAbs) {
		super();
		this.widgetAbs = widgetAbs;
	}

}
