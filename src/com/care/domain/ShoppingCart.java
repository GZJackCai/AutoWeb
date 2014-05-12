package com.care.domain;

import java.util.LinkedList;

import com.care.mybatis.bean.User;

public class ShoppingCart {
	private User user;
	private LinkedList<ShoppingCartItem> items = new LinkedList<ShoppingCartItem>();

	
	
	public ShoppingCart(User user ) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public LinkedList<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(LinkedList<ShoppingCartItem> items) {
		this.items = items;
	}
	
	
	public float getTotalPrice(){
		float  t = 0F;
		for(ShoppingCartItem item : items ){
			t+= item.getPrice();
		}
		return t;
	}
	
	public float getTotalCount(){
		return items.size();
	}
	
}
