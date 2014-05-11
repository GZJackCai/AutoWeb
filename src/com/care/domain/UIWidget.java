package com.care.domain;

public class UIWidget {
	private String name;
	private String img;
 
	public UIWidget(String name, String imgUrl) {
		super();
		this.name = name;
		this.img = imgUrl;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
