package com.care.domain;

import java.util.LinkedList;
import java.util.List;

import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.Order;
import com.care.mybatis.bean.OrderItem;
import com.care.mybatis.bean.User;
import com.care.mybatis.bean.UserAddress;

public class UserOrder {
	private Order order;
	private List<OrderItem> orderItems;
	private User user;
	private List<UserAddress> userAddress;
	private float totalPrice;

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		for (OrderItem item : orderItems) {
			this.totalPrice += item.getpPrice();
		}
	}

	public UserOrder(User user) {
		this.user = user;
		orderItems = new LinkedList<OrderItem>();
		order = new Order();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void add(AutoWidget widget, int count) {
		OrderItem item = new OrderItem();
		item.setpName(widget.getName());
		item.setpPrice(widget.getPrice());
		item.setpQuantity(count);
		item.setpId(widget.getId());
		item.setpNo(widget.getNo());
		orderItems.add(item);
	}

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

}
